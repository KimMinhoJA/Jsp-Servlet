<%@page import="java.util.Enumeration"%>
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
request.setCharacterEncoding("UTF-8");
Enumeration<String> keys = request.getParameterNames();
while(keys.hasMoreElements()){
	String key = keys.nextElement();
	out.print(key + " : " + request.getParameter(key) + "<br>");
}

%>

request.getContextPath() : <%=request.getContextPath() %> <p>
request.getRealPath("/") : <%=request.getRealPath("/") %><p>
request.getRequestURI() : <%=request.getRequestURI() %><p>
request.getRequestURL() : <%=request.getRequestURL() %><p>

</body>
</html>