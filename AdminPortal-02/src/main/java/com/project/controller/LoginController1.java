package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Service.LoginService;
import com.project.bean.Login;

/**
 * Servlet implementation class LoginController1
 */
public class LoginController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController1() {
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
		System.out.println("Hello login Servlet");
		PrintWriter pw = response.getWriter();
		String email=request.getParameter("email");
		String pwd = request.getParameter("password");
		
		Login input = new Login(email, pwd);
		
		
	    
        RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
        RequestDispatcher rd2 = request.getRequestDispatcher("Home.jsp");
        
        LoginService login = new LoginService();
        String result=login.checkLogin(input);
		
          if(result.equals("success")) {
			
			rd2.forward(request, response);
			
		}else {
			pw.println("Failed to login");
			rd1.include(request, response);
		}
	}

}
