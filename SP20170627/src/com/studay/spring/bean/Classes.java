package com.studay.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="cla") // 这里value不写默认就是小写
public class Classes {
	@Value(value="java0207")
	private String name;
	@Value(value="11111")
	private int  id;
	
	public Classes() {
		System.out.println("班级  无参构造方法");
	}
	public Classes(String name, int id) {
		System.out.println("班级  有参构造方法");
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("班级  setName方法");
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("班级  setId方法");
		this.id = id;
	}
	@Override
	public String toString() {
		return "Classes [name=" + name + ", id=" + id + "]";
	}
	
}
