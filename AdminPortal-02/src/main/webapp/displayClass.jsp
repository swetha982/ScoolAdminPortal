<%@page import="java.util.Iterator"%>
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
<h2> View Class Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>Name</th>
      
      
  </tr>
  <%
  Object obj = session.getAttribute("clsList") ;
  if(obj != null){
	  List<Class> classes = (List<Class>)obj;
	  Iterator<Class> itr = classes.listIterator();
	  while(itr.hasNext()){
		  Class cls = itr.next();
		  %>
		  <tr>
		  <td><%=cls.getClassId() %></td>
		  <td><%=cls.getClassName() %></td>
		  </tr>    
		  <% 
	  }
	  
  }
  %>
</table>
<a href="Home.jsp">Go to Home Page</a>
</body>
</html>