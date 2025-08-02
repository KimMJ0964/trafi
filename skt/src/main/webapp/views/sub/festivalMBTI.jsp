<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="common.PageInfo, java.util.ArrayList, com.skt.board.model.vo.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>축 MBTI</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/sub_test.css">
<link rel="stylesheet" href="./css/sub_test_animation.css">
<style>
.container {
	width: 100%;
	height: auto;
}
</style>
</head>
<body class="body">
	<div class="container">
		<section id="main">
			<img src="" alt="">
			<h3>나와 어울리는 축제는?</h3>
			<button type="button" class="btn btn-outline-info"
				onclick="js:begin()">축BTI 시작하기</button>
		</section>

		<section id="qna">
			<div class="status">
				<div class="statusBar">
					<!-- <div id="tic"><img src="./images/ticket.png" width="20%"></div> -->
				</div>
				<!-- <div id="fes"><img src="./images/festival_icon.png"  width="20%"></div> -->
			</div>
			<div class="qBox"></div>
			<div class="answerBox"></div>
		</section>
		<section id="result" class="mx-auto my-4 py-5 px-3">
			<h3>나와 어울리는 축제는</h3>
			<div class="resultname"></div>
			<div id="resultImg"></div>
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
				<h1>
					<b>축제를 즐기러 가볼까요?</b>
				</h1>
				<button onclick="location.href='#'">당신과 맞는 축제</button>
			</div>
			<hr>
			<button type="button" class="return">
				<a href="./sub_test.html">테스트 다시하기</a>
			</button>
		</section>
		<script src="./js/sub_test.js"></script>
		<script src="./js/sub_test_data.js" charset="utf-8"></script>
		<script src="./js/sub_test_start.js" charset="utf-8"></script>
		<script src="./js/sub_test_share.js" charset="utf-8"></script>
	</div>
	<br><br>
	 <jsp:include page="/views/common/footer.jsp" />
</body>
</html>