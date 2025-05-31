package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	// member 전체 읽기
	public List<DataDto> selectMemberAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<DataDto> list = null;
		try {
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectMemberAll err: " + e);
		}finally {
			
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	// 회원 추가
	public boolean insertMember(DataFormBean bean){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean b = false;
		try {
			if(sqlSession.insert("insertData", bean) > 0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("insertMember err: " + e);
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
	// 회원 1명 정보 읽기
	public DataDto selectMember(String id) throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		DataDto dto = sqlSession.selectOne("selectDataPart",id);
		sqlSession.close();
		return dto;
	}
	
	// 회원 수정
	public boolean updateMember(DataFormBean bean){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean b = false;
		try {
			// 비번 비교 후 업데이트 결정
			DataDto dto = selectMember(bean.getId());
			
			if(dto.getPasswd().equals(bean.getPasswd())) {
				if(sqlSession.update("updateData", bean) > 0) b=true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("updateMember err: " + e);
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}

	// 회원 삭제
	public boolean deleteMember(String id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean b = false;
		try {
			if(sqlSession.update("deleteData", id) > 0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("updateMember err: " + e);
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}
