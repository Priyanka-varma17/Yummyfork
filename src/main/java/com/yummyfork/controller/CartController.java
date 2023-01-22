package com.yummyfork.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yummyfork.dto.Cart;
import com.yummyfork.services.CartServices;
import com.yummyfork.services.FoodService;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CartServices cs;
	FoodService fs;
  
    public CartController() {
        super();
        cs=new CartServices();
        fs=new FoodService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("txt/html");
		RequestDispatcher rd;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		String operation=request.getParameter("operation");
		if(operation!=null && operation.equalsIgnoreCase("addToCart")) {
			int foodId=Integer.parseInt(request.getParameter("foodId"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			//String foodname=request.getParameter("foodname");
		
			Cart cart=new Cart();
			cart.setCustEmail((String)session.getAttribute("username"));
			cart.setFoodId(foodId);
			cart.setQuantity(quantity);
			//cart.setFoodName(foodname);
			
			System.out.println("inside cart controller doget method");
			System.out.println(foodId+"*****"+quantity+"*****");
			try {
				cs.addOrUpdateToCart(cart);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.print("Successfully added item to cart!!!");
		}	
		
		else if(operation!=null && operation.equalsIgnoreCase("RemoveFromCart")) {
			
			String username=request.getParameter("username");
			int foodId=Integer.parseInt(request.getParameter("foodId"));
			int cartId=Integer.parseInt(request.getParameter("cartId"));
			
			System.out.println("username::  "+username+ " cartId::    "+cartId+" foodId:: "+foodId);
			
			int flag= cs.deleteFromCart(cartId, username,foodId);
			
			if(flag>0) {
				System.out.println("cart item deleteed");
				out.println("success deleting food");
				response.sendRedirect("CartController");
			}
			else {
				System.out.println("cart item not deleteed");
				
				rd = request.getRequestDispatcher("CartController?operation=");
				rd.include(request, response);
			}
		}
		
		else  {
			
		String username=(String) session.getAttribute("username");
		
		System.out.println("USERNAME IS==>"+username);
				
		List<Cart> cartItem = cs.getItemByEmail(username);
		request.setAttribute("cartItem", cartItem);
		rd = request.getRequestDispatcher("ShowCart.jsp");
		rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
