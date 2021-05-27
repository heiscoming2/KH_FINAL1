<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css, c태그 라이브러리) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/noticeinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO 공지 글 수정</title>
</head>
<body>

<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="notice_insertwrap mt-5">
      <form action="noticeupdate.do" method="post">
      <input type="hidden" name="bd_no" value=${dto.bd_no }>
        <!-- 공지글 작성 글 영역-->
        <h3>공지글 수정</h3>
        <br>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="${dto.m_img_path }${dto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none"
                    style="font-size:15px;">
                    ${dto.m_nickname }
                  </a>
                </div>
              </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
              <br>
              <br>
        <table class="table notice_inserttable">
            <tr>
              <th><span>* </span>제목</th>
              <td><input type=text class="form-control" name="bd_title" value="${dto.bd_title }"></td>
            </tr>
           
        </table>
        <textarea id="summernote" name="bd_content"><c:out value="${dto.bd_content }"></c:out></textarea>
        <br>
      <!-- 공지 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="submit" value="등록" class="btn btn-primary" style="float:right; margin-left:10px;">
	    <input type="button" value="취소" class="btn btn-primary" onclick="location.href='noticedetail.do?bd_no=${dto.bd_no }'" style="float:right;" >
	   
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
<!-- noticeUPDATE 개별 JS -->
<script type="text/javascript" src="resources/js/noticeupdate.js"></script>

</body>

</html>