<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/include/header.jsp" />
<title>과목 변경폼</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">

  <h3>과목 변경폼</h3>
  <br>
  <form action='update.bit' class="form-horizontal" method='post' role="form">
    <div class="form-group no-margin">
      <label for="no" class="control-label no-margin" style="border: 1px solid red;">번호</label>
      <div class="col-1x mg">
        <input type='text' id="no" name='no' class="form-control"
          value='${subject.no}' readonly>
      </div>
    </div>
    <div class="form-group">
      <label for="title" class="control-label">과목</label> 
      <div class="col-5x mg">
      <input type='text' name='title'
        class="form-control" id="title" value='${subject.title}'>
      </div>
    </div>
    <div class="form-group">
      <label for="description" class="control-label">설명</label>
      <div class="col-5x mg">
      <textarea id="description" name='description' rows="8" cols="80"
      class="form-control">${subject.description}</textarea>
      </div>
    </div>
   <div class="button-bottom">
     <input type="submit" class="btn btn-danger btn-sm" value="변경">
     <input type="button" class="btn btn-warning btn-sm" value="취소" 
       onclick="location.href='detail.bit?no=${subject.no}'">      
   </div>
  </form>
</div>

<c:set var="studyClass" value="Java48$$" scope="request" />
<jsp:include page="/include/footer.jsp" />














