<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完善用户信息</title>
</head>
<body>
<%
Object error = request.getAttribute("error");
if (error != null) {
	out.println(" <font color= 'red '>" + error + "</font><br>");
}
%>
<table>
<tr ><td colspan="2" align="right">
<jsp:include page="Topu.jsp"></jsp:include>
</td></tr>
<tr valign="top">
<td width="20%">
<%@include file="Left.jsp" %>
</td>
<td align="center">
<form action='CheckUserAdd' method= 'post'>
<jsp:useBean id="user" class="Entity.User" scope="session"></jsp:useBean>
姓名:<jsp:getProperty property="username" name="user"/><br>
<br>性别:<input type='radio' name='sex' checked='checked' value='女' />女
     <input type='radio' name='sex' value='男' />男<br>
<br>专业:<input type='text' name='major' /><br>
<br>学历:<input type='text' name='degree' /><br>
<br>电话:<input type='text' name='phone' /><br>
<br>邮箱:<input type='text' name='email' /><br>
<br>地址:<input type='text' name='address' /><br>
<br><input type='submit' value='保存'></form>
</form>
</table>
</body>
</html>