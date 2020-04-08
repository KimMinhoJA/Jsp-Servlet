<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<script>

</script>
</head>
<body>
<%
String id = request.getParameter("userId");
String pwd = request.getParameter("userPwd");
String name = request.getParameter("userName");

if("jang".equals(id) && "1234".equals(pwd)){
	session.setAttribute("name", name);
	session.setAttribute("time", new Date().toLocaleString());
	Cookie co = new Cookie("lastId", id);
	co.setMaxAge(60*60*24*365);
	co.setPath("/");
	
	response.addCookie(co);
	response.sendRedirect("LoginOk.jsp");
}else{
	%>
	<script>
		alert('<%=name%>님 정보를 확인해주세요.');
		history.back();
	</script>
	<%
}
%>

</body>
</html>