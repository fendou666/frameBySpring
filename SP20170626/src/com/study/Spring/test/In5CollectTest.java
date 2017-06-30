package com.study.Spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.bean.In5CollectionDataType;

public class In5CollectTest {
	@Test
	public void testCollect(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/Spring/config/In5CollectionAc.xml");
		
		In5CollectionDataType clc = ac.getBean("clo", In5CollectionDataType.class);
		// list
		System.out.println(clc.getMyList());
		// set
		//  set�в�֧��integer����
		System.out.println(clc.getMySet());
		// map ����
		// map key,value���Ƕ���֧�֣�����
		System.out.println(clc.getMyMap());
		// pro
		System.out.println(clc.getMyPro());
	}
}