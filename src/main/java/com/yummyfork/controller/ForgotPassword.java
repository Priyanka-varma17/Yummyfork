package com.yummyfork.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yummyfork.dto.User;
import com.yummyfork.services.UserService;


@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {

	private static final long serialVersionUID = -4935208342175657412L;
	UserService us;

    public ForgotPassword() {
        super(); 
        us=new UserService();
   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		RequestDispatcher rd;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();
		
		
		String operation=request.getParameter("operation");
		System.out.println("OPERATION VALUE== "+operation);
		
		if(operation!=null && operation.equalsIgnoreCase("forgotpassword")) {		
			User u=new User(email);
			int flag=us.checkUsernameExist(u);			//to check whether entered email is already exist or not in our User table
														//if yes, then you will get otp otherwise u have to signup
			if(flag>0) {
				out.println("SENDING OTP ON EMAIL");
				
				if(email!=null || !email.equals("")) {
					
					Random rand = new Random();
					otpvalue = rand.nextInt(125560);

					String to = email;// change accordingly
					// Get the session object
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {

							return new PasswordAuthentication("", "");  //Enter your email and web app pwd

						}
					});
					// compose message
					try {
						MimeMessage message = new MimeMessage(session);
						message.setFrom(new InternetAddress(email));
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						message.setSubject("Bye,bye old password! You're about to be reset.");
						message.setText("Your OTP is: " + otpvalue);
						// send message
						Transport.send(message);
						System.out.println("message sent successfully");
					}

					catch (MessagingException e) {
						throw new RuntimeException(e);
					}
					rd = request.getRequestDispatcher("EnterOtp.jsp");
					request.setAttribute("message","OTP is sent to your email id");
					mySession.setAttribute("otp",otpvalue); 
					mySession.setAttribute("email",email); 
					rd.forward(request, response);
				}
			}
			else {
				response.setContentType("text/html");
				rd=request.getRequestDispatcher("forgotPassword.jsp");
				out.println("Entered Email is not registered, Please signup !");
				rd.include(request, response);
			}
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("ValidateOtp")) {
			int value=Integer.parseInt(request.getParameter("otp"));
			HttpSession session=request.getSession();
			int otp=(int)session.getAttribute("otp");
			
			if (value==otp) 
			{
				request.setAttribute("email", request.getParameter("email"));
				request.setAttribute("status", "success");
				rd=request.getRequestDispatcher("newPassword.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("message","wrong otp");
				response.setContentType("text/html");	
			   rd=request.getRequestDispatcher("EnterOtp.jsp");
				rd.include(request, response);
			}
		}
		
		else if(operation!=null && operation.equalsIgnoreCase("resetpassword")) {
			
			HttpSession session = request.getSession();
			out=response.getWriter();
			String newPassword = request.getParameter("password");
			
			System.out.println("EMAIL"+ (String) session.getAttribute("email")+" NEW PASSWORD "+newPassword);
			
			String confPassword = request.getParameter("confPassword");
			
			if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

				User u=new User(newPassword, (String) session.getAttribute("email"));
				
				int flag=us.updateUser(u);
				if(flag>0) {
					response.setContentType("text/html");
					System.out.println("password updated successfully");
					
					out.println("Password updated successfully");
					
					request.setAttribute("status", "resetSuccess");
					rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
					
				}
				else {
					request.setAttribute("status", "resetFailed");
					System.out.println("password not updated ");
				}
			}
			
			else {
				request.setAttribute("pwdstatus","Password is not matching");
				response.setContentType("text/html");	
			   rd=request.getRequestDispatcher("newPassword.jsp");
				rd.include(request, response);
			}
	}
}
}
