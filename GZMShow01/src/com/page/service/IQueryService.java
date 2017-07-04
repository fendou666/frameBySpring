package com.page.service;

import java.util.List;

import com.page.bean.User;

public interface IQueryService {
	
//	Oracle查询方法
	public List<User> queryOracle(String name);
	
//	MySQL查询方法 
	public List<User> queryMySQL(String name);
}
