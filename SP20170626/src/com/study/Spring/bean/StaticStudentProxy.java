package com.study.Spring.bean;

public class StaticStudentProxy {
	public static Student getStudentInstance(){
		return new Student();
	}
	public static Student getStudentInstance(String name,int age){
		return new Student(name, age);
	}
}	
