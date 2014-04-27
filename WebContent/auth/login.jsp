<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/header.jsp" />
<title>로그인</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">
  <h3 style="margin-bottom:50px">로그인</h3>
  <form class="form-horizontal" action="login.bit" role="form" method="post">
  <div class="form-group">
    <label for="email" class="control-label">이메일</label>
    <div class="col-3s mg">
      <input type="email" class="form-control" id="email" placeholder="Email"
       name="email" value="${cookie.loginEmail.value}">
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="control-label">암호</label>
    <div class="col-3s mg">
      <input type="password" class="form-control" id="password"
         name="password"placeholder="Password">
    </div>
  </div>
  <div class="form-group" style="margin-left:65px;">
    <div class="col-sm-offset-2 col-3s">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="saveEmail"
          <c:if test="${cookie.loginEmail != null}">checked</c:if>> 이메일 저장
        </label>
      </div>
    </div>
  </div>
  <div class="form-group" style="margin-left:120px;">
    <div class="col-sm-offset-2 col-3s">
      <button type="submit" class="btn btn-default">로그인</button>
    </div>
  </div>
</form>
</div>
<jsp:include page="/include/footer.jsp" />















