package com.yummyfork.operation;

import java.util.Scanner;

import com.yummyfork.dto.Cart;
import com.yummyfork.repository.CartRepository;


public class CartOperation {

	public static void main(String[] args) {

		CartRepository cr=new CartRepository();
		try(Scanner sc=new Scanner(System.in);){
			boolean isRunning=true;
			
			while(isRunning) {
				System.out.println("Enter choice:");
				System.out.println("1.insert cart");
				System.out.println("2.update");
				System.out.println("3.delete");
				System.out.println("4.select by cart id");
				System.out.println("5.select all cart");

				int choice=sc.nextInt();
			
				switch(choice) {
				
				case 1:
					System.out.println("Enter cart quantity,cart food id,cart food id");
					 //cr.addCart(new Cart(sc.nextInt(),sc.nextInt(),sc.nextInt()));
					 break;
					 
				case 2:
					System.out.println("Enter cartID to update record:");
					int updateId=sc.nextInt();
					//boolean isFound=cr.getCartByCartId(updateId);
							
					//if(isFound) 
					{
						System.out.println("Enter cart quantity,cart food id,cart food id");
						//Cart cart=new Cart(updateId,sc.nextInt(),sc.nextInt(),sc.nextInt());
						//cr.updateCart(cart);
					}
					break;
				
				case 3:
					System.out.println("Enter cartID to delete");
					//String foodId=sc.next();
					//cr.deleteCartById(sc.nextInt());
					break;
					
				case 4:
					System.out.println("Enter cart id to select");
					//cr.getCartByCartId(sc.nextInt());
					break;
					
				case 5:
					System.out.println("select all");
					//cr.getAllCart();
				
					
				default:
					System.out.println("Please enter valid choice");
				}
			

			}
		}catch(Exception e) {
			throw new RuntimeException("Something went wrong..."+e);

		}

	}

}
