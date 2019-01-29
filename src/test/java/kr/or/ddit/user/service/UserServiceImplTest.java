package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {
	private IUserService userService;
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
	}

	@Test
	public void testGetAllUser() {
		/***Given***/
//		IUserService userService = new UserServiceImpl();
		
		/***When***/
		List<UserVO> list = userService.getAllUser();
		
		/***Then***/
//		assertNotNull(list);
		assertEquals(5, list.size());
	}
	
	@Test
	public void testSelectUser(){
		/***Given***/
//		IUserService userService = new UserServiceImpl(); 
		
		/***When***/
		UserVO userVO = userService.selectUser("brown");

		/***Then***/
		assertNotNull(userVO);
	}
	
}