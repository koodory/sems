<%@page import="vo.FileVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/header.jsp" />
<title>업로드 확인</title>
<jsp:include page="/include/loginBar.jsp" />
<div class="contentBox small">
<h3 style="margin-bottom:50px">업로드 결과</h3>
<table style="margin-left:auto; margin-right:auto;">
<tr>
  <td colspan=2><img src="../upload/${file1.name}" 
  style="width:150px; height:200px;"></td>
</tr>
<tr >
  <td style="width:50px"><br>이름</td>
  <td><br>${file1.name}</td>
</tr>
<tr>
  <td colspan=2 style="text-align:center;"><br>
    <input type="button" class="btn btn-success btn-sm" value="목록"
      onclick="location.href='/sems/index.jsp'"> </td>
</tr>
</table>
</div>
<jsp:include page="/include/footer.jsp" />

















