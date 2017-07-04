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
		System.out.println("���� login.action");
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("forward:gotoLogin.action");
		return "forward:gotoLogin.action";
	}
	@RequestMapping("gotoLogin.action")
	public  ModelAndView gotoLogin(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("���� gotoLogin.action");
		modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	
	@RequestMapping("getUser.action")
	public String getUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
//		Ĭ������ת��
//		modelAndView.setViewName("WEB-INF/jsp/success.jsp");
		System.out.println("req name:" + req.getParameter("name"));
		System.out.println("req pwd:" + req.getParameter("pwd"));
//		����ת��
		//modelAndView.setViewName("forward:/WEB-INF/jsp/success.jsp");
//		�ض��� Ҫ����ҳ������web-infoĿ¼��
		//modelAndView.setViewName("redirect:/WEB-INF/jsp/success.jsp");
//		��web-info�µ��ļ����Է���
		//modelAndView.setViewName("redirect:/test.jsp");
//		=================������ֱ�ӷ�����Դ�ļ���ֻ��ͨ������actionȻ�������������ҳ=====
//		���治�ɷ�����Դ�ļ�������ͨ���ڲ�controlת������ʵ������
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
		userList.add(new User("С��", "1111"));
		userList.add(new User("С��", "2222"));
		userList.add(new User("С��", "3333"));
		return userList;
	}
}