package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.bean.Student;

public class In1SpringTest {
	@Test
	public void myTest(){
		System.out.println("我是一个junit测试文件");
		ApplicationContext ac = new ClassPathXmlApplicationContext
							("com/study/Spring/config/In1ApplicationContext.xml");
		// ======= 无参构造方法
		Student stu =  (Student)ac.getBean("stu");
		System.out.println("student name:" + stu.getName());
		System.out.println("student age:" + stu.getAge());
		//  无需声明返回值的一种情况
		Student stu1 =  ac.getBean("stu", Student.class);
		System.out.println("student name:" + stu1.getName());
		System.out.println("student age:" + stu1.getAge());
		
		// ======= 有参构造方法
		Student stucons =  (Student)ac.getBean("stucons");
		System.out.println("student name:" + stucons.getName());
		System.out.println("student age:" + stucons.getAge());
		
		
		//-----------------------静态工厂---------------
		System.out.println("-----------------------静态工厂---------------");
		ApplicationContext acs = new ClassPathXmlApplicationContext("com/study/Spring/config/StaticFactoryApplicationContext.xml");
		Student stuAcs = acs.getBean("stuStatic", Student.class);
		System.out.println("student name:" + stuAcs.getName());
		System.out.println("student age:" + stuAcs.getAge());
		

		//-----------------------普通工厂---------------
		System.out.println("-----------------------普通工厂---------------");
		ApplicationContext accstm = new ClassPathXmlApplicationContext("com/study/Spring/config/CostomFactoryApplicationContext.xml");
		Student stuCstm = accstm.getBean("stuCstm", Student.class);
		System.out.println("student name:" + stuCstm.getName());
		System.out.println("student age:" + stuCstm.getAge());
		
	}
}
