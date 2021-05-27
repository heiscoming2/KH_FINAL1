<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>

<style type="text/css">
.container {
	
	}

.item:nth-child(1){
	float: left;
	width: 30%;
	left: 0px;
}

.item:nth-child(2){
	float: right;
	width: 70%
}

.container2{
	flex-direction: column;
}	
	
</style>


</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->
	<div class="container">
		<div class="item">
			<%@include file="../inc/_sidebar_admin.jspf"%>
		</div>
		<!-- 본문 시작 -->

		<!-- 신고관리 -->
		<div class="item">
			<div class="container2">
				<div class="item2">
				<h1>신고관리</h1>
				</div>
				<div class="item2">
				<table border="1">

					<thead>
						<tr>
							<th>No</th>
							<th>해당게시판</th>
							<th>해당게시글</th>
							<th>신고댓글</th>
							<th>신고사유</th>
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
									<c:forEach var="dto" items="${list }">
										<tr>
											<td>${dto.report_no}</td>
											<td>${dto.name}</td>
											<td><a href="#">${dto.bd_title }</a></td>
											<td><a href="#">${dto.re_content }</a></td>
											<td><a href="reportdetail.do?bd_no=${dto.bd_no }">${dto.report_reason }</a></td>
											<td>${dto.report_date}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
					</tbody>
				</table>
			
				</div>
			</div>
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