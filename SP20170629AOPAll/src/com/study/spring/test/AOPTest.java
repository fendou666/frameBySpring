package com.study.spring.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.method.ClassMethod;

public class AOPTest {
	@Test
	public void testAopBefore(){
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("com/study/spring/config/aopAC.xml");
		ClassMethod myObj = cp.getBean("classMethod", ClassMethod.class);
		//System.out.println(cp.getBean("aopBF"));
		myObj.myMethod("aaaa");
		
	}
}	
