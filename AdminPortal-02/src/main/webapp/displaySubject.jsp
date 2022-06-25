<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Subject"%>
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
<h2> Subject Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>Student Name</th>
      
      
  </tr>
  <%
  Object obj = session.getAttribute("subList") ;
  if(obj != null){
	  List<Subject> subjects = (List<Subject>)obj;
	  Iterator<Subject> itr = subjects.listIterator();
	  while(itr.hasNext()){
		  Subject sub = itr.next();
		  %>
		  <tr>
		  <td><%=sub.getSubId() %></td>
		  <td><%=sub.getSubName() %></td>
		 
		   </tr>    
		  <% 
	  }
	  
  }
  %>
</table>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>