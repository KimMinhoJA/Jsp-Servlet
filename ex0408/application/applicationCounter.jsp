<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
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
/* Object obj = application.getAttribute("count");
int count = 1;
if(obj == null){
	application.setAttribute("count", count);
}else if(session.isNew()){
	count = (Integer)obj;
	application.setAttribute("count", ++count);
}else{
	count = (Integer)obj;
} */

Object obj = application.getAttribute("count");
if(obj == null){
	application.setAttribute("count", new AtomicInteger());
	obj = application.getAttribute("count");
}

AtomicInteger it = (AtomicInteger)obj;
int count = it.get();
if(session.isNew()){
	count = it.incrementAndGet();
}
%>

<h3>방문자 수 : <%=count %> 명</h3>

</body>
</html>