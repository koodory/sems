<%@page import="sems.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/include/header.jsp" />
<title>사용자 변경폼</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">

  <h3>사용자 변경폼</h3>
  <br>
  <form action='update.bit' class="form-horizontal" 
  method='post' role="form" enctype="multipart/form-data">
    <div class="form-group">
      <label for="no" class="control-label no-margin">번호</label>
      <div class="col-1x">
        <input type='text' id="no" name='no' class="form-control"
          value='${user.no}' readonly>
      </div>
      <label for="name" class="control-label col-xs left-margin">이름</label>
      <div class="col-1s">
        <input type='text' id="name" name='name' class="form-control"
          value='${user.name}'>
      </div>
    </div>

    <div class="form-group">
      <label for="email" class="control-label no-margin">이메일</label>
      <div class="col-5s">
        <input type='email' id="email" name='email' class="form-control"
          value='${user.email}'>
      </div>
    </div>

    <div class="form-group">
      <label for="password" class="control-label no-margin">비밀번호</label>
      <div class="col-5s">
        <input type="password" id="password" name='password' class="form-control">
      </div>
    </div>

    <div class="form-group">
      <label for="tel" class="control-label no-margin">전화번호</label>
      <div class="col-5s">
        <input type='tel' id="tel" name='tel' class="form-control"
          value='${user.tel}'>
      </div>
    </div>

    <div class="form-group">
      <label for="fax" class="control-label no-margin"> 팩스</label>
      <div class="col-1s">
        <input type='tel' id="fax" name='fax' class="form-control"
          value='${user.fax}'>
      </div>
      <label for="postNo" class="control-label"> 우편번호</label>
      <div class="col-1x">
        <input type='text' id="postNo" name='postNo' class="form-control"
          value='${user.postNo}'>
      </div>
    </div>

    <div class="form-group">
      <label for="address" class="control-label no-margin">주소</label>
      <div class="col-5s">
        <textarea id="address" name='address' class="form-control" rows='2'
          cols='80'>${user.address}</textarea>
      </div>
    </div>

    <div class="form-group">
      <label for="photo" class="control-label no-margin">사진</label>
      <div class="col-5s">
        <input type='file' id="photo" name='file' class="form-control"
          value='${user.photoPath}'>
      </div>
    </div>

    <div class="button-bottom">
      <input type="submit" class="btn btn-danger btn-sm" value="변경"> 
      <input type="button" class="btn btn-warning btn-sm" value="취소"
        onclick="location.href='detail.bit?no=${user.no}'">
    </div>

  </form>
</div>
<c:set var="studyClass" value="Java48$$" scope="request" />
<jsp:include page="/include/footer.jsp" />
