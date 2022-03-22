<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生登录页面</title>
</head>
<body>
<%
Object error = request.getAttribute("error");
if (error != null) {
	out.println("<font color= 'red '>" + error + "</font><br>");
}
%>
<form action='LoginServletStu' method= 'post'>
username:<input type='text' name='username' /><br/>
password:<input type='password' name='password' /><br/>
<input type='submit' value='登录'></form>
</body>
</html>