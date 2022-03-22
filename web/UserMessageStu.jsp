<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户个人信息</title>
</head>
<body>

<table>
<tr ><td colspan="2" align="right">
<jsp:include page="Top.jsp"></jsp:include>
</td></tr>
<tr valign="top">
<td width="20%">
<%@include file="LeftStu.jsp" %>
</td>
<td align="center">
<jsp:useBean id="stu1" class="Entity.User" scope="session"></jsp:useBean>
<br>姓名:<jsp:getProperty property="username" name="stu1"/><br>
<br>性别:<jsp:getProperty property="sex" name="stu1"/><br>
<br>专业:<jsp:getProperty property="major" name="stu1"/><br>
<br>学历:<jsp:getProperty property="degree" name="stu1"/><br>
<br>电话:<jsp:getProperty property="phone" name="stu1"/><br>
<br>邮箱:<jsp:getProperty property="email" name="stu1"/><br>
<br>住址:<jsp:getProperty property="address" name="stu1"/><br>
</table>

</body>
</html>