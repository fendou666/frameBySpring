package com.study.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.study.mvc.model.javabean.PageSpliteInfo;
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
		String sql = "SELECT id, name, age FROM firstTB ORDER BY id";
		int pageStartIndex = (pageInfo.getCurrentPageIndex()-1)*pageInfo.getPageMaxRows();
		sql+=" limit " + pageStartIndex + ", " + pageInfo.getPageMaxRows();
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
							rs.getString("name"),
							Integer.parseInt(rs.getString("age"))
							));
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
		objList.add(stu.getName());
		objList.add(stu.getAge());
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
		String sql = "UPDATE studentInfoA SET " 
				+ " name=?, age=? WHERE id=?";
		ArrayList objList = new ArrayList();
		objList.add(stu.getName());
		objList.add(stu.getAge());
		objList.add(stu.getId());
		System.out.println("更新sql语句是" + sql);
		int changeCount = dbutil.updateSql(sql, objList);
		if(changeCount==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public int getMaxPageIndex() {
		int cnt = 0;
		String sql = "SELECT count(id) as cnt FROM firstTB ORDER BY id";
		ResultSet rs = dbutil.queryData(sql, null);
		if(rs!=null){
			try {
				if(rs.next()){
					cnt = Integer.parseInt(rs.getString("cnt"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
}
