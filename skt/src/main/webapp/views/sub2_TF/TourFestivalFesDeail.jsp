<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>축제 상세페이지</title>
    <link rel="stylesheet" href="./views/sub2_TF/css/TourFestivalResDetail.css?after">
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3643b6hh5b"></script> 
    
    <style>
		#map {
			width: 900px;
			height: 400px;
			border: 5px solid #6FBAFF;
			border-radius: 10px;
		}
		
		body {
			margin 0;
			overflow-x: hidden;
		}
		
		.interest-button button{
   width: 400px; height:50px; padding: 10px; background:white; border: #6FBAFF solid 2px; color:#6FBAFF;
   border-radius:20px;
}

.interest-button button:hover{
   color:white;
}
</style>
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" />
<br><br><br>
    <div class="container">
        <div class="header">
            <img src="./resource/festival/${f.fsImg }" alt="축제 이미지" class="festival-image">
            <div class="festival-info">
                <h1>${f.fsName }</h1>
                <ul class="festival-details">
                    <li><img src="./views/sub2_TF/img/calendar.png" alt="기간" class="icon">${f.fsStart } ~ ${f.fsEnd }</li>
                    <li><img src="./views/sub2_TF/img/location.png" alt="위치" class="icon">${f.fsArea }</li>
                    <li><img src="./views/sub2_TF/img/link.png" alt="링크" class="icon">${f.fsUrl }</li>
                </ul>
            </div>
        </div>

        <div class="description" style="background: linear-gradient(rgba(255, 255, 255, 0.80), rgba(255, 255, 255, 0.80)), url(./views/sub2_TF/img/second.png);
    border-radius: 20px;">
            
            <p>${f.fsDct }</p>
        </div>
        <!-- 관심등록 버튼 추가 -->
        <div class="interest-button" align="center">
            <form action="fsInterested.ft" method="post">
                <input type="hidden" name="fsNo" value="${f.fsNo}" />
                <button type="submit" class="btn-interest">관심등록</button>
            </form>
        </div>
        <br><br>
        
    <div id="map"></div>
    </div>
    
	<br><br><br>
    <jsp:include page="/views/common/footer.jsp" />
        <script>
        var mapOptions = {
            center: new naver.maps.LatLng(${f.fsLat}, ${f.fsLong}),
            zoom: 18
        };

        var map = new naver.maps.Map('map', mapOptions);

        // 마크 추가
        var marker = new naver.maps.Marker({
            position: new naver.maps.LatLng(${f.fsLat}, ${f.fsLong}),
            map: map,
            title: '${f.fsName}' // 마우스 오버 시 표시될 제목
        });
    </script>
</body>
</html>