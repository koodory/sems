<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<jsp:useBean id="list" type="java.util.List<vo.UserVo>" scope="request"/>
<title>사용자목록</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<div id="title"> <h1>사용자 목록(byJSP)</h1> </div>
<div id="header">
<button type="button" class="btn btn-warning btn-xs"  
 onclick="location.href='/sems/index.jsp'"> HOME </button>
<button type="button" class="btn btn-danger btn-xs" 
 onclick="location.href='form.jsp'"> 사용자 등록</button>
</div>
<table>
<tr>
	<th>번호</th>
	<th>이름</th>
	<th>이메일</th>
</tr>
<%int i=0;%>
<%for(UserVo user : list) {%>
<tr>
	<td class=<%="row"+i%2%>><%=user.getNo() %></td>
	<td class=<%="row"+i%2%>><a href='detail.bit?no=<%=user.getNo()%>'><%=user.getName() %></a></td>
	<td class=<%="row"+i%2%>><%=user.getEmail() %></td>
</tr>
 <%i++;%>
<%}%>
</table>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>