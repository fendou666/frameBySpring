package com.study.springmvc.test;

import org.junit.Test;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class SpringMVCTest {
	@Test
	public void testSimpleUrlHandlerMap(){
		SimpleUrlHandlerMapping controllerMap = new  SimpleUrlHandlerMapping();
		//controllerMap.setMappings(mappings);
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//resolver.set
	}
}
