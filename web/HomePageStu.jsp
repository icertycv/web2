<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生首页</title>
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
<jsp:include page="Top.jsp"></jsp:include>
</td></tr>
<tr valign="top">
<td width="20%">
<%@include file="LeftStu.jsp" %>
</td>
</table>

</body>
</html>