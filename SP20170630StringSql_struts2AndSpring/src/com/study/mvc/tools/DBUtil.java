package com.study.mvc.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DBUtil {
	private String driver;
	private String url;
	private String user;
	private String pwd;
	private Connection conn;
	private String errInfo;
	//=========DButil只允许初始化的时候 对其里面的成员变量进行赋值
	public String getErrInfo(){
		return errInfo;
	}
	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
	}
	
	private DBUtil(String driver, String url, String user, String pwd){
		this.driver 	= driver;
		this.url 		= url + "?user="+user+"&password=" + pwd;
		System.out.println("调用了我");
		if(driver==null || url==null){
			errInfo = "加载数据库配置文件失败";
			System.out.println(errInfo);
			return;
		}else{
			getConnection();
		}
	}
	private Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);;
		} catch (ClassNotFoundException e) {
			errInfo = "没有找到JDBC驱动";
			System.out.println(errInfo);
			e.printStackTrace();
		} catch (SQLException e) {
			errInfo = "创建数据库连接失败";
			System.out.println(errInfo);
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//DBUtil.getJDBC().getConn();
	public Connection getConn(){
		return conn;
	}
	public  ResultSet queryData(String sql, ArrayList<Object> objList){
		ResultSet rs = null;
		if(errInfo!=null){
			return rs;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(objList!=null){
				for(int i=0; i<objList.size();i++){
					ps.setObject(i+1, objList.get(i));
					System.out.println("i对象为" + objList.get(i));
				}
			}
			System.out.println("sql执行语句为:" + sql);
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			errInfo = "查询sql执行失败";
			System.out.println(errInfo);
			e1.printStackTrace();
		}
		return rs;
	}
	
	
	public  int updateSql(String sql,  ArrayList<Object> objList){
		int ret = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(objList!=null){
				for(int i=0; i<objList.size();i++){
					ps.setObject(i+1, objList.get(i));
					System.out.println("i对象为" + objList.get(i));
				}
			}
			ret = ps.executeUpdate();
			System.out.println("增删改执行的sql 是" + sql);
		} catch (SQLException e) {
			errInfo = "增删该sql执行失败 sql 为:" + sql;
			System.out.println(errInfo);
			e.printStackTrace();
		}
		return ret;
	}
	
}
