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
<h1> ServletContext -> application 변수 </h1>
<h3>
application.getContextPath() : <%=application.getContextPath() %><br>
application.getRealPath("/") : <%=application.getRealPath("/") %><br>
application.getMajorVersion() : <%=application.getMajorVersion() %><br>
application.getMinorVersion() : <%=application.getMinorVersion() %><br>
application.getServerInfo() : <%=application.getServerInfo() %><br>

</h3>

<h3> application에 정보 저장하기...</h3>
<%
application.setAttribute("message", "졸지맙시다...");
application.setAttribute("addr", "서울시 강남구...");
%>

<h3> application 정보 확인하기...  </h3>
메세지 : <%=application.getAttribute("message") %><br>
주소 : <%=application.getAttribute("addr") %>


<a href = "../session/sessionGet.jsp">정보확인하러 가자.</a>


</body>
</html>