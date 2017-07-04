package com.page.bean;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Test implements BeanNameAware,ApplicationAware,BeanPostProcessor,InitializingBean,DisposableBean {

	public Test() {
		System.out.println("ʵ���Ѵ���");
	}

	@Override
	public void setBeanName(String arg0) {
	System.out.println("��bean�����������"+arg0);
		
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		System.out.println("����3");
		
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("����4"+arg0+"    "+arg1);
		return arg0;
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("����5");
		return arg0;
	}

	

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("����6");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("����7");
	}
	public void init() throws Exception {
		System.out.println("init()");
	}
	public void del() throws Exception {
		System.out.println("del()");
	}

	
	
}
