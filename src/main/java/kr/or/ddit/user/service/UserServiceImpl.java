package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserServiceImpl implements IUserService {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private IUserDao userDao;
	
	public UserServiceImpl(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		userDao = new UserDaoImpl();
	}
	
	/**
	 * Method : getAllUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 정보 조회
	 */
	@Override
	public List<UserVO> getAllUser() {
		sqlSession = sqlSessionFactory.openSession();
		List<UserVO> userList = userDao.getAllUser(sqlSession);
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
	public UserVO selectUser(String userId) {
		sqlSession = sqlSessionFactory.openSession();
		UserVO userVO = userDao.selectUser(sqlSession, userId);
		sqlSession.close();
		
		return userVO;
	}

	/**
	 * Method : selectUserPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : 사용자 페이지 리스트 조회
	 */
	@Override
	public Map<String, Object> selectUserPagingList(PageVO pageVO) {
		sqlSession = sqlSessionFactory.openSession();
		
		//결과값을 두개 담아서 return 하기위해 Map 객체 사용
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("userList", userDao.selectUserPagingList(sqlSession, pageVO));
		resultMap.put("userCnt", userDao.getUserCnt(sqlSession));
		
		sqlSession.close();
		
		return resultMap;
	}

	/**
	 * Method : insertUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVO userVO) {
		sqlSession = sqlSessionFactory.openSession();
		int result = userDao.insertUser(sqlSession, userVO);
		sqlSession.commit(); //트랜잭션이 발생되는 쿼리이기때문에 commit해줘야함
		sqlSession.close();
		
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
	public int deleteUser(String userId) {
		sqlSession = sqlSessionFactory.openSession();
		int result = userDao.deleteUser(sqlSession, userId);
		sqlSession.commit(); //트랜잭션이 발생되는 쿼리이기때문에 commit해줘야함
		sqlSession.close();
		
		return result;
	}

	/**
	 * Method : updateUser
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param userVO
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	@Override
	public int updateUser(UserVO userVO) {
		sqlSession = sqlSessionFactory.openSession();
		int result = userDao.updateUser(sqlSession, userVO);
		sqlSession.commit(); //트랜잭션이 발생되는 쿼리이기때문에 commit해줘야함
		sqlSession.close();
		
		return result;
	}

	/**
	 * Method : encryptPass
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 비밀번호 수정
	 */
	@Override
	public int encryptPass() {
		sqlSession = sqlSessionFactory.openSession();
		
		List<UserVO> userList = userDao.getAllUser(sqlSession);
		
		int result = 0;
		for(UserVO userVO : userList){
			String pass = userVO.getPass();
			String encryptPass = KISA_SHA256.encrypt(pass);
			userVO.setPass(encryptPass);
			
			result += userDao.encryptPass(sqlSession, userVO);
		}
		
		sqlSession.commit(); //트랜잭션이 발생되는 쿼리이기때문에 commit해줘야함
		sqlSession.close();
		
		return result;
	}
}