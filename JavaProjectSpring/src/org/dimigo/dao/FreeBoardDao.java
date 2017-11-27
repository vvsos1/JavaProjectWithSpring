package org.dimigo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import freeboard.vo.Article;
import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.dao |_ FreeBoardDao
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */

public class FreeBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Article> rowMapper = new RowMapper<Article>() {
		@Override
		public Article mapRow(ResultSet rs, int count) throws SQLException {
			return new Article(new UserVo(rs.getString("writerId")), rs.getInt("number"), rs.getString("title"),
					toDate(rs.getTimestamp("regDate")), rs.getInt("readCount"));
		}
	};

	public Article insert(Article article) {
		jdbcTemplate.update("INSERT INTO FREEBOARD (TITLE, REGDATE, READCOUNT, WRITERID) values(?,?,?,?)",
				article.getTitle(), toTimestamp(article.getRegDate()), article.getReadCount(),
				article.getWriter().getId());

		// int articleNumber = jdbcTemplate.queryForInt("SELECT LAST_INSERT_ID()
		// FROM FREEBOARD");
		// SELECT LAST_INSERT_ID() FROM FREEBOARD의 결과가 같은 값이 있는 2개의 행으로 반환되는 오류로
		// 인해 List로 받음'
		List<Integer> articleNumber = jdbcTemplate.query("SELECT LAST_INSERT_ID() FROM FREEBOARD",
				new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int count) throws SQLException {
						return rs.getInt(1);
					}
				});

		return new Article(article.getWriter(), articleNumber.get(0), article.getTitle(), article.getRegDate(),
				article.getReadCount());
	}

	public Article selectByNumber(Integer number) {
		return jdbcTemplate.queryForObject("SELECT * FROM FREEBOARD WHERE NUMBER=?", new Object[] { number },
				this.rowMapper);
	}

	public List<Article> select(int start, int size) {
		return jdbcTemplate.query("SELECT * FROM FREEBOARD ORDER BY NUMBER DESC LIMIT ? OFFSET ?",
				new Object[] { size, start }, this.rowMapper);
	}

	public int deleteByNumber(int number) {
		return jdbcTemplate.update("DELETE FROM FREEBOARD WHERE NUMBER=?", new Object[]{number}, new int[]{java.sql.Types.INTEGER});
	}

	public int increaseReadCount(int number) {
		return jdbcTemplate.update("UPDATE FREEBOARD SET READCOUNT = READCOUNT + 1 WHERE NUMBER=?", number);
	}

	public int update(int number, String title) {
		return jdbcTemplate.update("UPDATE FREEBOARD SET TITLE=? WHERE NUMBER=?", new Object[] { title, number });
	}

	public int count() {
		return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM FREEBOARD");
	}
	
	public int selectPreviousNumber(int number) {
		return jdbcTemplate.queryForInt("SELECT MAX(NUMBER) FROM FREEBOARD WHERE NUMBER < ?",new Object[]{number});
	}
	
	public int selectNextNumber(int number) {
		return jdbcTemplate.queryForInt("SELECT MIN(NUMBER) FROM FREEBOARD WHERE NUMBER > ?",new Object[]{number});
	}

	private Date toDate(Timestamp regDate) {
		return new Date(regDate.getTime());
	}

	private Timestamp toTimestamp(Date regDate) {
		return new Timestamp(regDate.getTime());
	}

}
