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
        <h3>이력서 조회</h3> 	
        <div class="float-end">
        	<c:if test="${sessionScope.login.m_type eq '개인회원' }">
	        	<button class="btn btn-danger" onclick="location.href='resume_delete.do?r_no=${resumeDetailDto.r_no}'">삭제</button>
	        	<button class="btn btn-primary" onclick="location.href='resume_updateForm.do?r_no=${resumeDetailDto.r_no}'">수정</button>
	            <button class="btn btn-success" onclick="location.href='resume_list.do'">목록</button>
	            <button class="btn btn-success" onclick="location.href='mypage_user.do'">마이페이지</button>
        	</c:if>
        </div>
        <br><br>
        <form>
            <div class="col-10 mb-4">
                <h4 class="fw-bold text-center">${resumeDetailDto.r_title }</h4>
            </div>
            
            <h4 class="fw-bold">기본정보</h4>
            <br>
            <div class="clearfix">
                <!--이력서 이미지-->
                <img src="${resumeDetailDto.r_img_path }${resumeDetailDto.r_img }" class="img-thumbnail col-md-6 float-md-end mb-3 ms-md-3" style="width: 200px; height: 200px;" alt="이력서 이미지">
                
                <!--기본 인적사항-->              
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">이 름</h5></div>
                    <div class="col-3">            
                        <span class="fs-5">${memberDto.m_name }</span>            
                    </div> 
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">생년월일</h5></div>
                    <div class="col-3">            
                        <span class="fs-5"><fmt:formatDate value="${memberDto.m_birth }" pattern="yyyy년 MM월 dd일"/></span>           
                    </div>      
                    <div class="col-1"><h5 class="fw-bold">성별</h5></div>
                    <div class="col-1">
                        <span class="fs-5">${memberDto.m_gender }</span>
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">휴대폰</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">${memberDto.m_phone }</span>         
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">이메일</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">${memberDto.m_email }</span>           
                    </div>     
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">주 소</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">${resumeDetailDto.r_roadAddress }${resumeDetailDto.r_detailAddress }</span>            
                    </div>     
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">포폴 링크</h5></div>
                    <div class="col-5">            
                        <span class="fs-5"><a style="color:black;" href="${resumeDetailDto.r_portfolio }">${resumeDetailDto.r_portfolio }</a></span>           
                    </div>     
                </div>
            </div>     
            
            <hr><!---학력사항---->
            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h4 class="fw-bold">학력사항</h4></sapn>
                </div>
            </div>
            <table class="table table-borderless table-sm text-center">
                <thead>
                  <tr>
                    <th class="col-2">입학</th>
                    <th class="col-2">졸업</th>
                    <th class="col-2">학교</th>
                    <th class="col-2">전공</th>
                    <th class="col-2">구분</th>
                    <th class="col-2">졸업여부</th>
                  </tr>
                </thead>
                <tbody>  
                  <c:choose>
					<c:when test="${empty educationList }">
						<tr class="d-flex"><td class="col-12">작성된 내역이 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${educationList}" var="educationList">
							<tr>
								<td><fmt:formatDate value="${educationList.ed_startdate}" pattern="yyyy년 MM월 "/></td>
			                    <td><fmt:formatDate value="${educationList.ed_gradudate}" pattern="yyyy년 MM월 "/></td>
			                    <td>${educationList.ed_schoolName}</td>
			                    <td>${educationList.ed_major}</td>
			                    <td>${educationList.ed_school}</td>
			                    <td>${educationList.ed_graduation}</td>
		                  	</tr>
						</c:forEach> 
					</c:otherwise>
				</c:choose>                            
                </tbody>
            </table>

            <hr><!---자격사항---->

            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h4 class="fw-bold">자격사항</h4></sapn>
                </div>
            </div>
            <table class="table table-borderless table-sm" style='text-align: center'>
                <thead>
                  <tr>
                    <th class="col-4">자격증</th>
                    <th class="col-4">취득년월</th>
                    <th class="col-4">발행기관</th>
                  </tr>
                </thead>
                <tbody>                  
                  <c:choose>
					<c:when test="${empty licenceList }">
						<tr class="d-flex"><td class="col-12">작성된 사항이 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${licenceList}" var="licenceList">
							<tr>
			                    <td>${licenceList.li_title}</td>
			                    <td><fmt:formatDate value="${licenceList.li_date}" pattern="yyyy년 MM월 dd일"/></td>
			                    <td>${licenceList.li_organ}</td>
		                  	</tr>
						</c:forEach> 
					</c:otherwise>
				</c:choose>               
                </tbody>
            </table>
            
            <hr><!---교육 및 사회경험---->

            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h4 class="fw-bold">교육 및 사회경험</h4></sapn>
                </div>
            </div>
            <table class="table table-borderless table-sm" style='text-align: center'>
                <thead>
                  <tr>
                    <th class="col-3">회사·기관</th>
                    <th class="col-3">시작일</th>
                    <th class="col-3">종료일</th>
                    <th class="col-3">세부내용</th>
                  </tr>
                </thead>
                <tbody>
                  </tr>                 
                </tbody>
                <c:choose>
					<c:when test="${empty careerList }">
						<tr class="d-flex"><td class="col-12">작성된 사항이 없습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${careerList}" var="careerList">
							<tr>
			                    <td>${careerList.ca_title}</td>
			                    <td><fmt:formatDate value="${careerList.ca_start_date}" pattern="yyyy년 MM월 dd일"/></td>
			                    <td><fmt:formatDate value="${careerList.ca_end_date}" pattern="yyyy년 MM월 dd일"/></td>
			                    <td>${careerList.ca_content}</td>
		                  	</tr>
						</c:forEach> 
					</c:otherwise>
				</c:choose> 
            </table>

            <hr><!---자소서---->
            
            <div>
                <div>
                    <sapn><h4 class="fw-bold">자기소개서</h4></sapn>
                </div>
                <div>
                    <div class="lh-base" style="height: 500px; white-space:pre-wrap; ">${resumeDetailDto.r_selfletter }</div>
                </div>
            </div>
        </form>
    </div>



<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>