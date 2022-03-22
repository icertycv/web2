<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Entity.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改课程</title>
</head>
<body>
<%
Object error = request.getAttribute("error");
if (error != null) {
	out.println("<font color= 'red '>" + error + "</font><br>");
}
String id = request.getParameter("id");
request.getSession().setAttribute("ID",id);//Session
String name=null;
String time=null;
String score=null;
Course c=new Course();
ArrayList<Course> list=c.InCourse();
for(int i=0;i<list.size();i++){
	if(list.get(i).getId().equals(id)){
		name=list.get(i).getName();
		time=list.get(i).getTime();
		score=list.get(i).getScore();
	}
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

<form action='AlterCourse' method= 'post'>

<br>课程号:<%=id%><br>
<br>课程名:<input type='text' name='name' value='<%=name%>'/><br>
<br>课程学期:<input type='text' name='time' value='<%=time%>'/><br>
<br>课程学分:<input type='text' name='score' value='<%=score%>'/><br>
<br><input type='submit' value='保存'></form>
</form>
</table>

</body>
</html>