<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>쪽지 작성</title>
</head>
<body>


<!-- 본문 시작 -->
<div class="container mt-3 mb-3">
	<h3>쪽지 작성</h3> 
	<form action="noteSend.do" method="post" onsubmit="onsubmitForm">
		<div class="mb-3">
			<label for="recipient-name" class="col-form-label">받는사람</label>
			<input type="text" class="form-control" name="n_receiver_nickname" placeholder="닉네임 입력" value="${m_nickname }">
		</div>
		<div class="mb-3">
			<label for="recipient-title" class="col-form-label">제목</label>
			<input type="text" class="form-control" name="n_title" maxlength="10" placeholder="10자내 입력 가능">
		</div>
		<div class="mb-3">
			<label for="message-text" class="col-form-label">내용</label>
			<textarea class="form-control" name="n_content" maxlength="200" style="height: 150px" placeholder="200자내 입력 가능"></textarea>
		</div>
		<div class="float-end">		
			<input type="button" class="btn btn-danger" value="취소" onclick="self.close();">
			<input type="submit" class="btn btn-primary" value="보내기" >
		</div>
	</form>
</div> 
<!-- 본문 종료 -->



<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
  <%@include file="../inc/_foot.jspf" %>
	<script src="resources/js/reportInsert.js" type="text/javascript"></script>
</body>
</html>