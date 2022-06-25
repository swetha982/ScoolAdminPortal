package com.project.controller;

import java.io.IOException;
import com.project.bean.Subject;
import com.project.dto.ClsSubDisplay;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Service.SubjectService;


/**
 * Servlet implementation class SubClsController
 */
public class SubClsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      SubjectService ss = new SubjectService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubClsController() {
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
		List<Subject>subList = ss.dispSub();
		hs.setAttribute("subList", subList);
	
	/*for(int i=0;i<=subList.size();i++) {
		pw.println(subList.get(i));
		
		System.out.println("Subject:"+subList.get(i));
	}*/
	RequestDispatcher rd1 = request.getRequestDispatcher("displaySubCls.jsp");
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
		
		
		
		int clsId= Integer.parseInt(request.getParameter("class"));
		int subId = Integer.parseInt(request.getParameter("subject"));
		String result;
		
		result= ss.mapClass(clsId,subId);
		
         RequestDispatcher rd1 = request.getRequestDispatcher("mapClsSub.jsp");
		
		pw.println("Result:"+result);
		
		rd1.include(request, response);
	}

}
