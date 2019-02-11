package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements IUserDao{
	
	/**
	 * Method : getAllUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 조회
	 */
	@Override
	public List<UserVO> getAllUser(SqlSession sqlSession){
		List<UserVO> userList = sqlSession.selectList("user.getAllUser");
		
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
	public UserVO selectUser(SqlSession sqlSession, String userId){
		UserVO userVO = sqlSession.selectOne("user.selectUser", userId);
		
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
	public List<UserVO> selectUserPagingList(SqlSession sqlSession, PageVO pageVO) {
		List<UserVO> userList = sqlSession.selectList("user.selectUserPagingList", pageVO);
		
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
	public int getUserCnt(SqlSession sqlSession) {
		int userCnt = sqlSession.selectOne("user.getUserCnt");
		
		return userCnt;
	}

	/**
	 * Method : insertUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userVO
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(SqlSession sqlSession, UserVO userVO) {
		int result = sqlSession.insert("user.insertUser", userVO);
		
		return result;
	}

	/**
	 * Method : deleteUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(SqlSession sqlSession, String userId) {
		int result = sqlSession.delete("user.deleteUser", userId);
		
		return result;
	}

	/**
	 * Method : updateUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param sqlSession
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	@Override
	public int updateUser(SqlSession sqlSession, UserVO userVO) {
		int result = sqlSession.update("user.updateUser", userVO);
		
		return result;
	}
}