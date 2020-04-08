<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStreamWriter"%>
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
if(request.getParameter("name") != null){
	try(FileWriter fw = new FileWriter(application.getRealPath("/").replaceAll("\\\\","/") + "ex0408/mission/text/" 
		+ request.getParameter("name") + System.currentTimeMillis() + ".txt")){
		fw.write("이름 : " + request.getParameter("name") + System.getProperty("line.separator"));
		fw.write("제목 : " + request.getParameter("subject") + System.getProperty("line.separator"));
		fw.write("내용 : " + request.getParameter("content") + System.getProperty("line.separator"));
		response.sendRedirect("fileBoardjsp.jsp");
	}catch(IOException e){
		e.printStackTrace();
	}
}else{
	%>
	<script>
		alert("게시글을 작성하세요");
		location.href="board_Form.html";
	</script>
	<%
}

%>


</body>
</html>