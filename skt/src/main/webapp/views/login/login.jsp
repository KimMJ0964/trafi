<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="<%=contextPath %>/views/login/css/login.css">

<style>
</style>
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
	<br><br><br>
	<div class="container">
    <form action="<%=contextPath %>/login.me" method="post">
         <img src="<%=contextPath %>/views/login/img/logo_1.png" alt="">
        <br>
        <input type="text" placeholder="아이디"  name="memId"><br>
        <input type="password" placeholder="비밀번호" name="memPwd"><br>
        <button type="submit" style="height: 50px;">로그인</button>
    </form>
    <div class="member">
    <a href="<%=contextPath %>/intoSearchId.co"><b>아이디 찾기 | </b></a>
    <a href="<%=contextPath %>/intoSearchPwd.co"><b>비밀번호 찾기</b></a>
    <br>
    <p id="memberp">아직 회원이 아니시라면 <b style="color: black;"><a href="<%=contextPath %>/intoRegister.co"><b>회원가입</b></a></b></p>
    </div>
    </div>
    <jsp:include page="/views/common/footer.jsp" />
</body>
</html>