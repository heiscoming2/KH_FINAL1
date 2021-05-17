<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/projectinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO project 글 쓰기</title>






</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="project_insertwrap">
      <form action="projectinsert.do" method="post">
         <!-- 프로젝트 작성 글 영역-->
        <h3>프로젝트 글 작성</h3>
        <br>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="${projectDetailDto.m_img_path }${projectDetailDto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"
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
              
              
          <table class="project_inserttable">
            <h5><b>프로젝트</b></h5>
            
            <!-- project_appendchild div 박스 시작 -->
            <div id="project_appendchild">
            <tr>
              <th><span>* </span>제목</th>
              <td><input type=text class="form-control" name="bd_title"></td>
            </tr>
            <tr>
            <th><span>* </span>설명 </th>
            <td><input type=text name="bd_content"></td>
            </tr>
            
            <tr>
              <th><span>* </span>프로젝트 제목</th>
              <td><input type=text class="form-control" placeholder="프로젝트 제목을 입력해 주세요." name="pro_title"></td>
            </tr>
            <tr>
              <th><span>* </span>프로젝트 기간</th>
              <td><input type='date' name="pro_start"/> ~ <input type='date' name="pro_end"/></td>

            </tr>
            <tr>
              <th><span>* </span>프로젝트 파일</th>
              <td><input type="button" value="첨부 파일"></td>

          </tr>
            <tr>
              <th><span>* </span>프로젝트 링크(Git) </th>
              <td><input type="text" class="form-control" placeholder="ex) https://github.com/heiscoming2/KH_FINAL1" name="pro_link"></td>
            </tr>
            <tr>
              <th><span>* </span>ERD 링크 </th>
              <td><input type="text" class="form-control" placeholder="ex) https://www.erdcloud.com/d/iKXvArFPz8qqZmiQD" name="pro_erd"></td>
            </tr>
            <tr>
              <th><span>* </span>개발 환경 </th>
              <td><input type="text" class="form-control" placeholder="ex) Java, HTML/CSS, API(지도, 결제) 등" name="pro_develop"></td>
            </tr>
            <tr>
              <th><span>* </span>개발 목표 </th>
              <td><input type="text" class="form-control" placeholder="개발 목표를 입력해 주세요." name="pro_goal"></td>
            </tr>
            <tr>
            <th><span>* </span>구현 기능 </th>
            <td><textarea id="summernote" name="pro_function"></textarea></td>
            </tr>
            
            </div>
            <!-- project_appendchild div 박스 종료 -->
            
            <tr>
            <td><input type="button" value="프로젝트 추가" onclick="add_div('')"></td>
            <td><input type="button" value="프로젝트 삭제" onclick="remove_div(this)"></td>
            </tr>
            
            <div id="project_field"> </div>
            
        </table>
          
        <br>
        
        <br>
    
     <!-- value 꼭 바꿔주기 로그인 기능 완성되면-->
      <input type="hidden" value="1004" name="m_no">

      <!-- 프로젝트 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="submit" value="등록" class="btn btn-primary" style="float:right; margin-left:10px;">
	    <input type="button" value="취소" class="btn btn-primary" onclick="location.href='projectlist.do'" style="float:right;" >
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
<!-- PROJECTINSERT 개별 JS -->
<script type="text/javascript" src="resources/js/projectinsert.js"></script>


</body>
</html>