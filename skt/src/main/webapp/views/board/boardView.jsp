<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.skt.board.model.vo.Board"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글</title>

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
	width: 100%;
	max-width: 1246px;
	margin: auto;
	border: 1px solid black;
	border-radius: 20px;
	background-color: white;
	padding: 20px;
	box-shadow: 1px 1px 1px 1px rgb(203, 203, 203);
}

#header {
	width: 1284px;
	max-width: 1284px;
	height: 91px;
	background-color: white;
	border-radius: 30px;
	margin: 20px auto;
	box-shadow: 1px 1px 1px 1px rgb(203, 203, 203);
}

.post-title {
	font-size: 16px;
	background-color: #F6F6F6;
}

.post-meta {
	font-size: 14px;
	background-color: #F6F6F6;
}

.post-meta table {
	width: 100%;
	table-layout: fixed;
	margin-top: 10px;
	border: 2px solid #C8C8C8;
}

.post-meta td {
	border: 2px solid #C8C8C8;
}

.post-content {
	font-size: 16px;
	line-height: 1.5;
	padding: 15px 0;
	background-color: white;
}

.comments-section {
	padding-left: 20px;
	padding-right: 20px;
	background-color: #F6F6F6;
	border: 2px solid #C8C8C8;
}

.comment {
	margin-top: 20px;
	padding: 5px;
}

.buttons {
	margin-top: 20px;
	display: flex;
	gap: 10px;
}

.pagination {
	margin-top: 20px;
}

/* 반응형 처리 */
@media ( max-width : 768px) {
	.wrap {
		width: 90%;
		padding: 10px;
	}
	#header {
		width: 100%;
		margin: 10px auto;
	}
	.post-meta table {
		font-size: 12px;
	}
	.post-meta td {
		padding: 5px;
	}
	.post-content {
		font-size: 14px;
	}
	.comments-section {
		padding-left: 10px;
		padding-right: 10px;
	}
}

/* 모바일 화면에서 테이블의 <td> 요소를 한 줄씩 배치 */
@media ( max-width : 480px) {
	.post-meta td {
		display: block;
		width: 100%;
		border: none;
		background-color: #ececec;
		margin-bottom: 5px;
	}
	.post-meta table {
		border: none;
	}
	.post-meta tr {
		display: block;
	}
	.pagination {
		font-size: 12px;
	}
}
</style>
</head>
<body>
	<jsp:include page="/views/common/menubar.jsp" />
	<br><br><br><br><br><br>
	<div class="wrap">
		<h1 style="text-align: center;">게시글</h1>
		<!-- Post Metadata -->
		<div class="post-meta">
			<table class="table text-center" style="margin-bottom: 0px;">
				<tr>
					<td colspan="5"
						style="text-align: center; border: 2px solid #C8C8C8; background-color: #ececec; font-weight: bold; font-size: 16px;">${b.title}</td>
				</tr>
				<tr>
					<td style="background-color: #ececec;">아이디: ${b.memId }</td>
					<td style="background-color: #ececec;">작성일: ${b.createDate}</td>
					<td style="background-color: #ececec;">유형: ${b.type}</td>
					<td style="background-color: #ececec;">조회수: ${b.viewCount}</td>
					<td style="background-color: #ececec;">좋아요: ${boardLike}</td>
				</tr>
				<td colspan="5"><c:forEach var="imageLink"
						items="${imageLinks}">
						<img src="${imageLink}" alt="첨부 이미지"
							style="max-width: 100%; height: auto;">
						<br>
					</c:forEach></td>
				<tr>
					<td colspan="5" style="text-align: left; padding: 10px;">
						<div class="post-content">${b.content}</div>
					</td>
				</tr>
				<!-- 첨부파일 Row -->
				<tr>
					<td colspan="5"
						style="border: 2px solid #C8C8C8; background-color: #f9f9f9; text-align: left; padding: 10px;">
						<div class="attachment">
							<c:forEach var="link" items="${downloadLinks}" varStatus="status">
								<a download href="${link}">${originalFileNames[status.index]}</a>
								<br>
							</c:forEach>
						</div>
					</td>
				</tr>
				<!-- 게시글 주인 버튼 -->
				<tr>
					<td colspan="5">
						<div align="center">
							<a href="<%=contextPath%>/board.bo?cpage=1"
								class="btn btn-sm btn-secondary">목록가기</a>
							<c:choose>
								<c:when test="${ empty loginUser }">
								</c:when>
								<c:otherwise>
									<a href="<%=contextPath%>/like.bo" id="like-button"
										class="btn btn-sm btn-secondary"
										style="background-color: #ff69b4;">좋아요</a>
								</c:otherwise>
							</c:choose>

							<c:if test="${testLoginSession == b.memId}">
								<a href="<%=contextPath%>/updatePage.bo"
									class="btn btn-sm btn-warning">수정하기</a>
								<a
									href="${pageContext.request.contextPath}/deleteBoard.bo?bno=${b.commNo}"
									class="btn btn-sm btn-danger">삭제하기</a>
							</c:if>
						</div>
					</td>
				</tr>

			</table>
			<br>
		</div>

		<!-- 댓글 작성 -->
		<div class="comments-section">
			<br>
			<h5 style="font-weight: bold;">댓글</h5>
			<form action="insertComment.bo" method="get">
				<textarea class="form-control mb-3" name="content" rows="4"
					placeholder="댓글을 입력하세요"></textarea>
				<c:choose>
					<c:when test="${ empty loginUser }">
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn btn-primary">작성 완료</button>
					</c:otherwise>
				</c:choose>
			</form>
			<hr style="width: 98%;">

			<!-- 댓글 -->
			<c:forEach var="comment" items="${commentList}">
				<div class="comment mt-4" style="background-color: white;">
					<c:if test="${comment.status.equals('Y')}">
						<strong>${comment.memId}</strong>
						<p>${comment.commentContent}</p>
					</c:if>
					<c:if test="${!comment.status.equals('Y')}">
						<div class="no-reply-comment mt-3">
							<p>삭제된 댓글입니다.</p>
						</div>
					</c:if>

					<c:choose>
						<c:when test="${ empty loginUser }">
						</c:when>
						<c:otherwise>
							<button class="btn btn-link"
								style="background-color: rgb(225, 225, 255);"
								onclick="toggleReplyForm(${comment.commentNo});">답변</button>
						</c:otherwise>
					</c:choose>
					<form action="deleteComment.bo" method="post"
						style="display: inline;">
						<input type="hidden" name="commentNo" value="${comment.commentNo}">
						<input type="hidden" name="commentMasterNo"
							value="${comment.memId}">
							<c:if test="${testLoginSession == b.memId}">
						<button type="submit" class="btn btn-link text-danger"
							style="background-color: rgb(255, 225, 225);">댓글 삭제</button>
							</c:if>
					</form>

					<!-- 대댓글 작성폼 -->
					<div id="reply-form-${comment.commentNo}"
						style="display: none; margin-top: 10px;">
						<form action="insertReply.bo" method="post">
							<textarea class="form-control mb-3" name="replyContent" rows="3"
								placeholder="답변을 입력하세요"></textarea>
							<input type="hidden" name="parentCommentNo"
								value="${comment.commentNo}">
							<button type="submit" class="btn btn-primary">답변 완료</button>
						</form>
					</div>

					<!-- 대댓글 폼 -->
					<c:forEach var="reply" items="${replyList}">
						<c:if test="${reply.parentCommentNo == comment.commentNo}">
							<c:if test="${reply.status.equals('Y')}">
								<div class="reply-comment mt-3"
									style="background-color: #f0f8ff; padding: 10px; border-left: 3px solid #007bff;">
									<strong>${reply.memId}</strong>
									<p>${reply.commentContent}</p>
									<form action="deleteComment.bo" method="post"
										style="display: inline;">
										<input type="hidden" name="commentNo"
											value="${reply.commentNo}"> <input type="hidden"
											name="commentMasterNo" value="${reply.memId}">
											<c:if test="${testLoginSession == b.memId}">
										<button type="submit" class="btn btn-link text-danger"
											style="background-color: rgb(255, 225, 225);">댓글 삭제</button>
											</c:if>
									</form>
								</div>
							</c:if>
							<c:if test="${!reply.status.equals('Y')}">
								<div class="no-reply-comment mt-3"
									style="background-color: #ffe6e6; padding: 10px; border-left: 3px solid #ff0000;">
									<p>삭제된 댓글입니다.</p>
								</div>
							</c:if>
						</c:if>
					</c:forEach>
				</div>
			</c:forEach>
			<br>
		</div>

	</div>
	<br><br>
	 <jsp:include page="/views/common/footer.jsp" />
	<script>
	function toggleReplyForm(commentNo) {
		var replyForm = document.getElementById("reply-form-" + commentNo);
		if (replyForm.style.display === "none") {
			replyForm.style.display = "block";
		} else {
			replyForm.style.display = "none";
		}
	}
	</script>
</body>
</html>