<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Themes/myStyle.css">
<style>
body {
	background-image: url('Images/background.webp');
	background-repeat: no-repeat;
	background-size: 86em 46em;
}



/*.containers {
	background-repeat: no-repeat;
	background-size: 86em 46em;
	display: flex;
	align-items: center;
	justify-content: center;
}

.containers::before {
	content: "";
	background-size: 86em 46em;
	position: absolute;
	top: 0px;
	right: 0px;
	bottom: 0px;
	left: 0px;
	background-image: url('Images/background.webp');
	opacity: 0.7;
}*/
</style>
</head>
<body>
<%@include file="Header.jsp" %>
	<%
	String userName = (String) session.getAttribute("username");
	
	%>
		
	<div class="containers">


<%if(roles!=null && (roles.equalsIgnoreCase("customer")||(roles.equalsIgnoreCase("admin")))){ %>
		<div id="LoggedUser">
			<%
		out.println(userName);
		%>
		</div>
		
<%} %>
		<div class="home">
			Let the aroma of freshly cooked bread waft <br>through your home
			<br>with Bread Basket Today
		</div>
	</div>
	<%@include file="Footer.jsp" %>

</body>
</html>