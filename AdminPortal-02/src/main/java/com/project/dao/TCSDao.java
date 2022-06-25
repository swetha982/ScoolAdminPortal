package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.bean.Subject;
import com.project.bean.Teacher;
import com.project.config.DBConfiguration;

public class TCSDao {

	public boolean saveTCS(int tid, int clsId, int subId) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			Query q=session.createSQLQuery("INSERT INTO Teacher_Class(teacher_id,classId) VALUES(:id1,:id2)");
			q.setParameter("id1", tid);
			q.setParameter("id2", clsId);
			Query q1=session.createSQLQuery("INSERT INTO Teacher_Subject(teacher_id,sub_id) VALUES(:id1,:id2)");
			q1.setParameter("id1", tid);
			q1.setParameter("id2", subId);
			q.executeUpdate();
			q1.executeUpdate();
			tran.commit();
			return true;
			}
			catch(Exception e) {
				System.out.println("Exception :"+e);
				return false;
			}
	}

	public List<Teacher> showTeacher() {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select t from Teacher t");
		List<Teacher> tList = qry.list();
		System.out.println("In Teacher List......................");
		return tList;
	}

}
