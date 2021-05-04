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
  <div class="container">
        <div class="row d-flex flex-row justify-content-center mt-5 mb-5">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                    
                        <form method="POST" action="">

                            <div class="mb-3 row"><!--아이디 입력 폼-->
                                <label class="col-sm-4 col-form-label">아이디</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_id" name="m_id" >
                                </div>
                            </div>

                            <div class="mb-3 row"><!--비밀번호 입력 폼-->
                                <label class="col-sm-4 col-form-label">비밀번호</label>
                                <div class="col-sm-8">
                                  <input type="password" class="form-control" id="m_pw" name="m_pw">
                                </div>
                            </div>

                            <div class="mb-3 row"><!--닉네임 입력 폼-->
                                <label class="col-sm-4 col-form-label">닉네임</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_nickname" name="m_nickname" >
                                </div>
                            </div>

                            <div class="mb-3 row"><!--이메일 입력 폼-->
                                <label class="col-sm-4 col-form-label">이메일</label>
                                <div class="col-sm-8">
                                  <input type="text" class="form-control" id="m_email" name="m_email">
                                </div>
                            </div>
                            
                            <!--회원가입 버튼 @@@버튼 타입 변경 해야됨!!-->
                            <div class="d-grid gap-2 col-5 mx-auto">
                                <input type="submit" class="btn btn-primary" value="회원가입" onclick="location.href='main.do'">
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
	
</body>
</html>