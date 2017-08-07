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
	//=========DButilֻ������ʼ����ʱ�� ��������ĳ�Ա�������и�ֵ
	public String getErrInfo(){
		return errInfo;
	}
	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
	}
	
	private DBUtil(String driver, String url, String user, String pwd){
		this.driver 	= driver;
		this.url 		= url + "?user="+user+"&password=" + pwd;
		System.out.println("��������");
		if(driver==null || url==null){
			errInfo = "�������ݿ������ļ�ʧ��";
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
			errInfo = "û���ҵ�JDBC����";
			System.out.println(errInfo);
			e.printStackTrace();
		} catch (SQLException e) {
			errInfo = "�������ݿ�����ʧ��";
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
					System.out.println("i����Ϊ" + objList.get(i));
				}
			}
			System.out.println("sqlִ�����Ϊ:" + sql);
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			errInfo = "��ѯsqlִ��ʧ��";
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
					System.out.println("i����Ϊ" + objList.get(i));
				}
			}
			ret = ps.executeUpdate();
			System.out.println("��ɾ��ִ�е�sql ��" + sql);
		} catch (SQLException e) {
			errInfo = "��ɾ��sqlִ��ʧ�� sql Ϊ:" + sql;
			System.out.println(errInfo);
			e.printStackTrace();
		}
		return ret;
	}
	
}