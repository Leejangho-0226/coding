package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao processDao = new ProcessDao();
	public static ProcessDao getInstance() {	// singleton pattern
		return processDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDatAll() throws SQLException{	// 전체자료 읽기
		// SqlSession : DataMapper.xml에 정의된 id에 접근 가능
		SqlSession sqlSession = sqlSessionFactory.openSession();	// sqlSession 객채 생성후 열기
		List<DataDto> list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectDataPart(String code) throws SQLException {	// 부분자료 읽기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DataDto dto = sqlSession.selectOne("selectDataByCode", code);
		sqlSession.close();
		return dto;
	}
	public void insertData(DataDto dto) throws SQLException {	// 수동 commit : transaction
		/*
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertData", dto);
		sqlSession.commit(); // commit 이 있어야 db에 새 레코드 들어감 빠지면 성공메세지떠도 롤백됨
		sqlSession.close();
		*/
		// 자동커밋 true 하지만 보통은 false로 두고 직접 커밋하는게안전하고 실무에서 선호함
		SqlSession sqlSession = sqlSessionFactory.openSession(true);	// true자동커밋
		sqlSession.insert("insertData", dto);
		sqlSession.close();
	}
	public void updateData(DataDto dto) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("updateData", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public boolean deleteData(int code) {
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