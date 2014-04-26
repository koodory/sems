<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<title>사용자입력폼</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
<h1>사용자입력</h1>
<form action="insert.bit" method="post">
<table>
	<tr>
		<th>이메일</th>
		<td class="inputField"><input class="hiddenInputBox" type="email" name="email"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td class="inputField"><input class="hiddenInputBox" type="password" name="passwd"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="name"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="tel"></td>
	</tr>
	<tr>
		<th>팩스번호</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="fax"></td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="postno"></td>
	</tr>
	<tr>
		<th>주소</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="address"></td>
	</tr>
	<tr>
		<th>사진</th>
		<td class="inputField"><input class="hiddenInputBox" type="text" name="photo"></td>
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
<%@ include file="../inc/footer.jsp" %>
</div>
</div>
