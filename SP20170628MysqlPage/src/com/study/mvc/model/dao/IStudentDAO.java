package com.study.mvc.model.dao;

import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;

public interface IStudentDAO {
	// ��ѯ
	public HashMap getStudentById(int id);
	public HashMap getStudentByNum(int num);
	public HashMap getStudentByName(String name);
	public HashMap getStudentBySex(String sex);
	public HashMap getStudentByAge(int start, int end);
	public HashMap getStudentBySchool(String schoolName);
	public HashMap getStudentByCondition(int id, String name, PageSpliteInfo pageInfo);
	public HashMap getStudentByCondition(int num, String name, String sex, 
			int start, int end, String schoolName, PageSpliteInfo pageInfo);
	public int getMaxPageIndex();
	// ����
	public boolean insertStudentInfo(StudentInfo stu);
	// ɾ��
	public boolean deleteStudentInfo(int num);
	// �޸�
	public boolean saveStudentInfo(StudentInfo stu);
}
