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
<h3>
<%
request.setCharacterEncoding("UTF-8");
%>
이름 : <%=request.getParameter("name") %><br>
나이 : <%=request.getParameter("age") %><br>
취미 : <%
String[] hobbys = request.getParameterValues("hobby");
for(int i = 0; i < hobbys.length; i++){
	out.print(hobbys[i]);
	if(i != hobbys.length - 1){
		out.print(", ");
	}
}
System.out.println(request.getRemoteAddr());%><br>
접속자 IP : <%=request.getRemoteAddr() %><br>
</h3>


</body>
</html>