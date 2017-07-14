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
		modelAndView.setViewName("login");
		return modelAndView;
	}
	public  ModelAndView gotoGetUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	public ModelAndView getUser(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
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
		modelAndView.setViewName("forward:/gotoGetUser.action");
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