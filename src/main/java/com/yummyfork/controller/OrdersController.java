package com.yummyfork.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyfork.dto.Cart;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.Orders;
import com.yummyfork.services.CartServices;
import com.yummyfork.services.OrdersService;

@WebServlet("/OrdersController")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrdersService os;
	CartServices cs;
	
    public OrdersController() {
        super();
        os=new OrdersService();
        cs=new CartServices();
    }

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String operation=request.getParameter("operation");
		 RequestDispatcher rd;
		 PrintWriter out=response.getWriter();
		 
		 String username=(String) session.getAttribute("username");
		 
		 if(operation!=null && operation.equalsIgnoreCase("insertToOrder")) {
			 
		System.out.println("inside orders controller---------");
	
		Orders price=os.getTotalPrice(username);		//To calculate total price
		
		int flag=os.addOrders(price,username);
		
		int cartFlag=cs.deleteCartByEmail(username);
		
		//int foodId=Integer.parseInt(request.getParameter("foodId"));
		//int cartId=Integer.parseInt(request.getParameter("cartId"));
		
		//int cflag= cs.deleteFromCart(cartId, username,foodId);
		
		
		
		if(flag>0 && cartFlag>0) {
		
			out.println("order placed----");														//msg is not showing why????
			rd = request.getRequestDispatcher("CartController");		
			
			rd.include(request, response);		
			
		}
		else {
			System.out.println("order not placed");
		}
		
	 }
		 
		 else if(operation!=null && operation.equalsIgnoreCase("order")){
			 List<Orders> orderList = os.getAllOrdersList(username);
				request.setAttribute("orderList", orderList);
				rd = request.getRequestDispatcher("Order.jsp");
				rd.forward(request, response);
		 }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
