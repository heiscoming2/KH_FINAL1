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
	<form id="frm" action="report_insert.do">
	<input type="hidden" name="m_no" value="${dto.m_no }" >
	<input type="hidden" name="bd_no" value="${dto.bd_no }" >
	<input type="hidden" name="bd_title" value="${dto.bd_title }" >
	<input type="hidden" name="name" value="${dto.name}" >
	<input type="hidden" name="re_no" value="${dto.re_no}" >
	
	<table border="1">
	
			<tr>
				<th>게시판</th><td id="name">${dto.name}</td>
			</tr>
			
            <tr>
				<th>신고게시글</th><td id="bd_title">${dto.bd_title}</td>
            </tr>
            <tr>
				<th>신고댓글</th><td id="re_content">${dto.re_content}</td>
            </tr>
            <tr>
				<th>신고이유</th><td ><textarea name="report_reason" rows="6" cols="30"></textarea></td>
            </tr>
            
			<tr>
			</tr>
	</table>
				<td><input type="submit" value="신고 등록" ></td>
				<td><input type="button" value="취소" onclick="self.close();"></td>

	</form>

<!-- 본문 종료 -->



<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
  <%@include file="../inc/_foot.jspf" %>
	<script src="resources/js/reportInsert.js" type="text/javascript"></script>
	<script>
	setData('${dto}');
</script>
</body>
</html>