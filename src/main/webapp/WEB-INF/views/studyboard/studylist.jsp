<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/studylist.css?ver=1.1">
<title>IT PRO 스터디 글 목록</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
	<div class="study_wrap mt-5">
		<h3>스터디 구인</h3>
		<div class="study_btnwrap mb-4">
			<input type="button" class="btn btn-primary" value="필터/검색" onclick="loc_filter();"> 
			<input type="button" class="btn btn-primary" value="전체 조회"> 
			<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='studyinsertform.do'">
		</div>
		<div class="loc_toggle" style="clear: both; display: none;">
			 <div>
			 <span>지역선택</span>
			 <span style="display:flex; width:300px;" class="mb-2">
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
			<span style="display:flex; width:300px;">
				<select class="form-control mb-2">
					<option>전체</option>
					<option>모집중</option>
					<option>모집완료</option>
				</select>
			</span>
			</div>
			<div style="position:relative; bottom:1px;">
			<span>검색</span>
			<div class="mb-4">
				<input name="searchbox" type="text" placeholder="검색" value=""
					class="form-control search-bar" onkeyup="store_search_ent();"
					style="width: 200px; display: inline-block;">
				<input type="button" class="btn btn-primary" value="검색"
					onclick="store_search();">
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
							<td>${studyDto.st_status} </td>
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
										<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">
											<li><a class="dropdown-item" href="#">쪽지보내기</a></li>
											<li><a class="dropdown-item" href="#">이력서 열람</a></li>
										</ul> <!-- 프로필 드롭다운 메뉴 종료 -->
									</div> 
									<span class="study_regdate"> <fmt:formatDate value="${studyDto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
								</div>
							</td>
						<tr>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
				
		</table>
		</div>
<!-- 본문 종료 -->

<!-- 페이징 시작 -->
<%@include file="../inc/_page.jspf" %>
<!-- 페이징 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
<script type=text/javascript src="resources/js/studylist.js?ver=1.0"></script>
<script type=text/javascript src="resources/js/address.js"></script>
</body>
</html>