package com.study.spring.method;

import org.springframework.stereotype.Component;

@Component
public class ClassMethod {
	public String myMethod(String showInfo){
		System.out.println("����һ����ͨ���� ���������Ĳ�����" + showInfo);
		int a = 1/0;
		return showInfo;
	}
}
