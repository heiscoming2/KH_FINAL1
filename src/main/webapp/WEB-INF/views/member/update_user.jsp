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
<div class="wrap">
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container row justify-content-center mt-5 mb-5">
        <div class="row justify-content-center align-items-center">
        	<!-- 프로필 이미지 -->
            <div class="float-left col-md-3 col-3">
                <img src="${selectUser.m_img_path }${selectUser.m_img }" id="image_section" class="rounded-circle" alt="프로필 이미지" width="240" height="250">
            </div>
            
            <div class="col-md-4 mt-5">            	
            	<!-- 정보수정 폼 -->
                <form class="form-inline" id="updateForm" method="post">
                	<input type="hidden" name="m_no" value="${selectUser.m_no}">
                	
                    <div class="mb-3 row"><!--아이디-->
                        <label class="col-sm-3 col-form-label">아이디</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control-plaintext" id="m_id" readonly value="${selectUser.m_id }">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--비밀번호-->
                        <label class="col-sm-3 col-form-label">비밀번호</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="m_pw" name="m_pw">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--닉네임-->
                        <label class="col-sm-3 col-form-label">닉네임</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="m_nickname" name="m_nickname" value="${selectUser.m_nickname }">
                        </div>
                    </div>
                    
                    <div class="mb-3 row"><!--전화번호-->
                        <label class="col-sm-3 col-form-label">전화번호</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="m_phone" maxlength="13" value="${selectUser.m_phone }">
                        </div>
                    </div>

                    <div class="mb-3 row"><!--이메일-->
                        <label class="col-sm-3 col-form-label">이메일</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control-plaintext" id="m_email" name="m_email" readonly value="${selectUser.m_email }">
                        </div>
                    </div>
				</form><!-- #updateForm -->
				
				<!-- 프로필 이미지 폼 -->
                <form id="profileUpload">
                 	<div class="mb-3 row">
                        <label class="col-sm-3 col-form-label">프로필</label>
                        <div class="col-sm-6">
                            <input class="form-control form-control-sm" type="file" name="m_img" id="imgInput">
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-sm btn btn-secondary" id="uploadBtn">저장</button>
                        </div>
                    </div>                
                </form><!-- 프로필 이미지 폼 끝 -->
			</div>			
        </div>
        
        <div class="row justify-content-center col-md-2 me-md-4">
        	<input type="submit" class="btn btn-danger mt-2" value="회원탈퇴"	onclick="location.href='deleteForm.do'" />
		</div>
		<div class="row justify-content-center col-md-2">
			<button class="btn btn-primary mt-2" id="updateBiz">수정 저장</button>
		</div>
        
    </div>
</div>


<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<!-- 프로필 업로드 스크립트 -->
<script type="text/javascript" src="./resources/js/mProfileUpload.js"></script>
	
</body>
</html>