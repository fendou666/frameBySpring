package com.study.Spring.bean;

public class StudentAndClass {
	private String name = "刘帅";
	private int age = 22;
	private Classes cls;
	
	public StudentAndClass(String name, int age, Classes cls) {
		this.name = name;
		this.age = age;
		this.cls = cls;
	}
	public StudentAndClass(String name, int age) {
		System.out.println("初始化student 调用Student类有参构造方法");
		this.name = name;
		this.age = age;
	}
	public StudentAndClass() {
		System.out.println("初始化student 调用Student类无参构造方法");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Classes getCls() {
		return cls;
	}
	public void setCls(Classes cls) {
		System.out.println("set cls 方法");
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "StudentAndClass [name=" + name + ", age=" + age + ", cls="
				+ cls + "]";
	}
	
}
