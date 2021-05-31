<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	//체크박스 모두 선택, 취소하기
	function allChk(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}

	//체크를 하나도 하지 않았다면 submit 이벤트 취소
	$(function() {
		$("#muldelform").submit(function() {
			if ($("#muldelform input:checked").length == 0) {
				alert("하나 이상 체크해 주세요!!!");
				return false;
			}
		});
	});
</script>

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
				<h1>신고관리</h1>
				</div>
				<div class="item2">
				
				<form action="" method="post">
				<table class="main_table">
					<thead>
						<tr>
							<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
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
										 	<td><input type="checkbox" name="chk" value="1"></td>
											<td>${dto.report_reply_no}</td>
											<td>${dto.name}</td>
											<td><a href="#">${dto.bd_title }</a></td>
											<td><a href="#">${dto.re_content }</a></td>
											<td><a href="reportreplydetail.do?report_reply_no=${dto.report_reply_no }">${dto.report_reason }</a></td>
											<td><span class="report_date"> <fmt:formatDate value="${dto.report_date}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<td colspan="7"><input type="submit"  name="cmd" value="일괄삭제"></td>
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