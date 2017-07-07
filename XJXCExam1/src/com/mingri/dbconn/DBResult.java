package com.mingri.dbconn;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;
/*************************************

版权所有: 	吉林省明日科技有限公司

完成日期：	2010-09-15

项目出处：	编程词典

服务社区：	www.mingribook.com

学习社区：	www.mrbccd.com

*************************************/

public class DBResult {
	public static Connection conn = null;
	static{
		try {
			Context ctx = new InitialContext();
			ctx = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mingri"); // 获取连接池对象
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用于获得执行SQL语句的ResultSet对象
	 */
	public ResultSet getResult(String sql) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 用于执行SQL语句没有返回值
	 */
	public void doExecute(String sql) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (Exception e) {
		}
	}

	/**
	 * 用于获得执行SQL语句的PreparedStatement(预处理)对象
	 */
	public PreparedStatement getPreparedStatement(String sql) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			return pstmt;
		} catch (Exception e) {
		}
		return null;
	}

}
