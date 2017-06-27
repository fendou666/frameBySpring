package com.studay.spring.bean;

public class Student {
	private String name = "刘帅";
	private int age = 22;
	public Student(String name, int age) {
		//System.out.println("初始化student 调用Student类有参构造方法");
		this.name = name;
		this.age = age;
	}
	public Student() {
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public  void initStudent(){
		System.out.println("student对象已经被创建了。。。。。");
	}
//	public void initStudent(int aa){
//		System.out.println("这个是不可能触发的！！！！！");
//		System.out.println("创建对象时候触发的init 带参数aa的方法");
//	}
	public  void destroySingletonStudent(){
		System.out.println("student对象已经被销毁了。。。。。");
	}
}
