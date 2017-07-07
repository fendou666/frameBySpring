package com.mingri.info;

import com.mingri.dbconn.DBResult;
import java.sql.*;
/*************************************

版权所有: 	吉林省明日科技有限公司

完成日期：	2010-09-15

项目出处：	编程词典

服务社区：	www.mingribook.com

学习社区：	www.mrbccd.com

*************************************/

public class GysRegist
{
  private GysinfoBean gysinfo;
  DBResult rst=new DBResult();
  public void setGysinfo(GysinfoBean gysinfo)
  {
    this.gysinfo=gysinfo;
  }
  public void regist()throws Exception
  {
    String sql="insert into tb_supplier values(?,?,?,?,?,?,?,?,?,?)";
    try
    {
      PreparedStatement pstmt=rst.getPreparedStatement(sql);
      pstmt.setString(1,gysinfo.getGysname());
      pstmt.setString(2,gysinfo.getJc());
      pstmt.setString(3,gysinfo.getAddress());
      pstmt.setString(4,gysinfo.getPostcode());
      pstmt.setString(5,gysinfo.getTel());
      pstmt.setString(6,gysinfo.getFax());
      pstmt.setString(7,gysinfo.getLxr());
      pstmt.setString(8,gysinfo.getLxrtel());
      pstmt.setString(9,gysinfo.getKhyh());
      pstmt.setString(10,gysinfo.getEamil());
      pstmt.executeUpdate();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      throw e;
    }
  }
}
