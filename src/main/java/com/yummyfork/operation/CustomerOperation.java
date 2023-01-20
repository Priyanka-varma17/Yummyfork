//package com.yummyfork.operation;
//
//import java.util.Scanner;
//
//import com.yummyfork.dto.Customer;
//
//import com.yummyfork.repository.CustomerRepository;
//
//
//public class CustomerOperation {
//
//	public static void main(String[] args) {
//		
//		CustomerRepository fr=new CustomerRepository();
//		try(Scanner sc=new Scanner(System.in);){
//			boolean isRunning=true;
//			
//			while(isRunning) {
//				System.out.println("Enter choice:");
//				System.out.println("1.insert customer");
//				System.out.println("2.update");
//				System.out.println("3.delete");
//				System.out.println("4.select by id");
//				System.out.println("5.select all customers");
//				System.out.println("6.select customer by mail");
//				
//				int choice=sc.nextInt();
//			
//				switch(choice) {
//				
//				case 1:
//					System.out.println("Enter customer name,address,mobile,email");
//					 fr.addCustomer(new Customer(sc.next(),sc.next(),sc.nextLong(),sc.next()));
//					 break;
//					 
//				case 2:
//					System.out.println("Enter customerID to update record:");
//					int isFound=fr.getCustomerById(new Customer(sc.nextInt()));
//							
//					if(isFound>0) {
//						System.out.println("Enter customerName,Address,Mobile,Email");
//						Customer customer=new Customer(sc.next(),sc.next(),sc.nextLong(),sc.next());
//						fr.updateCustomer(customer);
//					}
//					break;
//				
//				case 3:
//					System.out.println("Enter customerID to delete");
//					//String foodId=sc.next();
//					fr.deleteCustomerById(sc.nextInt());
//					break;
//					
//				case 4:
//					System.out.println("Enter cust id to select");
//					
//					int flag=fr.getCustomerById(new Customer(sc.nextInt()));
//					
//					if(flag>0) {
//						System.out.println("operation success");
//					}
//					else {
//						System.out.println("operation fail");
//					}
//					break;
//					
//				case 5:
//					System.out.println("select all");
//					fr.getAllCustomer();
//					break;
//					
//				case 6:
//					System.out.println("select cust by mail");
//					System.out.println("Enter mail");
//					fr.getCustByEmail(sc.next());
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
//
//}
