<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Themes/myStyle.css">
</head>
<body>
<%String roles=(String) session.getAttribute("role"); %>
	
		<div class="header">
			<div class="cname">
				<img id="logoid" src="Images/logo.jpg">
				<div class="cname1">YummyFork</div>
			</div>

			<div class="menus">
				<a href="Home.jsp">Home</a>							
			</div>
			
			<%if(roles!=null && roles.equalsIgnoreCase("Admin")){ %>
			<div class="menus">
				<a href="AddFood.jsp">Add Foods</a>
			</div>
			<%} %>
			
			<div class="menus">
				<a href="AddFoodController">Available foods</a>			
			</div>
			
			<%if(roles!=null && roles.equalsIgnoreCase("Admin")){ %>
			<div class="menus">
				<a href="AddCustomerController">Customers</a>
			</div>
			<%} %>
			
			
			<%if(roles!=null && roles.equalsIgnoreCase("Customer")){ %>
			<div class="menus">
				<a href="CartController">Cart</a>
			</div>
				<div class="menus">
				<a href="OrdersController?operation=order">Orders</a>
			</div>
			<%} %>
			
			
			<%if(roles!=null && (roles.equalsIgnoreCase("Customer") ||roles.equalsIgnoreCase("Admin")) ){ %>
			<div class="dropdown">
				<button class="dropbtn">Profile</button>
				<div class="dropdown-content">
					<a href="ProfileController">My Profile</a> 
					<a href="ChangePassword.jsp">Change Password</a> 
					<a href="LogoutController">Logout</a>
				</div>
			</div>
			<%} %>
			
			
			<%if(roles==null) {%>
				<div class="menus">
				<a href="Login.jsp">Login</a>
			</div>
			
				<div class="menus">
				<a href="SignUp.jsp">SignUp</a>
			</div>
			<%} %>

		</div>
	
</body>
</html>