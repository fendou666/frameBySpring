package com.page.service;

import java.util.List;

import com.page.bean.User;
import com.page.dao.IQueryDao;
import com.page.dao.PageControllor;
import com.page.dao.QueryDaoImp;

public class QueryServiceImp implements IQueryService{
   
	IQueryDao dao;    //创建dao层对象
	PageControllor pageControl; //分页控制对象
	
	
	public IQueryDao getDao() {
		return dao;
	}
	public void setDao(IQueryDao dao) {
		this.dao = dao;
	}
	public PageControllor getPageControl() {
		return pageControl;
	}
	public void setPageControl(PageControllor pageControl) {
		this.pageControl = pageControl;
	}
	
	@Override
	public List<User> queryOracle(String name) {
		
		return dao.queryOracle(name,pageControl);
	}


	@Override
	public List<User> queryMySQL(String name) {
		return dao.queryMySQL(name,pageControl);
	}
	

}
