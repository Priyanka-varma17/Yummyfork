package com.yummyfork.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yummyfork.dto.Food;
import com.yummyfork.repository.FoodRepository;

public class FoodService {
	
	FoodRepository fr;

	public FoodService(FoodRepository fr) {
		super();
		this.fr = fr;
	}

	public FoodService() {
		fr=new FoodRepository();
	}
	
	public int addFood(Food f) {
		try {
			return fr.addFood(f);
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("can not add food");
			return 0;
		}
	}

	
	public int updateFood(Food f) {
		try {
			return fr.updateFood(f);
		} catch(Exception e) {
			System.out.println("cannot update food");
			return 0;
		}
	}
	
	public List<Food> getAllFood() {
		try {
			return fr.getAllFood();
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Food>();
		}
	}
	
	public int deleteFood(int foodId) {
		try {
			return fr.deleteFoodById(foodId);
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Food getFoodById(int id) {
		try {
			return fr.getFoodById(id);
		}catch(Exception e) {
			System.out.println("didnot get food by id");
			e.printStackTrace();
			return null;
		}
	}

	public List<Food> getFoodByName(String name) {
		try {
			System.out.println("got food list from repository");
			return fr.getFoodByName(name);
		}
		catch(Exception e) {
			System.out.println("didnot get food list from repository");
			e.printStackTrace();
			return new ArrayList<Food>();
		}
	}
	
	public List<Food> getFoodByCategorySearch(String category,String mainCategory) {
		try {
			System.out.println("got search food list from repository");
			return fr.getFoodByCategorySearch(category,mainCategory);
		}
		catch(Exception e) {
			System.out.println("didnot get search food list from repository");
			e.printStackTrace();
			return new ArrayList<Food>();
		}
	}

}
