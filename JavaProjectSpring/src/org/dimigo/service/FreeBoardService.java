package org.dimigo.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.dimigo.dao.FreeBoardContentDao;
import org.dimigo.dao.FreeBoardDao;
import org.dimigo.exception.PermissionDeniedException;
import org.dimigo.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import freeboard.vo.Article;
import freeboard.vo.ArticleContent;
import freeboard.vo.ArticleData;
import freeboard.vo.ArticlePage;
import freeboard.vo.DeleteRequest;
import freeboard.vo.ModifyRequest;
import freeboard.vo.WriteRequest;

/**
 * <pre>
 * org.dimigo.service |_ FreeBoardService
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class FreeBoardService {
	@Autowired
	private FreeBoardDao boardDao;
	@Autowired
	private FreeBoardContentDao contentDao;
	@Autowired
	private DataSource dataSource;

	private static final int ARTICLE_PER_PAGE = 10;

	public int write(WriteRequest request) throws Exception {
		// Spring이 쓰레드 당 1개의 커넥션을 보장해줌
		TransactionSynchronizationManager.initSynchronization();
		Connection conn = DataSourceUtils.getConnection(dataSource);
		// 트랜젝션 시작
		conn.setAutoCommit(false);
		try {

			// FreeBoard -> FreeBoardContent 순으로 insert
			Article reqArticle = toArticle(request);

			Article savedArticle = boardDao.insert(reqArticle);

			ArticleContent reqContent = new ArticleContent();
			// number는 Auto_Increment이므로 받아와서 설정
			reqContent.setNumber(savedArticle.getNumber());
			reqContent.setContent(request.getContent());

			contentDao.insert(reqContent);

			// 요청을 커밋
			conn.commit();

			return savedArticle.getNumber(); // 쓰기 성공한 데이터의 number를 리턴

		} catch (Exception e) {
			// 트랜젝션 롤백
			CommonUtil.rollback(conn);
			throw new Exception("글쓰기에 실패했습니다",e);
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource); // 커넥션을 닫음

			// 동기화 작업을 종료하고 저장소를 비운다
			TransactionSynchronizationManager.unbindResource(this.dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}
	}

	private Article toArticle(WriteRequest request) {
		Article result = new Article();
		result.setTitle(request.getTitle());
		result.setWriter(request.getRequester());
		result.setRegDate(new Date());
		result.setNumber(0);
		return result;
	}

	public ArticlePage list(int page) throws Exception {
		try {
		List<Article> list = boardDao.select((page - 1) * ARTICLE_PER_PAGE, ARTICLE_PER_PAGE);
		int count = boardDao.count();
		int totalPage;
		if (count%ARTICLE_PER_PAGE == 0)
			totalPage = (count / ARTICLE_PER_PAGE);
		else {
			totalPage = (count / ARTICLE_PER_PAGE) + 1;
		}

		return new ArticlePage(totalPage, page, list);
		} catch (Exception e) {
			throw new Exception("글 목록 조회에 실패했습니다",e);
		}
	}

	public ArticleData read(int number, boolean increaseReadCount) throws Exception {
		TransactionSynchronizationManager.initSynchronization();
		Connection conn = DataSourceUtils.getConnection(dataSource);
		// 트랜젝션 시작
		conn.setAutoCommit(false);
		ArticleData result = null;
		try {

			Article savedArticle = boardDao.selectByNumber(number);
			ArticleContent savedContent = contentDao.selectByNumber(number);
			int nextNumber = boardDao.selectNextNumber(number);
			int previousNumber = boardDao.selectPreviousNumber(number);
			
			// 읽은횟수를 증가
			if (increaseReadCount == true) {
				boardDao.increaseReadCount(number);
			}

			result = new ArticleData(savedArticle, savedContent, previousNumber, nextNumber);
			// 요청을 커밋
			conn.commit();

			return result; // 읽어온 게시판 내용을 리턴

		} catch (Exception e) {
			CommonUtil.rollback(conn);
			throw new Exception("글 내용 조회에 실패했습니다",e);
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource); // 커넥션을 닫음

			// 동기화 작업을 종료하고 저장소를 비운다
			TransactionSynchronizationManager.unbindResource(this.dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}
	}

	public void delete(DeleteRequest request) throws Exception {
		TransactionSynchronizationManager.initSynchronization();
		Connection conn = DataSourceUtils.getConnection(dataSource);
		// 트랜젝션 시작
		conn.setAutoCommit(false);
		try {

			// 삭제하려는 글의 작성자를 받아옴
			Article resultArticle = boardDao.selectByNumber(request.getArticleNumber());

			// 글 삭제 권한 확인
			if (!resultArticle.getWriter().getId().equals(request.getRequester().getId())) {
				throw new PermissionDeniedException("글 삭제 권한이 없습니다.");
			}

			boardDao.deleteByNumber(request.getArticleNumber());
			contentDao.deleteByNumber(request.getArticleNumber());

			// 요청을 커밋
			conn.commit();

		} catch (PermissionDeniedException e) {
			CommonUtil.rollback(conn);
			throw e;
		} catch (Exception e) {
			CommonUtil.rollback(conn);
			throw new Exception("글 삭제에 실패했습니다.", e);
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource); // 커넥션을 닫음

			// 동기화 작업을 종료하고 저장소를 비운다
			TransactionSynchronizationManager.unbindResource(this.dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}
	}

	public void modify(ModifyRequest request) throws Exception {
		TransactionSynchronizationManager.initSynchronization();
		Connection conn = DataSourceUtils.getConnection(dataSource);
		// 트랜젝션 시작
		conn.setAutoCommit(false);
		try {
			// 삭제하려는 글의 작성자를 받아옴
			Article resultArticle = boardDao.selectByNumber(request.getArticleNumber());

			if (!resultArticle.getWriter().getId().equals(request.getRequester().getId())) {
				throw new PermissionDeniedException("글 수정 권한이 없습니다.");
			}

			boardDao.update(request.getArticleNumber(), request.getTitle());
			contentDao.update(request.getArticleNumber(), request.getContent());

			// 요청을 커밋
			conn.commit();
		} catch (PermissionDeniedException e) {
			CommonUtil.rollback(conn);
			throw e;
		} catch (Exception e) {
			CommonUtil.rollback(conn);
			throw new Exception("글 수정에 실패했습니다");
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource); // 커넥션을 닫음

			// 동기화 작업을 종료하고 저장소를 비운다
			TransactionSynchronizationManager.unbindResource(this.dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}
	}
}
