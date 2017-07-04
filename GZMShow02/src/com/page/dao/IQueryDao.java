package com.page.dao;

import java.util.List;

import com.page.bean.User;

public interface IQueryDao {
//	Oracle查询方法
	public List<User> queryOracle(String name,PageControllor pageControl);
	
//	MySQL查询方法
	public List<User> queryMySQL(String name,PageControllor pageControl);
}
