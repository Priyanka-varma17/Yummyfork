package com.yummyfork.services;

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

}
