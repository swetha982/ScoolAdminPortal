package com.project.controller;
import com.project.Service.StudentService;
import com.project.bean.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReportController1
 */
public class ReportController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService ss = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession hs  = request.getSession();
		int clsId= Integer.parseInt(request.getParameter("clsid"));

		List<Student> studentList = ss.dispStuByclsId(clsId);
		 System.out.println("Student List...."+studentList);
			
			
			
			//System.out.println("resulr..."+result);
			
			hs.setAttribute("studentList", studentList);
			RequestDispatcher rd1= request.getRequestDispatcher("displayStudent.jsp");
		    rd1.forward(request, response);
		
	}

}
