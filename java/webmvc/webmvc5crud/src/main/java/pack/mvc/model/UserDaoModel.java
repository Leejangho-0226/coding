package pack.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mvc.controller.UserForm;

public class UserDaoModel { // userinfo 테이블 관련 Business Logic
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() {
		
	}
	
	public ArrayList<UserDto> getUserAll(){
		List<UserDto> list = null;
		SqlSession sqlSession = factory.openSession();	
		try {
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return (ArrayList<UserDto>)list;
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		SqlSession sqlSession = factory.openSession();
		
		try {
			dto = sqlSession.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return dto;
	}
	
	public int insertData(UserForm userForm) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.insert("insertData", userForm);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
	public int updateData(UserForm userForm) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.update("updateData", userForm);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
	public int deleteData(String userid) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.delete("deleteData", userid);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
}
