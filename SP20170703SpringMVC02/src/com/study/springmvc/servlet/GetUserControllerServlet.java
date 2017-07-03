package com.study.springmvc.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.springmvc.bean.User;

public class GetUserControllerServlet implements IHandlerMapping{

	@Override
	public String executeController(HttpServletRequest req,
			HttpServletResponse resp) {
		getUserList(req);
		//return  req.getContextPath() +"/WEB-INF/jsp/success.jsp";
		return  "WEB-INF/jsp/success.jsp";
	}
	private void getUserList(HttpServletRequest req){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("С��", "1111"));
		userList.add(new User("С��", "2222"));
		userList.add(new User("С��", "3333"));
		req.setAttribute("userList", userList);
	}

}
