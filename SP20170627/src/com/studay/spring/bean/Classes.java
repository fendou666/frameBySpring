package com.studay.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="cla") // ����value��дĬ�Ͼ���Сд
public class Classes {
	@Value(value="java0207")
	private String name;
	@Value(value="11111")
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