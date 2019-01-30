package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.util.model.PageVO;

public class LprodServiceImpl implements ILprodService{
	
	private ILprodDao lprodDao;
	public LprodServiceImpl() {
		lprodDao = new LprodDaoImpl();
	}
	
	/**
	 * Method : getAllLprod
	 * 작성자 : pc11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 lprod 리스트 조회
	 */
	@Override
	public List<LprodVO> getAllLprod() {
		return lprodDao.getAllLprod();
	}

	/**
	 * Method : selectProd
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param lprod_gu
	 * @return
	 * Method 설명 : lprod에 해당하는 prod 리스트 조회
	 */
	@Override
	public List<ProdVO> selectProd(String lprod_gu) {
		return lprodDao.selectProd(lprod_gu);
	}

	/**
	 * Method : selectLprodPagingList
	 * 작성자 : pc11
	 * 변경이력 :
	 * @param pageVO
	 * @return
	 * Method 설명 : lprod 페이지 리스트 조회
	 */
	@Override
	public Map<String, Object> selectLprodPagingList(PageVO pageVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", lprodDao.selectLprodPagingList(pageVO));
		resultMap.put("lprodCnt", lprodDao.getLprodCnt());
		
		return resultMap;
	}
	
}