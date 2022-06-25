<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Subject"%>
<%@page import="com.project.bean.Student"%>
<%@page import="com.project.bean.Teacher"%>
<%@page import="com.project.bean.Class"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>View Subject Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>Subject Name</th>
      
      
  </tr>
  <%
  Class obj =(Class)session.getAttribute("class") ;
  if(obj != null){
	  List<Subject> subjects = obj.getSubjects();
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
</table></br>
<h2>View Teacher Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>First Name</th>
       <th>Last Name</th>
      
  </tr>
  <%
 
  if(obj != null){
	  List<Teacher> ts = obj.getTeachers();
	  Iterator<Teacher> itr = ts.listIterator();
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
</table></br>
<a href="Home.jsp">Go to Home Page</a>

</body>
</html>