<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<link rel="stylesheet" href="resources/css/noticelist.css?ver=1.6">
<title>IT PRO 공지사항 목록</title>
</head>
<body>

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->
		<div class="notice_wrap mt-5">
			<h3>공지사항</h3>


			<div style="position: relative; bottom: 1px;">
				<input type="button" class="btn btn-primary" value="전체 조회" onclick="location.href='noticelist.do';"> 
			<c:if test="${sessionScope.login.m_auth eq 'Y' }">
				<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='noticeinsertform.do'">
			</c:if>
				<div class="mb-4" style="float:right;">
						<input name="keyword" value="${key }" class="form-control search-bar" style="width:200px; display:inline-block;" placeholder="제목 or 내용"> 
						<input type="button" class="btn btn-primary" value="검색" onclick="selectPage(1);">
				</div>
				
			</div>

		<table class="table notice_table">
			<col width="180px;">
			<col width="650px;">
			<col width="80px;">
			<col width="80px;">
			<col width="200px;">
			<tr>
				<th class="bd_no_th"><a>번호</a></th>
				<th>제목</th>
				<th>추천수</th>
				<th>조회수</th>
				<th>작성정보</th>
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
							<td class="bd_no"><a>${noticeDto.bd_no}</a></td>
							<td><a href="noticedetail.do?bd_no=${noticeDto.bd_no }"
								style="color: black;">${noticeDto.bd_title }
								 <span
									class="replycount">${noticeDto.bd_replycount }</span></a></td>
							<td class="bd_recommandcount"><b>+${noticeDto.bd_recommandcount }</b></td>
							<td class="bd_viewcount">${noticeDto.bd_viewcount }</td>
							<td>
								<div class="notice_profile">
									<img src="${noticeDto.m_img_path }${noticeDto.m_img}" alt="mdo"
										width="35" height="35" class="rounded-circle me-2">
									<div class="notice_writer">
										<a
											class="d-flex align-items-center text-decoration-none dropdown-toggle"
											id="dropdownUser" data-bs-toggle="dropdown">
											${noticeDto.m_nickname } </a>

										<jsp:include page="../inc/userDropDownMenu.jsp">
											<jsp:param name="m_no" value="${noticeDto.m_no }"></jsp:param>
											<jsp:param name="m_nickname" value="${noticeDto.m_nickname }"></jsp:param>
										</jsp:include>
										<!-- 프로필 드롭다운 메뉴 종료 -->
									</div>
									<span class="notice_regdate"> <fmt:formatDate
											value="${noticeDto.bd_createddate }"
											pattern="yyyy-MM-dd HH:mm:ss" /></span>
								</div>
							</td>
						<tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>
	</div>	

	<!-- 본문 종료 -->
	<!-- 하이라이트 효과를 주기 위해 사용 -->
	<input type="hidden" class="cateli" value="noticeli">
	<!-- 페이징 시작 -->
	<%@include file="../inc/_page.jspf"%>
	<!-- 페이징 종료 -->

	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>
	<script type=text/javascript src="resources/js/noticelist.js?ver=1.3"></script>

</body>
</html>