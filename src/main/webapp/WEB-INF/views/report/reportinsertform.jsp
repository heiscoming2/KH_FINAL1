<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>신고창</title>
</head>
<body>


<!-- 본문 시작 -->

<!-- 신고 상세내용 -->
	<h1>신고하기</h1>
	<form action="report_insert.do" method="post">
	
	<table border="1">
	
			<tr>
				<th>게시판</th><td>${dto.name}</td>
			</tr>
			
            <tr>
				<th>신고게시글</th><td>${dto.bd_title }</td>
            </tr>
            
            <tr>
				<th>신고이유</th><td ><textarea name="report_reason" rows="60" cols="10"></textarea></td>
            </tr>
            
			<tr>
				<td><input type="submit" value="신고 등록" ></td>
				<td><input type="button" value="취소" onclick="self.close();"></td>
			</tr>
	</table>

	</form>
<input type="submit" value="신고 등록" >
<input type="button" value="취소" onclick="self.close();">
<!-- 본문 종료 -->


<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>