/**
 * Copyright www.hoomsun.com ���Ͻ�����Ϣ�����Ϻ������޹�˾
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
 * ���ߣ�Administrator <br>
 * ����ʱ�䣺2017��10��10�� <br>
 * ������
 */
@Component
@Aspect
public class LogAspect2 {
	public LogAspect2() {
		System.out.println("###create MyInterceptor");
	}

	// ����һ�������
	@Pointcut("execution(* com.study.spring.method.*.*(..))")
	private void anyMethod() {
		
	}
//
////	@Before("execution(* com.study.spring.*.*.*(..))")
//	@Before("anyMethod()")
//	// ����ǰ��֪ͨ
//	public void doBefore(JoinPoint  point) throws Throwable {
//		// ���ص�ʵ����
//		Object target = point.getTarget();
//		// ���صķ�������
//		String methodName = point.getSignature().getName();
//		// ���صķ�������
//		Object[] args = point.getArgs();
//		Signature signature = point.getSignature();    
//		MethodSignature methodSignature = (MethodSignature)signature;    
//		Method targetMethod = methodSignature.getMethod();  
//		Method realMethod = point.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes()); 
//	        //��ȡ������ע���б�����Ȩ��    
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
//	// ��������֪ͨ
//	public void doAfterReturning(String result) {
//		System.out.println("����֪ͨ");
//		System.out.println("---" + result + "---");
//	}
//
//	@AfterThrowing(pointcut = "anyMethod()", throwing = "e")
//	// ��������֪ͨ
//	public void doAfterThrowing(Exception e) {
//		System.out.println("�쳣֪ͨ");
//		System.out.println(e.getMessage());
//	}
//
//	@After("anyMethod()")
//	// ��������֪ͨ
//	public void doAfter() {
//		System.out.println("����֪ͨ");
//	}

	@Around("anyMethod()")
	public void aopCroess(ProceedingJoinPoint pjp){
		System.out.println("ִ��ǰ");
		try {
			Object[] args = pjp.getArgs(); // ����Ŀ�귽���Ĳ�����
			Object returnValue = pjp.proceed(args);
			System.out.println("ִ�к�");
		} catch (Throwable e) {
			System.out.println("�׳��쳣��ִ��");
		}
		System.out.println("����ִ��");
	}
	
	/**
	 * AOP ������ֵ����
	 * @param pjp
	 */
	@Around("anyMethod()")
	public Object aopCroessRec(ProceedingJoinPoint pjp){
		System.out.println("ִ��ǰ");
		Object returnValue = null;
		try {
			Object[] args = pjp.getArgs(); // ����Ŀ�귽���Ĳ�����
			returnValue = pjp.proceed(args);
			System.out.println("ִ�к�");
		} catch (Throwable e) {
			System.out.println("�׳��쳣��ִ��");
		}
		System.out.println("����ִ��");
		return returnValue;
	}
}