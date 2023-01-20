package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Customer;
import com.yummyfork.dto.Food;

public class CustomerRepository {
	DatabaseConnection db=new DatabaseConnection();
	
	public int addCustomer(Customer customer)throws SQLException{		//ex
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addCustomer);){
			pst.setString(1,customer.getCustName());
			pst.setString(2,customer.getCustAddress());
			pst.setLong(3,customer.getCustMobile());
			pst.setString(4,customer.getCustEmail());
			
			System.out.println(customer.getCustName()+"\t"+customer.getCustAddress()+"\t"+customer.getCustMobile()+"\t"+customer.getCustEmail());
			
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				System.out.println("Record inserted successfully");
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
	
	public int getCustomerById(Customer cust) throws SQLException{			//ex
		
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getCustomerById);
				){
			
			pst.setInt(1, cust.getCustId());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
		
				System.out.println("Customer name:"+rs.getString("custname"));
				System.out.println("Customer Address:"+rs.getString("custaddress"));
				System.out.println("Customer Mobile:"+rs.getLong("custmobile"));
				System.out.println("Customer Email:"+rs.getString("custemail"));
				
				return 1;
			}
			else {
				System.out.println("Record not found for cust id:  "+cust.getCustId());
				return 0;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public Customer getCustByEmail(String mail) throws SQLException{		//new
		
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getCustomerByEmail);
				
			
			pst.setString(1, mail);
			ResultSet rs=pst.executeQuery();

			while (rs.next()) {
			Customer c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustAddress(rs.getString(3));
				c.setCustMobile(rs.getLong(4));
				c.setCustEmail(rs.getString(5));
				
				return c;
			}
		
		return null;
		
	}
	
public int getCustomerByEmail(Customer cust) throws SQLException{			//ex
		
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getCustomerByEmail);
				){
			
			pst.setString(1, cust.getCustEmail());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				return 1;
			}
			else {
				System.out.println("Record not found for cust email:  "+cust.getCustEmail());
				return 0;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int updateCustomer(Customer customer) throws SQLException {		//ex
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.updateCustomer);
			
			pst.setString(1, customer.getCustName());
			pst.setString(2, customer.getCustAddress());
			pst.setLong(3, customer.getCustMobile());
			pst.setString(4, customer.getCustEmail());
			
			System.out.println("inside customer repository");
			System.out.println(customer.getCustName()+"==>"+customer.getCustAddress()+"==>"+customer.getCustMobile()+"==>"+customer.getCustEmail());
			return pst.executeUpdate();
	}
	
	public int deleteCustomerByEmail(String email) throws SQLException{		//ex
		try(Connection con=db.getConnection();
								
				PreparedStatement pst=con.prepareStatement(QueryUtil.deleteCustomerByEmail);){
				pst.setString(1, email);
				
			return pst.executeUpdate();
	
		}
	}
	
	public List<Customer> getAllCustomer() throws SQLException{		//ex
		Connection con=db.getConnection();
		List<Customer> custList=new ArrayList<Customer>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getAllCustomer);
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			
			Customer cust=new Customer();
			cust.setCustId(rs.getInt(1));
			cust.setCustName(rs.getString(2));
			cust.setCustAddress(rs.getString(3));
			cust.setCustMobile(rs.getLong(4));
			cust.setCustEmail(rs.getString(5));
			
			custList.add(cust);
			
		}
		return custList;
		
	}
	


}
