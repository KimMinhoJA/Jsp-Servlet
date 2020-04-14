<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{text-decoration: none}
a:hover{
	color:red;
	font-style: italic;
	font-size: 25px;
}
</style>

<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h1> Download List </h1>
<ul>
	<c:forEach items="${fileList}" var="file">
		<li><a href="DownLoad?file=${file}">${file}</a></li>
	</c:forEach>
</ul>

</body>
</html>