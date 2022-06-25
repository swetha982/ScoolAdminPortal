<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Submit Class Details</h2>
<form action="createClass" method="post">
	<label>Id</label>
	<input type="number" name="id"><br/>
	<label>Class Name</label>
	<input type="text" name="classname"><br/>
	<input type="submit" value="save"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="createClass">View Class Details</a></br>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>