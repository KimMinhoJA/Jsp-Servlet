<%@page import="java.net.URLEncoder"%>
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
<%String id = request.getParameter("userId");
String pwd = request.getParameter("userPwd");
String name = request.getParameter("userName");
if("jang".equals(id) && "1234".equals(pwd)){
// 	response.sendRedirect("LoginOk.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
	rd.forward(request, response);
}else{
	out.println("<script>");
	out.println("alert('" + name + "님 정보를 확인해줘라..')");
	out.println("history.back()");
	out.println("</script>");
	
	%>
	<%-- <script>
		alert("<%=name%>님 정보를 확인해주세요.");
// 		location.href = "LoginForm.html";
		history.back();
	</script> --%>
	<%
 	//response.sendRedirect("LoginForm.html");
}

%>


</body>
</html>