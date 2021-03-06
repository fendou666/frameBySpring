package com.study.spring.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.study.mvc.model.dao.StudentDAOImp;
import com.study.mvc.model.javabean.Emp;
import com.study.mvc.model.javabean.StudentInfo;

public class TestPc {
	private JdbcTemplate jt;
	private SimpleJdbcTemplate sjt;
	
	public TestPc(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/study/spring/config/BackSpringAC.xml");
		jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
	}
	
/*	public void funcGetFromOracle(){
		String sql = "{? = call testjt(?,?,?)}";
		// 注册所有参数类型, 这里注册的out key 也是获取结果的key
		// SqlOutParameter、SqlInOutParameter、SqlReturnResultSet
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlParameter(Types.INTEGER));
		// out采用不需要注册
		params.add(new SqlOutParameter("outInt", Types.INTEGER));
		params.add(new SqlInOutParameter("inoutStr", Types.VARCHAR));
		//params.add(new SqlInOutParameter("inOutName", Types.VARCHAR));  
		// 这里注册返回值类型
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
			              // 这里传参
			              cstmt.setInt(1, 10); 
			              cstmt.registerOutParameter(2, OracleTypes.INTEGER);
			              cstmt.setString(3, "我的inout传参"); 
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
//		// 注册所有参数类型, 这里注册的out key 也是获取结果的key
//		// SqlOutParameter、SqlInOutParameter、SqlReturnResultSet
//		List<SqlParameter> params = new ArrayList<SqlParameter>();
//		// out采用不需要注册
//		// 这里注册返回值类型， 对返回值可以有不同的处理方式， 返回一个结果， 返回多个结果
//		// 按照sql 执行字符串对每个进行赋值类型
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
//			              // 这里传参
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
			// 这个方法负责创建 callAble, 创建会话，并赋值参数
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException {
				CallableStatement pc = conn.prepareCall(sql);
				pc.registerOutParameter(1, OracleTypes.CURSOR);
				pc.setObject(2, 10);
				pc.registerOutParameter(3, OracleTypes.VARCHAR);
				pc.setObject(4, "我是传入的in out 参数");
				pc.registerOutParameter(4, OracleTypes.VARCHAR);
				return pc;
			}
		}, new CallableStatementCallback<List<Emp>>() {
			//上面的那个方法返回值 是下面这个函数的参数
			// 这个方法负责执行 函数或者存储过程，然后获取其值 
			@Override
			public List<Emp> doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				cs.execute();
				ResultSet rs = (ResultSet)cs.getObject(1);
				System.out.println("sql in out 参数返回的out值" + cs.getObject(4));
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
	
	public void myCursorTest2(){
		String sql = "{? = call testJT(?,?,?)}";
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlReturnResultSet("result",  new RowMapper<Emp>() {
				@Override
				public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
					System.out.println("111111");
					Emp tmp = null;
//					System.out.println("rs" + rs.getInt(1));
//					tmp  = new Emp(
//								Integer.parseInt(rs.getString("empno")),
//								rs.getString("ename"));
//					System.out.println("tmp " + tmp);
					return tmp;
				}
			})
		);
		params.add(new SqlParameter(Types.INTEGER));
		// out采用不需要注册
		params.add(new SqlOutParameter("outInt", Types.INTEGER));
		params.add(new SqlInOutParameter("inoutStr", Types.VARCHAR));
		// 这里注册返回值类型
		
		Map<String, Object> outValues = jt.call(  
			       new CallableStatementCreator() {  
			            @Override  
			            public CallableStatement createCallableStatement(Connection conn) throws SQLException {  
			              CallableStatement cstmt = conn.prepareCall(sql);
			              // 这里传参
			              cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			              cstmt.setObject(2, 10);
			              cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			              cstmt.setObject(4, "我是传入的in out 参数");
			              cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			              return cstmt;  
			    }}, params);  
		//System.out.println(outValues.get("outInt"));
		//System.out.println(outValues.get("inoutStr"));
		//System.out.println(outValues.get("result"));
		//Assert.assertEquals(4, );  
	}
	

	
	public void myCursorTest3(){
		String sql = "{call testJTPro(?,?,?)}";
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlParameter(Types.INTEGER));
		// out采用不需要注册
		System.out.println("Types.INTEGER:" +Types.INTEGER);
		System.out.println("OracleTypes.NUMBER:" +OracleTypes.NUMBER);
		params.add(new SqlOutParameter("outInt", Types.INTEGER));
		// 这里注册返回值类型
		params.add(new SqlInOutParameter("inoutStr", Types.VARCHAR));
		Map<String, Object> outValues = jt.call(  
			       new CallableStatementCreator() {  
			            @Override  
			            public CallableStatement createCallableStatement(Connection conn) throws SQLException {  
			              CallableStatement cstmt = conn.prepareCall(sql);
			              // 这里传参
			              cstmt.setObject(1, 10);
			              cstmt.registerOutParameter(2, OracleTypes.NUMBER);
			              cstmt.setObject(3, "我是传入的in out 参数");
			              cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			              return cstmt;  
			    }}, params);  
		System.out.println(outValues.get("outInt"));
		System.out.println(outValues.get("inoutStr"));
		//System.out.println(outValues.get("result"));
		//Assert.assertEquals(4, );  
	}
	
	public void myCursorTest4(){
		String sql = "{?=call testJT(?,?,?)}";
		List<SqlParameter> params = new ArrayList<SqlParameter>();
		params.add(new SqlReturnResultSet("result", new ResultSetExtractor<StudentInfo>(){

			@Override
			public StudentInfo extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				StudentInfo tmp = null;
				if(rs.next()){
					System.out.println(rs.getInt(1));
				}
				return tmp;
			}
			
		}));
		params.add(new SqlParameter(Types.INTEGER));
		// out采用不需要注册
		params.add(new SqlOutParameter("outInt", Types.INTEGER));
		// 这里注册返回值类型
		params.add(new SqlInOutParameter("inoutStr", Types.VARCHAR));
		
		Map<String, Object> outValues = jt.call(  
			       new CallableStatementCreator() {  
			            @Override  
			            public CallableStatement createCallableStatement(Connection conn) throws SQLException {  
			              CallableStatement cstmt = conn.prepareCall(sql);
			              // 这里传参
			              cstmt.registerOutParameter(1, OracleTypes.NUMBER);
			              cstmt.setObject(2, 10);
			              cstmt.registerOutParameter(3, OracleTypes.NUMBER);
			              cstmt.setObject(4, "我是传入的in out 参数");
			              cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			              return cstmt;  
			    }}, params);  
		System.out.println(outValues.get("outInt"));
		System.out.println(outValues.get("inoutStr"));
		//System.out.println(outValues.get("result"));
		//Assert.assertEquals(4, );  
	}
	
	public static void main(String[] args) {
		//new TestPc().myCursorTest();
		//new TestPc().myCursorTest2();
		new TestPc().myCursorTest3();
//		new TestPc().myCursorTest4();
	}
}
