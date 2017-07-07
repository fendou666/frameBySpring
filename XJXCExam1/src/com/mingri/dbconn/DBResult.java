package com.mingri.dbconn;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;
/*************************************

��Ȩ����: 	����ʡ���տƼ����޹�˾

������ڣ�	2010-09-15

��Ŀ������	��̴ʵ�

����������	www.mingribook.com

ѧϰ������	www.mrbccd.com

*************************************/

public class DBResult {
	public static Connection conn = null;
	static{
		try {
			Context ctx = new InitialContext();
			ctx = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mingri"); // ��ȡ���ӳض���
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
	 * ���ڻ��ִ��SQL����ResultSet����
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
	 * ����ִ��SQL���û�з���ֵ
	 */
	public void doExecute(String sql) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (Exception e) {
		}
	}

	/**
	 * ���ڻ��ִ��SQL����PreparedStatement(Ԥ����)����
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
