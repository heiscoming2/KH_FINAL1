<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
<!-- 회원가입 폼 css -->
<link href="resources/css/join_form.css" rel="stylesheet">
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
  <div class="container">
        <div class="row d-flex flex-row justify-content-center mt-5 mb-5">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                    
                        <form method="post" action="join_user.do">

                            <div class="mb-1 row"><!--아이디 입력 폼-->
                                <label class="col-sm-3 col-form-label">아이디</label>
                                <div class="col-sm-8 id_input ">
                                  <input type="text" class="form-control" id="m_id" name="m_id" >
                                </div>
                            </div>
                            
                            <!-- 중복체크 알림 
                            <div class="mb-3 row">
                            	<span class="id_input_re1">사용 가능한 아이디입니다.</span>
                                <span class="id_input_re2">아이디가 이미 존재합니다.</span>
                            </div> -->

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
                                  <input type="text" class="form-control" id="m_phone" name="m_phone" >
                                </div>
                            </div>
                            
                            <div class="mb-2 row"><!--이메일 입력 폼-->
                                <label class="col-sm-3 col-form-label">이메일</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control mail_input" id="m_email">
                                </div>
                            </div>
                            
                            <div class="mb-2 row"><!--이메일 인증-->
                                <label class="col-sm-3"></label>
                                <div class="col-sm-5"><!-- 인증번호 입력 input -->
                                  <input type="text" class="form-control form-control-sm mail_check_input" id="m_email_cert">
                                </div>
                                <div class="col-sm-4 mail_check_button"><!-- 인증번호 전송 버튼 -->
                                    <button type="button" class="btn btn-outline-secondary btn-sm">인증번호전송</button>
                                </div>
                            </div>
                            <!-- 인증번호 일치 여부 알림 -->
                            <div class="mb-3 row clearfix text-center">
                            	<span class="mail_check_input_box_warn"></span>
                            </div>
                            
                            <div class="d-grid gap-2 col-5 mx-auto">
                                <input type="submit" class="btn btn-primary" value="회원가입">
                            </div>
                        </form>
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

<!-- 메일 인증 스크립트 -->
<script type="text/javascript" src="./resources/js/join_form.js"></script>

</body>
</html>