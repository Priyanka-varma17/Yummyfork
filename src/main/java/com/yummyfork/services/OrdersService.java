package com.yummyfork.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yummyfork.dto.Orders;
import com.yummyfork.repository.OrdersRepository;

public class OrdersService {
	
	OrdersRepository or;

	public OrdersService(OrdersRepository or) {
		super();
		this.or = or;
	}
	
	public OrdersService() {
		or=new OrdersRepository();
	}

	public int addOrders(Orders orders,String username) {
		try {
			return or.addOrders(orders,username);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Orders getTotalPrice(String email) {
		try {
			return or.getTotalPrice(email);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Orders> getAllOrdersList(String email) {
		try {
			return or.getOrderListByEmail(email);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Orders>();
		}
	}
}
