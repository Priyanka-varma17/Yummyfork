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
<%String roles1=(String) session.getAttribute("role"); %>
		<div class="footer">

			<table class="tablefooter" align="center">
				<tr>
					<th>Branch Locations</th>
					<th>Quick Links</th>
					<th>Follow Us</th>
				</tr>
				<tr class="tablefootertr">
					<th>India</th>
					<th><a href="#">Home</a></th>
					<th><a href="https://www.facebook.com">Facbook</a></th>
				</tr>
				<tr class="tablefootertr">
					<th>USA</th>
					<th><a href="AddFoodController">Available foods</a></th>
					<th><a href="https://www.instagram.com">Instagram</a></th>
				</tr>
				<tr class="tablefootertr">
					<th>Japan</th>
					<th><%if(roles1!=null && roles1.equalsIgnoreCase("Customer")){ %>
					<a href="CartController">Cart</a>
					<%}
					else if(roles1!=null && roles1.equalsIgnoreCase("Admin")){ %>
					<a  style="margin-top:2px" href="AddFood.jsp">Add Foods</a><%} %>
					</th>
					<th><a href="https://twitter.com">Twitter</a></th>
				</tr>
				<tr class="tablefootertr">
					<th>France</th>
					<th>
					<%if(roles1!=null && roles1.equalsIgnoreCase("Customer")){ %>
					<a href="OrdersController?operation=order">Orders</a><%}
					else if(roles1!=null && roles1.equalsIgnoreCase("Admin")){ %>
					<a href="AddCustomerController">Customers</a><%} %>
					</th>
					<th></th>
				</tr>
				
				<tr class="tablefootertr">
					<th colspan="3" style="height: 20px">
						<hr>
					</th>
				</tr>
				<tr>
					<td colspan="3" style="height: 50px; text-align: center;">Created
						By Priyanka | All Rights Reserved!</td>
				</tr>
			</table>
		</div>

</body>
</html>