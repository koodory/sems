<%@page import="vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp" />
<title>과정 상세정보</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">
  <h3>과정 상세정보</h3>
  <br>
    <div class="button-top">
    <input type="button" class="btn btn-success btn-sm" value="목록"
      onclick="location.href='list.bit?pageNo=1&pageSize=10'"> 
    <input type="button" class="btn btn-danger btn-sm" value="삭제"
      onclick="location.href='delete.bit?no=${course.no}'"> 
    <input type="button" class="btn btn-warning btn-sm" value="변경"
      onclick="location.href='update.bit?no=${course.no}'">
  </div>
  
  <table class="table">
    <tr>
      <th>번호</th>
      <td>${course.no}</td>
    </tr>
    <tr>
      <th>과정명</th>
      <td>${course.title}</td>
    </tr>
    <tr>
      <th>시간</th>
      <td>${course.hour}</td>
    </tr>
    <tr>
      <th>내용</th>
      <td>${course.description}</td>
    </tr>
  </table>
</div>
<jsp:include page="/include/footer.jsp" />











