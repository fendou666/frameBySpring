package com.study.spring.aop;


import org.aspectj.lang.JoinPoint;


public class In2BeforAop {
	public void aopBefore(JoinPoint po){
		System.out.println("��ȡ�����Ĳ���" + po.getArgs()[0]);
		System.out.println("��ȡ������java��ĵ��÷����ķ���" + po.getSignature());
		System.out.println("��ȡ������java����" + po.getTarget());
	}
}