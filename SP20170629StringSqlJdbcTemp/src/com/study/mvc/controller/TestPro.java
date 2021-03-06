package com.study.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;
import com.sun.net.httpserver.HttpServer;

public class TestPro extends HttpServlet {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");

	public ApplicationContext getAc() {
		return ac;
	}

	public void setAc(ApplicationContext ac) {
		this.ac = ac;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ==== 编码设置
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// ==== 获取参数
		String action = req.getParameter("action");
		// ==== 获取bean值
		PageSpliteInfo ps = ac.getBean("pageSP", PageSpliteInfo.class);
		IStudentService stuservice = ac.getBean("service", StudentServiceImp.class);
		int pageNeedIndex = 0;
		
		
		int allRows = stuservice.getMaxPageIndex();
		if(allRows == 0){
			 out.write("[]");
			 return;
		}else{
			ps.setAllRecodeNum(allRows);
			ps.initPageMaxIndex();
			switch (action) {
				case "first":
					ps.setCurrentPageIndex(1);
					break;
				case "pre":
					ps.setCurrentPageIndex(ps.getCurrentPageIndex() -1);
					break;
				case "nxt":
					ps.setCurrentPageIndex(ps.getCurrentPageIndex() +1);
					break;
				case "end":
					ps.setCurrentPageIndex(ps.getPageMaxIndex());
					break;
				default:
					try {
						pageNeedIndex = Integer.parseInt(action);
					} catch (NumberFormatException e) {
						out.write("[]");
						return;
					}
					ps.setCurrentPageIndex(pageNeedIndex);
					break;
			}
			// 数据暂时是假数据
			List<StudentInfo> stuList = stuservice.getStudentByCondition(2, "xiaoming", ps);
			JSONArray fo = JSONArray.fromObject(stuList);
			out.write(fo.toString());
		}
	}
}
