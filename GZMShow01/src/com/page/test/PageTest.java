package com.page.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.page.bean.User;
import com.page.dao.PageControllor;
import com.page.service.IQueryService;
import com.page.service.QueryServiceImp;

public class PageTest {

	
	@Test
	public void Test(){
	ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationOracle.xml");
	PageControllor pageControl = ac.getBean("pageControl",PageControllor.class);
	System.out.println(pageControl);
	pageControl = ac.getBean("pageControl",PageControllor.class);
	System.out.println(pageControl);
	System.out.println(pageControl);
	
   /* IQueryService bean = ac.getBean("QueryService",IQueryService.class);
	List<User> query = bean.queryOracle("baozi");
	System.out.println(query.size());*/
	}
}
