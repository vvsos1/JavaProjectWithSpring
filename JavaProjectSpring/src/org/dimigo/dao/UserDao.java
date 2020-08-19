package org.dimigo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

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
	private SimpleJdbcTemplate SimpleJdbcTemplate;
	private RowMapper<UserVo> rowMapper = new BeanPropertyRowMapper<>(UserVo.class);

	public UserVo searchUser(UserVo vo) {
		return SimpleJdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = :id AND PWD = :pwd", rowMapper,
				new BeanPropertySqlParameterSource(vo));
	}

	public List<UserVo> searchUserList() {
		return SimpleJdbcTemplate.query("SELECT * FROM USER", rowMapper);
	}

	public int insertUser(UserVo vo) {
		return SimpleJdbcTemplate.update(
				"INSERT INTO USER (ID, PWD, NAME, GRADE, CLASSROOM, NUMBER) VALUES(:id,:pwd,:name,:grade,:classroom,:number)",
				new BeanPropertySqlParameterSource(vo));
	}

	public UserVo searchUserById(UserVo vo) {
		return SimpleJdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = :id", rowMapper,
				new BeanPropertySqlParameterSource(vo));
	}

	public int update(UserVo vo) {
		return SimpleJdbcTemplate.update(
				"UPDATE USER SET PWD = :pwd, NAME = :name, GRADE = :grade ,CLASSROOM = :classroom, NUMBER = :number WHERE ID = :id",
				new BeanPropertySqlParameterSource(vo));
	}
}
