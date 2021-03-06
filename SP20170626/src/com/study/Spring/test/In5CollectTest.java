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
		//  set中不支持integer类型
		System.out.println(clc.getMySet());
		// map 测试
		// map key,value都是对象不支持？？？
		System.out.println(clc.getMyMap());
		// pro
		System.out.println(clc.getMyPro());
	}
}
