<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<title>과목상세정보</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>과목 상세정보(byJSP)</h1>
<table border='1'>
<tr>
	<th class="inputField">번호</th>
	<td style='text-align:left;'>${subject.no}</td>
</tr>
<tr>
	<th class="inputField">과목명</th>
	<td style='text-align:left;'>${subject.title}</td>
</tr>
<tr>
	<th class="inputField">내용</th>
	<td style='text-align:left;'><textarea class="hiddenInputBox">${subject.description}</textarea></td>
</tr>
</table>
<div id="footer">
<input type="button" class="btn btn-success btn-sm" value="목록" onclick="location.href='list.bit?pageNo=1&pageSize=10'">
<input type="button" class="btn btn-danger btn-sm" value="삭제" onclick="location.href='delete.bit?no=${subject.no}'">
<input type="button" class="btn btn-warning btn-sm" value="변경" onclick="location.href='update.bit?no=${subject.no}'"> 
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>