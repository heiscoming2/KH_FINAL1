<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>샘플 페이지 입니다.</title>

<style type="text/css">
.container{
	display:flex;

}



</style>

</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

<!-- 신고 상세내용 -->
	<div class="container">
	<h1>신고 상세내용</h1>

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
				<td>신고자</td><td>user1</td>
            </tr>
            <tr>
				<td>피신고자</td><td><a href="">user2</a></td>
            </tr>
            <tr>
				<td>신고글</td><td><a href="">역세권 지하철 2분거리 분양....</a></td>
            </tr>
            <tr>
				<td>type</td><td>게시글</td>
            </tr>
            <tr>
				<td>신고이유</td><td>광고성 글을 게재했습니다.</td>
            </tr>
            
		</body>

	
	</table>

</div>

<!-- 본문 종료 -->

<!-- sidebar 시작 -->
<div class="container">
<%@include file="../inc/_sidebar_admin.jspf" %>
</div>
<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>