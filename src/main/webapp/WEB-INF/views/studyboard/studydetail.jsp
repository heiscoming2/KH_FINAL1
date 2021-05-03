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
<title>IT PRO - ${studyDetailDto.bd_title}</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="study_detailwrap mt-5">
      <h4>스터디 구인</h4>
      <!-- 스터디모집 구인글 영역 -->
      <table class="table table-bordered" style="width:100%;">
        <tr>
          <td>
            <!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
            <div class="profile_wrap">
              <!-- 프로필 이미지 영역 -->
              <img src="${studyDetailDto.m_img_path }${studyDetailDto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <div class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${studyDetailDto.m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
                    <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
                    <li><a class="dropdown-item" href="#">이력서 열람</a></li>
                </ul>
              </div>
              <span class="reg_date">
                <fmt:formatDate value="${studyDetailDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성됨)
                <c:if test="${studyDetailDto.bd_modifydate ne null }">
                	<fmt:formatDate value="${studyDetailDto.bd_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정됨)
				</c:if>
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->
			<hr>
            <!-- 글 번호 / 제목 영역 시작 -->
            <div style="margin: 10px 0px;">
              <span class="detail_no">${studyDetailDto.bd_no }</span> <!-- 글 번호 -->
              <br>
              <span class="detail_title">${studyDetailDto.bd_title }</span> <!-- 글 제목 -->
            </div>
            <!-- 글 번호 / 제목 영역 종료 --> 
			<hr>
            <br>
            <div style="float:right; position:relative; top:-105px;"> <!-- 작성자에게만 보여질 버튼 -->
              <input type="button" value="신고" class="btn btn-danger">
              <input type="button" value="모집완료" class="btn btn-primary" onclick="statusChangeConfirm();"> <!-- 나중에 상태값을 담아서 매개변수로 뿌려주고 yn에 따라 confirm 메시지 출력-->
              <input type="button" value="수정" class="btn btn-primary"  onclick="location.href='studyupdate.do'">
              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm();">
            </div> <!-- 작성자에게만 보여질 버튼 종료 -->

            <!-- 필수 입력 정보 노출 시작 -->
            <div style="font-weight:bold; font-size: 15px; padding:10px 0px;"> 
              인원수 : ${studyDetailDto.st_nowperson } / ${studyDetailDto.st_closeperson }<br>
              장소 : ${studyDetailDto.st_addr1}&nbsp;${studyDetailDto.st_addr2 }&nbsp;${studyDetailDto.st_addrdetail }<br>
            </div>
            <!-- 필수 입력 정보 노출 종료 -->
            <br>

            <!-- 글 내용 시작 -->
            <div class="detail_content">
			${studyDetailDto.bd_content }
              <br>
              <br>
            </div>
            <div class="text-center">
            	<input type="button" class="btn btn-success" value="추천(${studyDetailDto.bd_recommandcount })">
            </div>
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- 스터디모집 구인글 영역 종료-->

      <!-- 본문 / 댓글 중간 여백 영역 시작 -->
      <div style="width:100%; display: block; height:80px;">
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;" onclick="location.href='studylist.do'">
      </div>
      <!-- 본문 / 댓글 중간 여백 영역 종료 -->
	
	 
      <!-- 댓글 영역 시작 -->
      	<!-- 댓글 작성 시 글번호를 넘겨주기 위해 hidden으로 심어준다. -->
      <input type="hidden" name="bd_no" value=${studyDetailDto.bd_no } form="replyinsert">
      <%@include file="../reply/_reply.jspf" %>
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
<script type="text/javascript" src="resources/js/studydetail.js?ver=1.1"></script>
</body>
</html>