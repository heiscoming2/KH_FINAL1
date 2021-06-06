<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/qnadetail.css" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">

<title>IT PRO - QNA ${dto.bd_title}</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="qna_detailwrap mt-5">
        <h4>QNA</h4>
      <!-- QNA 디테일 영역 -->
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
                <fmt:formatDate value="${dto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성)
                <c:if test="${dto.bd_modifydate ne null }">
                	<fmt:formatDate value="${dto.bd_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정)
				</c:if>
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->

            <!-- 글 번호 / 제목 영역 시작 -->
            <hr>
            <div style="margin: 10px 0px;">
              <span class="detail_no" onclick="CopyUrlToClipBoard();"></span> <!-- js에서 여기에 주소를 쏴줌 -->
              <br>
              <span class="detail_title">${dto.bd_title }</span> <!-- 글 제목 -->
            </div>            
            <hr>
            <!-- 글 번호 / 제목 영역 종료 --> 
            
            <br>
	        <div style="float:right; position:relative; top:-105px;"> 
	             <input type="button" value="신고" class="btn btn-danger">
	            	<c:if test="${sessionScope.login.m_no eq dto.m_no }">
		              <!-- 모집상태가 y이면 모집완료를 아니면 모집중 버튼을 보이도록한다. (짧게 줄일 수 있을거 같은데.. 나중에 수정) -->
		              <!-- 모집 버튼 종료 -->
		              <input type="button" value="수정" class="btn btn-primary"  onclick="location.href='qnaupdateform.do?bd_no=${dto.bd_no}'">
		              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.bd_no}');">
		            </c:if>
	        </div> 
            

            <!-- 글 내용 시작 -->
            <div class="detail_content">
              ${dto.bd_content }
              <br>
              <br>
           
            </div>
            

             <!-- 좋아요 버튼 시작 -->
            <div class="text-center">
				<div class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>" 
				onclick="
				<c:if test='${login ne null}'> like_func(${dto.bd_no}, ${login.m_no }) </c:if>
				<c:if test='${login eq null}'> alert('로그인해주세요.')</c:if>" 
				style="margin:0 auto;"> 
					<span style="color:orange; font-size:12px; font-weight:bold;">추천수<span class="likecnt">${dto.bd_recommandcount}</span></span>
				</div>
            </div>
            <!-- 좋아요 버튼 종료 -->
            
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- QNA 영역 종료-->

         <!-- 본문 / 댓글 중간 여백 영역 시작 -->
      <div style="width:100%; display: block; height:80px;">
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;" onclick="location.href='qnalist.do'">
      </div>
      <!-- 본문 / 댓글 중간 여백 영역 종료 -->
	


	 
      <!-- 댓글 영역 시작 -->
	  <jsp:include page="../reply/reply.jsp">
	  	<jsp:param name="replyListDto" value="${replyListDto }"></jsp:param>
	  </jsp:include>
	  
	  
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
<!-- qna 디테일 js -->
<script type="text/javascript" src="resources/js/qnadetail.js?ver=1.3"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.3"></script>
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.2"></script>


</body>
</html>