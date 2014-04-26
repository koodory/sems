<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<title>과정입력폼</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>과정입력</h1>
<form action="insert.bit" method="post">
<table>
	<tr>
		<th>과정명</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="title"></td>
	</tr>
	<tr>
		<th>설명</th>
		<td class="inputField"><textarea class="hiddenInputBox"  name="description" rows="10" cols="60"></textarea></td>
	</tr>
	<tr>
		<th>시간</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="hour"></td>
	</tr>
	<tr>
		<td colspan='2'>
<input type="submit" class="btn btn-danger btn-sm" value="등록"> 
<input type="button" class="btn btn-warning btn-sm" value="취소"> 
<input type="button" class="btn btn-success btn-sm" value="목록" onclick="history.back();">
		</td>
	</tr>
</table>
</form>
</div>
</div>
<%@ include file="../include/footer.jsp" %>