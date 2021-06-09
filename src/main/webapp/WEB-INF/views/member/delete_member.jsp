<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>

<title>회원탈퇴</title>
</head>
<body>
<div class="wrap">

<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="container">
        <div class="row d-flex flex-row justify-content-center mt-5">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <form method="POST" action="deleteMember.do">

                            <div class="mb-3 row"><!--아이디 입력 폼-->
                                <label class="col-sm-3 col-form-label">아이디</label>
                                <div class="col-sm-9">
                                  <input type="text" class="form-control" name="m_id">
                                </div>
                            </div>

                            <div class="mb-2 row"><!--비밀번호 입력 폼-->
                                <label class="col-sm-3 col-form-label">비밀번호</label>
                                <div class="col-sm-9">
                                  <input type="password" class="form-control" name="m_pw">
                                </div>
                            </div>
                            <div class="mb-1 row mt-1 mb-1"><!--오류 알림-->
                                <span id="loginChk"></span>
                            </div>
                            
                            <!--탈퇴 버튼-->
                            <div class="row d-flex flex-row justify-content-center">
                                <div class="row justify-content-center col-md-4 me-md-4">
                                    <input type="button" class="btn btn-danger mt-2" onclick="location.href='main.do'" value="취소"></input>
                                </div>
                    
                                <div class="row justify-content-center col-md-4">
                                    <button type="submit" class="btn btn-primary mt-2">탈 퇴</button>
                                </div>
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
<script type="text/javascript" src="./resources/js/login.js"></script> 
	
</body>
</html>