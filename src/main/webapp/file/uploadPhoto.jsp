<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/include/header.jsp" />
<title>파일 업로드</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox small">
  <h3 style="margin-bottom:50px">파일 업로드</h3>
  <form class="form-horizontal" action="upload.bit" role="form" 
  method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="name" class="control-label">파일이름</label>
    <div class="col-3s">
      <input type="text" class="form-control" id="name" placeholder="파일이름"
       name="name">
    </div>
  </div>
  
  <div class="form-group">
    <label for="InputFile" class="control-label">File input</label>
      <div class="col-3s">
    <input type="file" id="InputFile" name="file1">
  </div>
  </div>

  <div class="form-group" style="margin-left:120px;">
    <div class="col-sm-offset-2 col-3s">
      <input type="submit" class="btn btn-default" value="업로드">
    </div>
  </div>
</form>
</div>
<jsp:include page="/include/footer.jsp" />