package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.bean.Student;

public class In2SpringTestImport {
	@Test
	public void myTest(){
		System.out.println("����һ��junit�����ļ�");
		ApplicationContext ac = new ClassPathXmlApplicationContext
							("com/study/Spring/config/ImportMain.xml");
		// ======= �޲ι��췽��
		Student stu =  (Student)ac.getBean("stu");
		System.out.println("student name:" + stu.getName());
		System.out.println("student age:" + stu.getAge());
		//  ������������ֵ��һ�����
		Student stu1 =  ac.getBean("stu", Student.class);
		System.out.println("student name:" + stu1.getName());
		System.out.println("student age:" + stu1.getAge());
		
		// ======= �вι��췽��
		Student stucons =  (Student)ac.getBean("stucons");
		System.out.println("student name:" + stucons.getName());
		System.out.println("student age:" + stucons.getAge());
		
		
		//-----------------------��̬����---------------
		System.out.println("-----------------------��̬����---------------");
		Student stuAcs = ac.getBean("stuStatic", Student.class);
		System.out.println("student name:" + stuAcs.getName());
		System.out.println("student age:" + stuAcs.getAge());
		

		//-----------------------��ͨ����---------------
		System.out.println("-----------------------��ͨ����---------------");
		Student stuCstm = ac.getBean("stuCstm", Student.class);
		System.out.println("student name:" + stuCstm.getName());
		System.out.println("student age:" + stuCstm.getAge());
		
	}
}