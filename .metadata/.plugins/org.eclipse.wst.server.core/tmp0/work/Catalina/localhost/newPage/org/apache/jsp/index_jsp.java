/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.0-RC1
 * Generated at: 2017-07-18 09:18:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<!-- 分页查询功能展示页面 -->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/index.css\"/>\r\n");
      out.write(" <!-- jquery配置文件 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("      /*  获取指定页页码*/\r\n");
      out.write("   function getPage(){\r\n");
      out.write("\t  return $(\"#page\").val();\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   /*  jquery局部刷新查询结果*/\r\n");
      out.write("   function query(action){\r\n");
      out.write("\t   $.get(\r\n");
      out.write("\t\t\t   /* 发送请求到指定页面 */\r\n");
      out.write("\t\t\t   \"getdata?action=\"+action,\r\n");
      out.write("\t\t\t   /* 传输参数 */   \r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t\t  name: $(\"#name\").val()\r\n");
      out.write("\t\t   },\r\n");
      out.write("\t\t   /* 接收查询结果*/  \r\n");
      out.write("\t\t   function(data) {\r\n");
      out.write("\t\t\t  var html=\"\";\r\n");
      out.write("\t\t\t  /* 将JSON对象转换为集合对象 */\r\n");
      out.write("\t\t\t  var users=eval(data);\r\n");
      out.write("\t\t\t  html+=\"<table border=\\\"1px\\\" id=\\\"userform\\\">\"\r\n");
      out.write("\t\t\t  html+=\"<tr><td>用户名</td><td>密码</td><td>状态</td><td>QQ</td><td style=\\\"width:180px\\\">注册时间</td></tr>\"\r\n");
      out.write("\t\t\t  /* 遍历查询结果 */\r\n");
      out.write("\t\t\t  $.each(users,function(i){\r\n");
      out.write("\t\t\t  html+=\"<tr><td>\"+users[i].name+\"</td>\"\r\n");
      out.write("\t\t\t  html+=\"<td>\"+users[i].pwd+\"</td>\"\r\n");
      out.write("\t\t\t  html+=\"<td>\"+users[i].status+\"</td>\"\r\n");
      out.write("\t\t\t  html+=\"<td>\"+users[i].QQ+\"</td>\"\r\n");
      out.write("\t\t      html+=\"<td style=\\\"width:180px\\\">\"+users[i].time+\"</td></tr>\"\r\n");
      out.write("\t\t\t  })\r\n");
      out.write("\t\t\t   /* 设置翻页按钮 */\r\n");
      out.write("\t\t\t  html+=\"<tr><td><a href=\\\"#\\\" onclick=\\\"query('pre')\\\">前一页</a></td>\"\r\n");
      out.write("\t\t\t  html+=\"<td><a href=\\\"#\\\" onclick=\\\"query('next')\\\">下一页</a></td>\"\r\n");
      out.write("\t\t\t  html+=\"<td><a href=\\\"#\\\" onclick=\\\"query('last')\\\">尾页</a></td>\"\r\n");
      out.write("\t\t\t  html+=\"<td><a href=\\\"#\\\" onclick=\\\"query('first')\\\">首页</a></td>\"\r\n");
      out.write("\t\t\t  html+=\"<td style=\\\"width:180px\\\"><a href=\\\"#\\\" onclick=\\\"query(getPage())\\\">指定页</a>\"\r\n");
      out.write("\t\t\t  html+=\"<input type=\\\"text\\\" id=\\\"page\\\"style=\\\"width:30px\\\"> </td></tr>\"\r\n");
      out.write("\t\t\t  html+=\"</table>\"\r\n");
      out.write("\t\t\t  /*局部刷新至指定页面  */\r\n");
      out.write("\t\t\t  $(\"#dd\").html(html); \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t    },\r\n");
      out.write("\t\t    /* 指定接收类型 */\r\n");
      out.write("\t\t    \"JSON\"\r\n");
      out.write("\t   )\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <input type=\"text\" id=\"name\"><button onclick=\"query('first')\">查询</button>\r\n");
      out.write("    <div id=\"dd\">\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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