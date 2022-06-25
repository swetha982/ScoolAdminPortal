package com.project.Service;

import java.util.List;



import com.project.bean.Student;
import com.project.dao.ClassDao;
import com.project.dao.StudentDao;
import com.project.bean.Class;




public class StudentService {
	StudentDao sd = new StudentDao();
	ClassDao cd = new ClassDao();
	
	public String storeStudent(Student stu,int id) {
		Class cls = cd.findClass(id);
		if(sd.valStudent(stu.getFirstName(), stu.getLastName())) {
		
		if(cls!=null) {
			stu.setClasses(cls);
			Student st = new Student(stu.getStudentId(),stu.getFirstName(),stu.getLastName(),stu.getClasses());
		}
		else {
			return "Record not stored as given Class is not available";
		}
		}else
			return "Record not stored as the given names are present";
		
		if(sd.storeStudent(stu)==1)
			return "Record stored successfully";
		else
			return "Record not stored";
	}
	public List<Student> displayStudent() {
		// TODO Auto-generated method stub
		return sd.dispStudent();
		
	}
	public List<Student>dispStuByclsId(int clsId){
		return sd.getStuByclsId(clsId);
	}

}
