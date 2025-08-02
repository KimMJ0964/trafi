<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!--css-->
  <link rel="stylesheet" href="<%=contextPath%>/views/course/css/sub_course.css?after">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" />
<br><br><br>
<div class="wrap">
        <div id="search-form">
        <form id="searchForm" action="course.se" method="post">
            <table>
                <tr>
                    <th><p>지역별</p></th>
                    <td>
                        <div class="area">
                            <input type="checkbox" name="area" id="seoul" value="서울">
                            <label for="seoul">#서울</label>
                            <input type="checkbox" name="area" id="Gyeonggi" value="경기도">
                            <label for="Gyeonggi">#경기</label>
                            <input type="checkbox" name="area" id="Gangwon " value="경상도 ">
                            <label for="Gangwon ">#강원</label>
                            <input type="checkbox" name="area" id="Chungcheong" value="충청도">
                            <label for="Chungcheong">#충청</label>
                            <input type="checkbox" name="area" id="Gyeongsangbuk" value="경상도">
                            <label for="Gyeongsangbuk">#경상</label>
                            <input type="checkbox" name="area" id="Jeolla" value="전라도">
                            <label for="Jeolla">#전라</label>
                            <input type="checkbox" name="area" id="Jeju " value="제주도">
                            <label for="Jeju ">#제주</label>
                        </div>
                    </td>
                </tr>
                
                <tr>
                    <th><p>테마별</p></th>
                    <td>
                        <div class="tema">
                            <input type="checkbox" name="theme" id="history" value="역사">
                            <label for="history">#역사</label>
                            <input type="checkbox" name="theme" id="city" value="도시">
                            <label for="city">#도시</label>
                            <input type="checkbox" name="theme" id="natural" value="자연">
                            <label for="natural">#자연</label>
                            <input type="checkbox" name="theme" id="art" value="예술">
                            <label for="art">#예술</label>
                            <input type="checkbox" name="theme" id="healling" value="힐링">
                            <label for="healling">#힐링</label>
                            <input type="checkbox" name="theme" id="dynamic" value="다이나믹">
                            <label for="dynamic">#다이나믹</label>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="<%=contextPath%>/views/course/js/sub_course-area.js?after"></script>
           <div id="search">   
                <input type="submit" value="검색">
           </div>
         </form> 
         
        <div id="content-box">
            <div class="list-box" id="tour-content">
            <c:forEach var="c" items="${list}">
                <div id="list-con">
                    <div id="list-img">
                     <a href="<%=contextPath%>/courseDetail.cs?cno=${c.courseNo}">
                    <img src="./views/course/img/courseThumbnail/${ c.courseImg}" style="height: 300px; width: 300px;">
                     </a>
                    </div>
                    <h3>${c.courseName}</h3>
                    <div id="under-area">
                        <h5>${c.courseArea}</h5>
                        <button type="button">
                            <img src="./views/sub2_TF/img/Like.png" class="like(this)" onclick="like(this)">
                        </button>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    	<br><br><br>
    	<jsp:include page="/views/common/footer.jsp" />
        <script>
            // 좋아요 버튼 클릭 시 해당 이미지 변경
            function like(element) {
                if (element.src.includes("Like_r.png")) {
                    element.src = "./views/sub2_TF/img/Like.png";
                } else {
                    element.src = "./views/sub2_TF/img/Like_r.png";
                }
            }
        </script>

    </div>
    


</body>
</html>