package com.study.springmvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.springmvc.bean.User;
import com.sun.net.httpserver.HttpServer;

public class AllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println("action 为" + action);
		
		if(action.equals("login.action")){
			getUserList(req);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		}else if(action.equals("getUser.action")){
			
			getUserList(req);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
			//resp.sendRedirect("success.jsp");
		}else{
			out.write("servlet url partten配置错误");
		}
	}
	private void getUserList(HttpServletRequest req){
		List<User> userList = new ArrayList<User>();
		userList.add(new User("小明", "1111"));
		userList.add(new User("小军", "2222"));
		userList.add(new User("小红", "3333"));
		req.setAttribute("userList", userList);
	}
	
	
}
