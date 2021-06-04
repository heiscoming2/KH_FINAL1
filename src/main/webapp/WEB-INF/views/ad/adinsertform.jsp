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

<script type="text/javascript">
	
function cal(){
	
	var startday = document.getElementById("startDate").value;
	var endday = document.getElementById("endDate").value;
	
	if(startday==null || endday==null || startday=='' ||startday==''){
		
		alert("희망광고기간을 먼저 입력해주세요")
	}	
	
	
	
	console.log(startday);
	console.log(endday);
	
	//yyyy-mm-dd로 된 날짜를 "-"로 쪼개기
	var start_Array = startday.split("-");
	var end_Array = endday.split("-");
	
	console.log(start_Array);
	console.log(end_Array);
	//월에서 1을 뺀 이유는 자바스크립트에서 Date 객체의 월은 우리가 사용하는 것보다 1이 작기 때문에.
	var start_date = new Date(start_Array[0],Number(start_Array[1])-1, start_Array[2]);
	var end_date = new Date(end_Array[0],Number(end_Array[1])-1, end_Array[2]);
	
	console.log(start_date);
	console.log(end_date);
	
	var betweenday=(end_date.getTime() - start_date.getTime())/1000/60/60/24;
	var totalprice=betweenday * 10000;
	
	var finalprice= totalprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	console.log(finalprice);
	
	$('.price').val(finalprice);
};


</script>




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
					<th><span>* </span>희망광고기간</th>
					<td>
						<input type='date' id="startDate" class="period" name="ad_startdate"> ~ <input type='date' id="endDate" class="period " name="ad_enddate">
					</td>
				</tr>
				<tr>
					<th><span>* </span>가격</th>
					<td><input type=text class="price" size=15 name="ad_price" placeholder="1일당 1만원" readonly="readonly">
					<input type="button" value="가격책정" onclick="cal()"></td>
				</tr>
				<tr>					
					<th><span>*</span>결제</th>
					<td><button id="apibtn" type="submit"><img src="resources/images/payment_icon_yellow_small.png"></button></td>
				</tr>
				<tr>
					<th><span>* </span>광고 파일 업로드</th>
					<td><form id="pro_file_form" enctype="multipart/form-data" method="post"><input type="file" value="첨부 파일" name="pro_file" id="pro_file"></form></td>
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
		</form>

			<!-- ad 작성 글 영역 종료-->

			<!-- 취소 / 등록 컨펌 버튼 -->
			<div style="height: 80px;">
				<input type="submit" value="등록" class="btn btn-primary" style="float: right; margin-left: 10px;"> 
				<input type="button" value="취소" class="btn btn-primary" onclick="location.href='adlist.do'" style="float: right;">
			</div>

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