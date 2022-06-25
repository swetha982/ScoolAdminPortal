package com.project.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfiguration {
	
	private static SessionFactory sf;
	// it will call only once 
	static {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		sf = con.buildSessionFactory();
	}
	public static SessionFactory getSessionFactoryReference() {
		return sf;
	} 

}
