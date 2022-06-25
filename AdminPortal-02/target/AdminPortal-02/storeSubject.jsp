<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="createSubject" method="post">
	<label>Id</label>
	<input type="number" name="id"><br/>
	<label>Subject Name</label>
	<input type="text" name="subjectname"><br/>
	<input type="submit" value="save"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href=createSubject>View Subjects</a></br>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>