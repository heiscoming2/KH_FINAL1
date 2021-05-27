<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/qnainsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO QNA 글 쓰기</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="qna_insertwrap">
      <form action="qnainsert.do" method="post">
       <input type="hidden" name="m_no" value="${sessionScope.login.m_no}">
         <!-- qna 작성 글 영역-->
        <h3>qna 글 작성</h3>
        <br>
             <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none" id="dropdownaUser"
                    style="font-size:15px;">
                    ${sessionScope.login.m_nickname}
                  </a>
                </div>
              </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
              <br>
              <br>
        <table class="table qna_inserttable">
            <tr>
              <th><span>* </span>QnA 제목</th>
              <td><input type=text class="form-control" name="bd_title" value="${qnaDetailDto.bd_title }"></td>
            </tr>

        </table>
        <textarea id="summernote" name="bd_content" value="${qnaDetailDto.bd_content }"></textarea>
        <br>

      <!-- QnA 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="submit" value="등록" class="btn btn-primary" style="float:right; margin-left:10px;" onclick="location.href='qnalist.do'">
	    <input type="button" value="취소" class="btn btn-primary"  onclick="location.href='qnadetail.do?bd_no=${qnaDetailDto.bd_no }'" style="float:right;" >
	   </div>
    </form>
    
    </div> 
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- QNAINSERT 개별 JS -->
<script type="text/javascript" src="resources/js/qnainsert.js?ver=1.1"></script>


</body>
</html>