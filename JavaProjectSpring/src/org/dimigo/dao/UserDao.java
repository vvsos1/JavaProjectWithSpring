package org.dimigo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.dao |_ UserDao
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 14.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<UserVo> rowMapper = new RowMapper<UserVo>() {
		@Override
		public UserVo mapRow(ResultSet rs, int count) throws SQLException {
			return new UserVo(rs.getString("id"), rs.getString("pwd"), rs.getString("grade"), rs.getString("classroom"),
					rs.getString("number"), rs.getString("name"));
		}
	};

	public UserVo searchUser(UserVo vo) {
		return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ? AND PWD = ?",
				new Object[] { vo.getId(), vo.getPwd() }, rowMapper);
	}

	public List<UserVo> searchUserList() {
		return jdbcTemplate.query("SELECT * FROM USER", rowMapper);
	}

	public int insertUser(UserVo vo) {
		return jdbcTemplate.update("INSERT INTO USER (ID, PWD, NAME, GRADE, CLASSROOM, NUMBER) VALUES(?,?,?,?,?,?)",
				vo.getId(), vo.getPwd(), vo.getName(), vo.getGrade(), vo.getClassroom(), vo.getNumber());
	}

	public UserVo searchUserById(UserVo vo) {
		return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ?", new Object[] { vo.getId() }, rowMapper);
	}

	public int update(UserVo vo) {
		return jdbcTemplate.update(
				"UPDATE USER SET PWD = ?, NAME = ?, GRADE = ? ,CLASSROOM = ?, NUMBER = ? WHERE ID = ?", vo.getPwd(),
				vo.getName(), vo.getGrade(), vo.getClassroom(), vo.getNumber(), vo.getId());
	}
}
