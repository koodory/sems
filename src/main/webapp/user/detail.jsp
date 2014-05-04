<%@page import="sems.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp"/>
<title>사용자상세정보</title>
<jsp:include page="/include/loginBar.jsp"/>

<div class="contentBox large">
<h3>사용자 상세정보</h3>
  <br>
  <br>
  <div class="button-top">
    <input type="button" class="btn btn-success btn-sm" value="목록"
      onclick="location.href='list.bit?pageNo=1&pageSize=10'">
    <input type="button" class="btn btn-danger btn-sm" value="삭제"
      onclick="location.href='delete.bit?no=${user.no}'"> 
    <input type="button" class="btn btn-warning btn-sm" value="변경"
      onclick="location.href='update.bit?no=${user.no}'">
  </div>

<table class="table">
<tr>
  <td rowspan = 5>
   <img src="../upload/${user.photoPath}" 
   style="width:150px; height:200px; margin-right:0px;">
  </td>
  <th style="width:90px;">번호</th>
 <td style="width:250px;">${user.no}</td>
</tr>
<tr>
 <th>이름</th>
 <td>${user.name}</td>
</tr>
<tr>
 <th>이메일</th>
 <td>${user.email}</td>
</tr>
<tr>
 <th>전화번호</th>
 <td>${user.tel}</td>
</tr>
<tr>
 <th>팩스</th>
 <td>${user.fax}</td>
</tr>
<tr>
  <th>주소</th>
  <td colspan = 2>(${user.postNo})${user.address}</td>
</tr>
<tr>
  <th>사진경로</th>
  <td colspan = 2>${user.photoPath}</td>
</tr>
</table>
</div>
<jsp:include page="/include/footer.jsp"/>