<!doctype html>
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

<body style="background-color:lightgrey">
<form>
<div style="background-color:white;width:700px;margin:auto;margin-top:60px;padding:40px;" >
<h2 >Forgot password?</h2>
<p>Change your password in three easy steps. This will help you to secure your password!</p>
<ol>
<li>Enter your registered email address below.</li>
<li>Our system will send you an OTP to your email</li>
<li>Enter the OTP on the next page</li>
</ol>
</div>
</form>


<form action="ForgotPassword" method="post" style="margin-top:10px;">
<div style="background-color:white;width:700px;margin:auto;padding:40px;" >
<label>Enter your registered email address</label><br>


<input type="email" name="email" placeholder="Enter email" style="width:280px" required><br><br>

<input type="submit" class="fgtBtn" value="Get New Password">&nbsp;&nbsp;&nbsp;
<a class="fgtBtn" id="backLogin" href="Login.jsp">Back to Login</a>

<input type="hidden" name="operation" value="forgotpassword">


</div>
</form>
</body>
</html>