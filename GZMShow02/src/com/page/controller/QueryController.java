package com.page.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.page.bean.User;
import com.page.dao.PageControllor;
import com.page.service.IQueryService;

public class QueryController extends AbstractController{
	IQueryService queryService;
	PageControllor pageControl;
	public IQueryService getQueryService() {
		return queryService;
	}
	public void setQueryService(IQueryService queryService) {
		this.queryService = queryService;
	}
	public PageControllor getPageControl() {
		return pageControl;
	}
	public void setPageControl(PageControllor pageControl) {
		this.pageControl = pageControl;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		String name = req.getParameter("name");
		String action = req.getParameter("action");
		if(action!=null&&!action.equals("")){
		//根据指令参数设置查询页码
		switch (action) {
		case "pre":
			pageControl.setPageNo(pageControl.getPageNo()-1);
			break;
        case "next":
        	pageControl.setPageNo(pageControl.getPageNo()+1);
			break;
        case "last":
        	pageControl.setPageNo(pageControl.getMax_page());
	        break;
        case "first":
        	pageControl.setPageNo(1);
	        break;
		default:
			pageControl.setPageNo(Integer.parseInt(action));
			break;
		}
		}
//		查询记录
		List<User> query = queryService.queryOracle(name);
 //输出JSON数据
		PrintWriter out = res.getWriter();
		if(query!=null){
		JSONArray fromObject = JSONArray.fromObject(query);
		out.write(fromObject.toString());
		}
		return null;
	}

}
