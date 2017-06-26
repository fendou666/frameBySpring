package com.study.Spring.bean;

public class Classes {
	private String name;
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
