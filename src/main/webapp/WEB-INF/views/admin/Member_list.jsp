<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
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




</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->

	<!-- 회원명단 -->
	<h1>회원관리</h1>

	<table border="1">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<thead>
			<tr>
				<th><input type="checkbox" name="all"
					onclick="allChk(this.checked);"></th>
				<th>No</th>
				<th>ID</th>
				<th>회원구분</th>
				<th>성별</th>
				<th>회원등록일</th>
				<th>활동여부</th>
				<th>탈퇴여부</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="8" text-align="center">===회원명단이 존재하지 않습니다.===</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="" items="">
							<tr>
								<td><input type="checkbox" name="chk"
									value="1"></td>
								<td>1</td>
								<td><a href="">user1</a></td>
								<td>개인회원</td>
								<td>남자</td>
								<td>2010/12/31</td>
								<td>활동중</td>
								<td>안함</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>

	<!-- 쪽지보내기 -->

	<input type="button" value="쪽지보내기" onclick="">



	<!-- 본문 종료 -->

	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>

</body>
</html>