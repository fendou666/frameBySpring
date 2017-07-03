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

public class DispatcherServlet extends HttpServlet {

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
		System.out.println("action Œ™" + action);
		String url = "error.jsp";
		
		if(action.equals("login.action")){
			url = new LoginControllerServlet().executeController(req, resp);
		}else if(action.equals("getUser.action")){
			url = new GetUserControllerServlet().executeController(req, resp);
		}else{
			out.write("servlet url partten≈‰÷√¥ÌŒÛ");
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	
}
