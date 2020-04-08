<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	response.setHeader("Cache-Control","no-store");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<script src="/step01_JspExam/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<%
if(session.getAttribute("name") != null){
	String name = (String)(session.getAttribute("name"));
	String date = (String)(session.getAttribute("time"));
	out.print("접속시간 : " + date + "<br>");
	out.print(name + "님 로그인중<br>");
	%>
	<img src = "/step01_JspExam/images/Penguins.jpg" width="200px" height = "200px"><br>
	<button id="logout">로그아웃</button>
	
	<script>
	$(function(){
		$("#logout").click(function(){
			if(confirm("로그아웃 하시겠습니까?")){
				location.href = "Logout.jsp";
			}else{}
		});
	});
	</script>
	<%
}else{
	%>
	<script>
		alert("로그인하고 오세요");
		location.href = "LoginForm.html";
	</script>
	<%
}
%>


</body>
</html>