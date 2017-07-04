package com.page.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import oracle.jdbc.OracleTypes;
import com.page.bean.User;


public class QueryDaoImp implements IQueryDao {

	private JdbcTemplate jdbct;
	
	public JdbcTemplate getJdbct() {
		return jdbct;
	}

	public void setJdbct(JdbcTemplate jdbct) {
		this.jdbct = jdbct;
	}

	@Override
	public List<User> queryOracle(final String name, final PageControllor pageControl) {
	 
		//调用Oracle函数
		return jdbct.execute( new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection conn)
					throws SQLException {
				
				String sql="{?=call paging(?,?,?,?)}";
				CallableStatement call=conn.prepareCall(sql);
				call=conn.prepareCall(sql);
			    call.registerOutParameter(1, OracleTypes.CURSOR);
				call.registerOutParameter(5, OracleTypes.NUMBER);
				call.setInt(2, pageControl.getMax_cap());
				call.setInt(3, pageControl.getPageNo());
				call.setString(4, name);
				call.execute();
				return call;
			}
		}, new CallableStatementCallback<List<User>>() {
			@Override
			public List<User> doInCallableStatement(CallableStatement call)
					throws SQLException, DataAccessException {
			
	            //设置最大记录条数
				pageControl.setCount(call.getInt(5));
				 //更新最大页码
				pageControl.updateMax_page();
				//获取查询结果
				ResultSet rs =(ResultSet)call.getObject(1);
				List<User> list =new ArrayList<User>();
				while(rs.next()){
					User user = new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
					list.add(user);
				}
				return list;
			}
		});
	}

	
@Override
	public List<User> queryMySQL(String name,final PageControllor pageControl) {
		//创建User类型集合
		List<User> list=new ArrayList<User>(); 
		String sql="select * from userform where name like '%'||?||'%' limit ?,? ";
		String sql1="select count(name) from  userform";
	    list = jdbct.query(sql, new Object[]{
	    		name,
	    		(pageControl.getPageNo()-1)*pageControl.getMax_cap(),
	    		pageControl.getMax_cap(),
	    		
	    },new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				return user;
			}
		});
	    
	     jdbct.query(sql1, new ResultSetExtractor<String>(){
			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
                if(rs.next()){
                	//设置最大记录条数
        			pageControl.setCount(rs.getInt(1));
        			 //更新最大页码
        			pageControl.updateMax_page();
                }
				return null;
			}
	    });
		return list;
	}
	
	
	

}
