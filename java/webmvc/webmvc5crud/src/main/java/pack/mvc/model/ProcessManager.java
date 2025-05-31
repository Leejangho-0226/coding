package pack.mvc.model;

import java.util.ArrayList;

import pack.mvc.controller.UserForm;

public class ProcessManager { // 여러 개의 DAO(Business Logic)를 관리하는 역활
	private static ProcessManager manager = new ProcessManager();
	public static ProcessManager instance() {
		return manager;
	}
		
	// 여러 개의 DAO 중 UserDaoModel을 처리
	private UserDaoModel getUserDaoModel() {
		return new UserDaoModel();
	}
	
	public ArrayList<UserDto> getUserDataAll(){
		return getUserDaoModel().getUserAll();
	}
	
	public boolean login(String user_id, String user_password) {
		UserDto dto = getUserDaoModel().findUser(user_id);
		if(dto == null) return false;
		
		if(dto.getPassword().equals(user_password)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int insert(UserForm userForm) {
		return getUserDaoModel().insertData(userForm);
	}
	
	public UserDto findUser(String userid) {
		return getUserDaoModel().findUser(userid);
	}
	
	public int update(UserForm userForm) {
		return getUserDaoModel().updateData(userForm);
	}
	
	public int delete(String userid) {
		return getUserDaoModel().deleteData(userid);
	}
}
