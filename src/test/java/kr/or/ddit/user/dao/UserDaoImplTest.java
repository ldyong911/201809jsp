package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {
	private IUserDao userDao;
	
	@Before
	public void setup(){
		userDao = new UserDaoImpl();
	}

	@Test
	public void testGetAllUser() {
		/***Given***/
//		IUserDao userDao = new UserDaoImpl(); 
		
		/***When***/
		List<UserVO> list = userDao.getAllUser();
		
		/***Then***/
//		assertNotNull(list);
		assertEquals(5, list.size());
		
	}
	
	@Test
	public void testSelectUser(){
		/***Given***/
//		IUserDao userDao = new UserDaoImpl();
		
		/***When***/
		UserVO userVO = userDao.selectUser("brown");
		
		/***Then***/
		assertNotNull(userVO);

	}
	
}