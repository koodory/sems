<%@page import="java.util.ArrayList"%>
<%@page import="sems.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/header.jsp" />
<title>사용자목록</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox large">
  <h3>사용자 목록</h3>

  <table class="table table-striped">
    <tr>
      <th>번호</th>
      <th>사용자명</th>
      <th>이메일</th>
      <th>전화번호</th>
    </tr>
    <jsp:include page="/include/listButton.jsp" />
    <c:forEach var="user" items="${list}">
      <tr>
        <td>${user.no}</td>
        <td><a href='detail.bit?no=${user.no}'>${user.name}</a></td>
        <td>${user.email}</td>
        <td>${user.tel}</td>
      </tr>
    </c:forEach>
  </table>
</div>
<jsp:include page="/include/footer.jsp" />
















