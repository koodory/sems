<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp" />
<title>과목등록폼</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">
  <h3>과목등록폼</h3>
  <form action="insert.bit" method="post" role="form">
    <div class="form-group">
      <label for="title">과목명</label> 
      <input id="title" class="form-control"
        placeholder="과목명을 입력하세요" type="text" name="title">
    </div>
    <div class="form-group">
      <label for="description">설명</label>
      <textarea id="description" class="form-control" rows="8" cols="80"
       placeholder="과목에 대한 설명을 입력하세요" name="description"></textarea>
    </div>
    <jsp:include page="/include/insertButton.jsp" />
  </form>
</div>

<jsp:include page="/include/footer.jsp" />





















