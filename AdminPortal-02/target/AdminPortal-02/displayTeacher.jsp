<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Teacher"%>
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
<h2> Teacher Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
     
      
  </tr>
  <%
  Object obj = session.getAttribute("tList") ;
  if(obj != null){
	  List<Teacher> students = (List<Teacher>)obj;
	  Iterator<Teacher> itr = students.listIterator();
	  while(itr.hasNext()){
		  Teacher t = itr.next();
		  %>
		  <tr>
		  <td><%=t.getTeacherId() %></td>
		  <td><%=t.getFirstName() %></td>
		  <td><%=t.getLastName() %></td>
		  
		   </tr>    
		  <% 
	  }
	  
  }
  %>
</table>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>