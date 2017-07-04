package com.study.springmvc.servlet;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.study.springmvc.bean.User;

public class SimpleFormControllerTest extends SimpleFormController {
	public SimpleFormControllerTest(){
		setCommandClass(User.class);
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User u = (User)command;
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("获取到页面提交的信息是" + u);
		modelAndView.addObject("user", u);
		modelAndView.setViewName("success");
		return modelAndView;
	}
}
