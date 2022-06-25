<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Map Class & Subject for Teacher</h2>
<form action="mapTCS" method="post">
	<label>Choose Teacher Id</label>
	<input type="number" name="teacher"><br/>
	<label>Choose Class Id</label>
	<input type="number" name="class"><br/>
	<label>Choose Subject Id</label>
	<input type="number" name="subject"><br/>
	<input type="submit" value="save"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href=mapTCS>"View Class Subject teacher Mapping"</a></br>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>