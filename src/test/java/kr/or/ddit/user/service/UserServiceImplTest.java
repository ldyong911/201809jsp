package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {
	private SqlSession sqlSession;
	private IUserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	
	@Before
	public void setup(){
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		
		userService = new UserServiceImpl();
		
		userService.deleteUser("test1");
	}
	
	@After
	public void tearDown(){
		sqlSession.close();
	}

	@Test
	public void testGetAllUser() {
		/***Given***/
		
		/***When***/
		List<UserVO> list = userService.getAllUser();
		
		/***Then***/
		assertNotNull(list);
		assertEquals(105, list.size());
	}
	
	@Test
	public void testSelectUser(){
		/***Given***/
		
		/***When***/
		UserVO userVO = userService.selectUser("brown");

		/***Then***/
		assertNotNull(userVO);
	}
	
	@Test
	public void testSelectUserPagingList(){
		/***Given***/
		PageVO pageVO = new PageVO(1, 10);
		
		/***When***/
		Map<String, Object> resultMap = userService.selectUserPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>)resultMap.get("userList");
		int userCnt = (Integer)resultMap.get("userCnt");
		
		for(UserVO vo : userList){
			System.out.println(vo.toString());
		}
		
		System.out.println("userCnt : " + userCnt);

		/***Then***/
		//userList
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//userCnt
		assertEquals(105, userCnt);
	}
	
	@Test
	public void testInsertUser(){
		/***Given***/
		UserVO userVO = new UserVO();
		userVO.setUserId("test1");
		userVO.setUserNm("테스트");
		userVO.setAlias("테스트별명");
		userVO.setAddr1("대전 중구 대흥로 76");
		userVO.setAddr2("2층 ddit");
		userVO.setZipcode("34942");
		userVO.setPass("testPass");
		
		/***When***/
		int result = userService.insertUser(userVO);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void testUpdateUser(){
		/***Given***/
		UserVO userVO = new UserVO();
		userVO.setUserId("brown2");
		userVO.setUserNm("테스트");
		userVO.setAlias("테스트별명");
		userVO.setAddr1("대전 중구 대흥로 76");
		userVO.setAddr2("2층 ddit");
		userVO.setZipcode("34942");
		userVO.setPass("testPass");
		
		/***When***/
		int result = userService.updateUser(userVO);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void testEncryptPass(){
		/***Given***/
		List<UserVO> userList = userService.getAllUser();
		
		/***When***/
		int result = userService.encryptPass();
		
		logger.debug("result : {}", result);
		
		/***Then***/
		
	}
	
}