package com.project.controller;
import com.project.bean.Class;


import java.io.*;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Service.StudentService;
import com.project.Service.SubjectService;
import com.project.Service.TeacherService;

import com.project.dao.ClassDao;
/**
 * Servlet implementation class ReportController
 */
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService ss = new StudentService();
	SubjectService subService = new SubjectService();
	TeacherService ts = new TeacherService();
	ClassDao cd= new ClassDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
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

		
		
		
		Class c=cd.getClass(clsId); 
		
		hs.setAttribute("class", c);
		RequestDispatcher rd1= request.getRequestDispatcher("dispRep1.jsp");
	    rd1.forward(request, response);
		
		
		
	}

}
