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
<style>
body {
   margin: 0;
   padding: 0;
   background-color: #ADE8F4;
}

.wrap {
   width: 1246px;
   margin: auto;
   background-color: #ffffff;
    box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.1);
    border-radius: 56px;
    padding:20px;
}

#header, #footer, #aside {
   height: 20%;
}

#header {
   width: 1284px;
   height: 91px;
   background-color: white;
   border-radius: 30px;
   margin: 0 auto;
   margin-top: 30px;
   margin-bottom: 20px;
   display: flex;
   justify-content: space-between;
   align-items: center;
}

#header img {
   width: 100px;
}

.background-img{
   margin-top:30px;
}

.main_image img{
   border-radius:50px;
}


#header .dropdown {
   margin-right: 10px;
}

#header button {
   margin-right: 10px;
   background-color: white;
   font-size: 20px;
   color: black;
   font-weight: bold;
   border-style: none;
}

#header>.dropdown>button {
   background-color: white;
   font-size: 20px;
   color: black;
   font-weight: bold;
}

#footer {
   margin-top: 100px;
   width: 100%;
   height: 300px;
   background-color: #03045E;
}

.main_image {
   position: relative;
}

.main_image_text {
   position: absolute;
   top: 30%;
   left: 50%;
   transform: translate(-50%, -50%);
   color: white;
   font-weight: 900;
   text-shadow: -1px 0px black, 0px 1px black, 1px 0px black, 0px -1px
      black;
   font-size: 50px;
}

#search {
   display: flex;
   align-items: center;
   gap: 10px; /* 간격 조정 */
   margin-top: 10px;
   position: absolute;
   top: 80%;
   left: 58%;
   transform: translate(-30%, -50%);
   text-align: center;
   width: 100%;
}

#searchKeyword {
   background-color: rgb(231, 231, 231);
   border-radius: 40px;
   border-style: none;
   width: 40%;
   height: 35px;
   text-align: center;
}

.btn {
   background-color: #B4DBFF;
   border-radius: 5px;
   border-style: none;
   height: 35px;
   text-align: center;
}

.createBtn {
   float: right;
   border-radius: 10px;
   border-style: none;
   background-color: rgb(177, 192, 255);
   width: 90px;
   height: 35px;
   font-weight: 600;
   color: white;
}

.createBtn:hover {
   background-color: #6FBAFF;
}

.table {
   text-align: center;
}

th {
   background-color: #9fd7ff; /* 연한 파랑색 */
}

.table a{
   text-decoration: none ;
   color: black;
}

.background-img {
   width: 100%;
   border-radius: 20px;
   margin-top:-10px;
}

#createBoardBtn {
   width: 150px;
   border-style: none;
   background-color: #CFE2FF;
   border-radius: 10px;
   font-weight: bold;
   height: 40px;
   left: 0px;
   float: right;
   margin-right: 20px;
}

#createBoardBtn:hover {
   background-color: #a1c6ff;
}

/* 반응형 디자인 - 481px ~ 768px */
@media ( max-width : 768px) and (min-width: 481px) {
   .wrap {
      width: 100%;
      border-radius: 10px;
      box-shadow: none;
      border: none;
      
   }
   #header {
      width: 100%;
      height: 70px;
      margin-top: 10px;
      margin-bottom: 10px;
   }
   .main_image img {
      width: 100%;
      border-radius: 10px;
   }
   .main_image_text {
      font-size: 30px;
      margin-top: 5px;
   }
   #searchKeyword {
      width: 60%;
   }
   #search {
      top: 70%;
      left: 60%;
      transform: translate(-50%, -50%);
   }
   .createBtn {
      width: 100px;
      height: 40px;
   }
   .background-img {
      width: 400px;
      border-radius: 20px;
   }
   #createBoardBtn {
      width: 120px;
      border-style: none;
      background-color: #CFE2FF;
      border-radius: 10px;
      font-weight: bold;
      height: 30px;
      left: 0px;
      float: right;
      margin-right: 20px;
      font-size: 11px;
   }
}

/* 모바일 화면 (최대 480px 이하) */
@media ( max-width : 480px) {
   .wrap {
      width: 100%;
      margin: 0;
      border: none;
      box-shadow: none;
      padding: 0 10px;
   }
   #header {
      width: 100%;
      height: 70px;
      margin-top: 10px;
      margin-bottom: 10px;
   }
   .main_image img {
      width: 100%;
      border-radius: 10px;
   }
   .main_image_text {
      font-size: 25px;
   }
   #searchKeyword {
      width: 80%;
   }
   #search {
      top: 90%;
      left: 50%;
      transform: translate(-50%, -50%);
   }
   .createBtn {
      width: 90px;
      height: 35px;
   }
   .background-img {
      width: 400px;
      border-radius: 20px;
   }
   #createBoardBtn {
      width: 120px;
      border-style: none;
      background-color: #CFE2FF;
      border-radius: 10px;
      font-weight: bold;
      height: 30px;
      left: 0px;
      float: right;
      margin-right: 20px;
      font-size: 11px;
   }
}

</style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />
	<br><br><br>
	<br><br>
	<br>
	<div class="wrap">
		<div class="container mt-3">
			<div class="main_image">
				<img src="<%=contextPath%>/views/board/img/boardMain.png"
					class="background-img">
				<h1 class="main_image_text">커뮤니티</h1>
				<div id="search">
					<form action="search.bo" class="d-flex">
						<input type="hidden" name="cpage" value="1"> <select
							class="form-select me-2" name="condition" style="width: 150px;">
							<option value="writer">작성자</option>
							<option value="title">제목</option>
							<option value="type">유형</option>
						</select> <input type="text" class="form-control me-2" name="keyword"
							value="${keyword}" placeholder="검색어를 입력하세요" style="flex-grow: 1;">
						<button type="submit" class="btn btn-primary"
							style="width: 150px;">검색</button>
					</form>
				</div>

				<c:if test="${not empty condition}">
					<script>
			        	window.onload = function(){
			        		const opt = document.querySelector("#search-area option[value=${condition}]");
			        		opt.setAttribute("selected", true);
			        	}
			        </script>
				</c:if>

			</div>
			<br> <br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>유형</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<!--
                    <tr onClick="location.href='board.jsp'">
                        <td>1</td>
                        <td>첫번째 게시글</td>
                        <td>user01</td>
                        <td>125</td>
                        <td>2024-01-01</td>
                    </tr>
                    
                     -->
					<c:forEach var="b" items="${list}">
						<tr>
							
							<td><a href="detail.bo?bno=${b.commNo}">${b.commNo}</td>
							<td width="400"><a href="detail.bo?bno=${b.commNo}">${b.title}</td>
							<td><a href="detail.bo?bno=${b.commNo}">${b.type}</td>
							<td><a href="detail.bo?bno=${b.commNo}">${b.memId }</td>
							<td><a href="detail.bo?bno=${b.commNo}">${b.viewCount }</td>
							<td><a href="detail.bo?bno=${b.commNo}">${b.createDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<c:choose>
				<c:when test="${ empty loginUser }">
				</c:when>
				<c:otherwise>
				<button id="createBoardBtn"
					onClick="location.href='views/board/createBoard.jsp'">글쓰기</button>
				</c:otherwise>
			</c:choose>
			<br>
			<!-- Pagination -->
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center mt-3">
					<c:if test="${pi.currentPage ne 1}">
						<li class="page-item"><c:choose>
								<c:when test="${empty condition}">
									<a class="page-link"
										href="board.bo?cpage=${pi.currentPage - 1}">이전</a>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="search.bo?cpage=${pi.currentPage - 1}&condition=${condition}&keyword=${keyword}">이전</a>
								</c:otherwise>
							</c:choose></li>
					</c:if>

					<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
						<li
							class="page-item <c:if test='${i == pi.currentPage}'>active</c:if>">
							<c:choose>
								<c:when test="${empty condition}">
									<a class="page-link" href="board.bo?cpage=${i}">${i}</a>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="search.bo?cpage=${i}&condition=${condition}&keyword=${keyword}">${i}</a>
								</c:otherwise>
							</c:choose>
						</li>
					</c:forEach>

					<c:if test="${pi.currentPage ne pi.maxPage}">
						<li class="page-item"><c:choose>
								<c:when test="${empty condition}">
									<a class="page-link"
										href="board.bo?cpage=${pi.currentPage + 1}">다음</a>
								</c:when>
								<c:otherwise>
									<a class="page-link"
										href="search.bo?cpage=${pi.currentPage + 1}&condition=${condition}&keyword=${keyword}">다음</a>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<br><br><br>
 <jsp:include page="/views/common/footer.jsp" />
	<script>
    function clickDetailPage(boardNo){
        location.href = "<%=contextPath%>
		/detail.bo?bno=" + boardNo;
		}
	</script>
</body>
</html>