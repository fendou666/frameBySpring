package com.study.mvc.model.service;


import java.util.List;
import java.util.Map;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;

//规范开发的范围
//规范开发的目标
public interface IStudentService {
	//增 删 改
	public int insert(StudentInfo stu);//增
	
	public List<StudentInfo> findStudents(Map<String, String> conditionMap);
	
	public int getMaxPageNumbers(Map<String, String> conditionMap);
}
