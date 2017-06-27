package com.study.spring.aop;


import org.aspectj.lang.JoinPoint;


public class In2BeforAop {
	public void aopBefore(JoinPoint po){
		System.out.println("获取切入点的参数" + po.getArgs()[0]);
		System.out.println("获取切入点的java类的调用方法的反射" + po.getSignature());
		System.out.println("获取切入点的java对象" + po.getTarget());
	}
}
