package com.study.Spring.bean;

public class Classes {
	private String name;
	private int  id;
	
	public Classes() {
		System.out.println("�༶  �޲ι��췽��");
	}
	public Classes(String name, int id) {
		System.out.println("�༶  �вι��췽��");
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("�༶  setName����");
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("�༶  setId����");
		this.id = id;
	}
	@Override
	public String toString() {
		return "Classes [name=" + name + ", id=" + id + "]";
	}
	
}