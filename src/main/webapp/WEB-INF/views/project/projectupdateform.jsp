<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
    
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/projectinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO project 글 수정</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="project_insertwrap">
         <!-- 프로젝트 작성 글 영역-->
        <h3>프로젝트 글 수정</h3>
        <br>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="${sessionScope.login.m_img_path }${sessionScope.login.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"
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
             <div id="project_insert">

			</div>

          <table>
				<tr>
					<td><input type="button" value="프로젝트 추가" onclick="add_div()"></td>
					<td><input type="button" value="프로젝트 삭제"
						onclick="remove_div(this)"></td>
				</tr>
			</table>
        <br>

        <br>

      <!-- 프로젝트 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="button" value="등록" class="btn btn-primary" onclick="project_submit()" style="float:right; margin-left:10px;">
	    <input type="button" value="취소" class="btn btn-primary" onclick="location.href='projectdetail.do?bd_no=${bd_no }'" style="float:right;" >
	   </div>

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
<script type="text/javascript" src="resources/js/projectupdate.js?ver=1.3"></script>
<!-- 주소 정보 JS -->
<script type="text/javascript" src="resources/js/address.js"></script>
<script>
	getDetailData(${bd_no});
</script>
</body>
</html>
