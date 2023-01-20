package com.yummyfork.dto;

public class Cart {
	
	private int CartId;
	private int FoodId;
	private String CustEmail;
	private int Quantity;
	private String foodName;
	
	public Cart(int cartId, int foodId, String custEmail, int quantity) {
		super();
		CartId = cartId;
		FoodId = foodId;
		CustEmail = custEmail;
		Quantity = quantity;
	}
	
	

	public Cart(int cartId, int foodId, String custEmail, int quantity, String foodname) {		//test
		super();
		CartId = cartId;
		FoodId = foodId;
		CustEmail = custEmail;
		Quantity = quantity;
		foodName = foodname;
	}



	public Cart() {
		super();
	}

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public int getFoodId() {
		return FoodId;
	}

	public void setFoodId(int foodId) {
		FoodId = foodId;
	}

	public String getCustEmail() {
		return CustEmail;
	}

	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}	
	
	
}
