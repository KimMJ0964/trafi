<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
<link rel="stylesheet" href="./views/login/css/searchPwdResult.css">
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
<br><br><br>
    <div class="container">
            <img src="<%=contextPath %>/views/login/img/logo_1.png" alt="로고">
            <h1>당신의 비밀번호는</h1><br>
            <input type="text" placeholder="${searchPwd}" readonly><p>입니다.</p>
            <button><a onclick="location.href='views/login/login.jsp'">로그인 하기</a></button>
    </div>
     <jsp:include page="/views/common/footer.jsp" />
</body>
</html>