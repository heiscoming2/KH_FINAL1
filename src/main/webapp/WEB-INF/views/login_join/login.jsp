<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<script type="text/javascript" src="./resources/js/login.js"></script> 

<title>로그인</title>
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
                        <form>
                            <div class="mb-3 row"><!--아이디 입력 폼-->
                                <label class="col-sm-3 col-form-label">아이디</label>
                                <div class="col-sm-9">
                                  <input type="text" class="form-control" id="m_id">
                                </div>
                            </div>

                            <div class="mb-3 row"><!--비밀번호 입력 폼-->
                                <label class="col-sm-3 col-form-label">비밀번호</label>
                                <div class="col-sm-9">
                                  <input type="password" class="form-control" id="m_pw">
                                </div>
                            </div>
                            
                            <!--오류 알림-->
                            <div class="mb-3 row mt-1 mb-1 text-center" style="color:red">
                                <span id="loginChk"></span>
                            </div>
                            
                            <div class="d-grid gap-2 col-5 mx-auto">
                                <input type="button" class="btn btn-primary" value="로그인" onclick="login();">
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