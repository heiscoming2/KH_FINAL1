<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/studylist.css">
<title>IT PRO 스터디 글 목록</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
	<div class="study_wrap mt-5">
		<h3>스터디 구인</h3>
		<div class="study_btnwrap">
			<input type="button" class="btn btn-primary" value="필터" onclick="loc_filter();"> 
			<input type="button" class="btn btn-primary" value="전체 조회"> 
			<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='studyinsertform.do'">
		</div>
		<div class="loc_toggle" style="clear: both; display: none;">
			 <div>
			 <span>지역설정</span>
			 <span style="display:flex; width:300px;">
				<select class="form-control select_sido">
					<option>서울시</option>
					<option>경기도</option>
					<option>광주광역시</option>
				</select> 
				<select class="form-control select_sigu">
					<option>관악구</option>
					<option>어디구</option>
					<option>어디구</option>
				</select>
			</span>
			</div>
			<div>
			<span>모집여부</span>
			<span style="display:flex; width:300px;">
				<select class="form-control">
					<option>전체</option>
					<option>모집중</option>
					<option>모집완료</option>
				</select>
			</span>
			</div>
			<div style="position:relative; bottom:1px;">
			<span>검색</span>
				<div class="text-center">
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
			<col width="500px;">
			<col width="80px;">
			<col width="200px;">
			<tr>
				<th>번호</th>
				<th>모집여부</th>
				<th>지역</th>
				<th>인원수</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자/작성일</th>
			</tr>
			<!-- 게시물 한 줄 시작-->
			<tr>
				<!-- 글 번호 시작 --> 
				<td>123123</td>
				<td>모집중</td>
				<td>서울시 관악구</td>
				<td>1 / 3</td>
				<td>자바 초보자 구합니다. [7]</td>
				<td>12312</td>
				<td>
				    <div class="study_profile">
						<img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
						<div class="study_writer"> 
							<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
								hyojun9292 
							</a> 
							<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
							<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">
								<li><a class="dropdown-item" href="#">쪽지보내기</a></li>
								<li><a class="dropdown-item" href="#">이력서 열람</a></li>
							</ul> <!-- 프로필 드롭다운 메뉴 종료 -->
						</div> 
						<span class="study_regdate"> 2021-03-28 13:13 </span>
					</div>
				</td>
			</tr>	
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
	
</body>
</html>