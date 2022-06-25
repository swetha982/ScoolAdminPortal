package com.project.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name= "students")
public class Student {

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
	@Id
	@Column(name="id")
	private int studentId;
	@NotNull
	@Column(name="last_name")
	private String lastName;
	@NotNull
	@Column(name="first_name")
	private String firstName;
	/*@Column(name="class")
	private int classId;*/
	@OneToOne
	@JoinColumn(name="classId")
	private Class classes;
	
	
	
	public Student() {
		super();
	}
	public Student(int studentId, String lastName, String firstName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public Student(int studentId, String firstName, String lastName, Class classes) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classes = classes;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
   public Class getClasses() {
		return classes;
	}
	public void setClasses(Class classes) {
		this.classes = classes;
	}
	/*public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}*/
	
	
	
	
}
