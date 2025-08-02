<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="./views/login/css/searchPwd.css">
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
<br><br><br>
    <div class="container">
         <form action="<%=contextPath %>/searchPwd.me"  method="post">
            <img src="<%=contextPath %>/views/login/img/logo_1.png" alt="">
            <h1>비밀번호 찾기</h1><br>
            <p>아이디와 이메일 주소를 입력하세요.</p>
            <input type="text" placeholder="아이디" name="memId">
            <input type="text" placeholder="이메일" name="email">
            <button type="submit">비밀번호 찾기</button>
        </form>
    </div>
     <jsp:include page="/views/common/footer.jsp" />
</body>
</html>