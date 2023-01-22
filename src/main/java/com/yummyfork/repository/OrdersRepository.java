package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.Orders;

public class OrdersRepository {		
	
	DatabaseConnection db=new DatabaseConnection();
	
	public Orders getTotalPrice(String email) throws SQLException {
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getTotalPrice);
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();

		if(rs.next()) {
			Orders order=new Orders();
			order.setTotalPrice(rs.getDouble(1));
			System.out.println("inside orders repository  " +rs.getDouble(1));
			
			return order;			
		}
		return null;
	}
	
	

	public int addOrders(Orders orders,String username)throws SQLException{
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addOrders);){
			pst.setDouble(1,orders.getTotalPrice());
			pst.setString(2,"completed");
			pst.setString(3, username);
				
			return pst.executeUpdate();
		}
	}
	
	public List<Orders> getOrderListByEmail(String email) throws SQLException{		
		Connection con=db.getConnection();
		List<Orders> orderList=new ArrayList<Orders>();
		PreparedStatement pst=con.prepareStatement(QueryUtil.getOrderListByEmail);
		
	
		pst.setString(1,email);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			Orders o=new Orders();
			o.setOrderId(rs.getInt(1));
			o.setTotalPrice(rs.getDouble(2));
			o.setStatus(rs.getString(3));
			o.setEmail(rs.getString(4));
			orderList.add(o);
		}
		return orderList;
		
	}
	

}
