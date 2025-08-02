<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>나만의 여행코스 만들기</title>
<link rel="stylesheet" href="./mycourse.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"
	integrity="sha256-Fb0zP4jE3JHqu+IBB9YktLcSjI1Zc6J2b6gTjB0LpoM="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
<script src="./mycourse.js"></script>

<style>
body {
	margin: 0 auto;
	overflow-x: hidden;
}
.wrap {
	width: 100%;
	display: flex;
	justify-content: center;
}

header h1 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

.planner {
	width: 1184px;
	max-width: 1284px;
	margin: 50px;
	padding: 10px;
	display: flex;
	justify-content: space-between;
	height: 650px;
}

.course-details, .preview-list {
	width: 42%;
	background-color: #f0f0f0;
	padding: 15px;
	border-radius: 10px;
	overflow-y: auto;
	max-height: 100%;
	padding: 40px;
	background-color: #ffffff;
	box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.1);
	border-radius: 26px;
}

.preview-list h2 {
	font-size: 18px;
	margin-bottom: 30px;
	background-color: #FFC3C3;
	border-radius: 50px;
	padding: 10px;
	text-align: center;
	border-radius: 50px;
}

.course-header h2 {
	font-size: 18px;
	margin-bottom: 30px;
	background-color: #FFC3C3;
	border-radius: 50px;
	text-align: center;
	border-radius: 50px;
}

.course-header h2 input {
	padding: 10px 0;
	width: 100%;
	height: 100%;
	font-size: 18px;
	border: none;
	border-radius: 50px;
	background-color: #33333300;
	text-align: center;
}

.day {
	margin-bottom: 20px;
}

.day h3 {
	text-align: center;
	padding-bottom: 5px;
	margin-bottom: 5px;
	border-bottom: #5bc0de solid 2px;
}

.time-place {
	display: flex;
	justify-content: space-around;
	margin-bottom: 5px;
	background-color: #DFF0FF;
	padding: 10px;
	border-radius: 50px;
	margin: 10px 0;
	font-size: 15px;
}

.actions {
	display: flex;
	justify-content: space-between;
}

.actions button {
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.plus {
	width: 30%;
	position: relative;
	position: absolute;
	left: 130px;
	top: 755px;
}

.plus img {
	margin: 0 auto;
	width: 8%;
	height: 8%;
	display: flex;
	background-color: #FFC3C3;
	border-radius: 50px;
	padding: 5px;
}

.actions button {
	border-radius: 10px;
}

.preview-list .preview-item {
	margin-bottom: 15px;
}

.preview-list img {
	width: 80%;
	border-radius: 5px;
}

.preview-item p {
	text-align: center;
	margin-top: 5px;
	margin-bottom: 5px;
	color: #333;
	text-align: left;
	font-weight: 900;
}

.course-details::-webkit-scrollbar, .preview-list::-webkit-scrollbar {
	width: 15px;
}

.course-details::-webkit-scrollbar-thumb, .preview-list::-webkit-scrollbar-thumb
	{
	background-color: #afaeae;
	border-radius: 10px;
}

.course-details::-webkit-scrollbar-track, .preview-list::-webkit-scrollbar-track
	{
	background-color: #f0f0f0;
	border-radius: 10px;
	margin-right: 30px;
}

.content-footer {
	position: absolute;
	bottom: 20px;
}

.content-footer button {
	padding: 10px 20px;
	font-size: 16px;
	cursor: pointer;
	border: none;
	border-radius: 50px;
	background-color: #FFC3C3;
	color: white;
	width: 200px;
	margin: 0 auto;
}

.content-footer button:hover {
	background-color: rgb(255, 162, 162);
}

.action-buttons {
	width: 200px;
	display: flex;
	justify-content: space-between;
	background-color: #ffffff;
	padding: 10px;
	border-radius: 50px;
	position: absolute;
	top: 30px;
	right: 70px;
	margin: 1px;
}

.action-buttons button {
	padding: 10px 15px;
	border: none;
	border-radius: 50px;
	background-color: #FFC3C3;
	color: white;
	cursor: pointer;
	font-size: 16px;
	display: flex;
	align-items: center;
}

.action-buttons button:hover {
	background-color: rgb(255, 162, 162);
}

.time-place input {
	width: 50%;
	text-align: center;
	border: none;
	background-color: #f9f9f900;
	padding: 0px;
}

.time-place p {
	width: 50%;
	text-align: center;
	border: none;
	background-color: #f9f9f900;
	margin: 0;
}

.delete-icon {
	font-size: 20px;
	color: #5a5a5a;
	margin-left: 10px;
	cursor: pointer;
	transition: color 0.3s ease;
	display: flex;
	align-items: center;
}

.delete-icon:hover {
	color: #fd6d6d;
}

.login-button {
    background-color: #87CEEB;  /* 버튼 배경을 밝은 하늘색으로 설정 */
    color: white;  /* 텍스트 색상 */
    font-size: 18px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    transition: background-color 0.3s ease;
    
}

.login-button:hover {
    background-color: #5dade2;  /* 버튼 호버시 더 어두운 하늘색 */
}
</style>
</head>

<body>
	<jsp:include page="/views/common/menubar.jsp" />
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="wrap">
		<div class="planner">
			<div class="course-details" id="contentToSave">
				<!-- ID 추가 -->
				<div class="course-header">
					<h2>
						<input type="text" placeholder="제목을 입력하세요">
					</h2>
				</div>
				<div class="plus">
					<img src="./views/sub/img/plusImg.png" alt="">
				</div>
				<div class="actions">
					<!-- 추가 버튼들 -->
				</div>
			</div>

			<div class="preview-list">
				<h2>나의 관심목록</h2>

				<c:choose>
					<c:when test="${ empty loginUser }">
						<h3 align="center">로그인을 하시면 관심목록과 함께 만들 수 있습니다!
						<button style="margin-top: 20px;"class="login-button" onclick="window.location.href='<%= contextPath %>/intoLogin.co'">로그인</button></h3>
							
					</c:when>
					<c:otherwise>
						<c:if test="${not empty interestedList}">
							<c:forEach var="interested" items="${interestedList}">
								<div class="preview-item">
									<img src="/Skt/resource/festival/${interested.fsImg}"
										style="height: 290px; width: 205px;" alt="축제 이미지">
									<div class="text">
										<strong>${interested.fsName}</strong><br> 날짜 :
										${interested.fsStart}<br> 지역 : ${interested.fsArea}
									</div>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty interestedList}">
							<p>관심 있는 축제가 존재하지 않습니다.
						</c:if>
						<hr style="width: 90%;">
						<c:if test="${not empty interestedListTwo}">
							<c:forEach var="interestedTwo" items="${interestedListTwo}">
								<div class="preview-item">
									<img src="/Skt/resource/tourThumb/${interestedTwo.tourImg}"
										alt="투어 이미지">
									<div class="text">
										<strong>${interestedTwo.tourName}</strong><br> 테마 :
										${interestedTwo.tourTema}<br> 계절 :
										${interestedTwo.tourSeason}
									</div>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${empty interestedListTwo}">
							<p>관심 있는 투어가 존재하지 않습니다.
						</c:if>
					</c:otherwise>
				</c:choose>

			</div>

			<!-- PDF로 저장 버튼 추가 -->
			<div class="content-footer"></div>
		</div>
	</div>
	<br><br><br><br><br>
	 <jsp:include page="/views/common/footer.jsp" />
	<script>
    window.onload = function() {
        // plusImg를 클릭했을 때 두 개의 버튼이 나타나도록 함
        document.querySelector('.plus img').addEventListener('click', function() {
            // 이미 버튼이 생성된 경우 중복 생성 방지
            if (document.querySelector('.action-buttons')) return;

            // 버튼을 추가할 div 생성
            const actionButtons = document.createElement('div');
            actionButtons.classList.add('action-buttons');

            const addDayButton = document.createElement('button');
            addDayButton.textContent = '다음날';
            addDayButton.classList.add('add-day');

            const addCourseButton = document.createElement('button');
            addCourseButton.textContent = '다음코스';
            addCourseButton.classList.add('add-course');

            actionButtons.appendChild(addDayButton);
            actionButtons.appendChild(addCourseButton);

            // .plus 안에 버튼 추가
            const plusDiv = document.querySelector('.plus');
            plusDiv.appendChild(actionButtons);

            // 버튼 스타일 조정
            actionButtons.style.position = 'absolute';

            // N일차 버튼을 클릭하면 새로운 day를 추가하는 기능
            addDayButton.addEventListener('click', function() {
                const courseDetails = document.querySelector('.course-details');

                // 이미 존재하는 일차의 개수를 세고 그 다음 일차를 추가
                const dayCount = courseDetails.querySelectorAll('.day').length + 1;

                // 새로운 일차를 추가할 div 생성
                const newDay = document.createElement('div');
                newDay.classList.add('day');

                // 일차를 위한 제목 생성
                const newDayTitle = document.createElement('h3');
                newDayTitle.textContent = dayCount + `일차`;

                // 삭제 아이콘 생성
                const deleteDayIcon = document.createElement('i');
                deleteDayIcon.classList.add('fas', 'fa-times', 'delete-icon');
                deleteDayIcon.style.cursor = 'pointer';

                // 일차 제목 옆에 삭제 아이콘 추가
                newDayTitle.appendChild(deleteDayIcon);
                newDay.appendChild(newDayTitle);
                courseDetails.appendChild(newDay);

                // 삭제 아이콘 클릭 시 일차 삭제 기능
                deleteDayIcon.addEventListener('click', function() {
                    newDay.remove();
                });

                // actionButtons 사라지기
                actionButtons.remove();
            });

            // 다음코스 버튼을 클릭하면 time-place를 추가하는 기능
            addCourseButton.addEventListener('click', function() {
                const lastDay = document.querySelector('.course-details .day:last-child');

                if (!lastDay) {
                    alert('먼저 "다음날"을 추가하세요.');
                    return;
                }

                // 시간과 관광지를 입력할 폼 생성
                const timePlaceForm = document.createElement('div');
                timePlaceForm.classList.add('time-place');

                const timeInput = document.createElement('input');
                timeInput.type = 'text';
                timeInput.placeholder = '시간 입력 (예: 9:00)';

                const placeInput = document.createElement('input');
                placeInput.type = 'text';
                placeInput.placeholder = '관광지/축제 입력';

                // 삭제 아이콘 생성
                const deleteCourseIcon = document.createElement('i');
                deleteCourseIcon.classList.add('fas', 'fa-times', 'delete-icon');
                deleteCourseIcon.style.cursor = 'pointer';

                // 시간과 관광지 폼, 삭제 아이콘을 함께 추가
                timePlaceForm.appendChild(timeInput);
                timePlaceForm.appendChild(placeInput);
                timePlaceForm.appendChild(deleteCourseIcon);

                lastDay.appendChild(timePlaceForm);

                // 삭제 아이콘 클릭 시 해당 코스 삭제 기능
                deleteCourseIcon.addEventListener('click', function() {
                    timePlaceForm.remove();
                });

                actionButtons.remove();

                // 시간 입력 후 엔터를 누르면 텍스트로 변경
                timeInput.addEventListener('keydown', function(event) {
                    if (event.key === 'Enter') {
                        const timeText = document.createElement('p');
                        timeText.textContent = timeInput.value;
                        timePlaceForm.replaceChild(timeText, timeInput);
                    }
                });

                // 관광지 입력 후 엔터를 누르면 텍스트로 변경
                placeInput.addEventListener('keydown', function(event) {
                    if (event.key === 'Enter') {
                        const placeText = document.createElement('p');
                        placeText.textContent = placeInput.value;
                        timePlaceForm.replaceChild(placeText, placeInput);
                    }
                });
            });
        });

        // PDF로 저장하는 버튼 추가
        const savePdfButton = document.createElement('button');
        savePdfButton.textContent = 'PDF로 저장';
        document.querySelector('.content-footer').appendChild(savePdfButton);

        savePdfButton.addEventListener('click', function() {
            const contentToSave = document.querySelector('.course-details');

            // 엑스 아이콘과 plus 숨기기
            const deleteIcons = contentToSave.querySelectorAll('.delete-icon');
            const plusDiv = document.querySelector('.plus');

            deleteIcons.forEach(icon => icon.style.display = 'none');
            plusDiv.style.display = 'none';

            // PDF 설정
            const options = {
                margin: 0.5,
                filename: 'course-details.pdf',
                image: { type: 'jpeg', quality: 0.98 },
                html2canvas: { scale: 2, backgroundColor: 'white' }, // 배경 흰색
                jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
            };

            // PDF로 저장
            html2pdf().from(contentToSave).set(options).save().then(() => {
                // 숨긴 요소 다시 보이게 하기
                deleteIcons.forEach(icon => icon.style.display = 'inline');
                plusDiv.style.display = 'block';
            });
        });
    };

    </script>
</body>
</html>