<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="./inc/_head.jspf" %>
<link href="resources/css/postlookup.css?vser=1.9" rel="stylesheet">
<title>IT PRO - 작성 글 관리</title>
</head>
<body>
<div class="wrap">
<!-- HEADER 시작 -->
<%@include file="./inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
	<div class="postlookup_wrap" style="width:1190px; margin:0 auto;">	
	<!-- 작성 글 조회  영역 시작 -->
			<br>
			<br>
			<h1>"<c:out value="${keyword }"></c:out>"검색 결과</h1>
			<span>총 게시물 수 : <c:out value="${searchlistcnt }"></c:out></span>
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
	 		<!-- 

				<!-- 게시물 한 줄 시작-->
				<c:choose>
					<c:when test="${empty searchList}">
						<tr>
							<td colspan="6" align="center">조회할 게시물이 존재하지 않습니다.</td>
						</tr>			
					</c:when>
					<c:otherwise>
						<c:forEach var="searchDto" items="${searchList }">
						<tr>
								<!-- 글 번호 시작 --> 
								<td class="bd_no">${searchDto.bd_no}</td>
								<td>${searchDto.name } </td>
								<td><a href="boarddetail.do?bc_code=${searchDto.bc_code }&bd_no=${searchDto.bd_no}" style="color:black;">${searchDto.bd_title }<span class="replycount"> +${searchDto.bd_replycount }</span></a></td>
								<td class="bd_recommandcount"><b>${searchDto.bd_recommandcount }</b></td>
								<td class="bd_viewcount">${searchDto.bd_viewcount }</td>
								<td>
								    <div class="postlookup_profile">
										<img src="${searchDto.m_img_path }${searchDto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
										<div class="postlookup_writer"> 
											<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
												${searchDto.m_nickname }
											</a> 
											<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
											<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">
												<li><a class="dropdown-item" href="#">쪽지보내기</a></li>
												<li><a class="dropdown-item" href="#">이력서 열람</a></li>
											</ul> <!-- 프로필 드롭다운 메뉴 종료 -->
										</div>
										<span class="postlookup_regdate">
											<fmt:formatDate value="${searchDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<%@include file="./inc/_page.jspf" %>
<!-- 페이징 종료 -->
</div>
  	<!-- 검색 키워드/카테고리 -->
	<input id="keyword" type="hidden" value="${keyword }">
	<input id="category" type="hidden" value="${category }">
	
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="./inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="./inc/_foot.jspf" %>

<script type="text/javascript" src="resources/js/searchlist.js?ver=1.4"></script>
	
</body>
</html>