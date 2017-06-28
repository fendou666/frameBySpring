<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Myjs/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnSearch").click(function(){
			getpageInfo('first');
		});
	})
	function getpageInfo(forward){
			$.post(
				"reqPagInfoServlet?action="+forward,
				{
					id:$("#id").val(),
				 name:$("#name").val()
				 },
				 function(data){
					 var htmlStr="";
					 var students=eval(data);
					 alert('students:'+students);
					 $.each(students,function(i,stu){
						 htmlStr+="id:"+stu.id+" name:"+stu.name+"<br>";
					 });
					 htmlStr+="<input type=\"button\" value=\"首页\" onclick=\"getpageInfo('first')\">"
					 htmlStr+="<input type=\"button\" value=\"前页\" onclick=\"getpageInfo('pre')\">"
					 htmlStr+="<input type=\"button\" value=\"次页\" onclick=\"getpageInfo('nxt')\">"
					 htmlStr+="<input type=\"button\" value=\"尾页\" onclick=\"getpageInfo('end')\">"
					 $("#rec").html(htmlStr);
				 }
			);
	}
</script>
</head>
<body>
	<form action="" >
		ID：<input type="text" id="id" name="id"><br>
		NAME：<input type="text" id="name" name="name"><br>
		<input type="button" id="btnSearch" value="检索" onclick="" >
	</form>
	<div id="rec"></div>
</body>
</html>