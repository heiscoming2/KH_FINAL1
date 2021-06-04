<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/qnalist.css">
<title>포트폴리오/프로젝트</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

  <div class="qna_wrap">
        <h3>QNA 게시판</h3>
        <div class="qna_btnwrap">
			<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='qnainsertform.do'">
		</div>
		
		<!-- <div style="float:right;">
			<div class="mb-4">
				<input name="searchbox" type="text" placeholder="검색" value=""
					class="form-control search-bar" onkeyup="enterKey();"
					style="width: 200px; display: inline-block;">
				<input type="button" class="btn btn-primary" value="검색" onclick="selectPage(1);">
			</div>		
			</div> -->
		
        
        <table class="qna_table">
			<col width="80px;">
			<col width="500px;">
			<col width="80px;">
			<col width="80px;">
			<col width="200px;">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>추천</th>
				<th>조회</th>
				<th>작성자/작성일</th>
			</tr>
        
            <!-- 게시물 한 줄 시작-->
            <tr>
                <c:choose>
					<c:when test="${empty qnaList }">
						<td colspan="4" align="center">
							조회할 게시물이 존재하지 않습니다.
						</td>
					</c:when>
					<c:otherwise>

                  	<c:forEach var="dto" items="${qnaList }">
							<tr>
							<!-- 글 번호 시작 --> 
							<td>${dto.bd_no} </td>
							<td><a href= "qnadetail.do?bd_no=${dto.bd_no}">${dto.bd_title}</a></td>
							<td>+${dto.bd_recommandcount }</td>
							<td>${dto.bd_viewcount }</td>
							<td>
							    <div class="qna_profile">
								<img src="${dto.m_img_path }${dto.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
									<div class="qna_writer"> 
										<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
											${dto.m_nickname }
										</a>
										<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
												<jsp:include page="../inc/userDropDownMenu.jsp">
													<jsp:param name="m_no" value="${dto.m_no }"></jsp:param>
												</jsp:include>
												<!-- 프로필 드롭다운 메뉴 종료 -->
									</div> 
									<span class="qna_regdate"> <fmt:formatDate value="${dto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
								</div>
							</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>	
		</table>
		</div>
            <!-- 게시물 한 줄 종료 -->
     
 
<!-- 페이징 시작 -->
<%@include file="../inc/_page.jspf" %>
<!-- 페이징 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<!-- <script type=text/javascript src="resources/js/qnalist.js?ver=1.1"></script> -->
</body>
</html>