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
#showpwd{
	margin-left:90px;
	font-size:18px;
	margin-top:18px;
	
}

</style>

</head>
<body>
	<form action="LoginController" method="POST" name="form">
		<div class ="container">
		<h1 class="label"  >Login</h1>
		
		<%if(request.getAttribute("status")!=null){
			out.print("<p style='color:red;margin-left:7em;'>"+request.getAttribute("status")+"</p>");
		}%>
		
		<%if(request.getAttribute("signupMsg")!=null){
			out.print("<p style='color:red;margin-left:7em;'>"+request.getAttribute("signupMsg")+"</p>");
		}%>
			<div class="loginform">
			
				<div class="role">
				<input type="radio" name="role" value="customer" required>
				<label>Customer</label>
				
				<input type="radio" name="role" value="admin" required>
				<label>Admin</label>
				</div>
			
				<div class="uname "> <label for="uname">Enter Email:</label></div>
				<input class="input" type="email" name="uname" placeholder="Enter username" required>
				
				
				<div class="pwd"><label for="pwd"> Enter Password:</label></div>
				<input class="input" id="pwd" type="password" name="pwd" placeholder="Enter password" required><br>
				
				<div id="showpwd"><input type="checkbox" onclick="showPwd()">Show password</div>
				
				<div class="login-btn">
				<input class="loginbtn"  type="submit" value="Login"> </div>
				
				<div class="signup">Don't have an account? <a href="SignUp.jsp">SignUp</a></div><br>
		
			<div style="margin-left:150px"><a href="forgotPassword.jsp">Forgot Password?</a></div>
			
			</div>
		</div>
	
	</form>


	<script>
		function showPwd() {
			let val = document.getElementById("pwd");
			if (val.type === 'password') {
				val.type = "text";
			} else {
				val.type = "password";
			}
		}
	</script>

</body>
</html>