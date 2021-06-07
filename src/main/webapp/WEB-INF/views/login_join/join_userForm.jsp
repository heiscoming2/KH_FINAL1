<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
<!-- 회원가입 폼 css -->
<link href="resources/css/join_form.css" rel="stylesheet">
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>회원가입</title>
</head>
<body>
<div class="wrap">
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="container-sm" style="max-width: 1000px;">
  
  		<p class="mt-5"><h2>회원가입</h2></p>
    
        <div class="row d-flex flex-row justify-content-center mt-3 mb-5">
            <div class="col-lg-5">
                <div class="card">
                    <div class="card-body">
                    
                        <form id="joinForm" method="post">

                            <div class="mb-2 row"><!--아이디 입력 폼-->
                                <label class="col-sm-3 col-form-label">아이디</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control id_input" id="m_id" name="m_id">
                                </div>
                            </div>                            
                            
                            <div class="mb-2 row text-center">
                            	<span class="id_input_re1">사용 가능한 아이디입니다.</span>
                                <span class="id_input_re2">아이디가 이미 존재합니다.</span>
                            </div>

                            <div class="mb-3 row"><!--비밀번호 입력 폼-->
                                <label class="col-sm-3 col-form-label">비밀번호</label>
                                <div class="col-sm-8">
                                  <input type="password" class="form-control" id="m_pw" name="m_pw">
                                </div>
                            </div>

                            <div class="mb-3 row"><!--닉네임 입력 폼-->
                                <label class="col-sm-3 col-form-label">닉네임</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_nickname" name="m_nickname" >
                                </div>
                            </div>
                            
                            <div class="mb-3 row"><!--전화번호 입력 폼-->
                                <label class="col-sm-3 col-form-label">전화번호</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_phone" name="m_phone" maxlength="13" placeholder="-포함해서 입력">
                                </div>
                            </div>
                            
                            <div class="mb-1 row"><!--이메일 입력 폼-->
                                <label class="col-sm-3 col-form-label">이메일</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control mail_input" id="m_email" name="m_email" >
                                </div>
                            </div>
                            
                            <!-- 이메일 중복 확인 -->
                            <div class="mb-2 row text-center">
                            	<span class="email_input_re1">사용 가능한 이메일입니다.</span>
                                <span class="email_input_re2">이메일이 이미 존재합니다.</span>
                            </div>
                            
                            <div class="mb-2 row"><!--이메일 인증번호-->
                                <label class="col-sm-3"></label>
                                <div class="col-sm-5"><!-- 인증번호 입력 input -->
                                  <input type="text" class="form-control form-control-sm mail_check_input" maxlength="6" id="m_mail_cert" name="m_mail_cert">
                                </div>
                                <div class="col-sm-4 mail_check_button"><!-- 인증번호 전송 버튼 -->
                                    <button type="button" class="btn btn-outline-secondary btn-sm">인증번호전송</button>
                                </div>
                            </div>
                            <!-- 인증번호 일치 여부 알림 -->
                            <div class="mb-2 row text-center">
                            	<span class="mail_check_input_box_warn"></span>
                            </div>
                                                        
                            <div class="d-grid gap-2 col-5 mx-auto">
                                <input type="button" class="btn btn-primary joinButton" value="회원가입">
                            </div>
                        </form>
                    </div>
                </div>
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

<!-- 개인 회원가입 스크립트 -->
<script type="text/javascript" src="./resources/js/join_form.js"></script>
<script src="https://kit.fontawesome.com/817a0822ff.js" crossorigin="anonymous"></script>
</body>
</html>