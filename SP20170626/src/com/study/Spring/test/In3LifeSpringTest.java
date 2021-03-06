package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.bean.LifeStaticStudentProxy;
import com.study.Spring.bean.Student;

public class In3LifeSpringTest {
	@Test
	public void myTest(){
		//-----------------------静态工厂---------------
		System.out.println("-----------------------静态工厂---------------");
		ClassPathXmlApplicationContext acs = new ClassPathXmlApplicationContext
				("com/study/Spring/config/In3LifeStaticFactoryApplicationContext.xml");
//		System.out.println("直接单例模式1" +acs.getBean("stuSign").hashCode());
//		System.out.println("直接单例模式2" +acs.getBean("stuSign").hashCode());
		
		//Student stuAcs = acs.getBean("stuSignInitDestroy", Student.class);
		//acs.close();
		
		LifeStaticStudentProxy staticProxy = acs.getBean("proxyInitDestroy", LifeStaticStudentProxy.class);
		acs.close();
	}
}
