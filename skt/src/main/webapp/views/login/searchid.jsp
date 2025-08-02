<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="./views/login/css/searchid.css">
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
<br><br><br>
    <div class="container">
        <form action="<%=contextPath %>/searchId.me"  method="post">
            <img src="<%=contextPath %>/views/login/img/logo_1.png" alt="로고">
            <h1>아이디 찾기</h1><br>
            <p>전화번호 또는 이메일 주소를 입력하세요.</p>
            <input type="text" placeholder="전화번호 or 이메일" name="input">
            <button type="submit">아이디 찾기</button>
        </form>
    </div>
     <jsp:include page="/views/common/footer.jsp" />
</body>
</html>