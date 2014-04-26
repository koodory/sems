<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp" %>
<title>사용자변경</title></head><body>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
<h1>사용자변경</h1>
<form action='update.bit' method='post'>
<table>
<tr>
<th>번호</th>
<td class="inputField"><input class="hiddenInputBox" type='text' name='no' value='${user.no}' readonly></td>
</tr><tr>
<th>이메일</th>
<td class="inputField"><input class="inputBox" type='text' name='email' value='${user.email}'></td>
</tr><tr>
<th>비밀번호</th>
<td class="inputField"><input class="inputBox" type='password' name='passwd'>${user.passwd}</td>
</tr><tr>
<th>이름</th>
<td class="inputField"><input class="inputBox" type='text' name='name' value='${user.name}'></td>
</tr><tr>
<th>전화번호</th>
<td class="inputField"><input class="inputBox" type='text' name='tel' value='${user.tel}'></td>
</tr><tr>
<th>팩스번호</th>
<td class="inputField"><input class="inputBox" type='text' name='fax' value='${user.fax}'></td>
</tr><tr>
<th>우편번호</th>
<td class="inputField"><input class="inputBox" type='text' name='postno' value='${user.postno}'></td>
</tr><tr>
<th>주소</th>
<td class="inputField"><input class="inputBox" type='text' name='address' value='${user.address}'></td>
</tr><tr>
<th>사진</th>
<td class="inputField"><input class="inputBox" type='text' name='photo' value='${user.photo}'></td>
</tr>
<tr><td colspan='2'>
<input type="submit" class="btn btn-danger btn-sm" value="변경">
<input type="button" class="btn btn-warning btn-sm" value="취소" onclick="location.href='detail.bit?no=${user.no}'"> 
</td></tr>
</table>
</form>
</div>
</div>
<jsp:include page="../inc/footer.jsp" />