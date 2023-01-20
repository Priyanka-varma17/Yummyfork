<%@page import="com.yummyfork.dto.Admin"%>
<%@page import="com.yummyfork.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Themes/myStyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	
		<style>
/*	
	.imgcss{
	 position: relative; 
    height: 100vh;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
	}*/
/*	.imgcss::before {    
      content: "";
      background-image: url('Images/foodImg.jpeg');
      background-size: cover;
      position: absolute;
      top: 0px;
      right: 0px;
      bottom: 0px;
      left: 0px;
      opacity: 0.75;
}
form, h2{
  position: relative;
  color: grey;  
 
  line-height: 0.9;
  text-align: center;
}*/


body{
 	background-color: lightgrey;
 	background-image: url('Images/bgimg.png');
 	background-repeat: no-repeat;
 	background-size: 77em 46em;
}

</style>
	
</head>
<body>

	<%
	Customer c = (Customer) request.getAttribute("Cust");
	%>
	<%
	Admin a = (Admin) request.getAttribute("Admin");
	%>
	<%
	String role = (String) session.getAttribute("role");
	%>
<jsp:include page="Header.jsp" /> 
	<form action="ProfileController" id="updateprofile" method="post"  onsubmit="updateProfile()">
		
	<div style="background-color:white;margin:auto;margin-top:60px;padding:40px;padding-bottom:90px;width:400px;padding-left:90px;">
		
			<h2 class="signuplabel">Update Profile</h2>
			
			
				<%
				if (role.equalsIgnoreCase("customer")) {
				%>
				
						<input style="width:220px;" type="hidden" name="operation" value="updateProfile">
					
						<input style="width:220px;" type="hidden" name="email" value="<%=c.getCustEmail()%>">
					
						<input style="width:220px;" type="hidden" name="id" value="<%=c.getCustId()%>">
				

				
					<label>Customer Name</label>
					<input style="width:220px;" style="width:220px;" type="text" name="custName" value="<%=c.getCustName()%>">
					
					<label style="margin-top:12px">Customer Address</label>
					<input style="width:220px;" type="text" name="custAddress" value="<%=c.getCustAddress()%>">

					<label style="margin-top:12px">Cust mobile</label>
					<input style="width:220px;" type="text" name="custMobile" value="<%=c.getCustMobile()%>"><br><br>
			
				<%
				} else {
				%>
					<input style="width:220px;" type="hidden" name="operation"
						value="updateProfile">
					<input style="width:220px;" type="hidden" name="email"
						value="<%=a.getAdminEmail()%>">
					<input style="width:220px;" type="hidden" name="id"
						value="<%=a.getAdminId()%>">

					<label>Admin Name</label>
					<input style="width:220px;" type="text" name="custName"
						value="<%=a.getAdminName()%>">
						
					<label style="margin-top:12px">Admin Address</label>
					<input style="width:220px;" type="text" name="custAddress"
						value="<%=a.getAdminAddress()%>">

					<label style="margin-top:12px">Admin mobile</label>
					<input style="width:220px;" type="text" name="custMobile"
						value="<%=a.getAdminMobile()%>"><br><br>

				<%
				}
				%>
				<input style="width:220px;" type="submit" value="update">
						
			
		</div>
	</form>
<jsp:include page="Footer.jsp" /> 

<script>
function updateProfile(){
	alert("profile updated successfully!!")
}
</script>
</body>
</html>