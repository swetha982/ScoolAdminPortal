package com.project.dto;

public class ClsSubDisplay {
	
	private int classId;
	private int subId;
	private String className;
	private String subName;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	@Override
	public String toString() {
		return "ClsSubDisplay [classId=" + classId + ", subId=" + subId + ", className=" + className + ", subName="
				+ subName + "]";
	}
	
	
	

}
