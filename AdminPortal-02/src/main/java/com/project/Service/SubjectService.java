package com.project.Service;

import com.project.bean.Subject;
import com.project.dao.ClassDao;
import com.project.dao.SubjectDao;
import com.project.dto.ClsSubDisplay;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.Class;

public class SubjectService {
     SubjectDao sd = new SubjectDao();
     ClassDao cd = new ClassDao();
	public String storeStudent(Subject sub) {
		// TODO Auto-generated method stub
		if(sd.valSub(sub.getSubName())) {
		if(sd.createSubject(sub))
		return "Record Created Successfully";
		else
			return "Record Creation Failed";
		}else {
			return "Failed to store record as Subject is already present";
		}
	}
	public String mapClass(int clsId, int subId) {
		// TODO Auto-generated method stub
		
	  Class cls = cd.findClass(clsId);
	  Subject s=sd.getSubject(subId);
	  
	if(cls!=null && s!=null) { 
	if(sd.valSubCls(clsId, subId))	{
	  if(sd.mapClsSub(clsId,subId))
		return "Record Created Successfully";
	  else
			return "Record Creation Failed";
	}else
		return "Entered Subject Class Mapping is exsisting in table";
	}else
		return "Entered Class Id or Subject Id is not configured";
	}
	
	public List<Subject> dispSub() {
		
		return sd.dispSubject();
	}
	public List<Subject> dispSubByClsid(int clsId) {
		// TODO Auto-generated method stub
		return sd.getSubByClsid(clsId);
	}

}
