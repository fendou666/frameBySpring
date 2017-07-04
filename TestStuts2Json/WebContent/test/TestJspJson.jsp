<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#res").click(function(){
			console.log("进入click");
			$.post(
				"TestResultAndJsonAction",
				{
					returnSign:"input"
					/* returnSign:"input"
					returnSign:"input"
					returnSign:"input" */
				},
				function(data){
					console.log(data);
					$("#res").text("测试Jquery成功");
				}
			)
		})
	})
</script>
<body>
	<p id="res">pppppppp</p>
</body>
</html>