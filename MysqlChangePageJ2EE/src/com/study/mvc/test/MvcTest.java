package com.study.mvc.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;
import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;
import com.study.mvc.tools.DButil;

public class MvcTest {
	@Test
	public void mytestFind(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentServiceImp bean = ac.getBean("stuService", StudentServiceImp.class);
		Map<String, String> map=null;
		List<StudentInfo> findStudents = bean.findStudents(map);
		System.out.println(findStudents);
	}
}
