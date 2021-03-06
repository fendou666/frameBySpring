package com.studay.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class In1StudentAndClass {
	@Value(value="刘帅")
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
		System.out.println("初始化student 调用Student类有参构造方法");
		this.name = name;
		this.age = age;
	}
	public In1StudentAndClass() {
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
	@PostConstruct
	public void init(){
		System.out.println("对象被创建。。。。。。。。。。。。。");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("对象被销毁。。。。。。。。。。。。。");
	}
}
