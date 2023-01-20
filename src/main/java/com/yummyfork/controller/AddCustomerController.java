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

import com.yummyfork.dto.Customer;
import com.yummyfork.dto.Food;
import com.yummyfork.dto.User;
import com.yummyfork.services.CustomerService;
import com.yummyfork.services.UserService;

@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerService cs;
	
	UserService us;

  
    public AddCustomerController() {
        super();
        cs=new CustomerService(); 
        us=new UserService();
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd;
    	int custFlag,userFlag;
    	
    	String operation=request.getParameter("operation");
    	String custEmail=request.getParameter("custEmail");
    	
    	if(operation!=null && operation.equalsIgnoreCase("deleteCustomer")) {
    		
    		System.out.println("getting custEmail in addCustomer controller----> "+custEmail);
    		custFlag=cs.deleteCustByEmail(custEmail);		//to delete cust details from customer table
    		userFlag=us.deleteUserByEmail(custEmail);		//to delete credentials from user table
    		
    		
    		
    		if(custFlag>0 && userFlag>0) {
    			System.out.println("cust record deleted successfully");
    			rd = request.getRequestDispatcher("AddCustomerController?operation=");
				rd.include(request, response);
    		}
    		else {
    			System.out.println("cust record not deleted");
    			
    		}
    	}
    	
    	else {
    		List<Customer> custList = cs.getAllCustomer();
    		request.setAttribute("custList", custList);
    		rd = request.getRequestDispatcher("CustomerList.jsp");
    		rd.forward(request, response);
    	}
    
		
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	RequestDispatcher rd;
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		//RequestDispatcher rd;
		response.setContentType("text/html");
		
		String operation=request.getParameter("operation");
		System.out.println("OPERATION IS: "+operation);
		
		if(operation.equalsIgnoreCase("addCustomer")) {
		
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		long mob=Long.parseLong(request.getParameter("mob"));
		String email=request.getParameter("mail");
		String pwd=request.getParameter("pwd");
	
		Customer c=new Customer(name,addr,mob,email);
		User u=new User(role,email,pwd);
		
		System.out.println(role+"---------"+name+"..."+addr+"..."+mob+"..."+email+"---------");
		out=response.getWriter();
		
		int flag;
		
			
			//adding cust's (role,username,pwd) in customer table
			flag=cs.addCustomer(c);
			System.out.println("flag="+flag);
			
			if(flag>0) {
				rd=request.getRequestDispatcher("SignUp.jsp");
				out.println("Successfully registered...Now, You can login");
				rd.include(request,response);
				
			}
			else {
				rd=request.getRequestDispatcher("SignUp.jsp");
				out.println("User with this username is already exist...");
				rd.include(request,response);
				
			}
			
			//adding cust's (role,username,pwd) in user table
			flag=us.addUser(u);

			if(flag>0) {
				out.println("customer added successfully");
			}
			else {
				out.println("failed to add customer");
			}
		}
		else if(operation.equalsIgnoreCase("changePassword")) {
			
			String oldPwd=request.getParameter("oldpassword");
			String newPwd=request.getParameter("newpassword");
			
			String username=(String)session.getAttribute("username");
			
			System.out.println("oldpwd= "+oldPwd+" newPwd"+newPwd+" username"+username);
			
			int flag=us.checkPwdByEmail(username, oldPwd);
			
			if(flag>0) {
				System.out.println("flag "+flag);
				
				User u=new User(newPwd,username);
				int updateFlag=us.updateUserPassword(u);
				
				
				if(updateFlag>0) {
					System.out.println("updateFlag "+updateFlag);
					System.out.println("password changed successfully...........");
					rd=request.getRequestDispatcher("Home.jsp");
					out.println("PASSWORD CHANGED-----");
					rd.include(request, response);
					
				}
				else {
					System.out.println("password not changed");
				}
			}
			else {
				rd=request.getRequestDispatcher("ChangePassword.jsp");
				out.println("Your old password didn't match");
				rd.include(request, response);
			}
		}
		}
	}

