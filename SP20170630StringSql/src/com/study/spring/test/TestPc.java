package com.study.spring.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.Emp;

public class TestPc {
	private JdbcTemplate jt;
	
	public TestPc(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
	}
	
/*	public void funcGetFromOracle(){
		String sql = "{? = call testjt(?,?,?)}";
		// ע�����в�������, ����ע���out key Ҳ�ǻ�ȡ�����key
		// SqlOutParameter��SqlInOutParameter��SqlReturnResultSet
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlParameter(Types.INTEGER));
		// out���ò���Ҫע��
		params.add(new SqlOutParameter("outInt", Types.INTEGER));
		params.add(new SqlInOutParameter("inoutStr", Types.VARCHAR));
		//params.add(new SqlInOutParameter("inOutName", Types.VARCHAR));  
		// ����ע�᷵��ֵ����
		params.add(new SqlReturnResultSet("result",  
				       new ResultSetExtractor<Emp>() {  
				           @Override  
				           public Emp extractData(ResultSet rs) throws SQLException,  
				               DataAccessException {  
				               while(rs.next()) {  
				                  // return new Emp(rs.getInt(1), rs.getString(2));  
				               }  
				              return null;  
				           }
		           		})
				);
		Map<String, Object> outValues = jt.call(  
			       new CallableStatementCreator() {  
			            @Override  
			            public CallableStatement createCallableStatement(Connection conn) throws SQLException {  
			              CallableStatement cstmt = conn.prepareCall(sql);
			              // ���ﴫ��
			              cstmt.setInt(1, 10); 
			              cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			              cstmt.setString(3, "�ҵ�inout����"); 
			              cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			              return cstmt;  
			    }}, params);  
		//System.out.println(outValues.get("outInt"));
		//System.out.println(outValues.get("inoutStr"));
		//System.out.println(outValues.get("result"));
		//Assert.assertEquals(4, );  
	}*/
	
//	public void funcGetFromOracle(){
//		String sql = "{? = call testJT1(?)}";
//		// ע�����в�������, ����ע���out key Ҳ�ǻ�ȡ�����key
//		// SqlOutParameter��SqlInOutParameter��SqlReturnResultSet
//		List<SqlParameter> params = new ArrayList<SqlParameter>();
//		// out���ò���Ҫע��
//		// ����ע�᷵��ֵ���ͣ� �Է���ֵ�����в�ͬ�Ĵ�����ʽ�� ����һ������� ���ض�����
//		// ����sql ִ���ַ�����ÿ�����и�ֵ����
//		params.add( new SqlReturnResultSet("result",  new RowMapper<Emp>(){
//							@Override
//							public Emp mapRow(ResultSet rs, int rowNum)
//									throws SQLException {
//								System.out.println("111111");
//								Emp tmp = null;
//								System.out.println("rs" + rs);
//								tmp  = new Emp(
//											Integer.parseInt(rs.getString("empno")),
//											rs.getString("ename")
//											);
//								System.out.println("tmp " + tmp);
//								return tmp;
//							}
//						})
//		);
//		params.add(new SqlParameter(OracleTypes.INTEGER));
//		
//		Map<String, Object> outValues = jt.call(  
//			       new CallableStatementCreator() {  
//			            @Override  
//			            public CallableStatement createCallableStatement(Connection conn) throws SQLException {  
//			              CallableStatement cstmt = conn.prepareCall(sql);
//			              System.out.println("cstmt " + cstmt);
//			              // ���ﴫ��
//			              cstmt.registerOutParameter(1, OracleTypes.CURSOR);
//			              cstmt.setInt(2, 10); 
//			              return cstmt;  
//			    }}, params);  
//		//System.out.println(outValues.get("outInt"));
//		//System.out.println(outValues.get("inoutStr"));
//		System.out.println(outValues.get("result"));
//		//System.out.println(outValues);
//		//Assert.assertEquals(4, );  
//	}
	public void myCursorTest(){
		String sql = "{? = call testJT(?,?,?)}";
		List<Emp> empList = jt.execute(new CallableStatementCreator() {
			// ����������𴴽� callAble, �����Ự������ֵ����
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException {
				CallableStatement pc = conn.prepareCall(sql);
				pc.registerOutParameter(1, OracleTypes.CURSOR);
				pc.setObject(2, 10);
				pc.registerOutParameter(3, OracleTypes.VARCHAR);
				pc.setObject(4, "���Ǵ����in out ����");
				pc.registerOutParameter(4, OracleTypes.VARCHAR);
				return pc;
			}
		}, new CallableStatementCallback<List<Emp>>() {
			//������Ǹ���������ֵ ��������������Ĳ���
			// �����������ִ�� �������ߴ洢���̣�Ȼ���ȡ��ֵ 
			@Override
			public List<Emp> doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				cs.execute();
				ResultSet rs = (ResultSet)cs.getObject(1);
				System.out.println("sql in out �������ص�outֵ" + cs.getObject(4));
				ArrayList<Emp> empList = null;
				if(rs!=null){
					while(rs.next()){
						if(rs.isFirst()){
							empList = new ArrayList<Emp>();
						}
						empList.add(
								new Emp(Integer.parseInt(rs.getString("empno")),rs.getString("ename"))
						);
					}
				}
				return empList;
			}
		
		});
		for (Emp e : empList){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new TestPc().myCursorTest();
	}
}