<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>받은쪽지</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
<div class="container mt-5 mb-5" style="max-width: 1000px;">

	<h3>받은 쪽지 읽기</h3>
	<button class="btn btn-default" onclick="location.href='mypage_user.do'">마이페이지</button>
    <button class="btn btn-default" onclick="location.href='note_receivelist.do'">받은쪽지</button>
    <button class="btn btn-default" onclick="location.href='note_sendlist.do'">보낸쪽지</button>
    <input type="button" class="btn btn-default" onclick="noteForm();" value="쓰기">
   	<button class="btn btn-default" onclick="location.href='note_delete.do?n_no=${noteDto.n_no}'">삭제</button>

    
    <div class="row d-flex flex-row justify-content-center mt-3 mb-5">
       <div class="col-lg-11">
           <div class="card">
               <div class="card-body">                    
                   <div>
                       <div class="mb-3 row text-center">
                           <label class="col-sm-2 col-form-label">보낸 사람</label>
                           <div class="col-sm-10">
                             <input type="text" readonly class="form-control-plaintext" value="${noteDto.m_nickname}">
                           </div>
                       </div>
                       <div class="mb-3 row text-center">
                           <label class="col-sm-2 col-form-label">보낸시간</label>
                           <div class="col-sm-10">
                             <input type="text" readonly class="form-control-plaintext" value="${noteDto.n_sendDate}">
                           </div>
                       </div> 
                       <div class="mb-3 row text-center">
                           <label class="col-sm-2 col-form-label">읽은시간</label>
                           <div class="col-sm-10">
                             <input type="text" readonly class="form-control-plaintext" value="${noteDto.n_readDate}">
                           </div>
                       </div> 
                       <div class="mb-3 row text-center">
                           <label class="col-sm-2 col-form-label">제목</label>
                           <div class="col-sm-10">
                             <input type="text" readonly class="form-control-plaintext" value="${noteDto.n_title}">
                           </div>
                       </div>  
                       <div class="mb-3 row text-center">
                           <label class="col-sm-2 col-form-label">내용</label>
                           <div class="col-sm-10">
                             <textarea readonly class="form-control-plaintext" style="height: 200px; resize: none;">${noteDto.n_content}</textarea>
                           </div>
                       </div>  
                       
                                        
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

<!-- 쪽지 작성 팝업 스크립트 -->
<script type="text/javascript" src="resources/js/note_form.js?ver=1.2"></script>
	
</body>
</html>