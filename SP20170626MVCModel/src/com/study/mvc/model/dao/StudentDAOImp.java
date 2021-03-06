package com.study.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.javabean.StudentInfo;
import com.study.mvc.tools.DBUtil;

public class StudentDAOImp implements IStudentDAO {
	private DBUtil dbutil;
	
	public DBUtil getDbutil() {
		return dbutil;
	}

	public void setDbutil(DBUtil dbutil) {
		this.dbutil = dbutil;
	}

	@Override
	public HashMap getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
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
			String sex, int start, int end, String schoolName) {
//			String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA WHERE "
//					+ "id = " + num
//					+ " AND name = " + name
//					+ " AND name = " + name
//					+ " AND name = " + name
//					+ " AND name = " + name
//					;
		HashMap<String, List<StudentInfo>> stuMp = null;
		List<StudentInfo> stuList = null;
		String sql = "SELECT id, stuNum, name, sex, age, gradeFrom FROM studentInfoA ORDER BY id";
		ResultSet rs = dbutil.queryData(sql, null);
		if(rs!=null){
			try {
				
				while(rs.next()){
					// TODO为什么报错
					if(rs.isFirst()){
						System.out.println("rs first");
						stuMp = new HashMap<String, List<StudentInfo>>();
						stuList = new ArrayList<StudentInfo>();
					}
					System.out.println("id 为 "  + rs.getString("id"));
					stuList.add(new StudentInfo(
							Integer.parseInt(rs.getString("id")),
							Integer.parseInt(rs.getString("stuNum")),
							rs.getString("name"),
							rs.getString("sex"),
							Integer.parseInt(rs.getString("age")),
							rs.getString("gradeFrom")));
				}
				stuMp.put("stuList", stuList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stuMp;
	}

	@Override
	public boolean insertStudentInfo(StudentInfo stu) {
		String sql = "INSERT INTO studentInfoA  VALUES(?,?,?,?,?,?)";
		ArrayList objList = new ArrayList();
		objList.add(stu.getId());
		objList.add(stu.getNum());
		objList.add(stu.getName());
		objList.add(stu.getSex());
		objList.add(stu.getAge());
		objList.add(stu.getSchool());
		int changeCount = dbutil.updateSql(sql, objList);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean deleteStudentInfo(int num) {
		String sql = "DELETE FROM studentInfoA  WHERE id=?";
		ArrayList objList = new ArrayList();
		objList.add(num);
		System.out.println("删除sql为" +sql);
		int changeCount = dbutil.updateSql(sql, objList);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean saveStudentInfo(StudentInfo stu) {
		String sql = "UPDATE studentInfoA SET  stuNum=?" 
				+ ", name=?, sex=?, age=?, gradeFrom=? WHERE id=?";
		ArrayList objList = new ArrayList();
		objList.add(stu.getNum());
		objList.add(stu.getName());
		objList.add(stu.getSex());
		objList.add(stu.getAge());
		objList.add(stu.getSchool());
		objList.add(stu.getId());
		System.out.println("更新sql语句是" + sql);
		int changeCount = dbutil.updateSql(sql, objList);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	

}
