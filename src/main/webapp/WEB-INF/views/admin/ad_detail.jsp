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

	<!-- 광고문의 상세 게시판 -->
	<h1>광고문의 상세 게시판</h1>

	<table border="1">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<col width="">
		<body>
			<tr>
				<td>No</td><td>1</td>
            </tr>
            <tr>
				<td>광고주</td><td><a href="">user1</a></td>
            </tr>
            <tr>
				<td>업체분류</td><td>의료</td>
            </tr>
            <tr>
				<td>희망시작일</td><td>2021.4.1</td>
            </tr>
            <tr>
				<td>희망종료일</td><td>2021.4.30</td>
            </tr>
            <tr>
				<td>총기간</td><td>30일</td>
            </tr>
            <tr>
				<td>배너클릭시 사용될 url</td><td>thenavigators.co.kr</td>
            </tr>
            <tr>
				<td>이미지 업로드</td><td></td>
            </tr>
            <tr>
                <td>결제</td><td><a href="">결제기록보기</a></td>
            </tr>
		</body>

	
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