/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-07-07 00:50:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jcxx;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gysquest1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <title>供应商信息查询</title>\r\n");
      out.write("  <link href=\"../CSS/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html;charset=gb2312\">\r\n");
      out.write("  <style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style1 {color: #333333}\r\n");
      out.write("-->\r\n");
      out.write("  </style>\r\n");
      out.write("<body bgcolor=\"#FFFFFF\" text=\"#000000\" >\r\n");
      out.write("<script language='JavaScript'>\r\n");
      out.write("function listall()\r\n");
      out.write("{window.location.reload();\r\n");
      out.write("form1.ccif.value=\"ALL\";\r\n");
      out.write("\r\n");
      out.write("form1.submit();}\r\n");
      out.write("function  aa()\r\n");
      out.write("{\r\n");
      out.write("  window.location.reload();\r\n");
      out.write("  form1.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");

   session.removeAttribute("gysqu");

      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <td height=\"27\" colspan=\"6\" bgcolor=\"#EEEEEE\" class=\"tableBorder_gray\">\r\n");
      out.write("    &nbsp;<span  class=\"word_deepgrey\"> 当前位置：基础信息管理> </span>供应商信息查询 &gt;&gt;&gt;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("     <tr><td valign=\"top\" height=\"83\">\r\n");
      out.write("      <table width=\"98%\" height=\"50\" border=\"0\" cellpadding=\"-2\" cellspacing=\"-2\">\r\n");
      out.write("        <tr><td width=\"550\" height=\"43\" align=\"Top\">\r\n");
      out.write("          <form name=\"form1\" method=\"POST\" action=\"gysquest.jsp\" target=\"MainFrame\">\r\n");
      out.write("            <div align=\"center\">请选择查询条件:\r\n");
      out.write("              <select name=\"cif\">\r\n");
      out.write("                <option value=\"gysname\" selected>供应商全称</option>\r\n");
      out.write("                <option value=\"jc\">简称</option>\r\n");
      out.write("              </select>\r\n");
      out.write("              <select name=\"ccif\">\r\n");
      out.write("                <option value=\"=\" selected> 等于</option>\r\n");
      out.write("                <option value=\"LIKE\">LIKE</option>\r\n");
      out.write("                <option value=\"ALL\">ALL</option>\r\n");
      out.write("              </select>\r\n");
      out.write("              ");
request.setCharacterEncoding("gb2312");
      out.write("\r\n");
      out.write("              <input type=\"text\" name=\"qvalue\">\r\n");
      out.write("              <input name=\"submit1\" type=\"submit\" class=\"btn_grey\" value=\"查询\" onClick=\"aa()\">\r\n");
      out.write("              <input name=\"submit2\" type=\"submit\" class=\"btn_grey\" value=\"显示全部数据\" onClick=\"listall()\">\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </td></tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
