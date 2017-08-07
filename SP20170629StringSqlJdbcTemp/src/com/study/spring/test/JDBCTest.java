package com.study.spring.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.model.service.IStudentService;
import com.study.mvc.model.service.StudentServiceImp;
import com.study.mvc.tools.DBUtil;

public class JDBCTest {
	@Test
	public void AcBeanTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		DBUtil jdbc1 = ac.getBean("dbutil", DBUtil.class);
		DBUtil jdbc2 = ac.getBean("dbutil", DBUtil.class);
		StudentDAOImp dao1 = ac.getBean("DAO", StudentDAOImp.class);
		StudentDAOImp dao2 = ac.getBean("DAO", StudentDAOImp.class);
//		�����Ϊʲô
		System.out.println("bean 1" + jdbc1.hashCode());
		jdbc1.setErrInfo("aaaaaaaa1111");
		System.out.println("bean 2" + jdbc2.hashCode());
		System.out.println("bean1==bean2 " + (jdbc1 == jdbc2));
		System.out.println(jdbc2.getErrInfo());
		System.out.println("DAO1==DAO2 " + (dao1 == dao2));
		
	}
	
	@Test
	public void testPage(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		PageSpliteInfo page1 = ac.getBean("pageSP", PageSpliteInfo.class);
		PageSpliteInfo page2 = ac.getBean("pageSP", PageSpliteInfo.class);
//		�����Ϊʲô
		System.out.println("page 1" + page1.hashCode());
		page1.setPageMaxIndex(10);
		page1.setCurrentPageIndex(2);
		System.out.println("page 2" + page2.hashCode());
		System.out.println(page1.getCurrentPageIndex());
		System.out.println(page2.getCurrentPageIndex());
		System.out.println("page1==page2 " + (page1 == page1));
	
	}
	
	
	
	@Test
	public void DBUtilTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		DBUtil jdbc = ac.getBean("dbutil", DBUtil.class);
		
		String sql = "INSERT INTO firstTB VALUES(2, 'С��', 22)";
		int insertrst = jdbc.updateSql(sql, null);
		if(insertrst!=0){
			System.out.println("���ݲ���ɹ�");
		}
//		String querySql = "SELECT name FROM studentInfoA  WHERE id=502";
//		ResultSet rs = jdbc.queryData(querySql, null);
//		try {
//			while(rs.next()){
//				System.out.println(rs.getObject("name"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
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
		//StudentInfo stu = new StudentInfo(503, 10503, "ls-10503", "Ů", 22, "������ѧ");
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
		
	}
	
	// ================service����=================
	@Test
	public void serviceTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		// ����ʹ�ýӿ���һ��
		IStudentService service = ac.getBean("service",StudentServiceImp.class);
		//StudentInfo stu = new StudentInfo(502, 10502, "ls-10502", "Ů", 22, "������ѧ");
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
	@Test
	public void txTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
//		Object bean = ac.getBean("service");
		StudentInfo stu = new StudentInfo(511, 10503, "ls-10503", "Ů", 22, "������ѧ");
//		System.out.println(((IStudentService)bean).insertStudentInfo(stu));
		
		IStudentService svc = ac.getBean("service", IStudentService.class);
		System.out.println(svc.insertStudentInfo(stu));
//		StudentServiceImp svc2 = ac.getBean("service", StudentServiceImp.class);
//		System.out.println(svc2.insertStudentInfo(stu));
	}
}