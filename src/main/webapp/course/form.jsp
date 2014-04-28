<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp" />
<title>과정등록폼</title>
<jsp:include page="/include/loginBar.jsp" />

<div class="contentBox medium">
  <h3>과정등록폼</h3>
  <form action="insert.bit" method="post" role="form">
    <div class="form-group">
      <label for="title">과정명</label> 
      <input id="title" class="form-control"
        placeholder="과정명을 입력하세요" type="text" name="title">
    </div>
    <div class="form-group">
      <label for="hour">시간</label>
       <input id="hour" class="form-control col-1f"
        placeholder="강의 시간" type="text" name="hour">
    </div>
    <div class="form-group">
      <label for="description">설명</label>
      <textarea id="description" class="form-control"
        placeholder="과정에 대한 설명을 입력하세요" name="description" 
        rows="8" cols="80"></textarea>
    </div>
    <jsp:include page="/include/insertButton.jsp" />
  </form>
</div>
<jsp:include page="/include/footer.jsp" />





















