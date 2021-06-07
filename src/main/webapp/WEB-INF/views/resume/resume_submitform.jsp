<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>이력서 상세보기</title>
</head>
<body>
<div class="wrap">

<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container-sm mt-5 mb-5" style="max-width: 1100px;">
 		<h1>지원 기업</h1>
 		<img src="resources/images/companyimages/companylistsampleone.png" style="position:relative; left:-40px;"/>
 		<br><br>
 		<h5>제출할 이력서를 선택해 주세요.</h5>
 		<span><span style="color:red;">* </span>이력서는 기업당 1부만 제출이 가능합니다.</span>  
 		
        <br><br>
        	
        
        <table class="table table-bordered table-hover text-center" style="width:1150px;">
            <thead>
                <tr class="d-flex">
                    <th class="col-1">선택</th>
                    <th class="col-8">이력서</th>
                    <th class="col-3">등록일</th>
                </tr>
            </thead>
            <tbody><!--작성된 이력서 목록-->
				<c:choose>
					<c:when test="${empty resumeList }">
						<tr class="d-flex">
							<td class="col-12">=====작성된 이력서가 없습니다.=====</td>							
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${resumeList }" var="resumeList">
							<tr class="d-flex">
								<td class="col-1"><input type="checkbox" name="resumechkbox" value="${resumeList.r_no }" onclick="NoMultiChk(this)"></td>
								<td class="col-8"><a href="resume_detail.do?r_no=${resumeList.r_no }" style="color: black;">${resumeList.r_title }</a></td>
								<td class="col-3"><fmt:formatDate value="${resumeList.r_regdate }" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
        </table>
        <div style="text-align:center;">
        	<br>
			<input type="button" value="제출하기" class="btn btn-primary" onclick="resume_submit()">
			<!-- 게시글 번호 -->
			<input type="hidden" id="bd_no" value="30000">
			
        </div>
</div>
</div>
<!-- 본문 종료 -->
<!-- 하이라이트 효과를 주기 위해 사용 -->
<input type="hidden" class="cateli" value="comli">
<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<script type="text/javascript" src="resources/js/resume/resume_submit.js"></script>

</body>
</html>