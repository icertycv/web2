<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.User"%>

<meta charset="UTF-8">

<%
Object o=session.getAttribute("user");
if(o!=null){
	User user=(User) o;
%>
欢迎您:<%=user.getUsername() %>
<%
}else{	
%>
<a href="LoginView.jsp">请登录</a>
<%} %>
