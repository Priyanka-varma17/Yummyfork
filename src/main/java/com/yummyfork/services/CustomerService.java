package com.yummyfork.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yummyfork.dto.Customer;
import com.yummyfork.repository.CustomerRepository;
import com.yummyfork.repository.UserRepository;

public class CustomerService {

		CustomerRepository cr;
		UserRepository ur;

		public CustomerService(CustomerRepository cr) {
			super();
			this.cr = cr;
		}
		
		public CustomerService() {
			cr=new CustomerRepository();
		}
		
		public int addCustomer(Customer c) {
			try {
				int flag=cr.getCustomerByEmail(c);
				if(flag>0) {
					return 0;
				}
				else {
					cr.addCustomer(c);
					return 1;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public int getCustomerByEmail(Customer c) {
			try {
				int flag=cr.getCustomerByEmail(c);
				if(flag>0) {
					return 1;
				}
				else {
					return 0;
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public Customer getCustBymail(String mail) {
			try {
				return cr.getCustByEmail(mail);
			}
			catch(Exception e) {
				System.out.println("did not get cust by mail");
				e.printStackTrace();
				return null;
			}
			
		}
		
		public int updateCustomer(Customer cust) {
			try {
				return cr.updateCustomer(cust);
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public List<Customer> getAllCustomer() {
			try {
				return cr.getAllCustomer();
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ArrayList<Customer>();
			}
		}
		
		public int deleteCustByEmail(String email) {
			try {
				return cr.deleteCustomerByEmail(email);
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
	
}
