<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/studydetail.css?ver=1.5" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>IT PRO 상세보기</title>

</head>
<body>
<div class="wrap">
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
              <img src="${list.get(0).m_img_path }${list.get(0).m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <span class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${list.get(0).m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
				<jsp:include page="../inc/userDropDownMenu.jsp">
					<jsp:param name="m_no" value="${list.get(0).m_no }"></jsp:param>
					<jsp:param name="m_nickname" value="${list.get(0).m_nickname }"></jsp:param>
				</jsp:include>
              </span>
              <span class="reg_date">
                <fmt:formatDate value="${list.get(0).bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성)
                <c:if test="${list.get(0).bd_modifydate ne null }">
                	<fmt:formatDate value="${list.get(0).bd_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정)
				</c:if>
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->
			
			
         
            
            <!-- 글 번호 / 제목 영역 시작 -->
            <hr>
            <div style="margin: 10px 0px;">
              <span class="detail_no" onclick="CopyUrlToClipBoard();"></span> <!-- js에서 여기에 주소를 쏴줌 -->
              <br>
              <span class="detail_title">${list.get(0).bd_title }</span> <!-- 글 제목 -->
            </div>            
            <hr>
            <!-- 글 번호 / 제목 영역 종료 --> 

            <br>
	        <div style="float:right; position:relative; top:-105px;"> 
	             <input type="button" value="신고" class="btn btn-danger">
	            	<c:if test="${sessionScope.login.m_no eq list.get(0).m_no }">
		              <!-- 모집상태가 y이면 모집완료를 아니면 모집중 버튼을 보이도록한다. (짧게 줄일 수 있을거 같은데.. 나중에 수정) -->
		              <!-- 모집 버튼 종료 -->
		              <input type="button" value="수정" class="btn btn-primary"  onclick="location.href='projectupdateform.do?bd_no=${list.get(0).bd_no}'">
		              <input type="button" value="삭제" class="btn btn-primary" onclick="delConfirm('${dto.bd_no}');">
		            </c:if>
	        </div> 
	        
            <!-- 필수 입력 정보 노출 시작 -->
            <c:forEach items="${list }" var="item" varStatus="status"> 
            <div style="font-size: 15px; padding:10px 0px;"> 
              	<table class="table study_table" style="width:700px;">
            	<caption align="top" style="color:#0078FF; font-size:17px;">&nbsp;<b>프로젝트 ${status.count }</b><br></caption>
            	    <col width="200px;">
            		<col width="500px;">
            		<tr>
	            		<th><i class="bi bi-person-lines-fill"></i>프로젝트 제목</th>
	            		<td>${item.pro_title }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-calendar-date"></i>프로젝트 기간</th>
	            		<td><fmt:formatDate value="${item.pro_start }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${item.pro_end  }" pattern="yyyy-MM-dd"/></td>
            		</tr>
           			<tr>
	            		<th><i class="bi bi-link-45deg"></i>프로젝트 링크</th>
	            		<td>${item.pro_link }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-bounding-box"></i>ERD 링크</th>
	            		<td>${item.pro_erd }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-clipboard-data"></i>개발 환경</th>
	            		<td>${item.pro_develop }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-stack"></i>개발 목표</th>
	            		<td>${item.pro_goal }</td>
            		</tr>
            		<tr>
	            		<th><i class="bi bi-download"></i>프로젝트 파일</th>
	            		<td><input type="button" value="다운로드" onclick='location.href="/upgrade/${item.pro_file_path }"' class="btn-sm btn-dark"></td>
            		</tr>
            	</table>     	
            </div>
            <!-- 필수 입력 정보 노출 종료 -->
            <!-- 글 내용 시작 -->
            <b style="font-size:15px;">&nbsp;구현 기능 상세 설명</b>
            <br><br>
            <div class="detail_content" style="margin-left:4px;">
             ${item.pro_function }
             <c:if test="${!status.last }">
            <hr>
            </c:if>
              <br>
            </div>
             </c:forEach>
            
           
			<input type="hidden" id='bd_no' name="bd_no" value='1'>
            <input type="hidden" id='m_no' name="m_no" value='1004'>
			
			
							
				
             <!-- 좋아요 버튼 시작 -->
            <div class="text-center">
				<div class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>" 
				onclick="
				<c:if test='${login ne null}'> like_func(${list.get(0).bd_no}, ${login.m_no }) </c:if>
				<c:if test='${login eq null}'> alert('로그인해주세요.')</c:if>" 
				style="margin:0 auto;"> 
					<span style="color:orange; font-size:12px; font-weight:bold;">추천수<span class="likecnt">${list.get(0).bd_recommandcount}</span></span>
				</div>
            </div>
            <!-- 좋아요 버튼 종료 -->
            
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- 프로젝트 디테일 영역 종료-->

	  <!-- 본문 / 댓글 중간 여백 영역 시작 -->
	    <div style="width:100%; display: block; height:80px;">
	        <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;" onclick="location.href='projectlist.do'">
	    </div>
	  <!-- 본문 / 댓글 중간 여백 영역 종료 -->
		

      
      <!-- 댓글 영역 시작 -->
	  <jsp:include page="../reply/reply.jsp">
	  	<jsp:param name="replyListDto" value="${replyListDto }"></jsp:param>
	  </jsp:include>
	  
	  
      <!-- 댓글 영역 끝 -->
  </div>
</div>
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->
<!-- 하이라이트 효과를 주기 위해 사용 -->
<input type="hidden" class="cateli" value="projectli">

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- 스터디 디테일 js -->
<script type="text/javascript" src="resources/js/projectdetail.js?ver=1.3"></script>
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.3"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.3"></script>
</body>
</html>