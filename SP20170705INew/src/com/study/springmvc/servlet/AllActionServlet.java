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
		modelAndView.setViewName("forward:gotoLogin.action");
		return modelAndView;
	}
	public  ModelAndView gotoLogin(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	public  ModelAndView gotoGetUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/jsp/success.jsp");
		return modelAndView;
	}
	
	public ModelAndView getUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
//		默认请求转发
//		modelAndView.setViewName("WEB-INF/jsp/success.jsp");
		System.out.println("req name:" + req.getParameter("name"));
		System.out.println("req pwd:" + req.getParameter("pwd"));
//		请求转发
		//modelAndView.setViewName("forward:/WEB-INF/jsp/success.jsp");
//		重定向， 要求网页不能在web-info目录下
		//modelAndView.setViewName("redirect:/WEB-INF/jsp/success.jsp");
//		非web-info下的文件可以访问
		//modelAndView.setViewName("redirect:/test.jsp");
//		=================不可以直接访问资源文件，只能通过请求action然后进行请求不能网页=====
//		上面不可访问资源文件，不过通过内部control转发可以实现请求
		modelAndView.setViewName("forward:/gotoGetUser.action");
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
