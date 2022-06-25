package com.project.Service;

import com.project.bean.Login;

public class LoginService {
	
	public String checkLogin(Login login) {
		
		if(login.getEmail().equals("sai@gmail.com")&&login.getPassword().equals("123"))
		return "success";
		else
			return "fail";
	}

}
