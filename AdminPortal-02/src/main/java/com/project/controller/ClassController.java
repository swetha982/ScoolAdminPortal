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

import com.project.Service.ClassService;
import com.project.bean.Class;

/**
 * Servlet implementation class ClassController
 */
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassService cs = new ClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		HttpSession hs  = request.getSession();
	    List<Class>clsList = cs.displayClass();
	    hs.setAttribute("clsList", clsList);
	    RequestDispatcher rd1= request.getRequestDispatcher("displayClass.jsp");
	    rd1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("classname");
		Class cls = new Class(id,name);
		
		
		String result;
		if(cls.getClassName().trim().isEmpty())
			result= "Enter Class Name to store Class Details";
		else
		result=cs.createClass(cls);
		
		RequestDispatcher rd1 = request.getRequestDispatcher("storeClass.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);
		
		
	}

}
