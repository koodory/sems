<%@page import="java.util.ArrayList"%>
<%@page import="sems.vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/header.jsp" />
<title>과정목록</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">
<h3 style="margin-bottom:10px">과정 목록</h3>
  <table class="table table-striped">
    <tr>
      <th>번호</th>
      <th>과목명</th>
    </tr>
    <jsp:include page="/include/listButton.jsp" />
    <c:forEach var="course" items="${list}">
      <tr>
        <td>${course.no}</td>
        <td><a href='detail.bit?no=${course.no}'>${course.title}</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
<jsp:include page="/include/footer.jsp" />
















