<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<h1> Upload Result</h1>
<h3>
	작성자 : ${name}<br>
	제목 : ${subject}<br>
	첨부파일이름(OriginalName) : ${originalName}<br>
	첨부파일이름(SystemName) : ${systemName}<br>
	파일용량 : <fmt:formatNumber value="${fileSize}"/>byte<br>
	저장경로 : ${saveDir}<br>
</h3>

</body>
</html>