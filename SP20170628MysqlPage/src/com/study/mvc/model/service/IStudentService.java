package com.study.mvc.model.service;

import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;

public interface IStudentService {
	// ��ѯ
	public StudentInfo getStudentById(int id);
	public StudentInfo getStudentByNum(int num);
	public List<StudentInfo> getStudentByName(String name);
	public List<StudentInfo> getStudentBySex(String sex);
	public List<StudentInfo> getStudentByAge(int start, int end);
	public List<StudentInfo> getStudentBySchool(String schoolName);
	public List<StudentInfo> getStudentByCondition(int id, String name, PageSpliteInfo pageInfo);
	public List<StudentInfo> getStudentByCondition(int num, String name, String sex, 
			int start, int end, String schoolName, PageSpliteInfo pageInfo);
	
	public int getMaxPageIndex();
	
	// ����
	public boolean insertStudentInfo(StudentInfo stu);
	// ɾ��
	public boolean deleteStudentInfo(int num);
	// �޸�
	public boolean saveStudentInfo(StudentInfo stu);
}
