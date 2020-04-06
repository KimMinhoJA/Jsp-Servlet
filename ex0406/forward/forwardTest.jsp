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
<h1>forward 액션 태그</h1>
<%
	request.setCharacterEncoding("UTF-8");
	int sum=0;
	for(int i = 0; i <= 10; i++){
		sum += i;
	}
%>


<jsp:forward page="forwardResult.jsp">
	<jsp:param name="total" value="<%=sum%>"/>
	<jsp:param name="name" value="민호"/>
</jsp:forward>

<%
	//기능.... 쓸모없음
%>

</body>
</html>