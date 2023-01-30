<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="Themes/myStyle.css">
<style>
body{
 background-color: lightgrey;
	background-image: url('Images/bgimg.png');
	background-repeat: no-repeat;
	background-size: 85em 46em;
}


</style>
</head>
<body  style="background-color:lightgrey;">

<%String msg=(String)request.getAttribute("addFoodStatus");%>

		<jsp:include page="Header.jsp" /> 
		<form action="AddFoodController" method="POST" name="form" enctype="multipart/form-data">
		<div class ="signupcontainer">
		<h1 class="signuplabel" >Add Food</h1>
		<%if(request.getAttribute("addFoodStatus")!=null){ 
		out.print("<p style='color:red; margin-left:205px;'>"+request.getAttribute("addFoodStatus")+"</p>");}%>
		
			<div class="loginform">
	
				<table id="signuptable">
				<tr>
				<td class="row1 tispace"><input type="hidden" name="operation" value="addFood"></td>
				</tr>
				
				<tr>
				<td class="row1 tlspace" style="width:87%">Food Name:</td>
				<td class="row2 tlspace">Food Price: </td>
				</tr>
				
				<tr>
				<td class="row1 tispace"> <input type="text" name="name" required></td>
				<td class="row2 tispace"><input type="text" name="price" required></td>
				
				</tr>
				
				<tr>
				<td class="row1 tlspace">Food Quantity:</td>
				<td class="row2 tlspace">Food Category:</td>
				</tr>
				
				<tr>
				<td class="row1 tispace"><input type="text" name="quantity" required></td>
				<td class="row2 tispace"><input type="text" name="category" required></td>
				</tr>
				
					<tr>

						<td class="row1 tlspace">Select Image :</td>
						<td style="padding-top:25px"><input type="file" name="image"> </td>
						

					</tr>
					<tr>
					<td colspan="2" style="padding-top:40px;">
					<input style="width:300px;margin-left:100px;height:30px;cursor:pointer;" type="submit" value="Add"></td>
					</tr>
				</table>
						
			</div>
		</div>
	
	</form>
	<jsp:include page="Footer.jsp" />
</body>
</html>