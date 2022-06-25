package com.project.Service;
import java.util.List;

import com.project.bean.Class;
import com.project.dao.ClassDao;

public class ClassService {
	
	ClassDao repo = new ClassDao();
	
	public String createClass(Class cls) {
		if(repo.valClass(cls.getClassName())) {
	    if(repo.storeClass(cls))
		return "Class details stored successfully";
	    else
	    	return "Failed to store class details";
		}else
			return "Failed to store as entered Class is available";
	}
	
	public List<Class> displayClass(){
		return repo.dispClass();
	}

}
