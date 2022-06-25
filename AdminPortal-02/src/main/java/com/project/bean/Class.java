package com.project.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="class")
public class Class {
	
    
	@Id
	private int classId;
	private String className;
	
	
	/*@OneToMany(mappedBy="classes")
	private List<Student> student = new ArrayList<>();*/
	
	@ManyToMany(mappedBy="cls")
	private List<Subject> subjects = new ArrayList<>();
	
	@ManyToMany(mappedBy="clss")
	private List<Teacher> teachers = new ArrayList<>();
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	@NotNull
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Class(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	/*public List<Student> getStudent() {
		return student;
	}
	public Class(int classId, String className, List<Student> student) {
		super();
		this.classId = classId;
		this.className = className;
		this.student = student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}*/
	public Class() {
		super();
	}
	
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + "]";
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
