package com.study.mvc.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DButil {
	private String driverName="";
	private String url="";
	private String user="";
	private String pwd="";
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	//连接数据   单例：针对数据库的交互比较频繁  平常类：按需分配
	public DButil(String driverName){
		try {
			this.driverName=driverName;
			System.out.println("0000 driverName:"+driverName);
			Class.forName(driverName);
			System.out.println("1111 driverName:"+driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//增删改查
	public int executeUpdate(String sql){
        int rec=-1;
        
		try {
			Statement st = getConnection().createStatement();
			rec=st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rec;
	}
	//查询
	public ResultSet find(String sql){
		ResultSet rec=null;
		try {
			Statement st = getConnection().createStatement();
			rec = st.executeQuery(sql);
			//st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rec;
	}
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DButil bean = ac.getBean("datasours",DButil.class);
		ResultSet find = bean.find("select id,name from userInfo");
			try {
				while(find.next()){
					System.out.println("id:"+find.getInt(1));
					System.out.println("name:"+find.getString(2));
				}
				//find.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println("DriverName:"+bean.getDriverName());
	}
}
