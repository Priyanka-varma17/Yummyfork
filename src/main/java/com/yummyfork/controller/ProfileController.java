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

import com.yummyfork.dto.Admin;
import com.yummyfork.dto.Customer;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.User;
import com.yummyfork.services.AdminService;
import com.yummyfork.services.CustomerService;
import com.yummyfork.services.ProfileService;
import com.yummyfork.services.UserService;

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProfileService ps;
	UserService us;
	AdminService as;
	CustomerService cs;
	
    public ProfileController() {
        super();
        ps=new ProfileService();
        us=new UserService();
        as=new AdminService();
        cs=new CustomerService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation=request.getParameter("operation");
		response.setContentType("text/html");
		RequestDispatcher rd;
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("username");		
	
		
		
		
		if(operation!=null && operation.equals("editProfile")) {
			String email=request.getParameter("email");
			System.out.println("EditProfile==> "+email);
			
			String role=(String) session.getAttribute("role");
			if(role.equalsIgnoreCase("Customer")) {
				Customer c=cs.getCustBymail(email);					//ps to cs change
				request.setAttribute("Cust", c);
				rd=request.getRequestDispatcher("updateProfile.jsp");
				rd.forward(request, response);
			}else {
				Admin a=as.getUserByMail(email);
				request.setAttribute("Admin",a);
				rd=request.getRequestDispatcher("updateProfile.jsp");
				rd.forward(request, response);
			}
			
		
		}
		
		else {
			
			System.out.println("role---->: " +session.getAttribute("role"));
			
			String role=(String) session.getAttribute("role");
			if(role.equalsIgnoreCase("customer")) {
				
				Customer c=cs.getCustBymail(userEmail);		//changing ps to cs customerservice
				
				request.setAttribute("Cust", c);
				
				rd=request.getRequestDispatcher("ShowProfile.jsp");
				rd.forward(request, response);
			}
			else {
				Admin a=as.getUserByMail(userEmail);
				request.setAttribute("Admin", a);
				rd=request.getRequestDispatcher("ShowProfile.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		String roleTest=request.getParameter("role");
//		System.out.println("Inside ProfileController post method=======>"+roleTest);
		
		String operation=request.getParameter("operation");
		
		if(operation!=null && operation.equals("updateProfile"));{
			System.out.println("Inside ProfileController updateProfile");
			
			//int id=Integer.parseInt(request.getParameter("id"));
			String email=request.getParameter("email");
			String name=request.getParameter("custName");
			Long mob=Long.parseLong(request.getParameter("custMobile"));
			String addr=request.getParameter("custAddress");
			
			System.out.println("inside profileController post method");
			System.out.println(name+"==>"+mob+"==>"+addr+"==>"+email);
			
			HttpSession session=request.getSession();
			String role=(String) session.getAttribute("role");
			
			if(role.equalsIgnoreCase("customer")) {
				Customer c=new Customer(name,addr,mob,email);
				int flag=cs.updateCustomer(c);
				
				System.out.println("flag val==>"+flag);
				if(flag>0) {
					response.sendRedirect("ProfileController?operation=");
				}
				else {
					response.sendRedirect("ProfileController?operation=");
				}
				
			}
			else {
				Admin a=new Admin(name,addr,mob,email);
				int flag=as.updateAdmin(a);
				System.out.println("flag val==>"+flag);
				if(flag>0) {
					response.sendRedirect("ProfileController?operation=");
				}
				else {
					response.sendRedirect("ProfileController?operation=");
				}
			}
		
		}
	}

}
