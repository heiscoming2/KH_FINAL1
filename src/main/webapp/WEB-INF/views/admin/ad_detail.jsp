<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- 결제기록관리 -->
<h1>결제기록관리</h1>

<table border="1">
<col width=""><col width=""><col width=""><col width=""><col width=""><col width=""><col width="">
	<thead>
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>업체분류</th>
		<th>ID</th>
		<th>업체명</th>
		<th>전화번호</th>
		<th>이메일 </th>
		<th>희망시작일 </th>
		<th>희망기간 </th>
		<th>링크주소</th>
		<th>업로드 이미지</th>
		<th>결제금액 </th>
	</tr>
	</thead>
	
	<tbody>
	<tr>
		<c:choose>
		<c:when test="${empty list }">
			<tr>
				<td>===광고목록이 존재하지 않습니다.===</td>
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
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</tr>	
	</tbody>
</table>




<!-- 본문 종료 -->

<!-- sidebar 시작 -->
<%@include file="../inc/_sidebar_admin.jspf" %>

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>