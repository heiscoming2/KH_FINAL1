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
		
		<body>
			<tr>
				<th>No</th><td>${dto.report_reply_no }</td>
            </tr>
            <tr>
				<th>게시판</th><td>${dto.name }</td>
            </tr>
            <tr>
				<th>게시글</th><td><a href="">${dto.bd_title }</a></td>
            </tr>
            <tr>
				<th>댓글 내용</th><td><a href="">${dto.re_content }</a></td>
            </tr>
            <tr>
				<th>신고이유</th><td>${dto.report_reason}</td>
            </tr>
            <tr>
				<th>신고날짜</th><td>${dto.report_date}</td>
            </tr>
            <tr>
				<td>글게시회원</td><td><a href="member_detail.do?m_no=${dto.m_no }">${dto.m_nickname }</a></td>
            </tr>
             <tr>
				<td><input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.report_reply_no}');"></td>
				<td><input type="button" value="뒤로가기" class="btn btn-primary" onclick="location.href='reportreplylist.do';"></td>
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
<!-- report reply 디테일 js -->
<script type="text/javascript" src="resources/js/reportreplydetail.js?ver=1.1"></script>
	
</body>
</html>