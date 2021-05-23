<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>로그인</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

  <div class="container row justify-content-center mt-5 mb-5">
        <div class="row justify-content-center align-items-center">
        <!-- 프로필 이미지 -->
            <div class="float-left col-md-3 col-3">
                <img src="${selectUser.m_img_path }${selectUser.m_img }" class="img-fluid rounded-circle" alt="프로필 이미지" width="150" height="150">
                <p><h5>${selectUser.m_nickname }</h5></p>
            </div>
            <div class="col-md-4 mt-5">
            
            <!-- 정보수정 폼 -->
                <form class="form-inline" action="biz_update.do" method="post">
                	<input type="hidden" name="m_no" value="${selectUser.m_no}">
                    <div class="mb-3 row"><!--아이디-->
                        <label class="col-sm-4 col-form-label">아이디</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control-plaintext" id="m_id" readonly value="${selectUser.m_id }">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--비밀번호-->
                        <label class="col-sm-4 col-form-label">비밀번호</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="m_pw" name="m_pw">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--닉네임-->
                        <label class="col-sm-4 col-form-label">닉네임</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="m_nickname" name="m_nickname">
                        </div>
                    </div>
                    
                    <div class="mb-3 row"><!--사업자번호-->
                        <label class="col-sm-4 col-form-label">사업자번호</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control-plaintext" id="m_regno" readonly value="${selectUser.m_regno }">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--이메일-->
                        <label class="col-sm-4 col-form-label">이메일</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="m_email" name="m_email">
                        </div>
                    </div>
                    
                     <div class="mb-3 row"><!--관리자 승인 여부-->
                        <label class="col-sm-4 col-form-label">승인 여부</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control-plaintext" readonly value="${selectUser.m_auth }">
                        </div>
                    </div>
                
                
                <!-- 프로필 이미지 폼 -->
                <div id="profileUpload">
                 	<div class="mb-3 row">
                        <label class="col-sm-4 col-form-label">프로필 수정</label>
                        <div class="col-sm-6">
                            <input class="form-control form-control-sm" type="file" name="m_img">
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-sm btn btn-secondary" id="uploadBtn">저장</button>
                        </div>
                    </div>                
                </div>
                
            </div>
        </div>
        
        
        <div class="row justify-content-center col-md-2 me-md-4">
            <input type="submit" class="btn btn-danger mt-2" value="탈퇴하기" onclick="location.href='deleteForm.do'"/>
        </div>

        <div class="row justify-content-center col-md-2">
            <input type="submit" class="btn btn-primary mt-2" value="정보수정하기">
        </div>     
        </form> 
        
    </div>



<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
<!-- 기업 회원가입 스크립트 -->
<script type="text/javascript" src="./resources/js/mProfileUpload.js"></script>	
</body>
</html>