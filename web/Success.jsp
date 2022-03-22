<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
<%@page import="java.util.Date,java.text.SimpleDateFormat" %>      
    
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>>">
<title>登陆成功首页</title>
</head>
<body>
<jsp:useBean id="user" class="Entity.User" scope="session"></jsp:useBean>

<%
if(user.getUsername()==null){
%>
<jsp:forward page="LoginView.jsp"></jsp:forward>
<%} %>
欢迎<jsp:getProperty property="username" name="user"/>访问系统!
<br>登陆时间:
<%SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>
<%=sdf.format(new Date()) %>
<br><a href="HomePage.jsp">进入首页</a>
</body>
</html>