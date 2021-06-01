<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>관리자-개인회원관리 페이지</title>

<link href="resources/css/admin.css" rel="stylesheet">




<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
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

<style>
.pull-right {
	float: left;
}
</style>





</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- ADMIN SIDEBAR 시작 -->
	<div class="item"><%@include file="../inc/_sidebar_admin.jspf"%></div>
	<!-- SIDEBAR 종료 -->


	<!-- 본문 시작 -->


	<!-- 회원명단 -->
	<div class="content">
		<h1>회원관리 : 개인회원</h1>

		<form name="form1" method="post" action="member_list.do">

			<select name="search_option">
				<option value="m_nickname"
					<c:if test="${map.search_option == 'm_nickname'}">selected</c:if>>작성자</option>

				<%-- <option value=""
					<c:if test="${map.search_option == 'm_gender'}">selected</c:if>>제목</option>

				<option value="content"
					<c:if test="${map.search_option == 'm_'}">selected</c:if>>내용</option>

				<option value="all"
					<c:if test="${map.search_option == 'all'}">selected</c:if>>작성자+내용+제목</option>--%>

			</select> <input name="keyword" value="${map.keyword}"> <input
				type="submit" value="검색">
		</form>
F
		<br>
		<table class="main_table">
			<thead>
				<tr>
					<th><input type="checkbox" name="all"
						onclick="allChk(this.checked);"></th>
					<th>Nickname</th>
					<th>회원구분</th>
					<th>성별</th>
					<th>회원등록일</th>
					<th>활동여부</th>
					<th>탈퇴여부</th>
					<th>관리자권한</th>
				</tr>
			</thead>
			<tbody id="ajaxTable">
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="8" align="center">===회원명단이 존재하지 않습니다.===</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${list }">
							<tr>
								<td><input type="checkbox" name="chk" value="1"></td>
								<td><a href="member_detail.do?m_no=${dto.m_no }">${dto.m_nickname}</a></td>
								<td>${dto.m_type}</td>
								<td>${dto.m_gender}</td>
								<td><span class="m_regdate"> <fmt:formatDate
											value="${dto.m_regdate}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
								<td>${dto.m_act}</td>
								<td>${dto.m_used}</td>
								<td>${dto.m_auth}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>


			</tbody>
		</table>
		<!-- 쪽지보내기 -->

		<input type="button" value="쪽지보내기" onclick="">



		<!-- 본문 종료 -->

	</div>

	<script type="text/javascript" src="resources/js/slidebar.js?ver=1.1"></script>

	<div class="footer">
		<%@include file="../inc/_footer.jspf"%>

		<!-- FOOTER 종료 -->

		<%@include file="../inc/_foot.jspf"%>
	</div>
</body>
<!-- FOOTER 시작 -->
</html>