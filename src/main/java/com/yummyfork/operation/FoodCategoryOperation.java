package com.yummyfork.operation;

import java.util.Scanner;
import com.yummyfork.dto.FoodCategory;
import com.yummyfork.repository.FoodCategoryRepository;

public class FoodCategoryOperation {

public static void main(String[] args) {
		
		FoodCategoryRepository fcr=new FoodCategoryRepository();
		try(Scanner sc=new Scanner(System.in);){
			boolean isRunning=true;
			
			while(isRunning) {
				System.out.println("Enter choice:");
				System.out.println("1.insert Food category");
				System.out.println("2.update");
				System.out.println("3.delete");
				System.out.println("4.select by food category name");
				System.out.println("5.select all food category");

				int choice=sc.nextInt();
			
				switch(choice) {
				
				case 1:
					System.out.println("Enter food category name,main category");
					 fcr.addFoodCategory(new FoodCategory(sc.next(),sc.next()));
					 break;
					 
				case 2:
					System.out.println("Enter food category name to update:");
					String updateName=sc.next();
					boolean isFound=fcr.getFoodByName(updateName);
							
					if(isFound) {
						System.out.println("Enter main food category");
						FoodCategory foodCategory=new FoodCategory(updateName,sc.next());
						fcr.updateFoodCategory(foodCategory);
					}
					break;
				
				case 3:
					System.out.println("Enter food category to delete");
					fcr.deleteFoodCategoryByName(sc.next());
					break;
					
				case 4:
					System.out.println("Enter food category to select");
					fcr.getFoodByName(sc.next());
					break;
					
				case 5:
					System.out.println("select all");
					fcr.getFoodCategory();
					break;
					
				default:
					System.out.println("Please enter valid choice");
				}
			

			}
		}catch(Exception e) {
			throw new RuntimeException("Something went wrong..."+e);

		}
	}
}
