package com.study.spring.aop;


import jdk.nashorn.internal.ir.JoinPredecessor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class In1AopAll {
	public void aopBefore(JoinPoint po){
		System.out.println("aopBefore ��ȡ�����Ĳ���" + po.getArgs()[0]);
		System.out.println("aopBefore ��ȡ������java��ĵ��÷����ķ���" + po.getSignature());
		System.out.println("aopBefore ��ȡ������java����" + po.getTarget());
	}
	public void aopReturing(JoinPoint po, Object o){
		System.out.println("aopReturing ��������������� ִ�к�Ļ�ȡ����ֵ��");
		System.out.println("aopReturing ����㷵��ֵ�� " + o);
	}
	public void aopGetException(JoinPoint po, Throwable e){
		System.out.println("aopGetException ��������� ִ���� �׳��쳣��  �����л�ȡ�쳣�ķ���");
		System.out.println("aopGetException ������׳����쳣�� " + e);
	}
	public void aopAfterMust(JoinPoint po){
		System.out.println("aopAfterMust ��������� ִ�к� ����ִ�еķ���");
	}
	
	public void aopCroess(ProceedingJoinPoint pjp){
		System.out.println("ִ��ǰ");
		try {
			pjp.proceed();
			System.out.println("ִ�к�");
		} catch (Throwable e) {
			System.out.println("�׳��쳣��ִ��");
		}
		System.out.println("����ִ��");
	}
	
}