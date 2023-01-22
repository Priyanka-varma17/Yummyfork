package com.yummyfork.services;

import java.sql.SQLException;
import com.yummyfork.dto.User;
import com.yummyfork.repository.UserRepository;


public class UserService {
	
	UserRepository ur;


	public UserService(UserRepository ar) {
		super();
		
	}
	public UserService() {
		ur=new UserRepository();
	}
	public int addUser(User u) {
		try {
			
			int flag=ur.getUserByUsername(u);
			if(flag>0) {
				return 0;
			}
			else {
				ur.addUser(u);
				return 1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int checkUsernameExist(User u) {
		try {
			
			int flag=ur.getUserByUsername(u);
			if(flag>0) {
				return 1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public int deleteUserByEmail(String email) {
		try {
			return ur.deleteUserByUsername(email);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateUser(User u) {
		try {
			return ur.updateUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUserPassword(User u) {
		try {
			return ur.updateUserPassword(u);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int checkPwdByEmail(String email,String pwd) {
		try {
			return ur.checkPwdByEmail(email, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
