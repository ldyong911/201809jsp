package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface IUserService {
	
	/**
	 * Method : getAllUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
 	 * Method 설명 : 전체 사용자 정보 조회
	 */
	List<UserVO> getAllUser();
	
	/**
	 * Method : selectUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 조회
	 */
	UserVO selectUser(String userId);
	
	/**
	 * Method : selectUserPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 사용자 페이지 리스트 조회
	 */
	Map<String, Object> selectUserPagingList(PageVO pageVO);
	
	/**
	 * Method : insertUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	int insertUser(UserVO userVO);
	
	/**
	 * Method : deleteUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * Method : updateUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	int updateUser(UserVO userVO);
	
	/**
	 * Method : encryptPass
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 수정
	 */
	int encryptPass();
}