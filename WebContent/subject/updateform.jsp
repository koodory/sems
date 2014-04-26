<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../inc/header.jsp" %>
<title>과목변경폼</title></head><body>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
<h1>과목변경</h1>
<form action='update.bit' method='post'>
<table>
<tr>
<th>번호</th><td style='text-align:left;'><input class="hiddenInputBox" type='text' name='no' value='${subject.no}' readonly></td>
</tr>
<tr>
<th>과목명</th><td style='text-align:left;'><input class="inputBox" type='text' name='title' value='${subject.title}'></td>
</tr>
<tr>
<th>설명</th><td style='text-align:left;'><textarea class="inputBox" name='description' rows='10' cols='50'>${subject.description}'</textarea></td>
</tr>
<tr><td colspan='2'>
<input type="submit" class="btn btn-danger btn-sm" value="변경">
<input type="button" class="btn btn-warning btn-sm" value="취소" onclick="location.href='detail.bit?no=${subject.no}'"> 
</td></tr>
</table>
</form>
<c:set var="studyClass" value="Java48$$" scope="request"/>
</div>
</div>
<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="../inc/footer.jsp"/>
