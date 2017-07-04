<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 分页查询功能展示页面 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
 <!-- jquery配置文件 -->
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

      /*  获取指定页页码*/
   function getPage(){
	  return $("#page").val();
   }

   /*  jquery局部刷新查询结果*/
   function query(action){
	   $.get(
			   /* 发送请求到指定页面 */
			   "query.action?action="+action,
			   /* 传输参数 */   
		   {
			  name: $("#name").val()
		   },
		   /* 接收查询结果*/  
		   function(data) {
			  var html="";
			  /* 将JSON对象转换为集合对象 */
			  var users=eval(data);
			  html+="<table border=\"1px\" id=\"userform\">"
			  html+="<tr><td>用户名</td><td>密码</td><td>状态</td><td>QQ</td><td style=\"width:180px\">注册时间</td></tr>"
			  /* 遍历查询结果 */
			  $.each(users,function(i){
			  html+="<tr><td>"+users[i].name+"</td>"
			  html+="<td>"+users[i].pwd+"</td>"
			  html+="<td>"+users[i].status+"</td>"
			  html+="<td>"+users[i].QQ+"</td>"
		      html+="<td style=\"width:180px\">"+users[i].time+"</td></tr>"
			  })
			   /* 设置翻页按钮 */
			  html+="<tr><td><a href=\"#\" onclick=\"query('pre')\">前一页</a></td>"
			  html+="<td><a href=\"#\" onclick=\"query('next')\">下一页</a></td>"
			  html+="<td><a href=\"#\" onclick=\"query('last')\">尾页</a></td>"
			  html+="<td><a href=\"#\" onclick=\"query('first')\">首页</a></td>"
			  html+="<td style=\"width:180px\"><a href=\"#\" onclick=\"query(getPage())\">指定页</a>"
			  html+="<input type=\"text\" id=\"page\"style=\"width:30px\"> </td></tr>"
			  html+="</table>"
			  /*局部刷新至指定页面  */
			  $("#dd").html(html); 
			 
		    },
		    /* 指定接收类型 */
		    "JSON"
	   )
   }
</script>

</head>
<body>
    <input type="text" id="name"><button onclick="query('first')">查询</button>
    <div id="dd">
    </div>
    
</body>
</html>