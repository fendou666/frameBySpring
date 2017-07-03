package com.study.springmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IHandlerMapping {
	public String executeController(HttpServletRequest req, HttpServletResponse resp);
}
