package com.project.Service;

import java.util.List;

import com.project.bean.Subject;
import com.project.bean.Teacher;
import com.project.dao.ClassDao;
import com.project.dao.StudentDao;
import com.project.dao.SubjectDao;
import com.project.dao.TCSDao;
import com.project.dao.TeacherDao;
import com.project.bean.Class;

public class TCSService {
	
	TCSDao td= new TCSDao();
	ClassDao cd= new ClassDao();
	TeacherDao t = new TeacherDao();
	SubjectDao sd = new SubjectDao();

	public String mapTCS(int tid, int clsId, int subId) {
		// TODO Auto-generated method stub
		Subject s= sd.getSubject(subId);
		Class c= cd.findClass(clsId);
		Teacher tc = t.getTeacherById(tid);
		
		if(s!=null&&c!=null&&tc!=null) {
	    if(t.valTCS( tid, clsId, subId)) {
		
		if(td.saveTCS(tid,clsId,subId))
		return "Record stored Successfully";
		else
			return "Failed to store record";
		}else
			return "Entered Mapping is available";
	    }
	    else
			return "Failed to Store mapping as Class id/Subject id/Teacher id id not configured";
	}

	public List<Teacher> dispTeacher() {
		// TODO Auto-generated method stub
		return td.showTeacher();
	}

}
