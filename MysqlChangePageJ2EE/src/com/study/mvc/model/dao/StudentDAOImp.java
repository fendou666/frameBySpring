package com.study.mvc.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.study.mvc.model.bean.GenericPageInfo;
import com.study.mvc.model.bean.StudentInfo;
import com.study.mvc.tools.DButil;

public class StudentDAOImp implements IStudentDAO {
	private DButil dbutil;
	
    public StudentDAOImp(){
    	
    }
    
	public DButil getDbutil() {
		return dbutil;
	}

	public void setDbutil(DButil dbutil) {
		this.dbutil = dbutil;
	}

	@Override
	public int insert(StudentInfo stu) {
		String sql="insert into userinfo values(";
		sql+=stu.getId()+",'"+stu.getName()+"')";
		return dbutil.executeUpdate(sql);
	}

	@Override
	public List<StudentInfo> findStudents(Map<String, String> conditionMap,GenericPageInfo gPageInfo) {
		List<StudentInfo> list=null;
		String sql="Select id,name from userinfo ";
		if(conditionMap!=null){
			String id=conditionMap.get("id");
			String name=conditionMap.get("name");
			if(id==null && name==null){
			}
			else{
				if(id!=null){
					sql+=" where id="+id;
					if(name!=null){
						sql+=" and name like '%"+name+"%'";
					}
				}
				else{
					if(name!=null){
						sql+=" where name like '%"+name+"%'";
					}
				}
			}
			
		}
		
		//客户的页面需求（首页，尾页，前页，次页，指定页，循环页码链接）转换成页码的需求
		int rowIndex=(gPageInfo.getCurrentPageNo()-1)*gPageInfo.getPageSize();
		sql+=" limit "+rowIndex+","+gPageInfo.getPageSize();
		
		ResultSet rs = dbutil.find(sql);
		if(rs!=null){
			list=new ArrayList<StudentInfo>();
			try {
				while(rs.next()){
					list.add(new StudentInfo(rs.getInt(1), rs.getString(2)));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int getMaxPageNumbers(Map<String, String> conditionMap,GenericPageInfo gPageInfo) {
		int recCount=-1;
		String sql="Select count(id) as cnt from userinfo ";
		if(conditionMap!=null){
			String id=conditionMap.get("id");
			String name=conditionMap.get("name");
			if(id==null && name==null){
			}
			else{
				if(id!=null){
					sql+=" where id="+id;
					if(name!=null){
						sql+=" and name like '%"+name+"%'";
					}
				}
				else{
					if(name!=null){
						sql+=" where name like '%"+name+"%'";
					}
				}
			}
			
		}
		System.out.println("sql:"+sql);
		ResultSet rs = dbutil.find(sql);
		try {
			if(rs.next()){
				recCount=rs.getInt("cnt");
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int pageNumbers=0;
		if(recCount!=-1){
			if(recCount % gPageInfo.getPageSize()==0){
				pageNumbers=(int)(recCount/gPageInfo.getPageSize());
			}
			else{
				pageNumbers=(int)(recCount/gPageInfo.getPageSize())+1;
			}	
		}
		else{
			pageNumbers=0;
		}
		gPageInfo.setMaxPageNumbers(pageNumbers);
		
		return pageNumbers;
	}

    
}
