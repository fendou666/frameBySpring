package com.study.springmvc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.study.springmvc.bean.User;

public class GetUserControllerServlet extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	private List<User> getUserList(HttpServletRequest req){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("С��", "1111"));
		userList.add(new User("С��", "2222"));
		userList.add(new User("С��", "3333"));
		return userList;
	}

}