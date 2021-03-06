package com.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import com.exam.bean.EMPInfo;
import com.exam.bean.PageInfo;
import com.exam.tools.jdbc.DBUtil;

/**
 * Servlet implementation class GetEmpInfo
 */
@WebServlet("/GetEmpInfo")
public class GetEmpInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpInfo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
//		PageInfo pif = new PageInfo();
//		pif.setPageMaxRows(5);
//		pif.setCurrentPage(1);
		
//		List<EMPInfo> empList = null;
//		EMPInfo tmp = null;
//		Connection conn = DBUtil.getJDBC().getConn();
//		String sql = "{?=call getEmpPageDate(?,?,?)}";
//		CallableStatement pc;
//		try {
//			pc = conn.prepareCall(sql);
//			pc.registerOutParameter(1, OracleTypes.CURSOR);
//			pc.setObject(2, 5);
//			pc.setObject(3, 1);
//			pc.registerOutParameter(4, OracleTypes.INTEGER);
//			pc.execute();
//			ResultSet rs = (ResultSet)pc.getObject(1);
//			while(rs.next()){
//				if(rs.isFirst()){
//					empList = new ArrayList<EMPInfo>();
//				}
//				System.out.println(rs.getObject("empno"));
//				System.out.println(rs.getObject("ename"));
//				System.out.println(rs.getObject("sal"));
//				tmp = new EMPInfo(rs.getObject("empno").toString(), 
//						(String)rs.getObject("ename")==null?"":(String)rs.getObject("ename"), (double)rs.getObject("sal"));
//				empList.add(tmp);
//			}
//			
//			System.out.println("最大记录条数" + (int)pc.getObject(4));
////			pif.setPageMaxRows((int)pc.getObject(4));
////			pif.setPageMaxIndexByAllRows();
//			//session.setAttribute("pif", pif);
//			
//			if(empList == null){
//				out.write("[]");
//			}else{
//				out.write("[");
//				for(int i=0; i<empList.size(); i++){
//					out.write("{");
//					out.write("\"empNo\": "+empList.get(i).getEmpNo() + 
//							",\"empName\":\"" + empList.get(i).getEmpName() +
//							"\",\"empSal\":"+ empList.get(i).getEmpSal() +"}");
//					if(i == empList.size() -1){
//						out.write("}");
//					}else{
//						out.write("},");
//					}
//				}
//				out.write("]");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		out.write("[{\"empNo\":101,\"empName\":\"小明\",\"empSal\":2200}]");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
