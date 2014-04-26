<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<title>사용자상세정보</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>사용자 상세정보(byJSP)</h1>
<table border='1'>
<tr>
	<th>번호</th>
	<td style='text-align:left;'>${user.no}</td>
</tr>
<tr>
	<th>이메일</th>
	<td style='text-align:left;'>${user.email}</td>
</tr>
<tr>
	<th>이름</th>
	<td style='text-align:left;'>${user.name}</td>
</tr>
<tr>
	<th>전화번호</th>
	<td style='text-align:left;'>${user.tel}</td>
</tr>
<tr>
	<th>팩스번호</th>
	<td style='text-align:left;'>${user.fax}</td>
</tr>
<tr>
	<th>주소</th>
	<td style='text-align:left;'>(${user.postno})${user.address}</td>
</tr>
<tr>
	<th>사진경로</th>
	<td style='text-align:left;'>${user.photo}</td>
</tr>
</table>
<div id="footer">
<input type="button" class="btn btn-success btn-sm" value="목록" onclick="location.href='list.bit?pageNo=1&pageSize=10'">
<input type="button" class="btn btn-danger btn-sm" value="삭제" onclick="location.href='delete.bit?no=${user.no}'">
<input type="button" class="btn btn-warning btn-sm" value="변경" onclick="location.href='update.bit?no=${user.no}'"> 
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>