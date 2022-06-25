<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Students Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Class Name</th>
      
  </tr>
  <%
  Object obj = session.getAttribute("studentList") ;
  if(obj != null){
	  List<Student> students = (List<Student>)obj;
	  System.out.println("....Student List......"+students);
	  Iterator<Student> itr = students.listIterator();
	  while(itr.hasNext()){
		  Student stu = itr.next();
		  %>
		  <tr>
		  <td><%=stu.getStudentId() %></td>
		  <td><%=stu.getFirstName() %></td>
		  <td><%=stu.getLastName() %></td>
		  <td><%=stu.getClasses().getClassName() %></td>
		   </tr>    
		  <% 
	  }
	  
  }
  %>
</table>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>