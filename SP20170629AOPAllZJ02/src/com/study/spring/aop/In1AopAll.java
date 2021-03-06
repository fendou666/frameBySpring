package com.study.spring.aop;


import jdk.nashorn.internal.ir.JoinPredecessor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component   // 如果这里不加， 就需要在 spring配置中进行配置
@Aspect
public class In1AopAll {
	@Before("bean(classMethod)")
	public void aopBefore(JoinPoint po){
		System.out.println("aopBefore 获取切入点的参数" + po.getArgs()[0]);
		System.out.println("aopBefore 获取切入点的java类的调用方法的反射" + po.getSignature());
		System.out.println("aopBefore 获取切入点的java对象" + po.getTarget());
	}
	@AfterReturning(pointcut="bean(classMethod)", returning="o")
	public void aopReturing(JoinPoint po, Object o){
		System.out.println("aopReturing 我是切入点切面中 执行后的获取返回值的");
		System.out.println("aopReturing 切入点返回值是 " + o);
	}
	@AfterThrowing(pointcut="bean(classMethod)", throwing="e")
	public void aopGetException(JoinPoint po, Throwable e){
		System.out.println("aopGetException 我是切入点 执行中 抛出异常后  切面中获取异常的方法");
		System.out.println("aopGetException 切入点抛出的异常是 " + e);
	}
	@After("bean(classMethod)")
	public void aopAfterMust(JoinPoint po){
		System.out.println("aopAfterMust 我是切入点 执行后 必须执行的方法");
	}
//	@Around("bean(classMethod)")
//	public void aopCroess(ProceedingJoinPoint pjp){
//		System.out.println("执行前");
//		try {
//			pjp.proceed();
//			System.out.println("执行后");
//		} catch (Throwable e) {
//			System.out.println("抛出异常后执行");
//		}
//		System.out.println("最终执行");
//	}
	
}
