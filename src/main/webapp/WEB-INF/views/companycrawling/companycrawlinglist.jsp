<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/companycrawlinglist.css?ver=1.3">

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
	        <input type="button" class="btn btn-success" value="새로고침" onclick="location.href='companycrawlingwating.do'">
	        <input type="button" class="btn btn-success" value="전체삭제" onclick="location.href='companycrawlingdelete.do'">
	      </div>
      </div>
      
      <div class="filter_innerwrap mt-3" style="<c:if test='${companyCrawlingSearchDto ne null }'>display:block;</c:if>">
       <div>
       	  <table class="filter_table" >
       	  <tr>
	          <td>
	          	  <span>지역선택</span>
	          </td>
	          <td style="display:flex;">
                   <select class="sidoselect form-control" id="sidoselect" onchange="change(this.selectedIndex);">
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
		          &nbsp;&nbsp;
	  	          <select class="form-control gugunselect" name="gugunselect" id="gugunselect">
	  	          	   <option value=''>전체</option>
	  	          </select>
       	  	  </td>
       	  </tr>
       	  <tr>
       	      <td>
       	      	  <span>경력선택</span>
       	      </td>
       	      <td>
	  	          <select class="form-control careerselect" id="careerselect">
		          	<option value=4>전체</option>
		          	<option value="1">무관</option>
		          	<option value="2">신입</option>
		          	<option value="3">경력</option>
		          </select>
	          </td>   
       	  </tr>
       	  <tr>
       	  	  <td>
	         	   <span>학력선택</span>
	          </td>
	          <td>
		          <select class="form-control eduselect" id="eduselect">
		          	<option value=4>전체</option>
		          	<option value="1">학력무관</option>
		          	<option value="2">고등학교 졸업 이하</option>
		          	<option value="3">대학교 졸업 이하 (2/3년제)</option>
		          </select>     	  	  
       	  	  </td>	
       	  </tr>
       	  <tr>
       	  <td colspan="3">
        <!-- 검색창 -->
	    <div class="mb-3">
	      <input type="button" class="btn btn-primary" value="검색" onclick="selectPage(1)">
	      <input id="searchbox" type="text" placeholder="회사명 or 채용정보" class="form-control search-bar cc_search"
	          onkeyup="enterKey();">
	    </div>
	    </td>
       	  </tr>
	    </table>
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
      		<th class="cc_name_th"><a>기업명</a></th>
      		<th>제목</th>
      		<th>경력</th>
      		<th>학력</th>
      		<th>지역</th>
      		<th>마감일</th>
      	</tr>
      	
      	<c:choose>
      		<c:when test="${empty companyCrawlingList }">
				<tr>
					<td colspan="6" align="center">조회할 게시물이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="companyCrawlingDto" items="${companyCrawlingList }">
			      	<tr onclick="openDetailUrl('${companydetailurl}${companyCrawlingDto.cc_code}');">      		
			      		<td class="cc_name"><a>${companyCrawlingDto.cc_name }</a></td>
			      		<td>
			      			<span class="cc_title">${companyCrawlingDto.cc_title}</span>
			      			<br>
			      			<span class="cc_meta">${companyCrawlingDto.cc_meta }</span>
			      		</td>
			      		<td class="cc_career">${companyCrawlingDto.cc_career }</td>
			      		<td class="cc_education">${companyCrawlingDto.cc_education }</td>
			      		<td class="cc_addr1_2">${companyCrawlingDto.cc_addr1}&nbsp;${companyCrawlingDto.cc_addr2 }</td>
			      		<td class="cc_deadline">${companyCrawlingDto.cc_deadline }</td>
			      	</tr>
				</c:forEach>
			</c:otherwise>
      	</c:choose>
      </table>
      <!-- 페이징 -->
	<%@include file="../inc/_page.jspf" %>
	<!-- 페이징 종료 -->
	</div>
	<!-- 본문 종료 -->
		
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf" %>
	<!-- FOOTER 종료 -->


<%@include file="../inc/_foot.jspf" %>

<!-- 넘어온 검색정보가 있다면 지역 정보를 hidden 태그로 전달하고 이 값으로 지역선택 초기값을 설정한다. -->
<c:if test="${companyCrawlingSearchDto ne null}">
	<input type="hidden" id="h_addr1" value="${companyCrawlingSearchDto.src_a1 }">
	<input type="hidden" id="h_addr2" value="${companyCrawlingSearchDto.src_a2 }">
	<input type="hidden" id="h_careerselect" value="${companyCrawlingSearchDto.src_cer }">
	<input type="hidden" id="h_eduselect" value="${companyCrawlingSearchDto.src_edu }">
	<input type="hidden" id="h_searchbox" value="${companyCrawlingSearchDto.src_key }">
</c:if>
	
<script type="text/javascript" src="resources/js/companycrawling/companycrawlinglist.js?ver=1.2"></script>
<script type="text/javascript" src="resources/js/address.js"></script>
</body>
</html>