package com.page.dao;

import java.util.List;

import com.page.bean.User;

public interface IQueryDao {
//	Oracle��ѯ����
	public List<User> queryOracle(String name,PageControllor pageControl);
	
//	MySQL��ѯ����
	public List<User> queryMySQL(String name,PageControllor pageControl);
}
