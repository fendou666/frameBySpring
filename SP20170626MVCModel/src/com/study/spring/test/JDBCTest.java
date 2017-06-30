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
		
		String sql = "INSERT INTO studentInfoA  VALUES(502, 10502, 'ls-10502', 'Ů', 22, '������ѧ')";
		int insertrst = jdbc.updateSql(sql, null);
		if(insertrst!=0){
			System.out.println("���ݲ���ɹ�");
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
//		String updtsql = "UPDATE studentInfoA SET stuNum=105022, name='ls-105022', sex='��', age=23, gradeFrom='����ɽׯ' WHERE id=502";
//		int updateRst = jdbc.updateSql(updtsql, null);
//		if(updateRst!=0){
//			System.out.println("���ݸ��³ɹ�");
//		}
//		String delsql = "DELETE FROM studentInfoA  WHERE id=502";
//		int delRst = jdbc.updateSql(delsql, null);
//		if(delRst!=0){
//			System.out.println("���ݸ��³ɹ�");
//		}
		
	}
	@Test
	public void DAOTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		// ����ʹ�ýӿ���һ��
		StudentDAOImp DAO = ac.getBean("DAO",StudentDAOImp.class);
		StudentInfo stu = new StudentInfo(503, 10503, "ls-10503", "Ů", 22, "������ѧ");
		// ================DAO��������
//		boolean insertSign = DAO.insertStudentInfo(stu);
//		if(insertSign){
//			System.out.println("DAO�������ݳɹ�");
//		}
		// ================DAO��ѯ����
//		HashMap stuMap = DAO.getStudentByCondition(0, "123", "��", 20, 22, "zz");
//		if(!stuMap.isEmpty()){
//			System.out.println("��ȡ������");
//		}
//		
//		// ===============DAO��������
//		stu.setName("С��");
//		boolean updSign = DAO.saveStudentInfo(stu);
//		if(updSign == true){
//			System.out.println("���³ɹ�");
//		}
//		
//		// ===============DAOɾ������
		boolean delSign = DAO.deleteStudentInfo(stu.getId());
		if(delSign == true){
			System.out.println("ɾ���ɹ�");
		}
		
	}
	
	// ================service����=================
	@Test
	public void serviceTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		// ����ʹ�ýӿ���һ��
		IStudentService service = ac.getBean("service",StudentServiceImp.class);
		StudentInfo stu = new StudentInfo(502, 10502, "ls-10502", "Ů", 22, "������ѧ");
//		// ================service��������
//		boolean insertSign = service.insertStudentInfo(stu);
//		if(insertSign){
//			System.out.println("service�������ݳɹ�");
//		}
//		// ================service��ѯ����
//		List<StudentInfo> stuList = service.getStudentByCondition(0, "123", "��", 20, 22, "zz");
//		if(stuList.size()<1){
//			System.out.println("û�л�ȡ������");
//		}
//		
//		// ===============service��������
//		stu.setName("С��");
//		boolean updSign = service.saveStudentInfo(stu);
//		if(updSign == true){
//			System.out.println("���³ɹ�");
//		}
		
		// ===============serviceɾ������
//		boolean delSign = service.deleteStudentInfo(stu.getId());
//		if(delSign == true){
//			System.out.println("ɾ���ɹ�");
//		}
	}
	
	
}