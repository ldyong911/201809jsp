package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;

public interface ILprodService {
	List<LprodVO> getAllLprod();
	
	List<ProdVO> selectProd(String lprod_gu);
}