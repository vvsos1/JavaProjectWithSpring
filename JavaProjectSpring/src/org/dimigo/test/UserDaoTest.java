package org.dimigo.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.dimigo.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.test
 * 	 |_ UserDaoTest
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 23.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="applicationContext-test.xml")
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	private UserVo user1;
	
	@Before
	public void before(){
		user1 = new UserVo("abcd", "2", "1", "235", "노답");
	}
	
	@Test
	public void insert(){
		System.out.println(userDao);
		userDao.insertUser(user1);
		UserVo result = userDao.searchUserById(user1);
		
		assertThat(user1.getName(), is(result.getName()));
	}
}
