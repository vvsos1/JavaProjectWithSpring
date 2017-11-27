package freeboard.vo;

import org.dimigo.exception.InvalidArguementException;
import org.dimigo.exception.PermissionDeniedException;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.vo
 * 	 |_ FreeBoardDeleteRequest
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 18.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class DeleteRequest {
	private UserVo requester;
	private int articleNumber;
	
	public DeleteRequest(UserVo requester, int articleNumber) {
		super();
		this.requester = requester;
		this.articleNumber = articleNumber;
	}

	public UserVo getRequester() {
		return requester;
	}

	public void setRequester(UserVo requester) {
		this.requester = requester;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	
	public void validate() throws PermissionDeniedException, InvalidArguementException {
		if (requester == null) {
			throw new PermissionDeniedException("로그인하지 않고는 글을 삭제 할 수 없습니다");
		}
		if (articleNumber == 0) {
			throw new InvalidArguementException("글의 번호가 없습니다");
		}
	}
}
