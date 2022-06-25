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
import com.project.bean.Class;
import com.sun.istack.NotNull;

@Entity
@Table(name="subject")
public class Subject {

	@Id
	@Column(name="sub_id")
	private int subId;
	@NotNull
	@Column(name="sub_name", nullable=false)
	private String subName;
	
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	@ManyToMany
	@JoinTable(
			name="Subject_Class",
			joinColumns = {@JoinColumn(name="sub_id")},
			inverseJoinColumns = {@JoinColumn(name="classId")}
			)
	private List<Class> cls = new ArrayList<>();
	
	@ManyToMany(mappedBy="subjects")
	private List<Teacher> teachers = new ArrayList<>();
	
	
	/*@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + "]";
	}*/
	
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", cls=" + cls + "]";
	}
	public Subject(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}
	
	public List<Class> getCls() {
		return cls;
	}
	public void setCls(List<Class> cls) {
		this.cls = cls;
	}
	public Subject(int subId, String subName, List<Class> cls) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.cls = cls;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	
}
