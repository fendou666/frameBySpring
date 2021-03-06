package com.study.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;
import com.study.mvc.tools.DBUtil;

public class JDBCTest {
	@Test
	public void DBUtilTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		DBUtil jdbc = ac.getBean("dbutil", DBUtil.class);
		
		String sql = "INSERT INTO studentInfoA  VALUES(502, 10502, 'ls-10502', '女', 22, '长安大学')";
		int insertrst = jdbc.updateSql(sql, null);
		if(insertrst!=0){
			System.out.println("数据插入成功");
		}
		String querySql = "SELECT name FROM studentInfoA  WHERE id=502";
		ResultSet rs = jdbc.queryData(querySql, null);
		try {
			while(rs.next()){
				System.out.println(rs.getObject("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		String updtsql = "UPDATE studentInfoA SET stuNum=105022, name='ls-105022', sex='男', age=23, gradeFrom='桂云山庄' WHERE id=502";
//		int updateRst = jdbc.updateSql(updtsql, null);
//		if(updateRst!=0){
//			System.out.println("数据更新成功");
//		}
//		String delsql = "DELETE FROM studentInfoA  WHERE id=502";
//		int delRst = jdbc.updateSql(delsql, null);
//		if(delRst!=0){
//			System.out.println("数据更新成功");
//		}
		
	}
	@Test
	public void DAOTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		// 这里使用接口试一试
		StudentDAOImp DAO = ac.getBean("DAO",StudentDAOImp.class);
		StudentInfo stu = new StudentInfo(503, 10503, "ls-10503", "女", 22, "长安大学");
		// ================DAO插入数据
//		boolean insertSign = DAO.insertStudentInfo(stu);
//		if(insertSign){
//			System.out.println("DAO插入数据成功");
//		}
		// ================DAO查询数据
//		HashMap stuMap = DAO.getStudentByCondition(0, "123", "男", 20, 22, "zz");
//		if(!stuMap.isEmpty()){
//			System.out.println("获取到数据");
//		}
//		
//		// ===============DAO更新数据
//		stu.setName("小红");
//		boolean updSign = DAO.saveStudentInfo(stu);
//		if(updSign == true){
//			System.out.println("更新成功");
//		}
//		
//		// ===============DAO删除数据
		boolean delSign = DAO.deleteStudentInfo(stu.getId());
		if(delSign == true){
			System.out.println("删除成功");
		}
		
	}
	
	// ================service测试=================
	@Test
	public void serviceTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		// 这里使用接口试一试
		IStudentService service = ac.getBean("service",StudentServiceImp.class);
		StudentInfo stu = new StudentInfo(502, 10502, "ls-10502", "女", 22, "长安大学");
//		// ================service插入数据
//		boolean insertSign = service.insertStudentInfo(stu);
//		if(insertSign){
//			System.out.println("service插入数据成功");
//		}
//		// ================service查询数据
//		List<StudentInfo> stuList = service.getStudentByCondition(0, "123", "男", 20, 22, "zz");
//		if(stuList.size()<1){
//			System.out.println("没有获取到数据");
//		}
//		
//		// ===============service更新数据
//		stu.setName("小红");
//		boolean updSign = service.saveStudentInfo(stu);
//		if(updSign == true){
//			System.out.println("更新成功");
//		}
		
		// ===============service删除数据
//		boolean delSign = service.deleteStudentInfo(stu.getId());
//		if(delSign == true){
//			System.out.println("删除成功");
//		}
	}
	
	
}
