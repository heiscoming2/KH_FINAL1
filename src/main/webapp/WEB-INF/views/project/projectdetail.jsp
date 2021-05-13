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
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">
<title>IT PRO 상세보기</title>

<!-- 
<script>
function like_func(){
	  alert('like func start')
	  
	  
	  var bd_no = $('#bd_no').val();
	  var m_no = $('#m_no').val();
	  console.log("bd_no, m_no : " + bd_no +","+ m_no);
	  let likeno = {"bd_no":bd_no,"m_no":m_no};
	  
	  
	  
	$.ajax({
		url: "like.do",
	    type: "POST",
	    cache: false,
		data:JSON.stringify(likeno),	    
	    dataType: "json",
	    contentType:"application/json",
	    success: function(data) {
	      var msg = '';
	      var like_img = '';
	      msg += data.msg;
	      alert(msg);
	
	      if(data.like_check == 0){
	        like_img = "";
	      } else {
	        like_img = " ";
	      }      
	      $('#like_cnt').html(data.like_cnt);
	      $('#like_check').html(data.like_check);
	    },
	    error: function(request, status, error){
	      alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	  });
	}

</script> -->
 <!-- https://shxrecord.tistory.com/6 -->

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
              <img src="${dto.m_img_path }${dto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2 profile_img">
              <!-- 프로필 아이디 표시 영역 -->
              <span class="profile_id">
                <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                  data-bs-toggle="dropdown" aria-expanded="false">
                  ${dto.m_nickname }
                </a>
                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
                    <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
                    <li><a class="dropdown-item" href="#">이력서 열람</a></li>
                </ul>
              </span>
              <span class="reg_date">
                <fmt:formatDate value="${dto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성)
                <c:if test="${dto.bd_modifydate ne null }">
                	<fmt:formatDate value="${dto.bd_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정)
				</c:if>
              </span>
              
            </div> <!-- 프로필이미지, 아이디, 작성일 div 종료 -->
			
			
         
            
            <!-- 글 번호 / 제목 영역 시작 -->
             <div style="margin: 10px 0px;">
              <span class="detail_no">${dto.bd_no }</span> <!-- 글 번호 -->
              <br>
              <span class="detail_title">${dto.bd_title }</span> <!-- 글 제목 -->
             </div>
            <!-- 글 번호 / 제목 영역 종료 --> 

             <br>
            <div style="float:right;"> <!-- 작성자에게만 보여질 버튼 -->
              <input type="button" value="수정" class="btn btn-primary" onclick="location.href='projectupdateform.do?bd_no=${dto.bd_no}'">
              <input type="button" value="삭제" class="btn btn-primary"> <!-- 수정 필요!!!!! -->
            </div> <!-- 작성자에게만 보여질 버튼 종료 -->

            <!-- 필수 입력 정보 노출 시작 -->
            <div style="font-weight:bold; font-size: 15px; padding:10px 0px;"> 
            <b>프로젝트</b>
            
              ※ 프로젝트 제목: ${dto.pro_title } <br>
              ※ 프로젝트 기간: ${dto.pro_start } ~ ${dto.pro_end }<br>
              ※ 프로젝트 링크: ${dto.pro_link }<br>
              ※ ERD 링크: ${dto.pro_erd }<br>
              ※ 개발 환경: ${dto.pro_develop }<br>
              ※ 개발 목표: ${dto.pro_goal }
            </div>
            <!-- 필수 입력 정보 노출 종료 -->
            <br>
            
            <!-- 글 내용 시작 -->
            <b>구현 기능</b>
            <div class="detail_content">
             ${dto.pro_function }
              <br>
              <br>
            </div>
            
           
			<input type="hidden" id='bd_no' name="bd_no" value='1'>
            <input type="hidden" id='m_no' name="m_no" value='1004'>
			
			
							
				
             <!-- 좋아요 버튼 시작 -->
            <div class="text-center">
				<div class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>" onclick="like_func()" style="margin:0 auto;">
					<span style="color:orange; font-size:12px; font-weight:bold;">추천수<span class="likecnt">${dto.bd_recommandcount}</span></span>
					
				</div>
				
            </div>
            <!-- 좋아요 버튼 종료 -->`
            <!-- 글 내용 종료 -->
          </td>
        </tr>
      </table>
      <!-- 프로젝트 디테일 영역 종료-->

      <!-- 본문 / 댓글 중간 여백 영역 시작 -->
      <div style="width:100%; display: block; height:80px;">
            <input type="button" class="btn btn-primary" value="뒤로가기" style="float:right;">
      </div>
      <!-- 본문 / 댓글 중간 여백 영역 종료 -->
	
	  <!-- 댓글 영역 시작 -->
	  <input type="hidden" name="bd_no" value=${dto.bd_no } form="replyinsert">
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
<!-- 좋아요 js -->
<script type="text/javascript" src="resources/js/likebutton.js?ver=1.1"></script>
<!-- 댓글 js -->
<script type="text/javascript" src="resources/js/reply.js?ver=1.2"></script>
</body>
</html>