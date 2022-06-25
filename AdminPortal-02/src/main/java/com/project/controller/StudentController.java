package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Student;
import com.project.Service.StudentService;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService ss = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		HttpSession hs  = request.getSession();
		List<Student> studentList = ss.displayStudent();
		System.out.println("No.of students:"+studentList.size());
		hs.setAttribute("studentList", studentList);
		RequestDispatcher rd1= request.getRequestDispatcher("displayStudent.jsp");
		rd1.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Student stu = new Student();
		
		
		stu.setStudentId(Integer.parseInt(request.getParameter("id")));
		stu.setLastName(request.getParameter("lastname"));
		stu.setFirstName(request.getParameter("firstname"));
		Integer classId = Integer.parseInt(request.getParameter("classid"));
		
		//stu.setClassId(Integer.parseInt(request.getParameter("classid")));
		
		System.out.println("welcome;");
		
		
		String result;
		if(stu.getFirstName().trim().isEmpty()||stu.getLastName().trim().isEmpty())
			result= "Enter First Name and Last Name";
		else
		    result= ss.storeStudent(stu,classId);
		
         RequestDispatcher rd1 = request.getRequestDispatcher("storeStudent.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);
	}

}
