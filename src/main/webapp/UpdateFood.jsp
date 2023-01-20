<%@page import="com.yummyfork.dto.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Themes/myStyle.css">
</head>
<body style="background-color:lightgrey;">

	<% Food f=(Food)request.getAttribute("food"); %>
	<jsp:include page="Header.jsp" /> 
	
	<form action="AddFoodController" method="post">
	
	<div class ="signupcontainer">
		<h1 class="signuplabel" >Update</h1>
			<div class="loginform">
			<table style="margin:auto;">
			<tr>
				<td><input type="hidden" name="operation" value="update"></td>
				<td><input type="hidden" name="foodId" value="<%=f.getFoodId() %>"></td>
			</tr>
			<tr>
				<td class="row1 tlspace">Food Name</td>
				<td class="row1 tlspace">Food Price</td>
			</tr>
			<tr>
				<td class="row1 tispace"><input type="text" name="foodName" value="<%=f.getFoodName() %>"></td>
				<td class="row2 tispace"><input type="text" name="foodPrice" value="<%=f.getFoodPrice() %>"></td>
			</tr>
			<tr>
				<td class="row1 tlspace">Food Quantity</td>
				<td class="row1 tlspace">Food Category</td>
			</tr>
			<tr>
				<td class="row1 tispace"><input type="text" name="quantity" value="<%=f.getFoodQuantity() %>"></td>
				<td class="row2 tispace"><input type="text" name="category" value="<%=f.getFoodCategory() %>"></td>
			</tr>
			</table>
			<input class="register" type="submit" value="Save"><br>
			</div>
	</div>
	</form>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>