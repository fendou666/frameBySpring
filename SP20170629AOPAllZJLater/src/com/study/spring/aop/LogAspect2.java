/**
 * Copyright www.hoomsun.com 红上金融信息服务（上海）有限公司
 */
package com.study.spring.aop;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 作者：Administrator <br>
 * 创建时间：2017年10月10日 <br>
 * 描述：
 */
@Component
@Aspect
public class LogAspect2 {
	public LogAspect2() {
		System.out.println("###create MyInterceptor");
	}

	// 声明一个切入点
	@Pointcut("execution(* com.study.spring.method.*.*(..))")
	private void anyMethod() {
		
	}
//
////	@Before("execution(* com.study.spring.*.*.*(..))")
//	@Before("anyMethod()")
//	// 声明前置通知
//	public void doBefore(JoinPoint  point) throws Throwable {
//		// 拦截的实体类
//		Object target = point.getTarget();
//		// 拦截的方法名称
//		String methodName = point.getSignature().getName();
//		// 拦截的方法参数
//		Object[] args = point.getArgs();
//		Signature signature = point.getSignature();    
//		MethodSignature methodSignature = (MethodSignature)signature;    
//		Method targetMethod = methodSignature.getMethod();  
//		Method realMethod = point.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes()); 
//	        //获取方法上注解中表明的权限    
////	        Permission permission = (Permission)realMethod.getAnnotation(Permission.class);   
//	        BussAnnotation annotation = realMethod.getAnnotation(BussAnnotation.class);
//	        if(annotation!= null){
//	        	String moduleName = annotation.moduleName();
//	        	String option = annotation.option();
//	        	System.err.println("moduleName=="+moduleName);
//	        	System.err.println("option=="+option);
//	        	System.err.println("target=="+target);
//	        	System.err.println("methodName=="+methodName);
//	        }
//	}

//	@AfterReturning(pointcut = "anyMethod()", returning = "result")
//	// 声明后置通知
//	public void doAfterReturning(String result) {
//		System.out.println("后置通知");
//		System.out.println("---" + result + "---");
//	}
//
//	@AfterThrowing(pointcut = "anyMethod()", throwing = "e")
//	// 声明例外通知
//	public void doAfterThrowing(Exception e) {
//		System.out.println("异常通知");
//		System.out.println(e.getMessage());
//	}
//
//	@After("anyMethod()")
//	// 声明最终通知
//	public void doAfter() {
//		System.out.println("最终通知");
//	}

	@Around("anyMethod()")
	public void aopCroess(ProceedingJoinPoint pjp){
		System.out.println("执行前");
		try {
			Object[] args = pjp.getArgs(); // 访问目标方法的参数：
			Object returnValue = pjp.proceed(args);
			System.out.println("执行后");
		} catch (Throwable e) {
			System.out.println("抛出异常后执行");
		}
		System.out.println("最终执行");
	}
	
	/**
	 * AOP 将返回值返回
	 * @param pjp
	 */
	@Around("anyMethod()")
	public Object aopCroessRec(ProceedingJoinPoint pjp){
		System.out.println("执行前");
		Object returnValue = null;
		try {
			Object[] args = pjp.getArgs(); // 访问目标方法的参数：
			returnValue = pjp.proceed(args);
			System.out.println("执行后");
		} catch (Throwable e) {
			System.out.println("抛出异常后执行");
		}
		System.out.println("最终执行");
		return returnValue;
	}
}
