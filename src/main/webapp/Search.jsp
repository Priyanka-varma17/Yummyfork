<%@page import="com.yummyfork.dto.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="Themes/newStyle.css">
</head>
<body>

<form action="AddFoodController" method="post" align="center" style="margin-top:90px;">

<input type="hidden" name="operation" value="searchFood">

<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Enter food name</label>&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" class="form-control" id="exampleFormControlInput1" name="search" placeholder="Search here">
  	<input type="submit" class="btn btn-outline-primary" value="Search">
</div>
	
</form>	

</body>
</html>