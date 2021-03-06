<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/noticedetail.css" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">
<title>IT PRO - ${dto.bd_title}</title>
</head>
<body>
<div class="wrap">
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="notice_detailwrap mt-5">
      <div style="width:1190px; margin:0 auto;">
      <h4>공지사항 상세</h4>
      <!-- 공지사항 상세글 영역 -->
      <table class="table table-bordered" style="width:100%;">
        <tr>
          <td>
            <!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
            <div class="profile_wrap">
              <!-- 프로필 이미지 영역 -->
              <img src="${dto.m_img_path }${dto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <div class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${dto.m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
				<jsp:include page="../inc/userDropDownMenu.jsp">
					<jsp:param name="m_no" value="${dto.m_no }"></jsp:param>
					<jsp:param name="m_nickname" value="${dto.m_nickname }"></jsp:param>
				</jsp:include>
              </div>
              <span class="reg_date">
                <fmt:formatDate value="${dto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성됨)
                <c:if test="${dto.bd_modifydate ne null }">
                	<fmt:formatDate value="${dto.bd_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정됨)
				</c:if>
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->
			<hr>
            <!-- 글 번호 / 제목 영역 시작 -->
            <div style="margin: 10px 0px;">
              <span class="detail_no" onclick="CopyUrlToClipBoard();"></span> <!-- js에서 여기에 주소를 쏴줌 -->
              <br>
              <span class="detail_title">${dto.bd_title }</span> <!-- 글 제목 -->
            </div>
            <!-- 글 번호 / 제목 영역 종료 --> 
			<hr>
            <br>
            <!-- 작성자에게만 보여질 버튼 -->
            <!-- 세션이 null이 아닌 경우, 세션값의 m_no와 글 작성자의 m_no가 같은 경우에만 보여준다. -->
	        <div style="float:right; position:relative; top:-105px;"> 
	             <input type="button" value="신고" class="btn btn-danger" onclick="reportInsert('${dto.bd_no}');">
	            	<c:if test="${sessionScope.login.m_auth eq 'Y' }">
		              <input type="button" value="수정" class="btn btn-primary"  onclick="location.href='noticeupdateform.do?bd_no=${dto.bd_no}'">
		              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.bd_no}');">
		            </c:if>
	        </div> 
	            <!-- 작성자에게만 보여질 버튼 종료 -->
            <!-- 필수 입력 정보 노출 시작 -->
            
            <!-- 필수 입력 정보 노출 종료 -->
            <br>

            <!-- 글 내용 시작 -->
            <div class="detail_content">
			${dto.bd_content }
              <br>
              <br>
            </div>
            
              <!-- 좋아요 버튼 시작 -->
            <div class="text-center">
				<div class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>" onclick="like_func(${dto.bd_no},${sessionScope.login.m_no })" style="margin:0 auto;">
					<span style="color:orange; font-size:12px; font-weight:bold;">추천수<span class="likecnt">${dto.bd_recommandcount}</span></span>
				</div>
            </div>
            <!-- 좋아요 버튼 종료 -->
      
            		
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- 공지 글 영역 종료-->

      <!-- 본문 / 댓글 중간 여백 영역 시작 -->
      <div style="width:100%; display: block; height:80px;">
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;" onclick="location.href='noticelist.do'">
      </div>
      <!-- 본문 / 댓글 중간 여백 영역 종료 -->
	
	 
      <!-- 댓글 영역 시작 -->
    	 <%@include file="../reply/reply.jsp" %>
      <!-- 댓글 영역 끝 -->
      </div>
  </div>
<!-- 본문 종료 -->
</div>

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->
<!-- 하이라이트 효과를 주기 위해 사용 -->
<input type="hidden" class="cateli" value="noticeli">

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- notice 디테일 js -->
<script type="text/javascript" src="resources/js/noticedetail.js?ver=1.1"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.6"></script>
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.2"></script>
<!-- 신고 js -->
<script type="text/javascript" src="resources/js/reportInsert.js?ver=1.2"></script>

</body>
</html>