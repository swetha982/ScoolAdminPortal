<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Submit Student Details</h2>
<form action="storeStudent" method="post">
	<label>Id</label>
	<input type="number" name="id"><br/>
	<label>FirstName</label>
	<input type="text" name="firstname"><br/>
	<label>LastName</label>
	<input type="text" name="lastname"><br/>
	<label>Class</label>
	<input type="number" name="classid"><br/>
	<input type="submit" value="Save"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="storeStudent">View Students Details</a></br>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>