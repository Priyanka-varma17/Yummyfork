package com.yummyfork.services;

import java.sql.SQLException;

import com.yummyfork.dto.User;
import com.yummyfork.repository.UserRepository;

public class LoginService {
	
	UserRepository ur;

	public LoginService(UserRepository ur) {
		super();
		this.ur = ur;
	}
	
	public LoginService() {
		ur=new UserRepository();
	}
	
	public int checkValidity(User u) {
		try {
		System.out.println("inside login service checkvalidity method");
		return ur.userValidity(u);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
