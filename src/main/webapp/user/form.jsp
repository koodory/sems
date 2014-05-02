<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp" />
<title>사용자등록폼</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">

  <h3>사용자 등록폼</h3>
  <br>
  <form action="insert.bit" class="form-horizontal" 
   method="post" role="form" enctype="multipart/form-data">

    <div class="form-group">
      <label for="name" class="control-label no-margin">이름</label>
      <div class="col-5s">
        <input type='text' id="name" name='name' class="form-control"
          value='${user.name}'>
      </div>
    </div>

    <div class="form-group">
      <label for="email" class="control-label no-margin">이메일</label>
      <div class="col-5s">
        <input type='text' id="email" name='email' class="form-control"
          value='${user.email}'>
      </div>
    </div>

    <div class="form-group">
      <label for="passwd" class="control-label no-margin">비밀번호</label>
      <div class="col-5s">
        <input type="password" id="passwd" name='passwd' class="form-control"
          value='${user.passwd}'>
      </div>
    </div>

    <div class="form-group">
      <label for="tel" class="control-label no-margin">전화번호</label>
      <div class="col-5s">
        <input type='text' id="tel" name='tel' class="form-control"
          value='${user.tel}'>
      </div>
    </div>
    
    <div class="form-group">
      <label for="fax" class="control-label no-margin"> 팩스</label>
      <div class="col-1s">
        <input type='text' id="fax" name='fax' class="form-control"
          value='${user.fax}'>
      </div>
      <label for="postno" class="control-label">
      우편번호</label> 
       <div class="col-1x">
       <input type='text' id="postno"
        name='postno' class="form-control" value='${user.postno}'>
      </div>
    </div>

    <div class="form-group">
      <label for="address" class="control-label no-margin">주소</label>
      <div class="col-5s">
        <textarea id="address" name='address' class="form-control" 
         rows='2' cols='80'>${user.address}</textarea>
      </div>
    </div>

    <div class="form-group">
      <label for="photo" class="control-label no-margin">사진</label>
      <div class="col-5s">
       <input type='file' id="photo" name='file'
        class="form-control" value='${user.photo}'>
    </div>
    </div>
    <jsp:include page="/include/insertButton.jsp" />
  </form>
</div>

<jsp:include page="/include/footer.jsp" />
