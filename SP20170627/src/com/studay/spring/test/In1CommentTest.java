package com.studay.spring.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studay.spring.bean.In1StudentAndClass;

public class In1CommentTest {
	@Test
	public void testComment(){
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("com/study/spring/config/In1CommentAc.xml");
		In1StudentAndClass testB = cp.getBean("in1StudentAndClass",In1StudentAndClass.class);
		System.out.println(testB);
		System.out.println(testB.getCls());
		cp.close();
	}
	
	
}
