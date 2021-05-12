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

<!-- 신고 상세내용 -->
	<h1>신고하기</h1>
	<form action="report_insert.do" method="post">
	<table border="1">
	
			
            <tr>
				<th>신고자</th>
				<td><input type="text" name="reportTitle"></td>
            </tr>
            <tr>
				<th>작성자</th>
				<td></td>
            </tr>
            <tr>
				<th>신고이유</th>
				<td><textarea rows="10" cols="60" name="report_reason"></td>
            </tr>
            <tr>
				<td>신고일시</td><td></td>
            </tr>
			<tr>
				<td><input type="submit" value="신고 등록" ></td>
				<td><input type="button" value="취소" onclick="location.href='report_list.do'"></td>
			</tr>
	</table>

	</form>

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