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

<style>
body{
 	background-color: lightgrey;
 	background-image: url('Images/bgimg.png');
 	background-repeat: no-repeat;
 	background-size: 85em 46em;
}

</style>
</head>
<body>
<jsp:include page="Header.jsp" />
	<form method="post" action="AddCustomerController">
	<div style="background-color:white;margin:auto;margin-top:60px;padding:40px;padding-bottom:90px;width:400px;padding-left:90px;">
	<h2>Change Password</h2>
	<label>Enter old password:</label>
	<input style="width:220px;" type="password" name="oldpassword" required>
	
	<label>Enter New password:</label>
	<input style="width:220px;" type="password" name="newpassword" required>
	
	<label>Confirm password:</label>
	<input style="width:220px;" type="password" name="confpassword" required>
	
	<input type="hidden" name="operation" value="changePassword"><br><br>
	
	<input style="width:220px;" type="submit" value="Change password">
	</div>
	</form>
	<jsp:include page="Footer.jsp" />
</body>
</html>