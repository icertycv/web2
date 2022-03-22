<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
</head>
<body>
<%
Object error = request.getAttribute("error");
if (error != null) {
	out.println("<font color= 'red '>" + error + "</font><br>");
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

<form action='CheckCourseAdd' method= 'post'>

<br>课程号:<input type='text' name='id' /><br>
<br>课程名:<input type='text' name='name' /><br>
<br>课程学期:<input type='text' name='time' /><br>
<br>课程学分:<input type='text' name='score' /><br>
<br><input type='submit' value='保存'></form>
</form>
</table>

</body>
</html>