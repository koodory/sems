<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<title>과정변경폼</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>과정변경</h1>
<form action='update.bit' method='post'>
<table>
<tr>
<th>번호</th>
<td class="inputField"><input class="hiddenInputBox" type='text' name='no' value='${course.no}' readonly></td>
</tr>
<tr>
<th>과정명</th>
<td class="inputField"><input  class="inputBox" type='text' name='title' value='${course.title}'></td>
</tr>
<tr>
<th>설명</th>
<td class="inputField"><textarea class="inputBox" name='description' rows='10' cols='50'>${course.description}</textarea></td>
</tr>
<tr>
<th>시간</th>
<td class="inputField"><input class="inputBox" type='text' name='hour' value='${course.hour}'></td>
</tr>
<tr><td colspan='2'>
<input type="submit" class="btn btn-danger btn-sm" value="변경">
<input type="button" class="btn btn-warning btn-sm" value="취소" onclick="location.href='detail.bit?no=${course.no}'"> 
</td></tr>
</table>
</form>
</div>
</div>
<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="../include/footer.jsp"/>