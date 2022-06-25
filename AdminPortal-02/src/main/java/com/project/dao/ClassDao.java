package com.project.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.bean.Class;
import com.project.bean.Student;
import com.project.bean.Subject;
import com.project.config.DBConfiguration;

public class ClassDao {

	public boolean storeClass(Class cls) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(cls);
			tran.commit();
			return true;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
	}
	
	public List<Class>dispClass(){
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select cls from Class cls");
		List<Class> listOfCls = qry.list();
		return listOfCls;
	}
	
	public Class findClass(int clsId) {
		Class classObj;
		try {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select cls from Class cls where classId=:id");
		qry.setInteger("id", clsId);
		 classObj = (Class)qry.getSingleResult();
		System.out.println("ClassId:"+classObj.getClassId());
		}
		catch(Exception e) {
			classObj = null;
			System.out.println("Exception in Classdao:"+e);	
		}
		return classObj;
		
		
	}
	public boolean valClass(String className) {
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createQuery("select c from Class c where c.className=:name");
			qry.setString("name", className);
			
			Class c= (Class)qry.getSingleResult();
			if (c==null)
			   return true;
			else 
			   System.out.println("Class is exsisting in table");	
			   return false;
			}catch(NoResultException e) {
				return true;
			}
	}
	public Class getClass(int id) {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Class c= session.get(Class.class, id);
		return c;
	}

}
