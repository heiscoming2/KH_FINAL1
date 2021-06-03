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
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container-sm mt-5 mb-5" style="max-width: 1100px;">
 		<h1>등록한 채용 공고</h1>
 		<img src="resources/images/companyimages/companylistsampleone.png" style="position:relative; left:-40px;"/>
 		<br><br>
 		<h5>지원자 이력서 정보</h5>
 		<span><span style="color:red;">* </span>지원자 프로필을 클릭 시 작성한 포트폴리오 및 프로젝트 게시글 조회가 가능합니다.</span>  
 		
        <br><br>
        
        <table class="table table-bordered table-hover text-center" style="width:1150px;">
            <thead>
                <tr class="d-flex">
                    <th class="col-2">지원자 프로필</th>
                    <th class="col-6">이력서</th>
                    <th class="col-2">지원일</th>
                    <th class="col-2">승인/거절 처리</th>
                </tr>
            </thead>
            <tbody><!--작성된 이력서 목록-->
				<c:choose>
					<c:when test="${empty CompanyResumeList }">
						<tr class="d-flex">
							<td class="col-12">=====지원자 회원이 존재하지 않습니다.=====</td>							
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${CompanyResumeList }" var="dto">
							<tr class="d-flex">
								<td class="col-2">
										<div class="resume_profile d-flex">
											<img src="${dto.m_img_path }${dto.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
												<a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownUser" data-bs-toggle="dropdown"> 
													${dto.m_nickname }
												</a> 
												<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
												<jsp:include page="../inc/userDropDownMenu.jsp">
													<jsp:param name="m_no" value="${dto.m_no }"></jsp:param>
												</jsp:include>
												<!-- 프로필 드롭다운 메뉴 종료 -->
										</div>
								</td>
								<td class="col-6"><a href="resume_detail.do?r_no=${dto.r_no }" style="color: black;">${dto.r_title }</a></td>
								<td class="col-2"><fmt:formatDate value="${dto.ca_date }" pattern="yyyy-MM-dd"/></td>
							<c:if test="${dto.ca_status eq 'W' }">
								<td class="col-2"><input type="button" class="btn-sm btn-primary" value="서류합격" onclick="statusChange(${dto.r_no},30000,'Y');">&nbsp;&nbsp;<input type="button" class="btn-sm btn-danger" value="서류불합격" onclick="statusChange(${dto.r_no},30000,'N')"></td>
							</c:if>
							<c:if test="${dto.ca_status eq 'Y' }">
								<td class="col-2">
						 			<span style="background-color:#009688; border-radius:8px; color:white; padding:10px; margin-right:5px; margin-top:5px;">
						 			합격 지원자 
						 			</span>								
								</td>
							</c:if>
							<c:if test="${dto.ca_status eq 'N' }">
								<td class="col-2">
						 			<span style="background-color:#E91E63; border-radius:8px; color:white; padding:10px; margin-right:5px;">
						 			불합격 지원자
						 			</span>										
								</td>
							</c:if>
								
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
        </table>
        <div style="text-align:center;">
        	<br>
			<!-- 게시글 번호 -->
			<input type="hidden" id="bd_no" value="30000">
			
        </div>
</div>

<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<script type="text/javascript" src="resources/js/company/companyresumelist.js?ver=1.0"></script>

</body>
</html>