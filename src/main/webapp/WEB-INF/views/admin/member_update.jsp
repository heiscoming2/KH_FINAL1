<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/admin.css?ver=1.3">

<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>개인회원 정보 수정</title>
</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->
<div class="item"><%@include file="../inc/_sidebar_admin.jspf"%></div>
	<!-- 본문 시작 -->

	<!-- 회원정보수정내용 -->
	<div class="content">
	<h3>회원정보수정</h3>
	<form action="member_update.do" method="post">
	<input type="hidden" name="m_no" value="${dto.m_no }">
	<table class="main_table" >
	
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
			<th>가입일</th>
			<td><span class="m_regdate"> <fmt:formatDate
				value="${dto.m_regdate}" pattern="yyyy-MM-dd HH:mm:ss" /></span></td>
		</tr>
        <tr>
			<th>활동여부</th>
			<td><select name="m_act">
				<option value="활동" <c:if test="${m_act eq '활동'}"> selected </c:if>>활동</option>
				<option value="정지" <c:if test="${m_act eq '정지'}"> selected </c:if>>정지</option>			
			</select></td>
		</tr>
         <tr>
			<th>탈퇴여부</th>
			<td><select name="m_used">
				<option value="N">현재회원</option>
				<option value="Y">탈퇴회원</option>			
			</select></td>
		</tr>
        <tr>
			<th>관리자권한</th>
			<td><select name="m_auth" >
				<option value="N"> 관리자 권한 해지</option>
				<option value="Y"> 관리자 권한 부여</option>			
			</select></td>
		</tr>
        <tr>
			<th>성명</th>
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
      <%--  <tr>
			<th>regno</th>
			<td>${dto.m_regno }</td>
		</tr>
          <tr>
			<th>admin_cert</th>
			<td><select name="authority">
				<option value="Y">인증</option>
				<option value="N">미인증</option>			
			</select></td></td>
		</tr> --%>
    	<tr>
			<td colspan="2" align="right">
				<input type="submit" value="완료">
				<input type="button" value="취소" onclick="location.href='member_detail.do?m_no=${dto.m_no}'">
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="쪽지보내기" onclick=""></td>
		</tr>
	</table>
</form>
	<!-- 쪽지보내기 -->
    
</div>

	<!-- 본문 종료 -->

	<!-- FOOTER 시작 -->
	<div class="footer">
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>
	</div>
</body>
</html>