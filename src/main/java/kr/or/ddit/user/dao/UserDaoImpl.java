package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements IUserDao{
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	public UserDaoImpl(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	/**
	 * Method : getAllUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 조회
	 */
	public List<UserVO> getAllUser(){
//		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession = sqlSessionFactory.openSession();
		List<UserVO> userList = sqlSession.selectList("user.getAllUser");
		sqlSession.close();
		
		return userList;
	}
	
	public UserVO selectUser(String userId){
		sqlSession = sqlSessionFactory.openSession();
		UserVO userVO = sqlSession.selectOne("user.selectUser", userId);
		sqlSession.close();
		
		return userVO;
	}
}
