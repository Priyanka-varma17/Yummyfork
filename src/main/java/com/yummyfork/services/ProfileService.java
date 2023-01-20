package com.yummyfork.services;

import com.yummyfork.dto.Customer;
import com.yummyfork.repository.CustomerRepository;

public class ProfileService {
	
	CustomerRepository cr;

	public ProfileService(CustomerRepository cr) {
		super();
		this.cr = cr;
	}
	public ProfileService() {
		cr=new CustomerRepository();
	}
//	public Customer getCustByMail(String mail) {
//		try {
//			return cr.getCustByEmail(mail);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public int updateCustomer(Customer cust) {
//		try {
//			return cr.updateCustomer(cust);
//		}catch(Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
}
