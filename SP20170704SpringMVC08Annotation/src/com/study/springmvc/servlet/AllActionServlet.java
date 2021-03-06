package com.study.springmvc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.study.springmvc.bean.User;

@Controller("AllControl")
@RequestMapping("/")
public class AllActionServlet {
	
	@RequestMapping("login.action")
	public  String login(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		System.out.println("进入 login.action");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("forward:gotoLogin.action");
		return "forward:gotoLogin.action";
	}
	@RequestMapping("gotoLogin.action")
	public  ModelAndView gotoLogin(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("进入 gotoLogin.action");
		modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	
	@RequestMapping("getUser.action")
	public String getUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
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
		//modelAndView.setViewName("forward:/gotoGetUser.action");
		return "forward:/gotoGetUser.action";
	}
	@RequestMapping("gotoGetUser.action")
	public  ModelAndView gotoGetUser(HttpServletRequest req,
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
