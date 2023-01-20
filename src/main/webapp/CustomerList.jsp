<%@page import="com.yummyfork.dto.Customer"%>
<%@page import="java.util.List"%>
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
		List<Customer> custList=(List<Customer>) request.getAttribute("custList");
	%> 
	<%String role=(String) session.getAttribute("role"); %>
	
	<jsp:include page="Header.jsp" />
	<h2 id="heading">Customer List</h2>
	<table border="1" id="foodListTable" style="margin:auto">
	
	<tr>
	<th class="colwidth">Cust id</th>
	<th class="colwidth">Cust name</th>
	<th class="colwidth">Cust address</th>
	<th class="colwidth">Cust mobile</th>
	<th class="colwidth">Cust email</th>
	<th class="colwidth">Delete</th>
	</tr>
	
	<% for(Customer c:custList){ %>
	<tr>
		<td><%=c.getCustId() %></td>
		<td><%=c.getCustName() %></td>
		<td><%=c.getCustAddress() %></td>
		<td><%=c.getCustMobile() %></td>
		<td><%=c.getCustEmail() %></td>
		<td><a href="AddCustomerController?operation=deleteCustomer&custEmail=<%=c.getCustEmail() %>">Delete</a>
		
	</tr>
	<%} %>
	
	</table>
		<jsp:include page="Footer.jsp" />
</body>
</html>