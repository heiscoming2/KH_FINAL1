<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>신고 관리 게시글 상세 페이지</title>



<link href="resources/css/admin.css" rel="stylesheet">


</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->
		<!-- SIDEBAR 추가 -->
		<div class="item">
			<%@include file="../inc/_sidebar_admin.jspf"%>
		</div>
		<!-- SIDEBAR 종료-->

		<!-- 본문 시작 -->

		<!-- 신고관리 -->
	<div class="content">
				<div class="item2">
				<h3>신고관리 : 게시글 상세</h3>
				</div>
				<div class="item2">
				
				<form action="" method="post">
				<table class="main_table">
					<thead>
						<tr>
							
							<th>신고글 No.</th>
							<th>해당게시판</th>
							<th>해당게시글</th>
							<th>신고사유</th>
							<th>글쓴이</th>
							<th>신고일시</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<c:choose>
								<c:when test="${empty list2 }">
									<tr>
										<td colspan="7">===신고목록이 존재하지 않습니다.===</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="dto" items="${list2}">
										<tr>
										 	
											<td>${dto.report_no}</td>
											<td>${dto.name}</td>
											<td><a href="#">${dto.bd_title }</a></td>
											<td>${dto.report_reason }</td>
											<td><a href="member_detail.do?m_no=${dto.m_no }">${dto.m_nickname }</a></td>
											<td><span class="report_date"> <fmt:formatDate value="${dto.report_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
						
					</tbody>
				</table>
			
				</form>
				</div>
			</div>

	<!-- 본문 종료 -->

	<!-- sidebar 시작 -->

	<!-- FOOTER 시작 -->
	<br>
<br><br><br><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>

</body>
</html>