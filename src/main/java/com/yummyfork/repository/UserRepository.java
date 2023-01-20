package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.User;

public class UserRepository {
	
	DatabaseConnection db=new DatabaseConnection();

	public int addUser(User user)throws SQLException{
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addUser);){
			pst.setString(1, user.getRole());
			pst.setString(2,user.getUname());
			pst.setString(3,user.getUpwd());

				
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				System.out.println(" Admin Record inserted successfully");
				System.out.println("*****************************");
				return 1;
			}
			else {
				System.out.println("Failed to insert record");
				return 0;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public List<User> getUserDetails(String username) throws SQLException{		
		Connection con=db.getConnection();
		List<User> userList=new ArrayList<User>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
		
	
		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			User u=new User();
			u.setRole(rs.getString(1));
//			u.setUname(rs.getString(2));
//			u.setUpwd(rs.getString(3));
			userList.add(u);
		}
		return userList;
		
	}
public int getUserByUsername(User user) throws SQLException{			//EX
			
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
				
			
			pst.setString(1, user.getUname());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				return 1;
			}
			else {
				System.out.println("Record not found for username"+user.getUname());
				return 0;
			}
		}

public int updateUser(User user) throws SQLException {			//EX
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.updateUser);){
		
		
		pst.setString(1, user.getUpwd());
		pst.setString(2, user.getUname());
	
		System.out.println("username "+user.getUname()+" password "+user.getUpwd());
		return pst.executeUpdate();
		
	}
}

public int deleteUserByUsername(String username) throws SQLException{		//ex
	try(Connection con=db.getConnection();
						
			PreparedStatement pst=con.prepareStatement(QueryUtil.deleteUserByUsername);){
			pst.setString(1, username);
			
		return pst.executeUpdate();
		
	}
}

public int userValidity(User u) throws SQLException{
	// TODO Auto-generated method stub
	try(Connection con=db.getConnection();
			PreparedStatement pst=con.prepareStatement(QueryUtil.isUserValid)){
		
		pst.setString(1,u.getRole());
		pst.setString(2,u.getUname());
		pst.setString(3, u.getUpwd());
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			System.out.println("valid");
			return 1;
		}
		else {
			System.out.println("Invalid");

			return 0;
		}
	}

	}

public User getUserByEmail(String mail) throws SQLException{		//ex
	
	Connection con=db.getConnection();
	PreparedStatement pst=con.prepareStatement(QueryUtil.getUserByEmail);
			
		
		pst.setString(1, mail);
		ResultSet rs=pst.executeQuery();

		while (rs.next()) {
							
			User u=new User();
			u.setRole(rs.getString(1));
			u.setUname(rs.getString(2));
			u.setUpwd(rs.getString(3));
			
			return u;
		}
	
	return null;
	
}

public int checkPwdByEmail(String email,String pwd) throws SQLException{			//TESTING
	Connection con=db.getConnection();
	PreparedStatement pst=con.prepareStatement(QueryUtil.checkPwdByEmail);
	
	pst.setString(1, email);
	pst.setString(2, pwd);
	
	ResultSet rs= pst.executeQuery();
	
	if(rs.next()) {
		return 1;
	}
	else {
		return 0;
	}
}

public int updateUserPassword(User u) throws SQLException {
	Connection con=db.getConnection();
	PreparedStatement pst=con.prepareStatement(QueryUtil.updatePassword);
	
	pst.setString(1, u.getUpwd());
	pst.setString(2, u.getUname());
	
	return pst.executeUpdate();
	
}


}
