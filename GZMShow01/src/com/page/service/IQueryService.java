package com.page.service;

import java.util.List;

import com.page.bean.User;

public interface IQueryService {
	
//	Oracle��ѯ����
	public List<User> queryOracle(String name);
	
//	MySQL��ѯ���� 
	public List<User> queryMySQL(String name);
}
