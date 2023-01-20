package com.yummyfork.services;

import com.yummyfork.dto.Admin;
import com.yummyfork.repository.AdminRepository;

public class AdminService {

	AdminRepository ar;
	
	public AdminService(AdminRepository ar) {
		super();
		this.ar = ar;
	}
	
	public AdminService() {
		ar=new AdminRepository();
	}

	public Admin getUserByMail(String mail) {
		try {
			return ar.getAdminByEmail(mail);
		}catch(Exception e) {
			System.out.println("in catch block");
			e.printStackTrace();
			return null;
		}
	}
	public int updateAdmin(Admin admin) {
		try {
			return ar.updateAdmin(admin);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
