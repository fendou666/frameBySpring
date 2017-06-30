package com.studay.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class In1StudentAndClass {
	@Value(value="��˧")
	private String name;
	@Value(value="22")
	private int age;
	@Resource(name="cla")
	//@Resource
	private Classes cls;
	
	public In1StudentAndClass(String name, int age, Classes cls) {
		this.name = name;
		this.age = age;
		this.cls = cls;
	}
	public In1StudentAndClass(String name, int age) {
		System.out.println("��ʼ��student ����Student���вι��췽��");
		this.name = name;
		this.age = age;
	}
	public In1StudentAndClass() {
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
	public Classes getCls() {
		return cls;
	}
	public void setCls(Classes cls) {
		System.out.println("set cls ����");
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "StudentAndClass [name=" + name + ", age=" + age + ", cls="
				+ cls + "]";
	}
	@PostConstruct
	public void init(){
		System.out.println("���󱻴�����������������������������");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("�������١�������������������������");
	}
}