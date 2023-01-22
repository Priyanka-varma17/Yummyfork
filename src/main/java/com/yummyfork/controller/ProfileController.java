package com.yummyfork.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yummyfork.dto.Admin;
import com.yummyfork.dto.Customer;
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
		HttpSession session=request.getSession();
		String userEmail=(String) session.getAttribute("username");		
	
		if(operation!=null && operation.equals("editProfile")) {
			String email=request.getParameter("email");
			
			String role=(String) session.getAttribute("role");
			if(role.equalsIgnoreCase("Customer")) {
				Customer c=cs.getCustBymail(email);					
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
			
			String role=(String) session.getAttribute("role");
			if(role.equalsIgnoreCase("customer")) {
				
				Customer c=cs.getCustBymail(userEmail);	
				
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
	
		String operation=request.getParameter("operation");
		
		if(operation!=null && operation.equals("updateProfile"));{
			String email=request.getParameter("email");
			String name=request.getParameter("custName");
			Long mob=Long.parseLong(request.getParameter("custMobile"));
			String addr=request.getParameter("custAddress");

			HttpSession session=request.getSession();
			String role=(String) session.getAttribute("role");
			
			if(role.equalsIgnoreCase("customer")) {
				Customer c=new Customer(name,addr,mob,email);
				int flag=cs.updateCustomer(c);

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
