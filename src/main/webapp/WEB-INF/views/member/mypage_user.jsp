<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>회원마이페이지</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
		
 <div class="container-sm mt-5 mb-5"style="max-width: 700px;">
		 
        <div class="mb-4"> <!-- 마이페이지 미니 프로필 -->
            <img src="${login.m_img_path }${login.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"
              style="float: left;">
            <span class="fw-bold"style="display: block; position: relative; top:5px;">${login.m_nickname }</span>
        </div>
        
        <!-- 마이페이지 목록 -->
        <div class="list-group">
        	
        	<!-- 정보수정 -->
            <a href="user_update_form.do" class="list-group-item list-group-item-action" aria-current="true">
              <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">회원정보</h5>
              </div>
              <p class="mb-1">비밀번호, 연락처, 프로필 정보를 확인하고 관리합니다.</p>
            </a>
            <!-- 이력서 -->
            <a href="resume_list.do" class="list-group-item list-group-item-action" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1">이력서</h5>
                </div>
                <p class="mb-1">이력서 정보를 등록하고 확인, 관리합니다.</p>
            </a>
            <!-- 쪽지 -->
            <a href="note_receivelist.do" class="list-group-item list-group-item-action" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1">쪽지</h5>
                </div>
                <p class="mb-1">쪽지를 보내고 관리합니다.</p>
            </a>
            <!-- 작성글 확인 -->
            <a href="postlookup.do?m_no=${sessionScope.login.m_no }" class="list-group-item list-group-item-action" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1">작성글</h5>
                </div>
                <p class="mb-1">그동안 작성한 게시글을 확인하고 관리합니다.</p>
            </a>
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