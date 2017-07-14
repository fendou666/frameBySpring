package com.study.springmvc.servlet;

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
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
}
