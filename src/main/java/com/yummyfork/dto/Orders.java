package com.yummyfork.dto;

public class Orders {

	private int orderId;
	private double totalPrice;
	private String status;
	private String email;
	
	
	public Orders() {
		super();
	}
	
	public Orders(double totalPrice, String status, String email) {
		super();
		this.totalPrice = totalPrice;
		this.status = status;
		this.email = email;
	}

	public Orders(int orderId, double totalPrice, String status, String email) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.email = email;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
