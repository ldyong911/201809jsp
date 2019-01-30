package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

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
	@Override
	public List<UserVO> getAllUser(){
//		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
//		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession = sqlSessionFactory.openSession();
		List<UserVO> userList = sqlSession.selectList("user.getAllUser");
		sqlSession.close();
		
		return userList;
	}
	
	/**
	 * Method : selectUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	@Override
	public UserVO selectUser(String userId){
		sqlSession = sqlSessionFactory.openSession();
		UserVO userVO = sqlSession.selectOne("user.selectUser", userId);
		sqlSession.close();
		
		return userVO;
	}

	/**
	 * Method : selectUserPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVO> selectUserPagingList(PageVO pageVO) {
		sqlSession = sqlSessionFactory.openSession();
		List<UserVO> userList = sqlSession.selectList("user.selectUserPagingList", pageVO);
		sqlSession.close();
		
		return userList;
	}

	/**
	 * Method : getUserCnt
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 수를 조회
	 */
	@Override
	public int getUserCnt() {
		sqlSession = sqlSessionFactory.openSession();
		int userCnt = sqlSession.selectOne("user.getUserCnt");
		sqlSession.close();
		
		return userCnt;
	}
}
