package com.study.spring.method;

import org.springframework.stereotype.Component;

import com.study.spring.aop.BussAnnotation;

//@Component
public class ClassMethod {
//	@BussAnnotation(moduleName="��˾����",option="ɾ����˾")
	public String myMethod(String showInfo){
		System.out.println("����һ����ͨ���� ���������Ĳ�����" + showInfo);
		int a = 1/0;
		return showInfo;
	}
}
