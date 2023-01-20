package com.yummyfork.dto;

public class Admin {

	private int adminId;
	private String adminName;
	private String adminAddress;
	private long adminMobile;
	private String adminEmail;
	
	public Admin() {
		super();
	}
	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin(String adminName, String adminAddress, long adminMobile, String adminEmail) {
		super();
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminMobile = adminMobile;
		this.adminEmail = adminEmail;
	}

	public Admin(int adminId, String adminName, String adminAddress, long adminMobile, String adminEmail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminAddress = adminAddress;
		this.adminMobile = adminMobile;
		this.adminEmail = adminEmail;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public long getAdminMobile() {
		return adminMobile;
	}

	public void setAdminmobile(long adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
}
