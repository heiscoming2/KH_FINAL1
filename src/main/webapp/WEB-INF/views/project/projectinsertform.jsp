<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<link href="resources/css/projectinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css"
	rel="stylesheet">
<title>IT PRO project 글 쓰기</title>

</head>
<body>
<div class="wrap">

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->
	<div class="project_insertwrap">
		<!-- <form action="projectinsert.do" method="post"> -->
			<!-- 프로젝트 작성 글 영역-->
			<br><br>
			<h3>프로젝트 글 작성</h3>
			<br>
			<!-- 프로필이미지, 아이디, 작성일 div -->
			<div>
				<img src="${sessionScope.login.m_img_path}${sessionScope.login.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none" style="font-size:15px;">
                    ${sessionScope.login.m_nickname}
                  </a>
				</div>
			</div>
			<!-- 프로필이미지, 아이디, 작성일 div 끝 -->
			<br> <br>

			<h5>
				<b>프로젝트</b>
			</h5>
			<div id="project_insert">
				
			</div>
			<table>
				<tr>
					<td><input type="button" value="프로젝트 추가" onclick="add_div()"></td>
					<td><input type="button" value="프로젝트 삭제"
						onclick="remove_div(this)"></td>
				</tr>
			</table>


			</table>

			<br> <br>

			<!-- value 꼭 바꿔주기 로그인 기능 완성되면-->
			<input type="hidden" name="m_no" id="m_no" value="${sessionScope.login.m_no }">

			<!-- 프로젝트 작성 글 영역 종료-->

			<!-- 취소 / 등록 컨펌 버튼 -->
			<div style="height: 80px;">
				<input type="button" value="등록" class="btn btn-primary" style="float: right; margin-left: 10px;" onclick="project_submit()">
				<input type="button" value="취소" class="btn btn-primary" onclick="location.href='projectlist.do'" style="float: right;">
			</div>
		<!-- </form> -->

	</div>
	<!-- 본문 종료 -->
</div>	

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf"%>
<!-- FOOTER 종료 -->

<!-- 하이라이트 효과를 주기 위해 사용 -->
<input type="hidden" class="cateli" value="projectli">

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf"%>

<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- PROJECTINSERT 개별 JS -->
<script type="text/javascript" src="resources/js/projectinsert.js?ver=1.3"></script>


</body>
</html>