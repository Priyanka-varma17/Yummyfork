
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

<body style="background-color: lightgrey">

	<form action="ForgotPassword" method="post">
		<div
			style="background-color: white; margin: auto; margin-top: 60px; padding: 40px; width: 450px; padding-left: 100px;">
			<h2>Reset Password</h2>


			<label>Enter New Password</label> <input style="width: 250px"
				type="password" name="password" placeholder="Enter New Password">
				
			
			 <label style="margin-top:13px">Confirm Password</label><br> <input
				style="width: 250px" type="password" name="confPassword"
				placeholder="Confirm New Password">

			<%
			if (request.getAttribute("pwdstatus") != null) {
				out.print("<p class='text-danger ml-1'>" + request.getAttribute("pwdstatus") + "</p>");
			}
			%>
		
			<input style="width: 250px;margin-top:20px;" type="submit" value="Reset" ><br>
			<br> <input type="hidden" name="operation" value="resetpassword">

			<p>
				Don't have an account? <a href="SignUp.jsp">Register Now!</a>
		</div>
	</form>

</body>
</html>