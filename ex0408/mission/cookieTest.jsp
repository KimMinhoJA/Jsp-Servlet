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

<h2>
<%
	String time = "";
	Cookie [] cookies = request.getCookies();
	Cookie cookie = null;
	boolean hasCookie = false;
	for(Cookie co : cookies){
		if("time".equals(co.getName())){
			hasCookie = true;
			time = co.getValue();
			cookie = co;
			break;
		}
	}
	
	if(hasCookie){
		out.print("당신의 마지막 접속일은 " + new Date(Long.parseLong(time)).toLocaleString());
		cookie.setValue(Long.toString(System.currentTimeMillis()));
		response.addCookie(cookie);
	}else{
		out.print("당신은 처음 방문하셨습니다.");
		cookie = new Cookie("time", Long.toString(System.currentTimeMillis()));
		cookie.setMaxAge(60*60*24*365);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
%>
</h2>

</body>
</html>