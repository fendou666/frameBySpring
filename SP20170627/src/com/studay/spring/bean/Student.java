package com.studay.spring.bean;

public class Student {
	private String name = "��˧";
	private int age = 22;
	public Student(String name, int age) {
		//System.out.println("��ʼ��student ����Student���вι��췽��");
		this.name = name;
		this.age = age;
	}
	public Student() {
		System.out.println("��ʼ��student ����Student���޲ι��췽��");
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
		System.out.println("student�����Ѿ��������ˡ���������");
	}
//	public void initStudent(int aa){
//		System.out.println("����ǲ����ܴ����ģ���������");
//		System.out.println("��������ʱ�򴥷���init ������aa�ķ���");
//	}
	public  void destroySingletonStudent(){
		System.out.println("student�����Ѿ��������ˡ���������");
	}
}
