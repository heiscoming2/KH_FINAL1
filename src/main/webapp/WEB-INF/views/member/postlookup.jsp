<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/postlookup.css?vser=1.9" rel="stylesheet">
<title>IT PRO - 작성 글 관리</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

	<div class="postlookup_wrap" style="width:1190px; margin:0 auto;">	
	<!-- 작성 글 조회  영역 시작 -->
			<br>
			<br>
			<h1><c:out value="${writer.m_nickname }"></c:out>님의 작성 글 조회</h1>
			<span>총 게시물 수 : <c:out value="${postlookupcnt }"></c:out></span>
			<hr>
			<br>
			<div class="categorywrap">
	 			<span class="cate0 cate" onclick="selectCate(0)">전체<span style="color:lightgray;"> | </span></span>
	 			<span class="cate7 cate" onclick="selectCate(7)">포트폴리오<span style="color:lightgray;"> | </span></span>
	 			<span class="cate1 cate" onclick="selectCate(1)">프로젝트<span style="color:lightgray;"> | </span></span>
	 			<span class="cate2 cate" onclick="selectCate(2)">Q & A<span style="color:lightgray;"> | </span></span>
	 			<span class="cate3 cate" onclick="selectCate(3)">스터디모집  </span>
	 		</div>
	 		<br>
	 		<div class="buttonwrap">
	 			<c:if test="${sessionScope.login.m_no eq writer.m_no}">
				<input type="button" value="선택삭제" class="btn btn-danger">
				</c:if>
				<input style="float:right; clear:both;" type="button" value="검색" class="btn btn-primary" onclick="selectPage(1)">
				
				<input style="margin-right:10px; 
				<c:if test='${sessionScope.login.m_no ne writer.m_no}'>margin-bottom:30px;</c:if>
				float:right; display:inline-block; width:200px;" type="search" placeholder="제목/내용" class="form-control" id="keyword" value="${keyword }">
	 		</div>
			<br>
			<table class="table postlookup_table" id="table-list">
				<c:if test="${sessionScope.login.m_no eq writer.m_no}">
				<col width="50px;">
				</c:if>
				<col width="80px;">
				<col width="200px;">
				<col width="520px;">
				<col width="80px;">
				<col width="80px;">
				<col width="200px;">
				<tr>
					<c:if test="${sessionScope.login.m_no eq writer.m_no}">
					<th class="text-center"><input type="checkbox" class="custom-control custom-checkbox"></th>
					</c:if>
					<th class="bd_no_th"><a>번호</a></th>
					<th>카테고리</th>
					<th>제목</th>
					<th>추천수</th>
					<th>조회수</th>
					<th>작성정보</th>
				</tr>
				<!-- 게시물 한 줄 시작-->
				<c:choose>
					<c:when test="${empty postLookupList}">
						<tr>
							<td colspan="7" align="center">작성한 게시물이 존재하지 않습니다.</td>
						</tr>			
					</c:when>
					<c:otherwise>
						<c:forEach var="postLookupDto" items="${postLookupList }">
						<tr>
								<!-- 글 번호 시작 --> 
								<c:if test="${sessionScope.login.m_no eq writer.m_no}">
								<td align="center"><input type="checkbox" name="postListDel" bc_code=${postLookupDto.bc_code } & bd_no=${postLookupDto.bd_no}></td>
								</c:if>
								<td class="bd_no">${postLookupDto.bd_no}</td>
								<td>${postLookupDto.name } </td>
								<td><a href="boarddetail.do?bc_code=${postLookupDto.bc_code }&bd_no=${postLookupDto.bd_no}&m_no=${writer.m_no}" style="color:black;">${postLookupDto.bd_title }<span class="replycount"> +${postLookupDto.bd_replycount }</span></a></td>
								<td class="bd_recommandcount"><b>${postLookupDto.bd_recommandcount }</b></td>
								<td class="bd_viewcount">${postLookupDto.bd_viewcount }</td>
								<td>
								    <div class="postlookup_profile">
										<img src="${writer.m_img_path }${writer.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
										<div class="postlookup_writer"> 
											<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
												${writer.m_nickname }
											</a> 
											<!-- 프로필 드롭다운 메뉴 -->
											<jsp:include page="../inc/userDropDownMenu.jsp">
												<jsp:param name="m_no" value="${writer.m_no }"></jsp:param>
											</jsp:include>
											<!-- 프로필 드롭다운 메뉴 종료 -->
										</div>
										<span class="postlookup_regdate">
											<fmt:formatDate value="${postLookupDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/>
										</span>
									</div>
								</td>
							<tr>	
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			</div>
	<!-- 스터디 모집 영역 종료 -->		

<!-- 페이징 시작 -->
<%@include file="../inc/_page.jspf" %>
<!-- 페이징 종료 -->

  	<!-- 사용자 세션/현재 카테고리 -->
	<input id="writer_mno" type="hidden" value="${writer.m_no}">
	<input id="category" type="hidden" value="${category }">
	
	
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<script type="text/javascript" src="resources/js/postlookup.js?ver=1.4"></script>
	
</body>
</html>