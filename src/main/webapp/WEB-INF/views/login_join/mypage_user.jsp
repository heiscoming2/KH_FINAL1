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

 <div class="container mt-5 mb-5">
        <div class="row justify-content-center align-items-center">
            <div class="col-md-3 col-3 mt-5 ">
                <img src="./resources/images/profileimages/testprofile.jpg" class="img-fluid rounded-circle" alt="프로필 이미지" width="200">
                <p><h5>닉네임 닉네임</h5></p>
            </div>
            <div class="list-group col-md-3 list-group-flush">
                <a href="modify_user.do" class="list-group-item list-group-item-action"><h4>회원정보수정</h4></a>
                <a href="resume_list.do" class="list-group-item list-group-item-action"><h4>이력서 등록/관리</h4></a>
                <a href="note_list.do" class="list-group-item list-group-item-action"><h4>쪽지관리</h4></a>
                <a href="post_list.do" class="list-group-item list-group-item-action"><h4>작성글 확인</h4></a>
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