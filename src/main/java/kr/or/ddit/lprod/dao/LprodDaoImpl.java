package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;

public class LprodDaoImpl implements ILprodDao{
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	public LprodDaoImpl(){
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}

	@Override
	public List<LprodVO> getAllLprod() {
		sqlSession = sqlSessionFactory.openSession();
		List<LprodVO> list = sqlSession.selectList("lprod.getAllLprod");
		sqlSession.close();
		
		return list;
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) {
		sqlSession = sqlSessionFactory.openSession();
		List<ProdVO> list = sqlSession.selectList("lprod.selectProd", lprod_gu);
		sqlSession.close();
		
		return list;
	}
	
}