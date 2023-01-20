package com.yummyfork.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yummyfork.connection.DatabaseConnection;
import com.yummyfork.connection.QueryUtil;
import com.yummyfork.dto.FoodCategory;

public class FoodCategoryRepository {
	
	DatabaseConnection db=new DatabaseConnection();
	
	public void addFoodCategory(FoodCategory foodCategory)throws SQLException{
		
		try(Connection connection=db.getConnection();
				PreparedStatement pst=connection.prepareStatement(QueryUtil.addFoodCategory);){
			pst.setString(1,foodCategory.getFoodCategoryName());
			pst.setString(2,foodCategory.getMainCategory());
			
			
			int rows=pst.executeUpdate();
			System.out.println(rows);
			if(rows>0) {
				System.out.println("Record inserted successfully");
				System.out.println("*****************************");

			}
			else {
				System.out.println("Failed to insert record");
			}
		
		}
	}
	
	public boolean getFoodByName(String foodCategoryName) throws SQLException {
		boolean isFound=false;
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodCategoryByName);
				){
			pst.setString(1,foodCategoryName);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				isFound=true;
				
				System.out.println("Food Category name: "+rs.getString(1));
				System.out.println("Food main Category: "+rs.getString(2));
				System.out.println("*****************************");
			}
			else {
				System.out.println("Recoord not found for category name: "+foodCategoryName);
			}
		}
		return isFound;
	}
	
	public void updateFoodCategory(FoodCategory foodCategory) throws SQLException {
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.updateFoodCategory);){
			
			pst.setString(1, foodCategory.getMainCategory());
			pst.setString(2, foodCategory.getFoodCategoryName());
						
			int rows=pst.executeUpdate();
			
			if(rows>0) {
				System.out.println("Record updated successfully");
				System.out.println("*****************************");
			}
			else {
				System.out.println("Failed to update record");
			}
		}
	}
	
	public void deleteFoodCategoryByName(String foodCategoryName) throws SQLException{
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.deleteFoodCategory);){
			
			pst.setString(1, foodCategoryName);
			int rows=pst.executeUpdate();
			
			if(rows>0) {
				System.out.println("Record deleted successfully");
				System.out.println("*****************************");
			}
			else {
				System.out.println("Failed to delete record");
			}
			
		}
	}
	
	public void getFoodCategory() throws SQLException{
		
		try(Connection con=db.getConnection();
				PreparedStatement pst=con.prepareStatement(QueryUtil.getFoodCategory);){
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				System.out.println("Food category name: "+rs.getString(1));
				System.out.println("Food main category: "+rs.getString(2));
				System.out.println("**********************************");
		
			}
		}
		
	}

}
