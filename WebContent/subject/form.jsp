<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<title>과목입력폼</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
<h1>과목 입력</h1>
<form action="insert.bit" method="post">
<table>
<tr>
<th>과목명</th> 
<td class="inputField"><input class="hiddenInputBox"  type="text" name="title"></td>
</tr><tr>
<th>설명</th>
<td><textarea class="hiddenInputBox" name="description" rows="10" cols="60"></textarea></td>
</tr><tr>
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
<%@ include file="../inc/footer.jsp" %>