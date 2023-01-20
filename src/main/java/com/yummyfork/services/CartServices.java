package com.yummyfork.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.dto.Cart;
import com.yummyfork.dto.Food;
import com.yummyfork.repository.CartRepository;

public class CartServices {
	
	CartRepository cr;

	public CartServices(CartRepository cr) {
		super();
		this.cr = cr;
	}
	
	public CartServices() {
		cr=new CartRepository();
	}

	public int addOrUpdateToCart(Cart c) throws SQLException {
		
		boolean isCartPresent =cr.isCartPresent(c);
		if(isCartPresent) {
			return cr.updateCart(c);
		}else {
			return cr.addToCart(c);
		}
	}
	
	public List<Cart> getItemByEmail(String username) {		
		try {
			
			return cr.getCartDetails(username);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Cart>();
		}
	}
	
	
	public int deleteFromCart(int cartId,String custEmail,int foodId) {
		try {
			return cr.deleteFromCart(cartId, custEmail,foodId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int deleteCartByEmail(String custEmail) {
		try {
			return cr.deleteCartByEmail(custEmail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
