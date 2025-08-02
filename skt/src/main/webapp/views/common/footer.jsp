<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
   String contextPath = request.getContextPath();
%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!--css-->
<link rel="stylesheet" href="./views/common/css/footer.css">

<style>
#footer-container {
}

#footer{
    width: 100%;height: 250px;
    background-color: #03045E;
    color: #fff;
    margin: 0;
}
#footer-con{
    width: 100%; height: 200px;
    padding-top: 30px;
}

#footer>div{
    width: 100%;
}

#footer_1{
    height: 55px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    gap: 10px;
}

#footer_1>a{
    text-decoration: none;
    color: #fff;
    font-size: 16px;
    font-weight: 500;
    padding-left: 40px;
}

#footer_2{
    padding-left: 40px;
    position: relative;
}

#footer_2>p{
    width: 100%;
    font-size: 12px;
    font-weight: 500;
}

#footer_2>p:nth-child(1){
    font-size: 14px;
}
#footer-info{
    margin-left: 40px;
}

#footer_2 > p:last-child{
    width: 98%;
    font-size: 11px;
    text-align: right;
    padding-top: 20px;
    padding-right: 40px;
}

#footer-logo{
    max-width: 150px; /* 로고 크기 조정 */
    height: auto;
    margin-bottom: 10px;
    position: absolute;
    right: 40px;
    top: -30px;
}
</style>
</head>
<body>
	<div id="footer-container">
		<div id="footer">
			<div id="footer_1">
				<a href="">이용약관</a> | <a href="">개인정보처리방침</a> | <a href="">위치기반서비스이용약관</a>
				| <a href="">저작권정책</a> | <a href="">Q&A</a>
			</div>
			<div id="footer_2">
				<p>KH정보교육원 ｜ 사업자등록번호 : 980-86-2633 ｜ 사업자등록번호 : 285-40-7633 ｜ 서울
					강남 제2014-01호 ｜ 대표자 : 김가영 ｜ 책임자 : 김민재 ｜ 개인정보관리책임자 : 신서희</p>
				<p>
					강남지원 256관 : 서울특별시 강남구 테헤란로14길 6 남도빌딩 2F, 3F, 4F, 5F, 6F <br>
					강남지원 2관 : 서울특별시 강남구 테헤란로10길 9 그랑프리 빌딩 4F, 5F, 7F <br> 강남지원 3관
					: 서울특별시 강남구 테헤란로 130 호산빌딩 5F, 6F <br> 종로지원 : 서울특별시 중구 남대문로 120
					그레이츠 청계(구 대일빌딩) 2F, 3F <br> 당산지원 : 서울특별시 영등포구 선유동2로 57
					이레빌딩(구관) 19F, 20F <br>
				</p>
			<div id="footer-info">
                <img src="<%=contextPath %>/resource/footerLogo.png" alt="Trafi Logo" id="footer-logo">
            </div>
				<p>Copyright © 2024-2024 Trafi Information Educational Institute
					All Right Reserved</p>
			</div>
		</div>
	</div>
</body>
</html>