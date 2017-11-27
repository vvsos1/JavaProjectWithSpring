package org.dimigo.service;

import java.util.List;

import org.dimigo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import user.vo.ModifyRequest;
import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.service |_ UserService
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 7.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class UserService {
	@Autowired
	private UserDao userDao;

	public UserVo login(UserVo user) throws Exception {
		try {
			return userDao.searchUser(user);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("아이디 또는 패스워드가 틀렸습니다", e);
		} catch (Exception e) {
			throw new Exception("로그인에 실패했습니다", e);
		}
	}

	public List<UserVo> searchUserList() {
		return userDao.searchUserList();

	}

	public void signup(UserVo user) throws Exception {
		try {
			// 사용자 등록
			userDao.insertUser(user);
		} catch (DuplicateKeyException e) {
			throw new Exception("이미 사용중인 아이디입니다", e);
		} catch (Exception e) {
			throw new Exception("회원가입에 실패했습니다", e);
		}
	}

	public UserVo modify(ModifyRequest modifyRequest) throws Exception {
		try {
			userDao.update(modifyRequest.getNewInfo());
			return userDao.searchUserById(modifyRequest.getNewInfo());
		} catch (Exception e) {
			throw new Exception("회원정보 수정에 실패했습니다", e);
		}
	}
}
