package com.yummyfork.operation;

import java.util.Scanner;
import com.yummyfork.dto.User;
import com.yummyfork.repository.UserRepository;

public class UserOperation {
	public static void main(String[] args) {
	
		int flag;
	UserRepository ur=new UserRepository();
	
	try(Scanner sc=new Scanner(System.in);){
		boolean isRunning=true;
		
		while(isRunning) {
			System.out.println("Enter choice:");
			System.out.println("1.insert user");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.select by username");
			System.out.println("5.User validity");

			int choice=sc.nextInt();
		
			switch(choice) {
			
			case 1:
				System.out.println("Enter users role,username, password");
				 flag=ur.addUser(new User(sc.next(),sc.next(),sc.next()));
				 
				 if(flag>0) {
					 System.out.println("insert use success");
				 }
				 else {
					 System.out.println("insert user failure");
				 }
				 break;
				 
			case 2:
				System.out.println("Enter username to update record:");
				String username=sc.next();
				int isFound=ur.getUserByUsername(new User(sc.next()));
						
				if(isFound>0) {
					System.out.println("Enter password");
					User user=new User(sc.next(),username);
					ur.updateUser(user);
				}
				break;
			case 3:
				System.out.println("Enter Username to delete");
				//String foodId=sc.next();
				ur.deleteUserByUsername(sc.next());
				break;
			
			case 4:
				System.out.println("Enter username to select");
				flag=ur.getUserByUsername(new User(sc.next()));
				if(flag>0) {
					System.out.println("User is preasent");
				}
				else{
					System.out.println("User is not preasent");
				}
				break;
				
			case 5:
				System.out.println("Enter role,username and pwd: ");
				User u=new User(sc.next(),sc.next(),sc.next());
				ur.userValidity(u);
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
