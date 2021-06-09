<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>

<link href="resources/css/login.css" rel="stylesheet">
<title>로그인</title>
</head>
<body>
<!-- HEADER 시작 -->

<div class="wrap">
<%@include file="../inc/_header.jspf" %>


<!-- HEADER 종료 -->

<!-- 본문 시작 -->
        <div class="login_wrap"style="max-width:20rem; margin:80px auto; text-align:center;">
        <h2><b>로그인</b></h2>
        <!-- 
            <div class="social_login" style="margin-top:20px;">
            	<div style="position:relative;">
	                <img src="resources/images/loginlogo/facebooklogo.svg" style="width:30px; height:30px; position:absolute; top:4px; left:15px; pointer-events : none; "></img>
	                <input style="width:100%; background-color: #3c5a99; color:white;" type="button" value="페이스북으로 로그인" class="btn">
                </div>
                <div style="position:relative;">
	                <img src="resources/images/loginlogo/naverlogo.svg" style="width:30px; height:30px; position:absolute; top:12px; left:15px; pointer-events : none"></img>
	                <input style="width:100%; background-color: #00c73c; color:white; margin-top:8px;" type="button" value="네이버로 로그인" class="btn">
                </div>
                <div style="position:relative;">
                	<img src="resources/images/loginlogo/googlelogo.svg" style="width:30px; height:30px; position:absolute; top:12px; left:15px; pointer-events : none; "></img>
                	<input style="width:100%; background-color: #c62828; color:white; margin-top:8px;" type="button" value="구글로 로그인" class="btn">
                </div>
                <div style="position:relative;">
                	<img src="resources/images/loginlogo/kakaologo.svg" style="width:30px; height:30px; position:absolute; top:12px; left:15px; pointer-events : none; "></img>
                	<input style="width:100%; background-color: #ffd400; color:black; margin-top:8px;" type="button" value="카카오로 로그인" class="btn">
            	</div>
            </div>
            --> 
             <div>
             <!-- 
                <hr><span style="font-size:12px; color:#B2C0CC;">또는</span>
                 -->
            </div>
            <label style="float:left; font-size: 14px; margin-bottom: 8px;">아이디</label>
            <input type="text" id="m_id" placeholder="아이디" style="width:100%;" class="form-control">
            
            <div style="margin-top:15px;">
                <div>
                <label style="float:left; font-size: 14px;">비밀번호</label>
                <!-- 
                <a style="float:right; font-size: 14px; color:#0d6efd; margin-bottom: 8px;">비밀번호 재설정</a>
                 -->
                <input type="password" id="m_pw" placeholder="비밀번호" style="width:100%;" class="form-control">
                <input type="button" value="로그인 하기" style="width:100%; margin-top:20px; font-weight: bold;" class="btn btn-primary" onclick="login()">
                <div style="text-align: center;">
                    <br>
                    <span style="color:#B2C0CC; font-size:14px;">아직 계정이 없으신가요?</span>
                    <span style="font-size:14px; color:#263747; font-weight:600; cursor:pointer;" onclick="location.href='join.do'">계정 만들기 ></span>
                </div>
            </div>
            <div>
                <br>
                <span style="font-size:13px;">이용약관</span>&nbsp;&nbsp;&nbsp;
                <span style="font-size:13px;">개인정보 처리방침</span>&nbsp;&nbsp;&nbsp;
                <span style="font-size:13px;">FAQ/문의</span>
            </div>
            </div>
   	   </div>
   </div>
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<script type="text/javascript" src="./resources/js/login.js"></script> 	
</body>
</html>