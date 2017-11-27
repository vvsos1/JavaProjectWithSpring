package org.dimigo.test;

import org.springframework.context.support.GenericXmlApplicationContext;

import user.vo.UserVo;

import org.dimigo.dao.UserDao;
import org.springframework.context.ApplicationContext;

/**
 * <pre>
 * org.dimigo.test |_ UserDaoTest2
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 23.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class UserDaoTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("/org/dimigo/servlet/applicationContext.xml");
		UserDao userDao = context.getBean(UserDao.class);
		
		UserVo result = userDao.searchUserById(new UserVo("vvsos1@hotmail.co.kr"));
		System.out.println(result);
	}
}
