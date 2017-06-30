package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.bean.LifeStaticStudentProxy;
import com.study.Spring.bean.Student;

public class In3LifeSpringTest {
	@Test
	public void myTest(){
		//-----------------------��̬����---------------
		System.out.println("-----------------------��̬����---------------");
		ClassPathXmlApplicationContext acs = new ClassPathXmlApplicationContext
				("com/study/Spring/config/In3LifeStaticFactoryApplicationContext.xml");
//		System.out.println("ֱ�ӵ���ģʽ1" +acs.getBean("stuSign").hashCode());
//		System.out.println("ֱ�ӵ���ģʽ2" +acs.getBean("stuSign").hashCode());
		
		//Student stuAcs = acs.getBean("stuSignInitDestroy", Student.class);
		//acs.close();
		
		LifeStaticStudentProxy staticProxy = acs.getBean("proxyInitDestroy", LifeStaticStudentProxy.class);
		acs.close();
	}
}