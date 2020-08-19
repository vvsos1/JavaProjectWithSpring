package org.dimigo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import freeboard.vo.ArticleContent;

/**
 * <pre>
 * org.dimigo.dao |_ FreeBoardContentDao
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class FreeBoardContentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<ArticleContent> rowMapper = new RowMapper<ArticleContent>() {
		@Override
		public ArticleContent mapRow(ResultSet rs, int count) throws SQLException {
			return new ArticleContent(rs.getInt("number"), rs.getString("content"));
		}
	};

	public int insert(ArticleContent articleContent) throws Exception {
		return jdbcTemplate.update("INSERT INTO FREEBOARDCONTENT (NUMBER, CONTENT) values(?,?)",
				articleContent.getNumber(), articleContent.getContent());
	}

	public int deleteByNumber(int number) throws Exception {
		return jdbcTemplate.update("DELETE FROM FREEBOARDCONTENT WHERE NUMBER=?", new Object[]{number}, new int[]{java.sql.Types.INTEGER});

	}

	public ArticleContent selectByNumber(int number) throws Exception {
		return jdbcTemplate.queryForObject("SELECT * FROM FREEBOARDCONTENT WHERE NUMBER = ?", new Object[] { number },
				rowMapper);
	}

	public int update(int number, String content) throws Exception {
		return jdbcTemplate.update("UPDATE FREEBOARDCONTENT SET CONTENT=? WHERE NUMBER=?", content, number);
	}
}
