<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>샘플 페이지 입니다.</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

<!-- 회원명단 -->
<h1>회원관리</h1>

<table border="1">
<col width=""><col width=""><col width=""><col width=""><col width=""><col width=""><col width="">
	<thead>
	<tr>
		<th>No</th>
		<th>결제회원ID</th>
		<th>결제방법</th>
		<th>결제일</th>
		<th>결제자명</th>
		<th>결제자 전화번호</th>
		<th>결제자 이메일 </th>
	</tr>
	</thead>
	
	<tbody>
	<tr>
		<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td>===회원명단이 존재하지 않습니다.===</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="" items="">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</tr>	
	</tbody>
</table>

<!-- 쪽지보내기 -->





<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>