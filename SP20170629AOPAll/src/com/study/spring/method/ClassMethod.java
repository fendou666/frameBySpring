package com.study.spring.method;

public class ClassMethod {
	public String myMethod(String showInfo){
		System.out.println("我是一个普通方法 ，传进来的参数是" + showInfo);
		int i = 1/0;
		return showInfo;
	}
}
