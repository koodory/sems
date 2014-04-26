<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<jsp:useBean id="list" type="java.util.List<vo.CourseVo>" scope="request"/>
<title>과정목록</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
<h1>과정 목록(byJSP)</h1>
<div id="header">
<button type="button" class="btn btn-warning btn-xs"  
 onclick="location.href='/sems/index.jsp'"> HOME </button>
<button type="button" class="btn btn-danger btn-xs" 
 onclick="location.href='form.jsp'"> 과정등록</button>
</div>
<table>
<tr>
	<th>번호</th>
	<th>과정명</th>
	<th>시간</th>
</tr>
<%int i=0;%>
<%for(CourseVo course : list) {%>
<tr>
	<td class=<%="row"+i%2%>><%=course.getNo() %></td>
	<td class=<%="row"+i%2%>><a href='detail.bit?no=<%=course.getNo()%>'><%=course.getTitle() %></a></td>
	<td class=<%="row"+i%2%>><%=course.getHour() %></td>
</tr>
   <%i++;%>
<% } %>
</table>
</div>
</div>
<jsp:include page="../inc/footer.jsp"/>