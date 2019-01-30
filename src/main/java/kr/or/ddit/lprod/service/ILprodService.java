package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public interface ILprodService {
	/**
	 * Method : getAllLprod
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 lprod 리스트 조회
	 */
	List<LprodVO> getAllLprod();
	
	/**
	 * Method : selectProd
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param lprod_gu
	 * @return
	 * Method 설명 : lprod에 해당하는 prod 리스트 조회
	 */
	List<ProdVO> selectProd(String lprod_gu);
	
	/**
	 * Method : selectLprodPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : lprod 페이지 리스트 조회
	 */
	Map<String, Object> selectLprodPagingList(PageVO pageVO);
}