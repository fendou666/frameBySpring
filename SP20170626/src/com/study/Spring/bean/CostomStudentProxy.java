package com.study.Spring.bean;

public class CostomStudentProxy {
	public Student getStudentInstance(){
		return new Student("С��", 18);
	}
}
