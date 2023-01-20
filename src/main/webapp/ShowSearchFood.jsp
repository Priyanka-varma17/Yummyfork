<%@page import="java.util.List"%>
<%@page import="com.yummyfork.dto.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="Themes/newStyle.css">
</head>
<body>
	<%
	List<Food> foodList1 = (List<Food>) request.getAttribute("foodList");
	%>
<jsp:include page="Header.jsp" /> 
<jsp:include page="Search.jsp" /> 

<form action="AddFoodController" method="post" align="center" style="margin-top:90px;">

	<table class="table table-striped table-hover" style="margin: auto">
		<tr>
			<th class="colwidth">Food Name</th>
			<th class="colwidth">Food Price</th>
			<th class="colwidth">Food Quantity</th>
			<th class="colwidth">Food Category</th>
		</tr>
		
		<%
		for (Food f : foodList1) {
		%>
		<tr>
			<td><%=f.getFoodName()%></td>
			<td><%=f.getFoodPrice()%></td>
			<td><%=f.getFoodQuantity()%></td>
			<td><%=f.getFoodCategory()%></td>
		<tr>
			<%
			}
			%>
		
	</table>
</form>
<jsp:include page="Footer.jsp" /> 
</body>
</html>