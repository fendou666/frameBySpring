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
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("onSubmit.action")
	public String onSubmit(String name, String pwd) throws Exception {
		System.out.println("req name:" + name);
		System.out.println("req pwd:" + pwd);
		return "forward:/gotoGetUser.action";
	}
	@RequestMapping("onSubmitBean.action")
	public String onSubmit(User u) throws Exception {
		System.out.println("req name:" + u.getName());
		System.out.println("req pwd:" + u.getPwd());
		return "forward:/gotoGetUser.action";
	}
	@RequestMapping("gotoGetUser.action")
	public  ModelAndView gotoGetUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
		modelAndView.setViewName("success");
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
