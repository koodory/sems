<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp" />
<title>BIT</title>
<jsp:include page="/include/loginBar.jsp" />
<div class="contentBox small box-margin">
  <table>
    <tr>
      <td class="small"><a class="btn btn-default btn-lg btn-block"
        href='subject/list.bit?pageNo=1&pageSize=10'>과목관리</a></td>
    </tr>
    <tr>
      <td class="small"><a class="btn btn-default btn-lg btn-block"
        href='course/list.bit?pageNo=1&pageSize=10'>과정관리</a></td>
    </tr>
    <tr>
      <td class="small"><a class="btn btn-default btn-lg btn-block"
        href='user/list.bit?pageNo=1&pageSize=10'>회원관리</a></td>
    </tr>
    <tr>
      <td class="small"><a class="btn btn-default btn-lg btn-block"
        href='file/uploadPhoto.jsp'>파일업로드</a></td>
    </tr>
  </table>
</div>
<jsp:include page="/include/footer.jsp" />
