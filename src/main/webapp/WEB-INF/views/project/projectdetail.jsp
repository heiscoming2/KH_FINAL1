<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/studydetail.css" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO 상세보기</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="study_detailwrap mt-5">
        <h4>프로젝트</h4>
      <!-- 프로젝트 디테일 영역 -->
      <table class="table table-bordered" style="width:100%;">
        <tr>
          <td>
            <!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
            <div class="profile_wrap">
              <!-- 프로필 이미지 영역 -->
              <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <span class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  leehj
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
                    <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
                    <li><a class="dropdown-item" href="#">이력서 열람</a></li>
                </ul>
              </span>
              <span class="reg_date">
                2021-04-12 00:00 (작성됨)
                2021-04-13 10:00 (수정됨)
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->

            <!-- 글 번호 / 제목 영역 시작 -->
             <div style="margin: 10px 0px;">
              <span class="detail_no">#1</span> <!-- 글 번호 -->
              <br>
              <span class="detail_title">[제목: ]</span> <!-- 글 제목 -->
             </div>
            <!-- 글 번호 / 제목 영역 종료 --> 

             <br>
            <div style="float:right;"> <!-- 작성자에게만 보여질 버튼 -->
              <input type="button" value="수정" class="btn btn-primary">
              <input type="button" value="삭제" class="btn btn-primary">
            </div> <!-- 작성자에게만 보여질 버튼 종료 -->

            <!-- 필수 입력 정보 노출 시작 -->
            <div style="font-weight:bold; font-size: 15px; padding:10px 0px;"> 
            <b>프로젝트</b>
            
              프로젝트 제목: KH 파이널 <br>
              프로젝트 기간: 2021.04~2021.06<br>
              프로젝트 링크: https://github.com/heiscoming2/KH_FINAL1 <br>
      ERD 링크: https://www.erdcloud.com/d/iKXvArFPz8qqZmiQD <br>
              개발 환경: JAVA, HTML/CSS, TOMCAT<br>
              개발 목표: ~~하기 위함
            </div>
            <!-- 필수 입력 정보 노출 종료 -->
            <br>
            <!-- 글 내용 시작 -->
            <b>구현 기능</b>
            <div class="detail_content">
              구현 내용 + 이미지<br>
              구현 내용 + 이미지<br>
              구현 내용 + 이미지<br>
              구현 내용 + 이미지<br>
              구현 내용 + 이미지<br>
              <br>
              <br>
            </div>
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- 스터디모집 구인글 영역 종료-->

      <!-- 본문 / 댓글 중간 여백 영역 시작 -->
      <div style="width:100%; display: block; height:80px;">
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;">
      </div>
      <!-- 본문 / 댓글 중간 여백 영역 종료 -->

      <!-- 댓글 영역 시작 -->
      <table class="table table-bordered" style="width:960px;">
        <tr>
          <td style="margin:0; padding:0;">
            <div style="background-color: rgb(230, 230, 230); margin:0; padding:15px 0px;">&nbsp;&nbsp;댓글 0</div>
          </td>
        </tr>
        <tr>
          <td>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <div style="float:right;">
                  <input type="button" class="btn btn-primary" value="수정">
                  <input type="button" class="btn btn-primary" value="삭제">
                </div>
              <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                style="float: left; margin-top: 5px;">
              <span style="display: block; position: relative; top:5px;">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  style="font-size:15px;">
                  leehj
                </a>
              </span>
              <span style="font-size: 10px; color:rgb(112, 112, 112); position: relative; bottom:5px;">2021-03-28 13:13 (작성됨)
                2021-04-13 13:13 (수정됨)</span>
            </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
            <div>
              짝짝
            </div>
          </td>
        </tr>
        
        
     


        <!-- 댓글 작성 영역 -->
        <tr>
          <td>
              <!-- 프로필이미지, 아이디, 작성일 div -->
            <div class="comment_wrap">
              <!-- 프로필 영역-->
              <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                style="float: left; margin-top: 5px;">
              <span style="display: block; position: relative; top:5px;">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  style="font-size:15px;">
                  leehj
                </a>
              </span>
              <span style="font-size: 10px; color:rgb(112, 112, 112); position: relative; bottom:5px;">2021-03-28 13:13
                2021-04-15 13:13 </span>
            </div> 
            <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
            <br>

            <!-- 댓글 작성 영역 시작 -->
            <form method="post">
                <textarea id="summernote"></textarea>
            </form> 
            <br>
            <input type="submit" class="btn btn-primary" value="댓글 작성" style="float:right;">
          </td>
        </tr>

       <!-- 댓글 작성 영역 종료 -->


        <!-- 비로그인 시 보여줄 댓글 작성 영역 시작 -->
        <tr>
          <td class="text-center">
            <div><b>로그인 후 댓글 작성 가능</b></div>
          </td>
        </tr>
        <!-- 비로그인 시 보여줄 댓글 작성 영역 종료 -->       


      </table>
      <!-- 댓글 영역 끝 -->
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
<script type="text/javascript" src="resources/js/studydetail.js"></script>
</body>
</html>