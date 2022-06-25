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

import com.project.Service.TeacherService;
import com.project.bean.Teacher;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService ts = new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor teacherb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method teacherb
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession hs  = request.getSession();
		List<Teacher> tlist = ts.showTeacher();
		hs.setAttribute("tList", tlist);
		RequestDispatcher rd1= request.getRequestDispatcher("displayTeacher.jsp");
		rd1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method teacherb
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Teacher teacher = new Teacher();
		
		teacher.setTeacherId(Integer.parseInt(request.getParameter("id")));
		teacher.setLastName(request.getParameter("lastname"));
		teacher.setFirstName(request.getParameter("firstname"));
		
		
		
		
		System.out.println("welcome;");
		
		
		String result;
		if(teacher.getFirstName().trim().isEmpty()||teacher.getLastName().trim().isEmpty())
			result="Enter First name and Last name";
		else
		result= ts.storeTeacher(teacher);
		
        RequestDispatcher rd1 = request.getRequestDispatcher("storeTeacher.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);
	
	}

}
