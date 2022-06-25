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

import com.project.Service.SubjectService;
import com.project.bean.Student;
import com.project.bean.Subject;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectService ss = new SubjectService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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
		List<Subject>subList = ss.dispSub();
		System.out.println("Subject:"+subList);
		hs.setAttribute("subList", subList);
		
		
	for(Subject sub:subList) {
		pw.println(sub);
		System.out.println("Subject:"+sub);
	}
	RequestDispatcher rd1 = request.getRequestDispatcher("displaySubject.jsp");
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
		Subject sub = new Subject();
		sub.setSubId(Integer.parseInt(request.getParameter("id")));
		sub.setSubName(request.getParameter("subjectname"));
		
		String result;
		if(sub.getSubName().trim().isEmpty())
		 
		result="Enter Subject Name to store";
		else
			result= ss.storeStudent(sub);
		
        RequestDispatcher rd1 = request.getRequestDispatcher("storeSubject.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);
	}

}
