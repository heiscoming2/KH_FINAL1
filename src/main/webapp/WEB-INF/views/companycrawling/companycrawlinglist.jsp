<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/companycrawlinglist.css?ver=1.1">

</head>
<body>

	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf" %>
	<!-- HEADER 종료 -->
	
	<!-- 본문 시작 -->
	<div class="joblist_wrap mt-5">
      <h3>채용 정보</h3>
      <div class="job_btn_wrap">
        <input type="button" class="btn btn-primary" value="필터/검색" onclick="filter_toggle();">
        <input type="button" class="btn btn-primary" value="전체 조회" onclick="location.href='companycrawlinglist.do'">
	      <div class="admin_btn" style="float:right;">
	        <input type="button" class="btn btn-success" value="새로고침" onclick="location.href='companycrawlingupdate.do'">
	        <input type="button" class="btn btn-success" value="전체삭제" onclick="location.href='companycrawlingdelete.do'">
	      </div>
      </div>
      
      <div class="filter_innerwrap mt-3" style="<c:if test='${companyCrawlingSearchDto ne null }'>display:block;</c:if>">
       <div>
       	<form action="test.do" id="test">
       	  <table class="filter_table">
       	  <tr>
	          <td>
	          	  <span>지역선택</span>
	          </td>
	          <td style="display:flex;">
		          <select class="form-control sidoselect" name="sido1">
		          	<c:if test='${companyCrawlingSearchDto ne null }'>
		          		<option>${companyCrawlingSearchDto.src_a1 }</option>
		          	</c:if>
		          </select>
		          &nbsp;&nbsp;
	  	          <select class="form-control gugunselect" name="gugun1"></select>
       	  	  </td>
       	  </tr>
       	  <tr>
       	      <td>
       	      	  <span>경력선택</span>
       	      </td>
       	      <td>
	  	          <select class="form-control careerselect">
		          	<option>전체</option>
		          	<option>신입</option>
		          	<option>경력</option>
		          </select>
	          </td>   
       	  </tr>
       	  <tr>
       	  	  <td>
	         	   <span>학력선택</span>
	          </td>
	          <td>
		          <select class="form-control eduselect">
		          	<option>전체</option>
		          	<option>학력무관</option>
		          	<option>고등학교 졸업 이하</option>
		          	<option>대학교 졸업 이하 (2/3년제)</option>
		          </select>     	  	  
       	  	  </td>	
       	  </tr>
       	  <tr>
       	  <td colspan="3">
        <!-- 검색창 -->
	    <div class="mb-3">
	      <input type="button" class="btn btn-primary" value="조회" onclick="selectPage(1)">
	      <input name="searchbox" type="text" placeholder="회사명 or 채용정보" class="form-control search-bar cc_search"
	          onkeyup="store_search_ent();">
	    </div>
	    </td>
       	  </tr>
	    </table>
	    </form>
      </div>
      </div>
      
      <table class="companycrawlingtable table mt-4">
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
      	
      	<c:choose>
      		<c:when test="${empty companyCrawlingList }">
				<tr>
					<td colspan="6" align="center">조회할 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="companyCrawlingDto" items="${companyCrawlingList }">
			      	<tr onclick="openDetailUrl('${companydetailurl}${companyCrawlingDto.cc_code}');">      		
			      		<td onclick="testfunction();">${companyCrawlingDto.cc_name }</td>
			      		<td>
			      			<span class="cc_title">${companyCrawlingDto.cc_title}</span>
			      			<br>
			      			<span class="cc_meta">${companyCrawlingDto.cc_meta }</span>
			      		</td>
			      		<td>${companyCrawlingDto.cc_career }</td>
			      		<td>${companyCrawlingDto.cc_education }</td>
			      		<td>${companyCrawlingDto.cc_addr1}&nbsp;${companyCrawlingDto.cc_addr2 }</td>
			      		<td>${companyCrawlingDto.cc_deadline }</td>
			      	</tr>
				</c:forEach>
			</c:otherwise>
      	</c:choose>

      	
      </table>
      
      
      <!-- 페이징 -->
      <div class="text-center mt-5 mb-5">
        <ul class="pagination" style="justify-content: center; cursor:pointer;">
       	  	<li class="page-item"><a class="page-link" onclick="selectPage(1)">처음</a></li>
         	<li class="page-item"><a class="page-link" onclick="selectPage('${pageProcessing.prevPage}')">이전</a></li>
          <c:forEach var="pageNum" begin="${pageProcessing.startPage}" end="${pageProcessing.endPage }">
          	<c:choose>
          		<c:when test="${pageNum eq pageProcessing.curPage }">
		            <li class="page-item">
		               <a style="color:red;" class="page-link" onclick="selectPage('${pageNum}');">
		                 <b>${pageNum}</b>
		               </a>
		          </li>
          		</c:when>
          		<c:otherwise>
	          		<li class="page-item">
	          			<a class="page-link" onclick="selectPage(${pageNum});">
	          			  ${pageNum}
	          			</a>
	          		</li>
          		</c:otherwise>
          	</c:choose>
	      </c:forEach>
	         <li><a class="page-link" onclick="selectPage('${pageProcessing.nextPage}')">다음</a></li>
         	 <li><a class="page-link" onclick="selectPage('${pageProcessing.pageCnt}')">끝</a></li>
        </ul>
      </div>
	</div>
	<!-- 페이징 종료 -->
	


	<!-- 본문 종료 -->
		
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf" %>
	<!-- FOOTER 종료 -->

<%@include file="../inc/_foot.jspf" %>
<script type="text/javascript" src="resources/js/companycrawlinglist.js?ver=1.0"></script>	
</body>
</html>