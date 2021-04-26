<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/companycrawlinglist.css">

</head>
<body>

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf" %>
	<!-- HEADER 종료 -->
	
	<!-- 본문 시작 -->
	<div class="joblist_wrap mt-5">
      <h3>채용 정보</h3>
      <div class="job_btn_wrap">
        <input type="button" class="btn btn-primary" value="필터" onclick="filter_toggle();">
        <input type="button" class="btn btn-primary" value="전체 조회">
        <input type="button" class="btn btn-success" value="새로고침" onclick="location.href='guininsertform.html'">
      </div>
      
      <div style="display:none;" class="filter_innerwrap">
        <div>
          <input type="button" class="btn btn-primary" value="지역별 조회">
          <input type="button" class="btn btn-primary" value="경력 선택">
          <input type="button" class="btn btn-primary" value="학력 선택">
          <input type="button" class="btn btn-primary" value="선택 조회">
        </div>
      </div>
      
      <table class="table">
      	<!-- 게시물 th(첫 줄) 영역 -->
      	<col width="212px">
      	<col width="503px">
      	<col width="100px">
      	<col width="122px">
      	<col width="153px">
      	<col width="100px">
      	
      	<tr>
      		<th>기업명</th>
      		<th>제목</th>
      		<th>경력</th>
      		<th>학력</th>
      		<th>지역</th>
      		<th>마감일</th>
      	</tr>
      	
      	<tr>
      		<td>삼성전자</td>
      		<td>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      			<br>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      		</td>
      		<td>신입/경력</td>
      		<td>고졸이상</td>
      		<td>서울시 강남구</td>
      		<td>D~5</td>
      	</tr>
      	
      	<tr>
      		<td>삼성전자</td>
      		<td>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      			<br>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      		</td>
      		<td>신입/경력</td>
      		<td>고졸이상</td>
      		<td>서울시 강남구</td>
      		<td>D~5</td>
      	</tr>
      	
      	<tr>
      		<td>삼성전자</td>
      		<td>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      			<br>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      		</td>
      		<td>신입/경력</td>
      		<td>고졸이상</td>
      		<td>서울시 강남구</td>
      		<td>D~5</td>
      	</tr>
      	
      	<tr>
      		<td>삼성전자</td>
      		<td>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      			<br>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      		</td>
      		<td>신입/경력</td>
      		<td>고졸이상</td>
      		<td>서울시 강남구</td>
      		<td>D~5</td>
      	</tr>
      	
      	<tr>
      		<td>삼성전자</td>
      		<td>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      			<br>
      			<span>채용정보입니다채용정보입니다채용정보입니다채용정보입니다</span>
      		</td>
      		<td>신입/경력</td>
      		<td>고졸이상</td>
      		<td>서울시 강남구</td>
      		<td>D~5</td>
      	</tr>
      	
      	
      </table>
      <!-- 페이징 -->
      <div class="text-center">
        <ul class="pagination" style="justify-content: center;">
          <li class="page-item"><a class="page-link" onclick="">이전</a></li>
          <li class="page-item">
            <a style="color:red;" class="page-link" onclick="">
              <b>1</b>
            </a>
          </li>
          <li class="page-item">
            <a class="page-link" onclick="">2</a>
          </li>
          <li><a class="page-link" onclick="page_next();">다음</a></li>
        </ul>
      </div>
	</div>
      <!-- 검색창 -->
      <div class="text-center mb-5">
        <input name="searchbox" type="text" placeholder="검색" value="" class="form-control search-bar"
          onkeyup="store_search_ent();" style="width:200px; display:inline-block; padding-bottom:11px;">
        <input type="button" class="btn btn-primary" value="검색" onclick="store_search();">
      </div>

	<!-- 본문 종료 -->
		
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf" %>
	<!-- FOOTER 종료 -->

<%@include file="../inc/_foot.jspf" %>
<script type="text/javascript" src="resources/js/companycrawlinglist.js"></script>	
</body>
</html>