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



<%if(request.getAttribute("logoutMsg")!=null){
	
		out.print("<p style='color:red;clear:both;margin-left:30em;font-size:20px;'>"+request.getAttribute("logoutMsg")+"</p>");
	
	}%>



		<div class="home">
			Let the aroma of freshly cooked bread waft <br>through your home
			<br>with Bread Basket Today
		</div>
	</div>
	<%@include file="Footer.jsp" %>

</body>


</html>