<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>나만의 여행코스</title>
<link rel="stylesheet" href="./css/sub_mycourse.css">
<%
   String contextPath = request.getContextPath();
%>
<body>
<jsp:include page="/views/common/menubar.jsp" />
<br><br>
	<div class="wrap">
		<img src="./img/coursebanner.png" alt="" id="coursebanner">
		<div class="container">
			<div class="container-header">
				<img src="./img/mapImg.png" alt="">
				<p>나만의 코스목록</p>
			</div>

			<div class="container-contents">
				<table>
					<thead>
						<th>번호</th>
						<th>제목</th>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>강원도 힐링여행</td>
						</tr>
						<tr>
							<td>1</td>
							<td>강원도 힐링여행</td>
						</tr>
						<tr>
							<td>1</td>
							<td>강원도 힐링여행</td>
						</tr>
						<tr>
							<td>1</td>
							<td>강원도 힐링여행</td>
						</tr>
						<tr>
							<td>1</td>
							<td>강원도 힐링여행</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="container-footer">
				<a href="<%=contextPath %>/createMyCourseToPage.mc"> <img src="./img/plusImg.png"
					alt="">
					<p>여행코스만들기</p>
				</a>
			</div>
		</div>
	</div>
	 <jsp:include page="/views/common/footer.jsp" />
</body>
</html>