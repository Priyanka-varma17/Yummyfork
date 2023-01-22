package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.Cart;

public class CartRepository {
	
	DatabaseConnection db=new DatabaseConnection();

	public int addToCart(Cart cart)throws SQLException{
		
		try(
		Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.ADD_TO_CART)){
			pst.setInt(1, cart.getFoodId());
			pst.setString(2, cart.getCustEmail());
			pst.setInt(3, cart.getQuantity());
			pst.setString(4, cart.getFoodName());
				
			return pst.executeUpdate();		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int updateCart(Cart cart) {
		try(
				Connection connection=db.getConnection();
						PreparedStatement pst=connection.prepareStatement(QueryUtil.UPDATE_CART)){
			pst.setInt(1, cart.getFoodId());
			pst.setString(2, cart.getCustEmail());
			pst.setInt(3, cart.getQuantity());;
			pst.setString(4, cart.getFoodName());
			
			
			return pst.executeUpdate();
						
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean isCartPresent(Cart cart) {
		try(
				Connection connection=db.getConnection();
						PreparedStatement pst=connection.prepareStatement(QueryUtil.CART_PRESENT)){
			pst.setString(1, cart.getCustEmail());
			pst.setInt(2, cart.getFoodId());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)>0) {
					System.out.println("inside cartRepository....already present in cart ");
					return true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Cart> getCartDetails(String username) throws SQLException{		
		Connection con=db.getConnection();
		List<Cart> itemList=new ArrayList<Cart>();
		
		PreparedStatement pst=con.prepareStatement(QueryUtil.getCartByEmail);

		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			Cart cart=new Cart();
						
			cart.setCartId(rs.getInt("cart_Id"));
			cart.setFoodId(rs.getInt("food_Id"));
			cart.setCustEmail(rs.getString(3));			
			cart.setQuantity(rs.getInt("cart_quantity"));
			cart.setFoodName(rs.getString("foodname"));
			
			itemList.add(cart);
		}
		return itemList;
	}
	
	
	public int deleteFromCart(int cartId,String custEmail,int foodId) throws SQLException {
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.DELETE_CART);
			pst.setInt(1, cartId);
			pst.setString(2, custEmail);
			pst.setInt(3, foodId);
			
			
		return pst.executeUpdate();
	}
	
	public int deleteCartByEmail(String custEmail) throws SQLException {
		Connection con=db.getConnection();
		PreparedStatement pst=con.prepareStatement(QueryUtil.DELETE_CART_BY_EMAIL);
			pst.setString(1, custEmail);			
			
		return pst.executeUpdate();
	}
	
}
