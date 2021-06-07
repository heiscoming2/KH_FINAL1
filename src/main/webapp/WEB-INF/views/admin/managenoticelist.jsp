<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	//체크박스 모두 선택, 취소하기
	function allChk(bool) {
		var chks = document.getElementsByName("chk");
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked = bool;
		}
	}

	//체크를 하나도 하지 않았다면 submit 이벤트 취소
	$(function() {
		$("#muldelform").submit(function() {
			if ($("#muldelform input:checked").length == 0) {
				alert("하나 이상 체크해 주세요!!!");
				return false;
			}
		});
	});
</script>



<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<link rel="stylesheet" href="resources/css/admin.css?ver=1.3">

<title>IT PRO 공지사항 목록</title>
</head>
<body>
<div class="wrap">

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- SIDEBAR 추가 -->
	<div class="item">
		<%@include file="../inc/_sidebar_admin.jspf"%>
	</div>
	<!-- SIDEBAR 종료-->


	<!-- 본문 시작 -->
	<br><br>
	<h3 style="text-align:left;">공지사항</h3>
	<div class="content">
		<div class="notice_wrap mt-5">
			<div>
					<input name="searchbox" type="text" placeholder="검색" value=""
						class="form-control search-bar" onkeyup="enterKey();"
						style="width: 200px; display: inline-block;"> <input
						type="button"  value="검색" class="btn btn-primary"
						onclick="selectPage(1);">
			</div>
			<div style="position: relative; bottom: 1px;">
				<div class="mb-4">
				</div>
			</div>
			</div>

		<form action="" method="post">
		<table class="table table-bordered" style="width:1190px;">
			<col width="30px">
			<col width="100px">
			<col width="500px">
			<col width="80px">
			<col width="80px">
			<col width="80px">
			<col width="320px">
			<tr>
				<th><input type="checkbox" name="all"
					onclick="allChk(this.checked);"></th>
				<th class="bd_no_th"><a>번호</a></th>
				<th>제목</th>
				<th>댓글수</th>
				<th>추천수</th>
				<th>조회수</th>
				<th class="lastcolumn">작성정보</th>
			</tr>
			<!-- 게시물 한 줄 시작-->
			<c:choose>
				<c:when test="${empty noticeList }">
					<tr>
						<td colspan="8" align="center">조회할 게시물이 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="noticeDto" items="${noticeList }">
						<tr>
							<!-- 글 번호 시작 -->
							<td><input type="checkbox" name="chk" value="1"></td>
							<td class="bd_no"><a>${noticeDto.bd_no}</a></td>
							<td><a href="noticedetail.do?bd_no=${noticeDto.bd_no }"
								style="color: blue;">${noticeDto.bd_title }</a></td>
							<td><span class="replycount">${noticeDto.bd_replycount }</span></td>
							<td class="bd_recommandcount"><b>${noticeDto.bd_recommandcount }</b></td>
							<td class="bd_viewcount">${noticeDto.bd_viewcount }</td>
							<td>
								<div class="notice_profile">
										<!-- ${noticeDto.m_nickname }  -->
										관리자
									<span class="notice_regdate"> <fmt:formatDate
											value="${noticeDto.bd_createddate }"
											pattern="yyyy-MM-dd HH:mm:ss" /></span>
								</div>
							</td>
						<tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="7" align="left"><input type="submit"  name="cmd" value="일괄삭제" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
		</div>
	<!-- 검색 결과를 히든 태그에 담아둔다. (없으면 null값이 담길것임) 이거를 js에서 받아서 -->
	<!-- null이 아닌 경우(검색 결과가 있는 경우) 해당하는 내용들을 보여지게끔 처리 -->
	<c:if test="${noticeSearchDto ne null }">
		<input type="hidden" id="h_a1" value="${noticeSearchDto.a1 }">
		<input type="hidden" id="h_a2" value="${noticeSearchDto.a2 }">
		<input type="hidden" id="h_stat" value="${noticeSearchDto.stat }">
		<input type="hidden" id="h_key" value="${noticeSearchDto.key }">
	</c:if>
	<!-- 본문 종료 -->

	<!-- 페이징 시작 -->
	
	<%@include file="../inc/_page.jspf"%>
	<!-- 페이징 종료 -->
</div>	
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>
	<script type=text/javascript src="resources/js/noticelist.js?ver=1.2"></script>

</body>
</html>