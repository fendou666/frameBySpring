<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:actionerror/>
	<s:form action="reg" method="post">
		<s:textfield id="id" name="id" label="id"></s:textfield>
		<s:textfield id="num" name="num" label="学号"></s:textfield>
		<s:textfield id="name" name="name" label="用户名"></s:textfield>
		<s:radio list="{'男', '女'}" id="sex" name="sex" label="性别" ></s:radio>
		<s:textfield id="age" name="age" label="年龄"></s:textfield>
		<s:textfield id="school" name="school" label="毕业学校"></s:textfield>
		<s:submit method="regMethod" />
	</s:form>
	<p>删除页面</p>
	<s:form action="reg" method="post">
		<s:textfield id="id" name="id" label="id"></s:textfield>
		<s:textfield id="num" name="num" label="学号"></s:textfield>
		<s:textfield id="name" name="name" label="用户名"></s:textfield>
		<s:radio list="{'男', '女'}" id="sex" name="sex" label="性别" ></s:radio>
		<s:textfield id="age" name="age" label="年龄"></s:textfield>
		<s:textfield id="school" name="school" label="毕业学校"></s:textfield>
		<s:submit method="regMethod" />
	</s:form>
	
</body>
</html>