//package com.yummyfork.operation;
//
//import java.util.Scanner;
//import com.yummyfork.dto.Orders;
//import com.yummyfork.repository.OrdersRepository;
//
//public class OrderOperation {
//
//	public static void main(String[] args) {
//		
//		OrdersRepository or=new OrdersRepository();
//		try(Scanner sc=new Scanner(System.in);){
//			boolean isRunning=true;
//			
//			while(isRunning) {
//				System.out.println("Enter choice:");
//				System.out.println("1.insert order");
//				System.out.println("2.update");
//				System.out.println("3.delete");
//				System.out.println("4.select by order id");
//				System.out.println("5.select all order");
//
//				int choice=sc.nextInt();
//			
//				switch(choice) {
//				
//				case 1:
//					System.out.println("Enter order total bill,custid,status");
//					 or.addOrders(new Orders(sc.nextDouble(),sc.nextInt(),sc.next()));
//					 break;
//					 
//				case 2:
//					System.out.println("Enter orderID to update record:");
//					int updateId=sc.nextInt();
//					boolean isFound=or.getOrderById(updateId);
//							
//					if(isFound) {
//						System.out.println("Enter order total bill,custid,status");
//						Orders orders=new Orders(updateId,sc.nextDouble(),sc.nextInt(),sc.next());
//						or.updateOrder(orders);
//					}
//					break;
//				
//				case 3:
//					System.out.println("Enter orderID to delete");
//					//String foodId=sc.next();
//					or.deleteOrderById(sc.nextInt());
//					break;
//					
//				case 4:
//					System.out.println("Enter order id to select");
//					or.getOrderById(sc.nextInt());
//					break;
//					
//				case 5:
//					System.out.println("select all");
//					or.getAllOrders();
//				
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
//
//	}
//
//}
