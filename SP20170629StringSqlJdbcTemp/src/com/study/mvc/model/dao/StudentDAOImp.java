package com.study.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.study.mvc.model.javabean.PageSpliteInfo;
import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.tools.DBUtil;

public class StudentDAOImp implements IStudentDAO {
	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public HashMap getStudentById(int id) {
		HashMap<String, StudentInfo> stuMp = null;
		StudentInfo stu = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA  WHERE id=? ORDER BY id";
		stu = jt.query(sql, new Object[]{id}, new ResultSetExtractor<StudentInfo>(){
			@Override
			public StudentInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				StudentInfo tmp = null;
				if(rs.next()){
					tmp = new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom"));
				}
				return tmp;
			}
			
		});
		//stuMp.put("stuList", stu);
		System.out.println("stuList " + stu);
		return stuMp;
	}
	
	@Override
	public HashMap getStudentByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentBySex(String sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentByAge(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap getStudentBySchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap getStudentByCondition(int num, String name,
			String sex, int start, int end, 
			String schoolName, PageSpliteInfo pageInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public HashMap getStudentByCondition(int id, String name,
			PageSpliteInfo pageInfo) {
		
		HashMap<String, List<StudentInfo>> stuMp = null;
		List<StudentInfo> stuList = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA WHERE id=0 ORDER BY id ";
		//jt.query(sql, new Object[]{}, new RowMapper<StudentInfo>()
		stuList = jt.query(sql, new RowMapper<StudentInfo>(){

			@Override
			public StudentInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				System.out.println("111111");
				StudentInfo tmp = null;
				System.out.println("rs" + rs);
				tmp  = new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom"));
				System.out.println("tmp " + tmp);
				return tmp;
			}
		});
		//stuMp.put("stuList", stuList);
		System.out.println("stuList " + stuList);
		return stuMp;
	}

	@Override
	public boolean insertStudentInfo(StudentInfo stu) {
		String sql = "INSERT INTO studentInfoA  VALUES(?,?,?,?,?,?)";
		int changeCount = jt.update(sql, new Object[]{stu.getId(), stu.getNum(), stu.getName(),
						stu.getSex(),stu.getAge(), stu.getSchool()
					});
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean deleteStudentInfo(int num) {
		String sql = "DELETE FROM studentInfoA  WHERE id=?";
		int changeCount = jt.update(sql, new Object[]{num});
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean saveStudentInfo(StudentInfo stu) {
		String sql = "UPDATE studentInfoA SET " 
				+ " name=?, age=? WHERE id=?";
		int changeCount = jt.update(sql, new Object[]{stu.getName(), 
							stu.getAge(), stu.getId()});
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		StudentDAOImp DAOBean = ac.getBean("DAO", StudentDAOImp.class);
		StudentInfo stu = new StudentInfo(504, 10504, "小军", "男", 24, "西安建筑科技大学");
		//DAOBean.getStudentByCondition(22, "ls", new PageSpliteInfo()); 
		//DAOBean.getStudentById(1);
		//DAOBean.insertStudentInfo(stu);
		stu.setName("小刚");
		//DAOBean.saveStudentInfo(stu);
		DAOBean.deleteStudentInfo(504);
	}
	
}
