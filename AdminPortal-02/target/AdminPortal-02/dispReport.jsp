<%@page import="java.util.Iterator"%>
<%@page import="com.project.bean.Subject"%>
<%@page import="com.project.bean.Teacher"%>
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
<%Object obj = session.getAttribute("result") ;
//List<Object> ob = (List<List<Object>>)obj;
List<Object> obj1 = (List<Object>)obj;
//List<Object> obj2 = (List<Object>)obj;

System.out.println("Obj1:"+ obj);
//out.println("Result:"+obj);
//out.println("Result1:"+obj1);
%>
<h2>Student Details</h2>

<table border="1">
  <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      
      
  </tr>
  <%
 // List<Object> obj3=obj1.get(0);
 System.out.println("Stu..."+obj1.get(0));
  if(obj != null){
	 
  
	  List<Student> students = (List<Student>)obj1.get(0);
	  //Student stu =students.get(0);
	 // for(Student stu:students){
		 for(int i=0;i<=students.size();i++){
			 System.out.println("Student+"+students.get(i));
			 Student s =students.get(i);
			  	//  }
	 // Iterator<Student> itr = students.listIterator();
	 // while(itr.hasNext()){
	//	  Student stu = itr.next();
		  
		  out.println("Student+"+students.get(i));
		 
		  System.out.println("Student+"+s);
		  %>
		  <tr>
		  <td><%=s.getStudentId() %></td>
		  <td><%=s.getFirstName() %></td>
		  <td><%=s.getLastName() %></td>
		  
		   </tr>    
		  <% 
	  }
	  
  }
  %>
</table>
<h2>Subject Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>Student Name</th>
      
      
  </tr>
  <%
  
  if(obj != null){
	  List<Subject> subjects = (List<Subject>)obj1.get(1);
	  Iterator<Subject> itr1 = subjects.listIterator();
	  while(itr1.hasNext()){
		  Subject sub = itr1.next();
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
<h2>Teacher Details</h2>
<table border="1">
  <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
     
      
  </tr>
  <%
  //Object obj2 = session.getAttribute("tList") ;
  if(obj != null){
	  List<Teacher> teachers = (List<Teacher>)obj1.get(2);
	  Iterator<Teacher> itr2 = teachers.listIterator();
	  while(itr2.hasNext()){
		  Teacher t = itr2.next();
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
</body>
</html>