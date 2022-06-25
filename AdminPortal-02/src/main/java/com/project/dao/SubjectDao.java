package com.project.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.bean.Class;
import com.project.bean.Student;
import com.project.bean.Subject;
import com.project.config.DBConfiguration;
import com.project.dto.ClsSubDisplay;

public class SubjectDao {

	public boolean createSubject(Subject sub) {
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(sub);
			tran.commit();
			return true;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
	}
	
	public Subject getSubject(int id) {
		Subject subObj;
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			Query qry = session.createQuery("select sub from Subject sub where subId=:id");
			qry.setInteger("id", id);
			subObj = (Subject)qry.getSingleResult();
			//System.out.println("ClassId:"+classObj.getClassId());
			}
			catch(Exception e) {
				subObj = null;
				System.out.println("Exception in Subjectdao:"+e);	
			}
			return subObj;
	}

	public boolean mapClsSub(int clsId,int subId) {
		// TODO Auto-generated method stub
		//Subject subObj = new Subject(s.getSubId(),s.getSubName(),s.getCls());
		try {
			SessionFactory sf = DBConfiguration.getSessionFactoryReference();
			Session session = sf.openSession();
			//Query qry = session.createQuery("update Subject sub set sub.cls=:clsList where classId=:id");
			//qry.setInteger("id", s.getSubId());
			//qry.setParameterList("clsList", s.getCls());
			 
			Transaction tran = session.getTransaction();
			tran.begin();
			Query q=session.createSQLQuery("INSERT INTO Subject_Class(sub_id,classId) VALUES(:id1,:id2)");
			q.setParameter("id1", subId);
			q.setParameter("id2", clsId);		
			q.executeUpdate();
			tran.commit();
			return true;
			}
			catch(Exception e) {
				System.out.println("Exception :"+e);
				return false;
			}
			
		
	}
	

	public List<Subject> dispSubject() {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select sub from Subject sub");
		List<Subject> listOfSub = qry.list();
		System.out.println("In Subject List......................");
		return listOfSub;
		
	}

	public List<Subject> getSubByClsid(int clsId) {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		//Query qry = session.createQuery("select sub from Subject sub inner join sub.Class c where c.classId=:id");
		//Query qry=session.createSQLQuery("select sub.* from subject sub inner join Subject_Class c on sub.sub_id=c.sub_id where c.classId=:id");
		Query qry=session.createQuery("select sub from Subject as sub INNER JOIN sub.cls as c where c.classId=:id");
		qry.setInteger("id", clsId);
		List<Subject> listOfSub = qry.list();
		System.out.println("In Subject List Dao......................");
		for(Subject sub:listOfSub) {
			
			System.out.println("Subject in DAO:"+sub);
		}
		return listOfSub;
	}

	/*public List<Subject> displaySubCls() {
		// TODO Auto-generated method stub
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		//Query q = session.createSQLQuery("SELECT cs.classId,cs.sub_id,c.className,s.sub_name FROM Subject_Class cs INNER JOIN class c "
				//+ "ON cs.classId=c.classId INNER JOIN subject s on cs.sub_id=s.sub_id");
		Query q=session.createQuery("SELECT sub from Subject sub");
		List<Subject> result=q.list();
		return result;
	}*/
	public boolean valSub(String subName) {
		try {
		SessionFactory sf = DBConfiguration.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select sub from Subject sub where sub.subName=:name");
		qry.setString("name", subName);
		
		Subject s= (Subject)qry.getSingleResult();
		if (s==null)
		   return true;
		else 
		   System.out.println("Subject is exsisting in table");	
		   return false;
		}catch(NoResultException e) {
			return true;
		}
	}
		
		public boolean valSubCls(int clsId,int subId) {
			try {
				SessionFactory sf = DBConfiguration.getSessionFactoryReference();
				Session session = sf.openSession();
				//Query qry = session.createQuery("select sub from Subject_Class sub where sub.subName=:name");
				Query qry = session.createSQLQuery("select s.* from Subject_Class s where classid=:id1 and sub_id=:id2");
				qry.setInteger("id1", clsId);
				qry.setInteger("id2", subId);
				Object s= qry.getSingleResult();
				if (s==null)
				   return true;
				else 
				   System.out.println("Entered Subject Class Mapping is exsisting in table");	
				   return false;
				}catch(NoResultException e) {
					return true;
				
		}
		}
	

}
