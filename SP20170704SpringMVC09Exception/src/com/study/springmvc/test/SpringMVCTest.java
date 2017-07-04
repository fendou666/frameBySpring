package com.study.springmvc.test;

import org.junit.Test;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class SpringMVCTest {
	@Test
	public void testSimpleUrlHandlerMap(){
		SimpleUrlHandlerMapping controllerMap = new  SimpleUrlHandlerMapping();
		//controllerMap.setMappings(mappings);
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//resolver.set
		InternalPathMethodNameResolver in = new InternalPathMethodNameResolver();
		ParameterMethodNameResolver p = new ParameterMethodNameResolver();
		ControllerClassNameHandlerMapping con = new ControllerClassNameHandlerMapping();
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		SimpleMappingExceptionResolver exception = new SimpleMappingExceptionResolver();
	}
}
