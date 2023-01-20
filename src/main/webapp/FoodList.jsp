<%@page import="com.yummyfork.dto.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="Themes/myStyle.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
function addToCart(foodId){
	var quantity=document.getElementById("quantity_"+foodId).value;
	
	$.get("CartController",
		{
		'operation':'addToCart',
		'foodId':foodId,
		'quantity':quantity
		
		},
		function(data,status){
			alert(data);
		}
	);
}
</script>

<style>
#heading{
margin-bottom:-50px;
}
</style>
</head>
<body>
<%
	String userName = (String) session.getAttribute("username");
	%>
	

	<%
	List<Food> foodList=(List<Food>) request.getAttribute("foodList");
	%> 
	
	<%String role=(String) session.getAttribute("role"); %>
	
	
<jsp:include page="Header.jsp" /> 	
	<h2 id="heading">Food List</h2>
	
	<%@include file="Search.jsp" %>
	
	<table id="foodListTable" style="margin:auto">
		<tr>
	 		<th class="colwidth">Food Name</th>
			<th class="colwidth">Food Price</th>
			<th class="colwidth">Food Quantity</th>
			<th class="colwidth">Food Category</th>
			<th class="colwidth">Image</th>
			
			<%if(role!=null && (role.equalsIgnoreCase("customer")||role.equalsIgnoreCase("admin"))) {%>
			<th class="operationcolwidth" colspan="2">Operations</th>
			<%} %>
			
		</tr>
	
	<% for(Food f:foodList){ %>
	<tr>
	
	<td><%=f.getFoodName() %></td>
	<td><%=f.getFoodPrice() %></td>
	<td><%=f.getFoodQuantity() %></td>
	<td><%=f.getFoodCategory() %></td>
	<td id="imageStyle"><img src="Images/<%=f.getImageFileName() %>"></td>
	
	<%if(role!=null && role.equalsIgnoreCase("Admin")){ %>
	<td class="tdwidth" style="width:60px;"><a href="AddFoodController?operation=edit&foodId=<%= f.getFoodId() %>">Edit</a></td>
	<td class="tdwidth" style="width:60px;" id="deleteCol"><a href="AddFoodController?operation=delete&foodId=<%= f.getFoodId() %>">Delete</a></td>
	<%} 
	
	else if(role!=null && role.equalsIgnoreCase("Customer")){ %>

	<td id="quantityinput" style="width:50px"><input type="number" name="quantity" value="1" id="quantity_<%=f.getFoodId() %>"></td>
	<td><button class="addToCartbtn" onclick="addToCart(<%=f.getFoodId() %>)" style="width:150px">AddToCart</button></td>
	 
	<%} %>
	
	</tr>
	<% }  %>
	
	</table>
</body>
</html>