package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class In4IOC {
	@Test
	public void testIOC(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/Spring/config/IOCApplicationContext.xml");
		System.out.println(ac.getBean("stu"));
	}
}