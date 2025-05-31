package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	public List<SangpumDto> selectDatAll() throws SQLException{	// 전체자료 읽기
		// SqlSession : DataMapper.xml에 정의된 id에 접근 가능
		SqlSession sqlSession = sqlSessionFactory.openSession();	// sqlSession 객채 생성후 열기
		List<SangpumDto> list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public SangpumDto selectDataPart(String code) throws SQLException {	// 부분자료 읽기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SangpumDto dto = sqlSession.selectOne("selectDataByCode", code);
		sqlSession.close();
		return dto;
	}
	public void insertData(SangpumBean bean) throws SQLException {	// 수동 commit : transaction
		/*
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertData", dto);
		sqlSession.commit(); // commit 이 있어야 db에 새 레코드 들어감 빠지면 성공메세지떠도 롤백됨
		sqlSession.close();
		*/
		// 자동커밋 true 하지만 보통은 false로 두고 직접 커밋하는게안전하고 실무에서 선호함
		SqlSession sqlSession = sqlSessionFactory.openSession(true);	// true자동커밋
		sqlSession.insert("insertData", bean);
		sqlSession.close();
	}
	public void updateData(SangpumBean bean) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("updateData", bean);
		sqlSession.commit();
		sqlSession.close();
	}
	public boolean deleteData(String code) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean b = false;
		try {
			int count = sqlSession.delete("deleteData", code);
			if(count > 0) b = true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("deleteData err " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}
