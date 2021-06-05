<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/portfoliodetail.css?ver=1.4" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>IT PRO 상세보기</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
  <div class="study_detailwrap mt-5">
		
  
        <h4>포트폴리오</h4>
      <!-- 포트폴리오 디테일 영역 -->
      <input type="hidden" name="m_no" value="${sessionScope.login.m_no}">
       <input type="hidden" name="bd_no" value=${dto.bd_no }>  <!-- *******dto.board.bd_no -->
      <table class="table table-bordered" style="width:100%;">
        <tr>
          <td>
             <!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
            <div class="profile_wrap">
              <!-- 프로필 이미지 영역 -->
              <img src="${dto.member.m_img_path }${dto.member.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <div class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${dto.member.m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
				<jsp:include page="../inc/userDropDownMenu.jsp">
					<jsp:param name="m_no" value="${dto.member.m_no }"></jsp:param>
					<jsp:param name="m_nickname" value="${dto.member.m_nickname }"></jsp:param>
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
              <div style="margin: 10px 0px;">
              <span class="detail_no">${dto.bd_no }</span> <!-- 글 번호 --> <!-- *******dto.board.bd_no -->
              <br>
              <span class="detail_title">${dto.bd_title }</span> <!-- 글 제목 -->
             </div>
            <!-- 글 번호 / 제목 영역 종료 --> 

             <br>
            <div style="float:right;"> <!-- 작성자에게만 보여질 버튼 -->
              <input type="button" value="수정" class="btn btn-primary" onclick="location.href='portfolioupdateform.do?bd_no=${dto.bd_no}&m_no=${dto.member.m_no}'">
              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.bd_no}');">  <!-- *******dto.board.bd_no -->
            </div> <!-- 작성자에게만 보여질 버튼 종료 -->


            <!-- 글 내용 시작 -->
            <div style="font-size: 15px; padding:10px 0px;"> 
              	<table class="table portfolio_table" style="width:700px;">
            	<caption align="top" style="color:#0078FF; font-size:17px;">&nbsp;<b>포트폴리오 정보</b><br></caption>
            	    <col width="200px;">
            		<col width="500px;">
            		<tr>
	            		<th><i class="bi bi-person-lines-fill"></i>닉네임</th>
	            		<td>${dto.member.m_nickname }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-envelope-open-fill"></i>이메일</th>
	            		<td>${dto.member.m_email }</td>
            		</tr>
           			<tr>
	            		<th><i class="bi bi-telephone-fill"></i>전화번호</th>
	            		<td>${dto.member.m_phone }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-book-fill"></i>최종학력</th>
	            		<td>${dto.edu.ed_school }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-bank2"></i>경력사항</th>
	            		<td>
							<c:forEach var="career" items="${dto.career }" > 
				             	${career.ca_title } 
				            	 [<fmt:formatDate value="${career.ca_start_date }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${career.ca_end_date }" pattern="yyyy-MM-dd"/>] <br>
				            </c:forEach>
						</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-stack"></i>사용개발기술</th>
	            		<td>${dto.port_develop }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-link"></i>프로젝트 링크</th>
	            		<td>${dto.port_link }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-award-fill"></i>수상내역</th>
	            		<td>${dto.port_prize }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-chat-dots-fill"></i>포트폴리오 소개</th>
	            		<td>${dto.bd_content }</td>
            		</tr>
            	</table>           
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
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;" onclick="location.href='portfoliolist.do'">
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
<!-- 포트폴리오 디테일 js -->
<script type="text/javascript" src="resources/js/portfoliodetail.js?ver=1.3"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.1"></script>
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.1"></script>

</body>
</html>