<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<script src="https://kit.fontawesome.com/817a0822ff.js" crossorigin="anonymous"></script>

<%@include file="../inc/_head.jspf" %>

<title>회원가입</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="container mt-5 wrap" style="max-width: 1000px;">
  		<p class="mb-5"><h2>회원가입</h2></p>
  		
  		<div class="mt-5">
	        <div class="row justify-content-center" style="text-align: center;">
	            <span class="col-md-6"><i class="fas fa-user" style="font-size: 180px;"></i></span>
	            <span class="col-md-6"><i class="fas fa-users" style="font-size: 200px;"></i></span>
	        </div>
	        <div class="row justify-content-center" style="text-align: center;">
	            <span class="col-md-6">
	            	<input type="button" class="btn btn-primary btn-lg mt-2" value="개인회원" onclick="location.href='join_userForm.do'">
	            </span>
	            <span class="col-md-6">
	            	<input type="button" class="btn btn-primary btn-lg mt-2" value="기업회원" onclick="location.href='join_bizForm.do'">
	            </span>
	        </div>        
        </div>
    </div>




<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>