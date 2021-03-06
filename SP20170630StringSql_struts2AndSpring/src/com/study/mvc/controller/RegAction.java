package com.study.mvc.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.study.mvc.model.javabean.MyExeception;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;

public class RegAction extends ActionSupport implements ModelDriven<StudentInfo> {

	private static final long serialVersionUID = 1L;
	private IStudentService stuService;
	private StudentInfo stu = new StudentInfo();
	
	public StudentInfo getStu() {
		return stu;
	}
	public void setStu(StudentInfo stu) {
		this.stu = stu;
	}
	public IStudentService getStuService() {
		return stuService;
	}
	public void setStuService(IStudentService stuService) {
		this.stuService = stuService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String regMethod() throws Exception{
		boolean insertSign = false;
		try{
			insertSign = stuService.insertStudentInfo(stu);
		}catch(MyExeception e){
			addActionError(e.getMessage());
		}
		if(insertSign){
			System.out.println("添加数据成功");
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	@Override
	public StudentInfo getModel() {
		
		return stu;
	}
}
