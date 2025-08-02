<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="./views/mbti/css/sub_test.css?after">
  <link rel="stylesheet" type="text/css" href="./views/mbti/css/sub_test_animation.css">
  
  <style>
  body {
     padding-bottom: 0;
  }
  
  </style>
</head>
<body class="body">
<jsp:include page="/views/common/menubar.jsp" />
  <br><br><br>
  <div class="test-container">
    <section id="main">
    <div class="imgbanner">
      <img src="./views/mbti/img/banner.png" alt="">
     </div>

      

      
      <button type="button" class="btn btn-outline-info" onclick="js:begin()">축BTI 시작하기</button>
    </section>

    <section id="qna">
      <div class="status">
        <div class="statusBar">
         
        </div>

      </div>
      <div class="qBox">

      </div>
      <div class="answerBox">

      </div>
    </section>
    <section id="result" class="mx-auto py-5 px-3">
      <h3>나와 어울리는 축제는</h3>
      <div class="resultname"></div>
      <div id="resultImg">
      
      </div>
      <ul>
        <li><div class="resulttag1"></div></li>
        <li><div class="resulttag2"></div></li>
        <li><div class="resulttag3"></div></li>
      </ul>
      <div class="resultDesc"></div>
      <br>
      <div class="resultDesc1"></div>
      <div id="family">
        <p>많은 축제가 당신을 기다리고있어요!</p>
        <h1><b>축제를 즐기러 가볼까요?</b></h1>
        <button onclick ="location.href='#'">당신과 맞는 축제</button>
      </div>
      <button type="button" class="return" onclick="location.href='<%=contextPath %>/intoMbti.co'">테스트 다시하기</button>
    </section>
    <script src="./views/mbti/js/sub_test.js"></script>
    <script src="./views/mbti/js/sub_test_data.js" charset="utf-8"></script>
    <script src="./views/mbti/js/sub_test_start.js" charset="utf-8"></script>
    <script src="./views/mbti/js/sub_test_share.js" charset="utf-8"></script>
  </div>
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
   <jsp:include page="/views/common/footer.jsp" />
</body>
</html>