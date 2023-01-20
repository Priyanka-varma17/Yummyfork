package com.yummyfork.dto;

public class User {

	private String role;
	private String uname;
	private String upwd;
	
	public User() {
		super();
	} 
	
	public User(String role, String uname, String upwd) {
		super();
		this.role = role;
		this.uname = uname;
		this.upwd = upwd;
	}

	public User(String upwd,String uname) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	public User(String uname) {
		super();
		this.uname = uname;	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
