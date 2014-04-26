<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<title>과정상세정보</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>과정 상세정보(byJSP)</h1>
<table border='1'>
<tr>
	<th class="inputField">번호</th>
	<td style='text-align:left;'>${course.no}</td>
</tr>
<tr>
	<th class="inputField">과정명</th>
	<td style='text-align:left;'>${course.title}</td>
</tr>
<tr>
	<th class="inputField">내용</th>
	<td style='text-align:left;'><textarea class="hiddenInputBox" rows='5' cols='100' readOnly>${course.description}</textarea></td>
</tr>
<tr>
	<th class="inputField">시간</th>
	<td style='text-align:left;'>${course.hour}</td>
</tr>
</table>
<div id="footer">
<input type="button" class="btn btn-success btn-sm" value="목록" onclick="location.href='list.bit?pageNo=1&pageSize=10'">
<input type="button" class="btn btn-danger btn-sm" value="삭제" onclick="location.href='delete.bit?no=${course.no}'">
<input type="button" class="btn btn-warning btn-sm" value="변경" onclick="location.href='update.bit?no=${course.no}'"> 
</div>
</div>
</div>
<jsp:include page="../include//footer.jsp" />
