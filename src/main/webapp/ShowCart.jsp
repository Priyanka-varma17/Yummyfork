<%@page import="com.yummyfork.dto.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.yummyfork.dto.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="Themes/myJavascript.js">
</script>
</head>
<body>
	
<%List<Cart> itemList = (List<Cart>) request.getAttribute("cartItem");%>
<%String username=(String)session.getAttribute("username"); %>
<%String role=(String)session.getAttribute("role"); %>
<jsp:include page="Header.jsp" /> 

<h2 id="heading">Show My Cart</h2>
<form action="CartController" method="get">
<table border="1" id="foodListTable" style="margin:auto">
<%if(role!=null && role.equalsIgnoreCase("Customer")){ %>

<tr>
<th class="colwidth">Food name</th>
<th class="colwidth">cart quantity</th>
<th class="colwidth">Remove from cart</th>

</tr>

<%for(Cart cart:itemList){ %>
<tr>
<td><%=cart.getFoodName() %></td>   
<td><%=cart.getQuantity() %></td>
<td><a href="CartController?operation=RemoveFromCart&cartId=<%= cart.getCartId() %>&username=<%=username%>&foodId=<%=cart.getFoodId()%>">remove</a></td>

</tr>
<input type="hidden" name="cartId" value="<%=cart.getCartId()%>">
<input type="hidden" name="foodId" value="<%=cart.getFoodId()%>">

<%System.out.println("cartId===> "+cart.getCartId()+" FoodName===> "+cart.getFoodName()+" foodQuantity===> "+cart.getQuantity());%>

<%}}%>


</table>
<br>
<br>
<a id="orderlink" href="OrdersController?operation=insertToOrder" onclick=orderMessage()>Place Order</a> 
</form>
<jsp:include page="Footer.jsp" /> 
</body>
</html>