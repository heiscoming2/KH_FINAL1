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
        <div class="row d-flex flex-row justify-content-center mt-5 mb-5">
            <div class="col-lg-5">
                <div class="card">
                    <div class="card-body">
                        
                        <form id="joinBizForm" method="post">

                            <div class="mb-2 row"><!--아이디 입력 폼-->
                                <label class="col-sm-4 col-form-label">아이디</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control id_input" id="m_id" name="m_id">
                                </div>
                            </div>
                            <!-- 아이디 중복확인 메시지 -->
                            <div class="mb-2 row text-center">
                            	<span class="id_input_re1">사용 가능한 아이디입니다.</span>
                                <span class="id_input_re2">아이디가 이미 존재합니다.</span>
                            </div>

                            <div class="mb-3 row"><!--비밀번호 입력 폼-->
                                <label class="col-sm-4 col-form-label">비밀번호</label>
                                <div class="col-sm-8">
                                  <input type="password" class="form-control" id="m_pw" name="m_pw">
                                </div>
                            </div>

                            <div class="mb-3 row"><!--기업명 입력 폼-->
                                <label class="col-sm-4 col-form-label">기업명</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_nickname" name="m_nickname">
                                </div>
                            </div>
                            
                            <div class="mb-3 row"><!--전화번호 입력 폼-->
                                <label class="col-sm-4 col-form-label">전화번호</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_phone" name="m_phone" maxlength="13" placeholder="-포함 작성">
                                </div>
                            </div>

                            <div class="mb-1 row"><!--사업자번호 입력 폼-->
                                <label class="col-sm-4 col-form-label">사업자번호</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control regno_input" name="m_regno" maxlength="12" placeholder="-포함 작성">
                                </div>
                            </div>
                            
                            <!-- 사업자 중복 확인 메시지-->
                            <div class="mb-2 row text-center">
                            	<span class="regno_input_re1">사용 가능한 번호입니다.</span>
                                <span class="regno_input_re2">번호가 이미 존재합니다.</span>
                            </div>

                            <div class="mb-3 row"><!--이메일 입력 폼-->
                                <label class="col-sm-4 col-form-label">이메일</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_email" name="m_email">
                                </div>
                            </div>
                            
                            <!--회원가입 버튼-->
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
	
<!-- 기업 회원가입 스크립트 -->
<script type="text/javascript" src="./resources/js/join_biz_form.js"></script>
<script src="https://kit.fontawesome.com/817a0822ff.js" crossorigin="anonymous"></script>
</body>
</html>