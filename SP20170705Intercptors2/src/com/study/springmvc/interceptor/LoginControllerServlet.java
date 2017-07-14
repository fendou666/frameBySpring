package com.study.springmvc.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.study.springmvc.bean.User;
import com.sun.media.sound.ModelAbstractOscillator;

// 需要3个包 web两个 + aspects一个
public class LoginControllerServlet extends AbstractController{
	
	
	private List<User> getUserList(HttpServletRequest req){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("小明", "1111"));
		userList.add(new User("小军", "2222"));
		userList.add(new User("小红", "3333"));
		return userList;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", getUserList(req));
		modelAndView.setViewName("success");
		return modelAndView;
	}
}
