package com.yummyfork.dto;

public class FoodCategory {
	
	private String foodCategoryName;
	private String mainCategory;
	
	public FoodCategory() {
		super();
	}

	public FoodCategory(String foodCategoryName, String mainCategory) {
		super();
		this.foodCategoryName = foodCategoryName;
		this.mainCategory = mainCategory;
	}

	public String getFoodCategoryName() {
		return foodCategoryName;
	}

	public void setFoodCategoryName(String foodCategoryName) {
		this.foodCategoryName = foodCategoryName;
	}

	public String getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	
	

}
