<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Entity.Course"%>
    <%@ page import="Entity.User"%>
    <%@ page import="Entity.SelectCourse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看全部课程</title>
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
<form action='' method='post'>
<table border='1'>

<tr><td colspan='6' align='center'>课程信息</td></tr>
<tr>

<td>课程编号</td>
<td>课程名</td>
<td>课程学期</td>
<td>课程学分</td>
<td>操作列表</td>
</tr>
<%
User user=(User)request.getSession().getAttribute("Stu");//Session
SelectCourse s=new SelectCourse();
ArrayList<SelectCourse> list=s.InSC();
if(list.size()==0){
	out.println("您尚未选课！");
}else{
for(int i=0;i<list.size();i++){
	if(list.get(i).getStuname().equals(user.getUsername())){
%>

<tr>
<td><%=list.get(i).getCourseid() %></td>
<td><%=list.get(i).getCoursename() %></td>
<td><%=list.get(i).getTime() %></td>
<td><%=list.get(i).getScore() %></td>
<td><a href='StuCourseDelete?id=<%=list.get(i).getCourseid()%>'>删除</a>
</tr>
<%}}
}%>
</td>
</table>
</form>
</table>
</body>
</html>