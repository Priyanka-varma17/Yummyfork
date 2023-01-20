<%@page import="java.util.List"%>
<%@page import="com.yummyfork.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	List<Orders> orderList=(List<Orders>) request.getAttribute("orderList");
	%> 

<%String username=(String)session.getAttribute("username"); %>

<jsp:include page="Header.jsp" /> 
<h2 id="heading">Orders</h2>
<table border="1" id="foodListTable" style="margin:auto">

	<tr>
	<th class="colwidth">Order Id</th>
	<th class="colwidth">Total Price</th>
	<th class="colwidth">Status</th>
	<th class="colwidth">Email</th>
	</tr>
	
	
	<% for(Orders o:orderList){ %>
	<tr>
<td><%=o.getOrderId() %></td>
<td><%=o.getTotalPrice() %></td>
<td><%=o.getStatus() %></td>
<td><%=o.getEmail() %></td>
</tr>
<%} %>
</table>
<jsp:include page="Footer.jsp" /> 
</body>
</html>