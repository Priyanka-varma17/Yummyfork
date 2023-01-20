//package com.yummyfork.operation;
//
//import java.util.Scanner;
//
//import com.yummyfork.dto.Food;
//import com.yummyfork.repository.FoodRepository;
//
//
//public class FoodOperation {
//
//	public static void main(String[] args) {
//		
//		FoodRepository fr=new FoodRepository();
//		try(Scanner sc=new Scanner(System.in);){
//			boolean isRunning=true;
//			
//			while(isRunning) {
//				System.out.println("Enter choice:");
//				System.out.println("1.insert");
//				System.out.println("2.update");
//				System.out.println("3.delete");
//				System.out.println("4.select by id");
//				System.out.println("5.select by category");
//				System.out.println("6.select all");
//				System.out.println("7.select by name");
//
//				int choice=sc.nextInt();
//			
//				switch(choice) {
//				
//				case 1:
//					System.out.println("Enter food name,price,quantity,category");
//					 fr.addFood(new Food(sc.next(),sc.nextFloat(),sc.nextInt(),sc.next()));
//					 break;
//					 
//				case 2:
////					System.out.println("Enter food id to update record:");
////					int updateId=sc.nextInt();
////					boolean isFound=fr.getFoodById(updateId);
////							
////					if(isFound) {
////						System.out.println("isFound:   "+isFound);
////						System.out.println("Enter food_name,price,quantity,category");
////						Food food=new Food(sc.next(),sc.nextDouble(),sc.nextInt(),sc.next());
////						fr.updateFood(food);
////					}
//					break;
//					
//				case 3:
//					System.out.println("Enter food_id to delete");
//					//String foodId=sc.next();
//					fr.deleteFoodById(sc.nextInt());
//					break;
//					
//				case 4:
//					System.out.println("Enter food id to select");
//					fr.getFoodById(sc.nextInt());
//					break;
//					
//				case 5:
////					System.out.println("Enter food category to select:");
////					fr.getFoodByCategory(sc.next());
////					break;
//					
//				case 6:
//					System.out.println("select all");
//					fr.getAllFood();
//					break;
//					
//				case 7:
//					System.out.println("select by name");
//					System.out.println("Enter food name");
//					fr.getFoodByName(sc.next());
//					break;
//					
//				default:
//					System.out.println("Please enter valid choice");
//				}
//			
//
//			}
//		}catch(Exception e) {
//			throw new RuntimeException("Something went wrong..."+e);
//
//		}
//	}
//}
