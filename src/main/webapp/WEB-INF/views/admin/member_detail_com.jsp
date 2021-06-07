<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<link rel="stylesheet" href="resources/css/admin.css?ver=1.3">
<title>관리자-기업회원 상세</title>
</head>
<body>
<div class="wrap">

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->
<div class="item">
	<%@include file="../inc/_sidebar_admin.jspf"%>
</div>

	<!-- 본문 시작 -->

	<div class="content">
	
	<h3>기업회원 상세</h3>
	
	<table class="main_table" style="width:90%">
		<tr>
			<th>별명</th>
			<td>${dto.m_nickname }</td>
		</tr>
		<tr>
			<th>회원구분</th>
			<td>${dto.m_type }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${dto.m_gender }</td>
		</tr>
		<tr>
			<th>회원등록일</th>
			<td>${dto.m_regdate }</td>
		</tr>
		<tr>
			<th>활동여부</th>
			<td>${dto.m_act }</td>
		</tr>
		<tr>
			<th>탈퇴여부</th>
			<td>${dto.m_used }</td>
		</tr>
		<tr>
			<th>관리자 권한</th>
			<td>${dto.m_auth }</td>
		</tr>
		<tr>
			<th>셩명</th>
			<td>${dto.m_name }</td>
		</tr>
		<tr>
			<th>생일</th>
			<td>${dto.m_birth }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.m_addr }</td>
		</tr>
		<tr>
			<th>사업자등록번호</th>
			<td>${dto.m_regno }</td>
		</tr>
		<tr>
			<th>사업자승인</th>
			<td>${dto.m_admin_cert }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="목록"
				onclick="location.href='member_list_com.do'"> <input
				type="button" value="수정"
				onclick="location.href='member_updateform_com.do?m_no=${dto.m_no}'">
			</td>
		</tr>
	</table>
	<!-- 쪽지보내기 -->
	<input type="button" value="쪽지보내기" onclick="">
	</div>

	<!-- 본문 종료 -->
</div>
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>

</body>
</html>