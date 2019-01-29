package kr.or.ddit.db.mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class MybatisSqlSessionFactoryTest {

	/**
	 * Method : testGetSqlSessionFactory
	 * 작성자 : pc11
	 * 변경이력 :
	 * Method 설명 : MybatisSqlSessionFactory객체로부터 SqlSessionFactory 객체가 정상적으로
	 *              생성되는지 테스트
	 */
	@Test
	public void testGetSqlSessionFactory() {
		/***Given***/

		/***When***/
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

		/***Then***/
		assertNotNull(sqlSessionFactory);
	}

}
