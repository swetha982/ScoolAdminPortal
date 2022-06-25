package com.project.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import com.project.bean.Student;
import com.project.bean.Subject;
import com.project.config.DBConfiguration;

public class StudentDao {
	
	public int storeStudent(Student stu) {
		
		try {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		
		session.save(stu);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}

	public List<Student> dispStudent() {
		// TODO Auto-generated method stub
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select stu from Student stu");
		List<Student> listOfStu = qry.list();
		return listOfStu;
		
	}

	public List<Student> getStuByclsId(int clsId) {
		// TODO Auto-generated method stub
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry =session.createQuery("select stu from Student as stu INNER JOIN stu.classes as c where c.classId=:id");
		qry.setInteger("id", clsId);
		List<Student> listOfStu = qry.list();
		return listOfStu;
	}
	public boolean valStudent(String fname, String lname) {
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createQuery("select s from Student s where s.firstName=:name1 and s.lastName=:name2");
			qry.setString("name1", fname);
			qry.setString("name2", lname);
			Student s= (Student)qry.getSingleResult();
			if (s==null)
			   return true;
			else 
			   System.out.println("Student is added in table");	
			   return false;
			}catch(NoResultException e) {
				return true;
			}
	}

}
