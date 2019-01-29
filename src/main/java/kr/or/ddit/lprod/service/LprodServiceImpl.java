package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;

public class LprodServiceImpl implements ILprodService{
	
	private ILprodDao lprodDao;
	public LprodServiceImpl() {
		lprodDao = new LprodDaoImpl();
	}
	
	@Override
	public List<LprodVO> getAllLprod() {
		return lprodDao.getAllLprod();
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) {
		return lprodDao.selectProd(lprod_gu);
	}

}