<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel='stylesheet' type='text/css' href='./CSS/css.css'>
<title>BIT</title>
</head>
<body>
<div id="backgroundImage">
<%@ include file="../inc/loginBar.jsp" %>
<div id="container">
  <table>
    <tr height="100px">
      <td >
        <a class="btn btn-default btn-lg btn-block" style="height:100px; padding-top:30px; "
         href='subject/list.bit?pageNo=1&pageSize=10'>과목관리</a>
      </td>
    </tr>
    <tr height="100px">
      <td>
        <a class="btn btn-default btn-lg btn-block" style="height:100px; padding-top:30px;"
         href='course/list.bit?pageNo=1&pageSize=10'>과정관리</a>
      </td>
    </tr>
    <tr height="100px">
      <td>
        <a class="btn btn-default btn-lg btn-block" style="height:100px; padding-top:30px;"
         href='user/list.bit?pageNo=1&pageSize=10'>회원관리</a>
      </td>
    </tr>
  </table>
  </div>
</div>
</body>
</html>
