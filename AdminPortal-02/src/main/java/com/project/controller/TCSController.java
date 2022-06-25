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

import com.project.Service.TCSService;
import com.project.bean.Subject;
import com.project.bean.Teacher;

/**
 * Servlet implementation class TCSController
 */
public class TCSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TCSService ts= new TCSService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TCSController() {
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
		List<Teacher>resList = ts.dispTeacher();
		hs.setAttribute("resList", resList);
	
/*	for(int i=0;i<=resList.size();i++) {
		pw.println(resList.get(i));
		
		System.out.println("Subject:"+resList.get(i));
	}*/
		RequestDispatcher rd1 = request.getRequestDispatcher("dispTCSjsp.jsp");
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
		
		
		int tid = Integer.parseInt(request.getParameter("teacher"));
		int clsId= Integer.parseInt(request.getParameter("class"));
		int subId = Integer.parseInt(request.getParameter("subject"));
		
		
		String result= ts.mapTCS(tid,clsId,subId);
		
         RequestDispatcher rd1 = request.getRequestDispatcher("mapTCS.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);

	}

}
