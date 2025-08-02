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
<title>커뮤니티</title>

<!-- Latest compiled and minified CSS -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
   rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
   crossorigin="anonymous">
<link rel="stylesheet" href="../menubar footer/menubar.css">
<link rel="stylesheet" href="./mainPage.css?after">

<script
   src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
   integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
   integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
   crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3643b6hh5b"></script>
</head>
<body>
   <jsp:include page="/views/common/menubar.jsp" />
   <br><br><br>
   <div class="container">
      <div id="media-section">
         <div id="title">
            <span class="title-font" style="font-size: 24px; font-weight: 800;">♬ 영상으로 즐기는 계절 축제 ♪</span>
         </div>

         <div class="hiperlink-container">
            <div class="hiperlink">
               <iframe class="media" width="410" height="225"
                  src="https://www.youtube.com/embed/zPNwGulo3ts?si=3eFTPjG2E9MIJb50"
                  title="YouTube video player" frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

               <iframe class="media" width="410" height="225"
                  src="https://www.youtube.com/embed/xyh_0wTokh8?si=tlyUCt6h4kHTYXeu"
                  title="YouTube video player" frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
               <iframe width="410" height="225" src="https://www.youtube.com/embed/7LRJSCZq_D8?si=SM94lc4aWjZUdz34" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

               <iframe width="410" height="225" src="https://www.youtube.com/embed/XN227v4-w1s?si=pfk6_vu3wKfmeYrv" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
               
               
            </div>

            
            </div>
         </div>
      </div>
      <br> <br>
      <div class="map-sidebar-container">
         <!-- 지도 영역 -->
         <div id="map"></div>

         <!-- 관광 명소 리스트 영역 -->
         <div class="sidebar">
            <h2 align="center" style="font-weight: 800;">인기관광명소 위치 찾기</h2>
            <!-- 인기 관광 명소 리스트 -->
             <ul id="topTouristsList"></ul>
            <div class="footer-link">
               <a href="<%=contextPath %>/tourfestivallist.tf?cpage=1">여러 관광지 보러가기 &gt;</a>
            </div>
         </div>
      </div>
      <!-- 계절별 관광지 보기 링크 -->

      <div class="tab_content">
         <input type="radio" name="tabmenu" id="tab01"> <label
            for="tab01">추천 관광명소</label> <input type="radio" name="tabmenu"
            id="tab02" checked> <label for="tab02">인기축제</label> <input
            type="radio" name="tabmenu" id="tab03"> <label for="tab03">축제
            MBTI</label> <input type="radio" name="tabmenu" id="tab04"> <label
            for="tab04">지역 룰렛</label>

         <div class="conbox con1">
         <br>
            <h1>TRAFI의 인기 관광명소</h1>
            <div id="pop-tour">
            </div>
         </div>
         <div class="conbox con2">
            <div class="group">
                
              </div>
        </div>
        <script src='https://unpkg.co/gsap@3/dist/gsap.min.js'></script>
        <script  src="./content02.js"></script>
        <div class="conbox con3">
           <br>
            <img src="./views/mbti/img/banner.png" style="height: 300px;">
            <h1>나와 맞는 축제는?</h1>
           <button onclick="location.href='<%=contextPath %>/intoMbti.co'">축제 MBTI 하러 가기</button>
        </div>
        <div class="conbox con4">
            <h1>어디로 떠나야할 지 모를 때?</h1>
            <button onclick="getRandomArea()">지역 룰렛 돌리기</button>
            <div id="area-result">
                <p id="area-text"></p><h1> 가자!</h1>
            </div>
        </div>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <div id="bottom-section" align="center">
         <h1 style="font-size: 80px; font-weight: bold; color:gray;">로그인하고 여행가자 !</h1><br>
         <button id="bottom-login-btn" style="margin-top:50px; background-color: #FFC3C3;
               width: 600px; height: 75px; color: white; border-radius: 10px; font-size: 30px; border-style: none;">로그인</button>
               <br><br><br><br><br><br><br><br><br><br><br>
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
               <!--  <img src="<%=contextPath %>/resource/footerLogo.png" alt="Trafi Logo" id="footer-logo"> 	-->
            </div>
				<p>Copyright © 2024-2024 Trafi Information Educational Institute
					All Right Reserved</p>
			</div>
		</div>
      </div>
      </div>
   </div>
   <br>
   <script  src="./mainPage.js"></script>
    <script>
        $(document).ready(function(){
           var allTourists = [];
            $.ajax({
                url: "touristRank.mp",
                method: "GET",
                dataType: "json",
                success: function(data) {
                    var list = $('#topTouristsList');
                    list.empty(); // 기존 리스트 비우기

                    // 첫 6개 데이터만 출력
                    var topSixTourists = data.slice(0, 6); // 데이터의 첫 6개 항목 선택
               var number = 1;
                    
                    topSixTourists.forEach(function(tourist) {
                        list.append(
                                  '<li class="tour-li-item" data-lat="' + tourist.tourLat + '" data-lng="' + tourist.tourLong + '">' 
                                  + number + "위 ▷ " + tourist.tourName + '</li><br>'
                              ); // TOUR_NAME, tourLat, tourLong 출력
                              number = number + 1;
                    });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('Error fetching top tourists:', textStatus, errorThrown);
                }
            });
            
            $.ajax({
                url: "touristRankTwo.mp",
                method: "GET",
                dataType: "json",
                success: function(data) {
                    // 데이터 병합
                    allTourists = allTourists.concat(data.slice(0, 4)); // 첫 4개 데이터 추가
                    updateTourDisplay();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('Error fetching top tourists:', textStatus, errorThrown);
                }
            });

            // 투어 이름을 업데이트하는 함수
            function updateTourDisplay() {
                var popTourDiv = $('#pop-tour');
                popTourDiv.empty(); // 기존 내용 비우기

                allTourists.slice(0, 4).forEach(function(tourist, index) {
                    // 조건문을 사용하여 첫 번째, 두 번째, 세 번째, 네 번째 경우를 다르게 처리
                    if (index === 0) {
                        popTourDiv.append('<div id="first-tour" class="item-01" style="height: 40%;"><div class="up-line01"  style="height: 200px;"> <div class="photo01"><a href="detail.tf?tno=' + tourist.tourNo + '"><img src="./resource/tourThumb/'+ tourist.tourImg +'" height="190px" width="190px"></a></div><div class="desc01"><h1>#' + tourist.tourTema + '</h1><br><h3>' + tourist.tourName + '</h3><h5>' + tourist.tourArea + '</h5></div> </div><div class="under-line01"></div></div>');
                    } else if (index === 1) {
                       popTourDiv.append('<div id="second-tour" class="item-01" style="height: 40%;"><div class="up-line01" style="height: 200px;"> <div class="photo01"><a href="detail.tf?tno=' + tourist.tourNo + '"><img src="./resource/tourThumb/'+ tourist.tourImg +'" height="190px" width="190px"></a></div><div class="desc01"><h1>#' + tourist.tourTema + '</h1><br><h3>' + tourist.tourName + '</h3><h5>' + tourist.tourArea + '</h5></div> </div><div class="under-line01"></div></div>');
                    } else if (index === 2) {
                       popTourDiv.append('<div id="third-tour" class="item-02" style="height: 40%;"><div class="up-line02" style="height: 200px;"> <div class="photo02"><a href="detail.tf?tno=' + tourist.tourNo + '"><img src="./resource/tourThumb/'+ tourist.tourImg +'"  height="190px" width="190px"></a></div><div class="desc02"><h1>#' + tourist.tourTema + '</h1><br><h3>' + tourist.tourName + '</h3><h5>' + tourist.tourArea + '</h5></div> </div><div class="under-line02"></div></div>');
                    } else if (index === 3) {
                       popTourDiv.append('<div id="fourth-tour" class="item-02" style="height: 40%;"><div class="up-line02" style="height: 200px;"> <div class="photo02"><a href="detail.tf?tno=' + tourist.tourNo + '"><img src="./resource/tourThumb/'+ tourist.tourImg +'" height="190px" width="190px"></a></div><div class="desc02"><h1>#' + tourist.tourTema + '</h1><br><h3>' + tourist.tourName + '</h3><h5>' + tourist.tourArea + '</h5></div> </div><div class="under-line02"></div></div>');
                    }
                });
            }
            
            $.ajax({
                url: "festivalIntro.mp",
                method: "GET",
                dataType: "json",
                success: function(data) {
                    var list = $('.group');
                    list.empty(); // 기존 리스트 비우기

                    // 첫 6개 데이터만 출력
                    var topFourFestivals = data.slice(0, 4); // 데이터의 첫 6개 항목 선택

                    topFourFestivals.forEach(function(festival) {
                        list.append('<div class="item"><div class="img-con" ><a href="fesdatail.tf?fno='+ festival.fsNo +'"><img src="./resource/festival/'+ festival.fsImg +'" alt="" style="height: 250px;" /></a></div><div class="text-con"><h1>' + festival.fsName + '</h1><h3>' + festival.fsArea + '</h3><h5>#'+ festival.fsTema +'</h5></div> </div>'); // TOUR_NAME 출력
                    });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('Error fetching top tourists:', textStatus, errorThrown);
                }
            });
        });
        
        document.getElementById("bottom-login-btn").addEventListener("click", function() {
            location.href = "<%= contextPath %>/intoLogin.co";
        });
        
        const areas = [
           "서울로",
           "부산으로",
           "제주도로",
           "강릉으로",
           "경주로",
           "전주로",
           "대구로",
           "인천으로",
           "광주로",
           "포항으로"];

        function getRandomArea() {
           const randomIndex = Math.floor(Math.random() * areas.length);
           const selectedArea = areas[randomIndex];
           document.getElementById("area-text").innerText = selectedArea;
           
        }
        
        var currentMarker = null;
        
        $(document).on('click', '.tour-li-item', function() {
            // 모든 <li>의 글씨를 기본 상태로 설정
            $('.tour-li-item').css('font-weight', 'normal');
            
            // 클릭한 <li>의 글씨만 굵게 설정
            $(this).css('font-weight', '800');
            
            var lat = $(this).data('lat');
            var lng = $(this).data('lng');
            
            // 새로운 중심 좌표 생성
            var newCenter = new naver.maps.LatLng(lat, lng);
            
            // 지도의 중심 좌표를 클릭한 관광지의 좌표로 변경
            map.setCenter(newCenter);
            
            // 기존 마커가 있다면 삭제
            if (currentMarker) {
                currentMarker.setMap(null);
            }

            // 새로운 마커 생성
            currentMarker = new naver.maps.Marker({
                position: newCenter,
                map: map
            });
        });
        
        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(37.5665, 126.9780),  // 초기 좌표 (서울)
            zoom: 10
        });

    </script>


</body>
</html>