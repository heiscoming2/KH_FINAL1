<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>
</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->

	<!-- 회원상세내용 -->
	<h1>회원상세내용</h1>

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
				<td>ID</td><td>1</td>
            </tr>
            <tr>
				<td>닉네임</td><td>1</td>
            </tr>
            <tr>
				<td>전화번호</td><td>1</td>
            </tr>
            <tr>
				<td>이메일</td><td>1</td>
            </tr>
            <tr>
				<td>탈퇴여부</td><td>1</td>
            </tr>
            <tr>
				<td>회원구분</td><td>1</td>
            </tr>
            <tr>
				<td>관리자승인</td><td>1</td>
            </tr>
            <tr>
				<td>회원등록일</td><td>1</td>
            </tr>
            <tr>
				<td>이름</td><td>1</td>
            </tr>
            <tr>
				<td>생년월일</td><td>1</td>
            </tr>
            <tr>
				<td>성별</td><td>1</td>
            </tr>
            <tr>
				<td>주소</td><td>1</td>
			</tr>
		</body>

	
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