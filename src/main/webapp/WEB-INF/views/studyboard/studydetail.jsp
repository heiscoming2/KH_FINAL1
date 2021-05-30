<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/studydetail.css?vser=1.3" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">
<title>IT PRO - ${dto.bd_title}</title>
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
              <img src="${dto.m_img_path }${dto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <div class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${dto.m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
                    <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
                    <li><a class="dropdown-item" href="#">이력서 열람</a></li>
                </ul>
              </div>
              <span class="reg_date">
                [ IP : ${dto.bd_writerip} ]
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
	             <input type="button" value="신고" class="btn btn-danger">
	            	<c:if test="${sessionScope.login.m_no eq dto.m_no }">
		              <!-- 모집상태가 y이면 모집완료를 아니면 모집중 버튼을 보이도록한다. (짧게 줄일 수 있을거 같은데.. 나중에 수정) -->
		              <c:choose>
		              	<c:when test="${'Y'==dto.st_status}">
			              <input type="button" value="모집완료" class="btn btn-primary" onclick="statusChangeConfirm('${dto.bd_no}');"> 
		              	</c:when>
		              	<c:otherwise>
						  <input type="button" value="모집중" class="btn btn-primary" onclick="statusChangeConfirm('${dto.bd_no}');">               	
		              	</c:otherwise>
		              </c:choose>
		              <!-- 모집 버튼 종료 -->
		              <input type="button" value="수정" class="btn btn-primary"  onclick="location.href='studyupdateform.do?bd_no=${dto.bd_no}'">
		              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.bd_no}');">
		            </c:if>
	        </div> 
	            <!-- 작성자에게만 보여질 버튼 종료 -->
			
            <!-- 필수 입력 정보 노출 시작 -->
            <div style="font-weight:bold; font-size: 20px; padding:10px 0px;"> 
		              요약<br>
		        • 인원수 : ${dto.st_nowperson } / ${dto.st_closeperson }<br>
		        • 장소 : ${dto.st_addr1}&nbsp;${dto.st_addr2 }&nbsp;${dto.st_addrdetail }<br>
            </div>
            <!-- 필수 입력 정보 노출 종료 -->
            <br>
            
            <!-- 글 내용 시작 -->
            <div class="detail_content">
			${dto.bd_content }
              <br>
              <br>
            </div>
            <!-- 글 내용 종료 -->
            
            
 
           <!-- 참여 승인 대기 인원 시작 (나중에 글 작성자에게만 보여지게 해야된다.) -->
			 <!-- 프로필이미지, 아이디 시작 -->
			 	<!-- 참여 승인 대기 숫자 나중에 변경해주어야 한다. (detail 넘어올때 따로 받아오게처리) -->
			<input type="button" value="참여 승인 대기 ▼" class="btn btn-primary btn-applynum" onclick="studyJoinList(${dto.bd_no},'n');"/>
			<span class="applynum">${applynum }</span>
			<div class="studyjoinapplylist"></div>
			<!-- 참여대기 인원 정보 종료 -->
			
			<!-- 빈 div가 없으면 위에 div가 display:none이 될때 br이 안 먹혀서 css가 이상해진다. -->
			<div></div>
            <br>
            
            <!-- 참여인원정보시작 -->
			 <!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
			<input type="button" value="참여 인원 ▼" class="btn btn-primary btn-joinnednum" onclick="studyJoinList(${dto.bd_no},'y');"/>
			<span class="joinnednum">${joinnednum }</span>
			<div class="studyjoinnedlist"></div>
			<!-- 참여인원정보종료 -->
			
			<!-- 빈 div가 없으면 위에 div가 display:none이 될때 br이 안 먹혀서 css가 이상해진다. -->
			<div></div>
            <br>
			
            <!-- 참여 신청 버튼 시작 -->
            <!-- 작성자의 경우에는 이게 안 보여야한다. -->
            <c:if test="${sessionScope.login.m_no ne dto.m_no }">
            <form id="studyJoinApplyForm" action="#">
            	<input type="button"
            	onclick="
            	<c:if test='${sessionScope.login eq null }'>alert('로그인 후 이용 가능합니다.')</c:if>
            	<c:if test='${sessionScope.login ne null }'>studyJoinApply(${dto.bd_no },${sessionScope.login.m_no });</c:if>"
            	 class="btn btn-primary" value="참여신청">
            	<input type="text" class="form-control" name="sj_message" placeholder="한 줄 자기소개" style="width:500px; display:inline-block;">
            </form>
            <!-- 참여 신청 버튼 종료 -->
            </c:if>
            <br>
            
             <!-- 좋아요 버튼 시작 -->
            <div class="text-center">
				<div class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>" 
				onclick="
				<c:if test='${sessionScope.login ne null}'> like_func(${dto.bd_no}, ${login.m_no }) </c:if>
				<c:if test='${sessionScope.login eq null}'> alert('로그인해주세요.')</c:if>" 
				style="margin:0 auto;"> 
					<span style="color:orange; font-size:12px; font-weight:bold;">추천수<span class="likecnt">${dto.bd_recommandcount}</span></span>
				</div>
            </div>
            <!-- 좋아요 버튼 종료 -->
            
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
	  <jsp:include page="../reply/reply.jsp">
	  	<jsp:param name="replyListDto" value="${replyListDto }"></jsp:param>
	  </jsp:include>
      <!-- 댓글 영역 끝 -->
  </div>
  
  	<!-- 게시글 작성자 M_NO와 세션 M_NO를 히든에 넣어둔다. JS에서 종종 사용될 경우가 있음 -->
	<input id="bd_mno" type="hidden" value="${dto.m_no }">
	<input id="session_mno" type="hidden" value="${sessionScope.login.m_no }">
	
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- 스터디 디테일 js -->
<script type="text/javascript" src="resources/js/studydetail.js?ver=1.5"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.3"></script>
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.2"></script>
</body>
</html>