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

<h1>include 지시어</h1>

<%@ include file="top.jsp" %>
<hr>
<%String addr = "제주도"; %>
여기는 index.jsp의 부분입니다.....
<%@ include file="footer.jsp" %>

</body>
</html>