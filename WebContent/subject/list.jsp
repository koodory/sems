<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<jsp:useBean id="list" type="java.util.List<vo.SubjectVo>" scope="request"/>
<title>과목목록</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<h1>과목 목록</h1>
<div id="header">
<button type="button" class="btn btn-warning btn-xs"  
 onclick="location.href='/sems/index.jsp'"> HOME </button>
<button type="button" class="btn btn-danger btn-xs" 
 onclick="location.href='form.jsp'"> 과목등록</button>
</div>
<table>
<tr>
	<th>번호</th>
	<th>과목명</th>
</tr>
<%int i=0;%>
<%for(SubjectVo subject : list) {%>
<tr>
	<td class=<%="row"+i%2%>><%=subject.getNo() %></td>
	<td class=<%="row"+i%2%>><a href='detail.bit?no=<%=subject.getNo()%>'><%=subject.getTitle() %></a></td>
</tr>
 <%i++;%>
<%}%>
</table>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>
