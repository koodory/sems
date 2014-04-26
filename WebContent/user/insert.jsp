<%@page import="vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<meta http-equiv="Refresh" content="1;url=list.bit?pageNo=1&pageSize=10">
<title>사용자등록결과</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../include/loginBar.jsp" %>
<div id="container">
<p>사용자 등록 성공입니다.!!</p>
</div>
</div>
<jsp:include page="../include/footer.jsp"/>