package com.study.spring.aop;


import jdk.nashorn.internal.ir.JoinPredecessor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class In1AopAll {
	public void aopBefore(JoinPoint po){
		System.out.println("aopBefore 获取切入点的参数" + po.getArgs()[0]);
		System.out.println("aopBefore 获取切入点的java类的调用方法的反射" + po.getSignature());
		System.out.println("aopBefore 获取切入点的java对象" + po.getTarget());
	}
	public void aopReturing(JoinPoint po, Object o){
		System.out.println("aopReturing 我是切入点切面中 执行后的获取返回值的");
		System.out.println("aopReturing 切入点返回值是 " + o);
	}
	public void aopGetException(JoinPoint po, Throwable e){
		System.out.println("aopGetException 我是切入点 执行中 抛出异常后  切面中获取异常的方法");
		System.out.println("aopGetException 切入点抛出的异常是 " + e);
	}
	public void aopAfterMust(JoinPoint po){
		System.out.println("aopAfterMust 我是切入点 执行后 必须执行的方法");
	}
	
	public void aopCroess(ProceedingJoinPoint pjp){
		System.out.println("执行前");
		try {
			pjp.proceed();
			System.out.println("执行后");
		} catch (Throwable e) {
			System.out.println("抛出异常后执行");
		}
		System.out.println("最终执行");
	}
	
}
