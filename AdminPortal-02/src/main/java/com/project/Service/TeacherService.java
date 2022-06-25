package com.project.Service;

import java.util.List;

import com.project.bean.Teacher;
import com.project.dao.TeacherDao;

public class TeacherService {
	
	TeacherDao td = new TeacherDao();

	public String storeTeacher(Teacher teacher) {
		if(td.valTeacher(teacher.getFirstName(), teacher.getLastName())) {
		if(td.createTeacher(teacher))
		return "Record Stored successfully";
		else
			return "Record Failed to store";
		}else
			return "Failed to store as given names are already present";
	}
	
	public List<Teacher>showTeacher(){
		return td.dispTeacher();
	}
	
	public List<Teacher>showTeacherByClsId(int clsId){
		return td.dispTeacherByClsId(clsId);
	}

}
