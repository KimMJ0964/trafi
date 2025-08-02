<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%
String contextPath = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오류 발생</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding: 50px;
        }
        .error-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
            padding: 20px;
            max-width: 400px;
            margin: auto;
        }
        .error-title {
            font-size: 24px;
            color: #e74c3c; /* 에러 색상 */
            margin-bottom: 20px;
        }
        .error-message {
            font-size: 18px;
            margin-bottom: 20px;
        }
        .return-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db; /* 버튼 색상 */
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .return-link:hover {
            background-color: #2980b9; /* 버튼 호버 색상 */
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-title">오류 발생</div>
        <div class="error-message">
            <c:choose>
                <c:when test="${not empty errorMsg}">
                    ${errorMsg}
                </c:when>
                <c:otherwise>
                    예상치 못한 오류가 발생했습니다.
                </c:otherwise>
            </c:choose>
        </div>
        <a href= "<%=contextPath%>">홈으로 돌아가기</a> <!-- 홈으로 돌아가는 링크 수정 -->
    </div>
</body>
</html>