package com.project.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.bean.Student;
import com.project.bean.Subject;
import com.project.bean.Teacher;
import com.project.config.DBConfiguration;

public class TeacherDao {

	public boolean createTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			
			session.save(teacher);
			tran.commit();
			return true;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
		
		
		
	}
	
	public List<Teacher> dispTeacher(){
		
		// TODO Auto-generated method stub
				SessionFactory sf = DBConfiguration.getSessionFactoryReference();
				Session session = sf.openSession();
				Query qry = session.createQuery("select t from Teacher t");
				List<Teacher> tList = qry.list();
				return tList;
	}

	public List<Teacher> dispTeacherByClsId(int clsId) {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		//Query qry = session.createSQLQuery("select t.* from teacher t inner join Teacher_Class c on t.teacher_id=c.teacher_id where c.classId=:id");
		Query qry = session.createQuery("select t from Teacher as t INNER JOIN t.clss as c where c.classId=:id");
		qry.setInteger("id", clsId);
		List<Teacher> tList = qry.list();
		return tList;
		
		
	}
	public boolean valTeacher(String fname,String lname) {
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createQuery("select t from Teacher t where t.firstName=:name1 and t.lastName=:name2");
			qry.setString("name1", fname);
			qry.setString("name2", lname);
			Teacher t= (Teacher)qry.getSingleResult();
			if (t==null)
			   return true;
			else 
			   System.out.println("Student is added in table");	
			   return false;
			}catch(NoResultException e) {
				return true;
			}
	}
	public Teacher getTeacherById(int id) {
		Teacher subObj;
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createQuery("select t from Teacher t where teacherId=:id");
			qry.setInteger("id", id);
			subObj = (Teacher)qry.getSingleResult();
			//System.out.println("ClassId:"+classObj.getClassId());
			}
			catch(Exception e) {
				subObj = null;
				System.out.println("Exception in Subjectdao:"+e);	
			}
			return subObj;
	}
	public boolean valTCS(int tid,int cid,int sid) {
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createSQLQuery("select s.* from Teacher_Class s where s.classId=:id1 and s.teacher_id=:id2 ");
			qry.setInteger("id1", cid);
			qry.setInteger("id2", tid);
			
			Object obj1=qry.getSingleResult();
			Query qry1 = session.createSQLQuery("select s.* from Teacher_Subject s where s.sub_id=:id1 and s.teacher_id=:id2 ");
			qry1.setInteger("id1", sid);
			qry1.setInteger("id2", tid);
			
			Object obj2 =qry1.getSingleResult();
			
			if(obj1==null &&obj2 ==null)
				return true;
			else
				return false;
			
			
		}catch(NoResultException e) {
			return true;
		}catch(NonUniqueResultException e) {
			return false;
		}
	}

}
