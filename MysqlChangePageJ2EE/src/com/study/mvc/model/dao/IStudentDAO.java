package com.study.mvc.model.dao;

import java.util.List;
import java.util.Map;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;

//�淶�����ķ�Χ
//�淶������Ŀ��
public interface IStudentDAO {
	
	public int insert(StudentInfo stu);//��
	
	public List<StudentInfo> findStudents(Map<String, String> conditionMap,GenericPageInfo gPageInfo);

	public int getMaxPageNumbers(Map<String, String> conditionMap,GenericPageInfo gPageInfo);
}
