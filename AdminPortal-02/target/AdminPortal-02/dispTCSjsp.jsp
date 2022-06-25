<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Subject"%>
<%@page import="com.project.bean.Class"%>
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
<h2> Teacher Subject Class Mapping Details</h2>
<table border="1">
  <tr>
      <th>Teacher ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Subject Name</th>
      <th>Class Name</th> 
   </tr>
  <%
  Object obj = session.getAttribute("resList") ;
  if(obj != null){
	  List<Teacher> ts = (List<Teacher>)obj;
	  Iterator<Teacher> itr = ts.listIterator();
	  while(itr.hasNext()){
		  Teacher t = itr.next();
		  List<Class>classes =t.getClss();
		  Iterator<Class> itr1 =classes.listIterator();
		  List<Subject> subjects = t.getSubjects();
		  Iterator<Subject> itr2 = subjects.listIterator();
		  if(!(classes.isEmpty()||subjects.isEmpty())){
			 while(itr1.hasNext() && itr2.hasNext()){
				 Class cls = itr1.next();
				 Subject s = itr2.next();
				 %>
				 <tr>
		  <td><%=t.getTeacherId() %></td>
		  <td><%=t.getFirstName() %></td>
		  <td><%=t.getLastName() %></td>
		  <td><%=s.getSubName() %>
		   <td><%=cls.getClassName() %></td>
		  </tr>
				 <% 
			 }
		  }else{
			  %>
				 <tr>
		  <td><%=t.getTeacherId() %></td>
		  <td><%=t.getFirstName() %></td>
		  <td><%=t.getLastName() %></td>
		  <td><%="" %>
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