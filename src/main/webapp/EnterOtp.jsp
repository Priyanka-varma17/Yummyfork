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
	<div style="background-color:white;margin:auto;margin-top:60px;padding:40px;width:400px;padding-left:100px;">
		<h2>Enter OTP</h2>
										<%
		  			if(request.getAttribute("message")!=null)
		  			{
		  				out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
		  			}
		  
		  %>
		<br> <input type="text" name="otp" placeholder="Enter OTP"><br><br>
		<input type="submit" value="Reset Password"> <input
			type="hidden" name="operation" value="ValidateOtp">
	</div>
	</form>
</body>
</html>