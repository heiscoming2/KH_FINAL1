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
	
		<thead>
			<tr>
				<th>No</th>
				<th>신고자</th>
				<th>신고게시글</th>
				<th>신고이유</th>
				<th>신고일시</th>
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
								<td>${dto.report_no }</td>
								<td>${dto.m_no }</td>
								<td>${dto.bd_title }</td>
								<td>${dto.report_reason }</td>
								<td>${dto.report_date}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>
	
	<table border="1">
		<thead>
			<tr>
				<
			
			</tr>
		</thead>
	
	
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