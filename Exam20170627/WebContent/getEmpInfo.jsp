<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	function getEmpInfo(pageMode){
		$.post(
			"GetEmpInfo",
			{
				pageMode:pageMode,
			},
			function(data){
				console.log(data);
				var infoList = eval(data);
				var htmlStr = "";
				if(infoList!=null && infoList.length>0){
					$.each(infoList, function(i){
						if(i==0){
							htmlStr+="<table border=\"1\"><tr><td>序号</td><td>工号</td><td>姓名</td><td>工资</td></tr>"
						}
						htmlStr+='<tr><td>'+ i + '</td>';
						htmlStr+='<td>'+ infoList[i].empNo + '</td>';
						htmlStr+='<td>'+ infoList[i].empName + '</td>';
						htmlStr+='<td>'+ infoList[i].empSal + '</td>';
						htmlStr+='</tr>';
					})
					htmlStr+='</table>';
				}else{
					$("#showInfo").html("没有数据");
				}
				console.log(htmlStr);
				$("#showInfo").html(htmlStr);
			},
			"JSON"
		)
	}
	
	$(function(){
		
		$("#bt").click(function(){
			getEmpInfo("first");
		})
		
	})
</script>
<body>
	<button id="bt">查询</button>
	<div id="showInfo"> 
		<table>
			<tr>
				<td>序号</td>
				<td>工号</td>
				<td>姓名</td>
				<td>工资</td>
			</tr>
		</table>
	</div>
	
</body>
</html>