<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' type='text/css' href='/sems/CSS/css.css'>
<title>로그인</title>
</head>
<body>
<div id="backgroundImage">
<div id="container" style="padding-top:300px;">
<h1>로그인</h1>

<form action="login.bit" method="post">
<table style="width:300px; margin-left:auto; margin-right:auto;">
<tr>
<th> 이메일 </th>
<td><input class="hiddenInputBox" style="width:200px"
 type="text" name="email" value="${cookie.loginEmail.value}"></td>
</tr>
<tr>
<th> 암  호 </th>
<td><input class="hiddenInputBox" style="width:200px"
type="password" name="password"></td>
</tr>
<tr>
<td colspan='2'><input type="checkbox" name="saveEmail" 
  <c:if test="${cookie.loginEmail != null}">checked</c:if>
>이메일 저장</td>
</tr>
<tr>
<td colspan='2'><input type="submit" value="로그인"></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>















