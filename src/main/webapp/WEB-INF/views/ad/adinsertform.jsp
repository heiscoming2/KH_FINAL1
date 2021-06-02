<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<link href="resources/css/adinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">


<title>IT PRO 광고문의하기</title>
</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->
	<div class="ad_insertwrap">
		<form action="adinsert.do" method="post">
			<input type="hidden" name="m_no" value="${sessionScope.login.m_no}">
			<!--ad 작성 글 영역-->
			<h3>광고문의 작성</h3>
			<br>
			<!-- 프로필이미지, 아이디, 작성일 div -->
			<div>
				<img src="https://github.com/mdo.png" alt="mdo" width="35"
					height="35" class="rounded-circle me-2" style="float: left;">
				<div style="position: relative; top: 5px;">
					<a class="d-flex align-items-center text-decoration-none"
						id="dropdownaUser" style="font-size: 15px;">
						${sessionScope.login.m_nickname} </a>
				</div>
			</div>
			<!-- 프로필이미지, 아이디, 작성일 div 끝 -->
			<br> <br>
			<table class="table ad_inserttable">
				<tr>
					<th><span>* </span>제목</th>
					<td><input type=text class="form-control" name="ad_title"></td>
				</tr>
				<tr>
					<th><span>* </span>업종</th>
					<td><input type=text class="form-control" name="ad_type"></td>
				</tr>
				<tr>
					<th><span>* </span>업체명</th>
					<td><input type=text class="form-control" name="ad_name"></td>
				</tr>
				<tr>
					<th><span>* </span>희망시작일</th>
					<td><input type='date' id="startDate" class="form-control datepicker" name="ad_starddate" value="startDate">
					<fmt:formatDate var="resultRegDt" value="${startDate}" pattern="yyyy-MM-dd"/>${resultRegDt}
					</td>
				</tr>
				<tr>
					<th><span>* </span>희망종료일</th>
					<td><input type='date' id="endDate" class="form-control datepicker" name="ad_enddate"></td>
				</tr>
				<tr>
					<th><span>* </span>가격</th>
					<td><input type=text class="form-control" name="ad_price"></td>
				</tr>
				<tr>
					<th><span>* </span>이미지파일 업로드</th>
					<td><input type=text class="form-control" name="ad_image"></td>
				</tr>
				<tr>
					<th><span>* </span>이미지 링크주소</th>
					<td><input type=text class="form-control" name="ad_url"
						value="https://"></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${sessionScope.login.m_auth ne 'Y'}">
							<th><span>* </span>진행상태</th>
							<td><select class="form-control" name="ad_status"
								onFocus='this.initialSelect = this.selectedIndex;'
								onChange='this.selectedIndex = this.initialSelect;'>
									<option value="1/5" selected>결제대기</option>
								<%-- 	<option value="2/5">결제진행</option>
									<option value="3/5">결제완료</option>
									<option value="4/5">광고게시중</option>
									<option value="5/5">광고종료</option>--%>
							</select></td>
						</c:when>
						<c:otherwise>
							<th><span>* </span>진행상태</th>
							<td><select class="form-control" name="ad_status">
									<option value="1/5" selected>결제대기</option>
									<option value="2/5">결제진행</option>
									<option value="3/5">결제완료</option>
									<option value="4/5">광고게시중</option>
									<option value="5/5">광고종료</option>
							</select></td>
						</c:otherwise>

					</c:choose>
				</tr>



			</table>
			<textarea id="summernote" name="bd_content"></textarea>
			<br>

			<!-- ad 작성 글 영역 종료-->

			<!-- 취소 / 등록 컨펌 버튼 -->
			<div style="height: 80px;">
				<input type="submit" value="등록" class="btn btn-primary"
					style="float: right; margin-left: 10px;"> <input
					type="button" value="취소" class="btn btn-primary"
					onclick="location.href='adlist.do'" style="float: right;">
			</div>
		</form>
<input type="text" id="Date">
	</div>
	<!-- 본문 종료 -->

	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	  <%@include file="../inc/_foot.jspf"%> 
	  
	<!-- 썸머노트 JS -->
	<script src="resources/js/summernote/summernote-lite.js"></script>
	<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<!-- ADINSERT 개별 JS -->
	<script type="text/javascript" src="resources/js/adinsert.js"></script>


</body>
</html>