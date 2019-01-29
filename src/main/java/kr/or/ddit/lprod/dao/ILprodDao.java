package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;

public interface ILprodDao {
	List<LprodVO> getAllLprod();
	
	List<ProdVO> selectProd(String lprod_gu);
}