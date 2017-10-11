package com.study.spring.method;

import org.springframework.stereotype.Component;

import com.study.spring.aop.BussAnnotation;

//@Component
public class ClassMethod {
//	@BussAnnotation(moduleName="公司管理",option="删除公司")
	public String myMethod(String showInfo){
		System.out.println("我是一个普通方法 ，传进来的参数是" + showInfo);
		int a = 1/0;
		return showInfo;
	}
}
