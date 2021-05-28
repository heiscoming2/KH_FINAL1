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
<style type="text/css">
.container{
	display: inline-flex;

}



</style>



</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->
	
	<!-- ADMIN SIDEBAR 시작 -->
	<div class="container"><%@include file="../inc/_sidebar_admin.jspf"%></div>
	<!-- SIDEBAR 종료 -->
	

	<!-- 본문 시작 -->


	<!-- 회원명단 -->
	<div class="container">
	<h1>회원관리</h1>
	<form action="#">
			<div align="right">
				<input type="text" class="control">
				<input type="submit"value="검색" class="btn btn-default"></input> 
			</div>
			<br>
	<table border="1">
		
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
				<th>사업자승인</th>
			</tr>

				<c:choose>
					<c:when test="${empty list_com }">
						<tr>
							<td colspan="8" align="center">===회원명단이 존재하지 않습니다.===</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${list_com }">
							<tr>
								<td><input type="checkbox" name="chk"
									value="1"></td>
								<td><a href="member_detail_com.do?m_no=${dto.m_no }">${dto.m_nickname}</a></td>
								<td>${dto.m_type}</td>
								<td>${dto.m_gender }
								<td><span class="m_regdate"> <fmt:formatDate value="${dto.m_regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
								<td>${dto.m_act}</td>
								<td>${dto.m_used}</td>
								<td>${dto.m_auth}</td>
								<td>${dto.m_admin_cert}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
		
		
	</table>
	<!-- 쪽지보내기 -->

	<input type="button" value="쪽지보내기" onclick="">



	<!-- 본문 종료 -->
	</form>
	</div>

	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf" %>
	
	<!-- FOOTER 종료 -->
	
	<%@include file="../inc/_foot.jspf" %>
	<script type="text/javascript" src="resources/js/slidebar.js?ver=1.1"></script>

</body>
</html>