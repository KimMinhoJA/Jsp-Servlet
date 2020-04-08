<%@page import="java.io.File"%>
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
<h1>
<%
	out.print(application.getRealPath("/") + "ex0408\\mission\\text\\<br>");
	out.print("폴더 LIST");
%>
</h1>
<ul>
<%
	File file = new File(application.getRealPath("/") + "ex0408\\mission\\text\\");
	String [] fileList = file.list();
	for(String str : fileList){
		out.print("<li>" + str + "<br>");
	}
%>
</ul>
<hr>
<a href="board_Form.html">새글 등록</a>
</body>
</html>