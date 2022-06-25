<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Home");

%>
<h2>Store Details</h2>
<a href="storeClass.jsp">Store Class Details</a></br>
<a href="storeStudent.jsp">Store Student Details</a></br>
<a href="storeSubject.jsp">Store Subject Details</a></br>
<a href="storeTeacher.jsp">Store Teacher Details</a></br>
<a href="mapClsSub.jsp">Map Class and Subject</a></br>
<a href="mapTCS.jsp">Map Class and Subject and Teacher</a></br>

<h2>View Details</h2>
<a href=createClass>View Class Details</a></br>
<a href=storeStudent>View Student Details</a></br>
<a href=createSubject>View Subject Details</a></br>
<a href=createTeacher>View Teacher Details</a></br>
<a href=mapSubCls>View Subject Class Mapping</a></br>
<a href=mapTCS>View Teacher & Class & Subject Mapping</a></br>
<h2>Report Details</h2>
<a href="report.jsp">Get Subjects and Teachers In report</a></br>
<a href="report1.jsp">Get Students In report</a></br>
<a href=logout>Logout</a>
</body>
</html>