<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<h1>&lt;c:forEach> TEST</h1>

<c:forEach begin="1" end="10" var="i">
	${i} ,
</c:forEach>

<hr>

<%
	String hobbys[] = {"등산", "수영", "낚시", "골프"};
%>

<c:forEach items="<%=hobbys%>" var="h" varStatus="state">
	${h} / ${state.index} / ${state.count}<br>
</c:forEach>
<hr>

<jsp:useBean id="bean" class="ex0414.jstl.ForEachBean"/>

<!-- names는 select박스로 출력 -->
<select>
	<option>--이름 선택--</option>
	<c:forEach items="${bean.names}" var="name">
		<option value="${name}">${name}</option>
	</c:forEach>
</select>
<br>
<!-- menus는 checkbox출력 --> 
<c:forEach items="${bean.menus}" var="menu">
	<input type="checkbox" name="menus" value="${menu}">${menu}
</c:forEach>
<br>
<!-- memberList는 테이블로 출력 -->
<table>
	<tr>
		<th>아이디 </th>
		<th>나이 </th>
		<th>주소 </th>
		<th>번호 </th>
	</tr>
	<c:forEach items="${bean.memberList}" var="member">
		<tr>
			<td>${member.id} </td>
			<td>${member.age} </td>
			<td>${member.addr} </td>
			<td>${member.phone} </td>
		</tr>
	</c:forEach>
</table>
<br>
<!-- map은 radio박스로 출력 -->
<c:forEach items="${bean.map}" var="country">
	<input type="radio" name="country" value="${country.key}">${country.value} 
</c:forEach>


</body>
</html>