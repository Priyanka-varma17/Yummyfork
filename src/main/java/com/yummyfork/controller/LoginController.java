package com.yummyfork.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyfork.dto.User;
import com.yummyfork.services.LoginService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	LoginService ls;
	
    public LoginController() {
        super();
        ls=new LoginService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("role");
		
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		response.setContentType("text/html");
				
		User u=new User(role,uname,pwd);
		System.out.println("Username= "+uname+"\t"+"Password= "+pwd);
		
		int flag=ls.checkValidity(u);
		System.out.println("flag="+flag);
		
		if(flag>0) {
		
			session.setAttribute("username",uname);
					
			session.setAttribute("role",role);
			
			System.out.println("name: " +session.getAttribute("username"));
			response.sendRedirect("Home.jsp");
						
		}
		else {
			
			rd=request.getRequestDispatcher("Login.jsp");
			out.println("Invalid Username or password");
			rd.include(request,response);
		}

	}

}
