package com.study.Spring.bean;

public class StaticStudentProxy {
	public static Student getStudentInstance(){
		return new Student();
	}
}	