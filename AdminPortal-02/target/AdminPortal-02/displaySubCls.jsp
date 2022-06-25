<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Subject"%>
<%@page import="com.project.bean.Class"%>
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
<h2> Subject Class Mapping Details</h2>
<table border="1">
  <tr>
      <th>Subject ID</th>
      <th>Subject Name</th>
      <th>Class Id</th>
      <th>Class Name</th>       
  </tr>
  <%
  Object obj = session.getAttribute("subList") ;
  if(obj != null){
	  List<Subject> subjects = (List<Subject>)obj;
	  Iterator<Subject> itr = subjects.listIterator();
	  while(itr.hasNext()){
		  Subject sub = itr.next();
		 if(!sub.getCls().isEmpty()){
		 List<Class>classes =sub.getCls();
		 Iterator<Class> itr1 =classes.listIterator();
		 while(itr1.hasNext()){
			 Class cls = itr1.next();
			 %>
			 
			 
		  <tr>
		  <td><%=sub.getSubId() %></td>
		  <td><%=sub.getSubName() %></td>
		  <td><%=cls.getClassId() %></td>
		   <td><%=cls.getClassName() %></td>
		  </tr>
			 
			 <% 
		 }
		 
		 }
		 else{
			 %>
			  <tr>
		  <td><%=sub.getSubId() %></td>
		  <td><%=sub.getSubName() %></td>
		  <td><%="" %></td>
		   <td><%="" %></td>
		  </tr>
			 <%
		 }
	  }
	  
  }
  %>
</table>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>