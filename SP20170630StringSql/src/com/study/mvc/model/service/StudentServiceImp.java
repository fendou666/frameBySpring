package com.study.mvc.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.dao.IStudentDAO;
import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.MyExeception;
import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.tools.DBUtil;

public class StudentServiceImp implements IStudentService {
	private IStudentDAO studentDAO;
	
	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public StudentInfo getStudentById(int id) {
		return null;
	}
	
	@Override
	public StudentInfo getStudentByNum(int num) {
		return null;
	}

	@Override
	public List<StudentInfo> getStudentByName(String name) {
		return null;
	}

	@Override
	public List<StudentInfo> getStudentBySex(String sex) {
		return null;
	}

	@Override
	public List<StudentInfo> getStudentByAge(int start, int end) {
		return null;
	}

	@Override
	public List<StudentInfo> getStudentBySchool(String schoolName) {
		return null;
	}
	
	@Override
	public List<StudentInfo> getStudentByCondition(int num, String name,
			String sex, int start, int end, String schoolName, PageSpliteInfo pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<StudentInfo> getStudentByCondition(int id, String name,
			PageSpliteInfo pageInfo) {
		List<StudentInfo> stuList = null;
		HashMap mp = studentDAO.getStudentByCondition(id, name, pageInfo);
		if(mp!=null){
			stuList = (List<StudentInfo>)mp.get("stuList");
		}
		return stuList;
	}

	@Override
	public boolean insertStudentInfo(StudentInfo stu)  throws MyExeception {
		return studentDAO.insertStudentInfo(stu);
	}

	@Override
	public boolean deleteStudentInfo(int num)  throws MyExeception {
		return studentDAO.deleteStudentInfo(num);
	}

	@Override
	public boolean saveStudentInfo(StudentInfo stu)  throws MyExeception {
		return studentDAO.saveStudentInfo(stu);
	}


	
}
