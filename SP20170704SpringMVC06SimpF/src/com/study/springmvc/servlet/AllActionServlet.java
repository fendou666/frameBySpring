package com.study.springmvc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.study.springmvc.bean.User;

public class AllActionServlet extends MultiActionController {

	public  ModelAndView login(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	public ModelAndView getUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
		modelAndView.setViewName("WEB-INF/jsp/success.jsp");
		return modelAndView;
	}
	private List<User> getUserList(HttpServletRequest req){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("小明", "1111"));
		userList.add(new User("小军", "2222"));
		userList.add(new User("小红", "3333"));
		return userList;
	}
}
