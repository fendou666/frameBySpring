package com.study.mvc.model.service;

import java.util.List;
import java.util.Map;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;
import com.study.mvc.model.dao.IStudentDAO;

public class StudentServiceImp implements IStudentService {
	private IStudentDAO studentDao;
	private GenericPageInfo gPageInfo;
	
    public StudentServiceImp(){
    	
    }

	public GenericPageInfo getgPageInfo() {
		return gPageInfo;
	}

	public void setgPageInfo(GenericPageInfo gPageInfo) {
		this.gPageInfo = gPageInfo;
	}

	public IStudentDAO getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int insert(StudentInfo stu) {
		return studentDao.insert(stu);
	}

	@Override
	public List<StudentInfo> findStudents(Map<String, String> conditionMap) {
		return studentDao.findStudents(conditionMap,gPageInfo);
	}

	@Override
	public int getMaxPageNumbers(Map<String, String> conditionMap) {
		return studentDao.getMaxPageNumbers(conditionMap,gPageInfo);
	}

}
