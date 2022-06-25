package com.project.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@Column(name="teacher_id")
	private int teacherId;
	@NotNull
	@Column(name="first_name")
	private String firstName;
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@ManyToMany
	@JoinTable(
			name="Teacher_Class",
			joinColumns = {@JoinColumn(name="teacher_id")},
			inverseJoinColumns = {@JoinColumn(name="classId")}
			)
	private List<Class> clss = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name="Teacher_Subject",
			joinColumns = {@JoinColumn(name="teacher_id")},
			inverseJoinColumns = {@JoinColumn(name="sub_id")}
			)
	private List<Subject> subjects = new ArrayList<>();
	
	public Teacher(int teacherId, String firstName, String lastName) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public List<Class> getClss() {
		return clss;
	}
	public void setClss(List<Class> clss) {
		this.clss = clss;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	public Teacher() {
		super();
	}
	public Teacher(int teacherId, String firstName, String lastName, List<Class> clss) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clss = clss;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + ", clss="
				+ clss + ", subjects=" + subjects + "]";
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
	
	
	
	
	
	

}
