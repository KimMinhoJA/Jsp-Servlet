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
	session.invalidate();
%>
<script>
alert("로그아웃 되었습니다.");
location.href = "LoginForm.html";
</script>
<%--
 	//response.sendRedirect("LoginForm.html");
--%>

</body>
</html>