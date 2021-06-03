<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/studylist.css?ver=1.3">
<title>IT PRO 스터디 글 목록</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
	<div class="content">
	<div class="study_wrap mt-5">
		<h3>스터디 모집</h3>
		<div class="study_btnwrap mb-4">
			<input type="button" class="btn btn-primary" value="필터/검색" onclick="loc_filter();"> 
			<input type="button" class="btn btn-primary" value="전체 조회" onclick="location.href='studylist.do';"> 
			<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='studyinsertform.do'">
		</div>
		<div class="loc_toggle" style="clear: both; display: none;">
			 <div>
			 <span>지역선택</span>
			 <span class="gugunselect_wrap mb-2">
                <select class="sidoselect form-control" style="margin-right:10px;" name="st_addr1" onchange="change(this.selectedIndex);">
                       <option value=''>전체</option>
                       <option value='서울'>서울</option>
                       <option value='경기'>경기</option>
                       <option value='대구'>대구</option>
                       <option value='인천'>인천</option>
                       <option value='광주'>광주</option>
                       <option value='대전'>대전</option>
                       <option value='울산'>울산</option>
                       <option value='부산'>부산</option>
                       <option value='강원'>강원</option>
                       <option value='충북'>충북</option>
                       <option value='충남'>충남</option>
                       <option value='전북'>전북</option>
                       <option value='전남'>전남</option>
                       <option value='경북'>경북</option>
                       <option value='경남'>경남</option>
                       <option value='제주'>제주</option>
                    </select>                                                  
	  	          <select class="form-control gugunselect" id="gugunselect" name="st_addr2">
	  	          	   <option value=''>전체</option>
	  	          </select>
			</span>
			</div>
			<div>
			<span>모집여부</span>
			<span class="status_wrap">
				<select class="form-control mb-2 status">
					<option value=''>전체</option>
					<option value='Y'>모집중</option>
					<option value='N'>모집완료</option>
				</select>
			</span>
			</div>
			<div style="position:relative; bottom:1px;">
			<span>검색</span>
			<div class="mb-4">
				<input name="searchbox" type="text" placeholder="검색" value=""
					class="form-control search-bar" onkeyup="enterKey();"
					style="width: 200px; display: inline-block;">
				<input type="button" class="btn btn-primary" value="검색" onclick="selectPage(1);">
			</div>		
			</div>
		</div>
		<table class="table study_table">
			<col width="80px;">
			<col width="80px;">
			<col width="150px;">
			<col width="100px;">
			<col width="420px;">
			<col width="80px;">
			<col width="80px;">
			<col width="200px;">
			<tr>
				<th class="bd_no_th"><a>번호</a></th>
				<th>모집여부</th>
				<th>지역</th>
				<th>인원수</th>
				<th>제목</th>
				<th>추천수</th>
				<th>조회수</th>
				<th>작성정보</th>
			</tr>
			<!-- 게시물 한 줄 시작-->
			<c:choose>
				<c:when test="${empty studyList }">
					<tr>
						<td colspan="8" align="center">조회할 게시물이 존재하지 않습니다.</td>
					</tr>			
				</c:when>
				<c:otherwise>
					<c:forEach var="studyDto" items="${studyList }">
					<tr>
							<!-- 글 번호 시작 --> 
							<td class="bd_no"><a>${studyDto.bd_no}</a> </td>
							<c:choose>
								<c:when test="${studyDto.st_status eq 'Y'}">
									<td style="color:#0d6efd;"><b>모집중</b></td>
									<td class="st_addr1_2">${studyDto.st_addr1 } ${studyDto.st_addr2 }</td>
									<td class="st_person">${studyDto.st_nowperson } / ${studyDto.st_closeperson }</td>
									<td><a href="studydetail.do?bd_no=${studyDto.bd_no }" style="color:black;">${studyDto.bd_title } <span class="replycount">+${studyDto.bd_replycount }</span></a></td>
									<td class="bd_recommandcount"><b>+${studyDto.bd_recommandcount }</b></td>
									<td class="bd_viewcount">${studyDto.bd_viewcount }</td>
									<td>
									    <div class="study_profile">
											<img src="${studyDto.m_img_path }${studyDto.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
											<div class="study_writer"> 
												<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
													${studyDto.m_nickname }
												</a> 
												<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
												<jsp:include page="../inc/userDropDownMenu.jsp">
													<jsp:param name="m_no" value="${studyDto.m_no }"></jsp:param>
												</jsp:include>
												<!-- 프로필 드롭다운 메뉴 종료 -->
											</div> 
											<span class="study_regdate"> <fmt:formatDate value="${studyDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
										</div>
									</td>									
								</c:when>
								<c:otherwise>
									<td style="color:lightgray;">모집완료</td>	
									<td class="st_addr1_2" style="color:lightgray;">${studyDto.st_addr1 } ${studyDto.st_addr2 }</td>
									<td class="st_person" style="color:lightgray;">${studyDto.st_nowperson } / ${studyDto.st_closeperson }</td>
									<td style="color:lightgray;"><a href="studydetail.do?bd_no=${studyDto.bd_no }" style="color:black;"><span style="color:lightgray;">${studyDto.bd_title }</span> <span class="replycount">+${studyDto.bd_replycount }</span></a></td>
									<td class="bd_recommandcount"><b>+${studyDto.bd_recommandcount }</b></td>
									<td class="bd_viewcount">${studyDto.bd_viewcount }</td>
									<td>
									    <div class="study_profile">
											<img src="${studyDto.m_img_path }${studyDto.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
											<div class="study_writer"> 
												<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
													${studyDto.m_nickname }
												</a> 
												<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
												<jsp:include page="../inc/userDropDownMenu.jsp">
													<jsp:param name="m_no" value="${studyDto.m_no }"></jsp:param>
												</jsp:include>
												<!-- 프로필 드롭다운 메뉴 종료 -->
											</div> 
											<span class="study_regdate"> <fmt:formatDate value="${studyDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
										</div>
									</td>														
								</c:otherwise>
							</c:choose>

						<tr>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
				
		</table>
		</div>
		</div>
<!-- 검색 결과를 히든 태그에 담아둔다. (없으면 null값이 담길것임) 이거를 js에서 받아서 -->
<!-- null이 아닌 경우(검색 결과가 있는 경우) 해당하는 내용들을 보여지게끔 처리 -->
<c:if test="${studySearchDto ne null }">
	<input type="hidden" id="h_a1" value="${studySearchDto.a1 }">
	<input type="hidden" id="h_a2" value="${studySearchDto.a2 }">
	<input type="hidden" id="h_stat" value="${studySearchDto.stat }">
	<input type="hidden" id="h_key" value="${studySearchDto.key }">
</c:if>
		
<!-- 본문 종료 -->

<!-- 페이징 시작 -->
<%@include file="../inc/_page.jspf" %>
<!-- 페이징 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<script type=text/javascript src="resources/js/studylist.js?ver=1.3"></script>
<script type=text/javascript src="resources/js/address.js"></script>
<script type=text/javascript src="resources/js/company/companylist.js?ver=1.5"></script>
</body>
</html>