<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

</head>
<body>

    <div id="container">

      <div id="loginBar">
        ${loginUser.name}(${loginUser.email})

        <div style="float: right; margin-left: 10px;">
          <a href="${pageContext.request.contextPath}/auth/logout.bit"
           style="color:yellow"> 로그아웃</a>
           </div>

        <div style="float: right">
          <a href="${pageContext.request.contextPath}/auth/login.bit"
            style="color: white"> 로그인 |</a>
        </div>
      </div>