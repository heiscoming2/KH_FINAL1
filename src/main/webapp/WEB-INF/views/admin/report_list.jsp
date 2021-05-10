<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>
</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->

	<!-- 신고관리 -->
	  <h1>신고관리</h1>

	<table border="1">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<thead>
			<tr>
				<th>No</th>
				<th>신고자</th>
				<th>피신고자</th>
				<th>제목</th>
				<th>신고날짜,시간</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="5">===신고목록이 존재하지 않습니다.===</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="" items="">
							<tr>
								<td>1</td>
								<td>user1</td>
								<td>user2</td>
								<td>광고성글 게재</td>
								<td>2021/4/13 2:00 AM</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>




	<!-- 본문 종료 -->

	<!-- sidebar 시작 -->
	<%@include file="../inc/_sidebar_admin.jspf"%>

	<!-- FOOTER 시작 -->
	<br>
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>

</body>
</html>