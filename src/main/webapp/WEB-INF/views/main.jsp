<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>IT PRO</title>
<%@include file="./inc/_head.jspf" %>
<link rel="stylesheet" type="text/css" href="resources/css/slidebar.css?ver=1.4">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrap">

<!-- HEADER 시작 -->
<%@include file="./inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 점보트론 -->
<div class="mt-3" style="height:300px; width:850px; margin:0 auto;">
	<div style="float:left; padding-top:30px;">
		<h2><b>IT PRO 에서는</b></h2>
		<h3><b>개발자들의 다양한</b></h3>
		<h3><b>포트폴리오를 공유합니다</b></h3>
		<br>
		<h6>내 포트폴리오를 등록하고</h6>
		<h6>채용 기업/개발자들의</h6>
		<h6>실제 평가를 받아 볼 수 있습니다.</h6>
		<input type="button" class="btn btn-primary" value="회원가입하고 포트폴리오 등록하기" onclick="location.href='join.do'">
	</div>
	<div style="float:right;">
		<img src="resources/images/mainimages/introduction-img.png">
	</div>
</div>
<!-- 점보트론 종료 -->


<!-- 광고배너1시작 -->
<br>
<br>
<div class="banner" style="text-align:center; background-color:rgb(125, 120, 212);">
	<img src="resources/images/bannerimages/banner_sample.png">
</div>
<!-- 광고배너1종료 -->


<!-- 인기 포트폴리오 슬라이드 시작 -->
	<section id="testimonial" class="section-100 mt-5">
		<div style="width:90%; margin:0 auto;">
			<div class="testimonial-view">
				<h5 class="text-center">
					<img src="resources/images/mainimages/pngwing.png" style="width:50px; height:50px;">
					<b>TOP 10 포트폴리오</b> <input type="button" class="btn btn-primary ml-3" value="더 보기" onclick="location.href='portfoliolist.do'">
				</h5>
				<div class="owl-carousel">
					<!-- 프로필 시작 -->
					<c:forEach var="mainPagePortfolioList" items="${mainPagePortfolioList }">
					<div onclick="location.href='portfoliodetail.do?bd_no=${mainPagePortfolioList.bd_no}&m_no=${mainPagePortfolioList.m_no}'">
						<div class="testimonial-box" >
							<div class="d-flex justify-content-center align-items-center mb-2" >
								<img src="testimages/testprofile.jpg" alt="" class="user-img mr-2">
								<div>
									<h6 class="mb-0"><b>&nbsp;&nbsp;&nbsp;${mainPagePortfolioList.m_nickname }</b>
									</h6>
									
									<p class="text-muted mb-0" style="font-size: 8px; margin:0; padding:0;">
										&nbsp;&nbsp;&nbsp;
										<span style="text-decoration: underline;">
											<fmt:formatDate value="${mainPagePortfolioList.m_birth}" pattern="yyyy-MM-dd"/>
										</span>
									</p>
								</div>
							</div>
							<hr class="mb-2" style="width:80%; margin: 0 auto; color:#212529;">
							<div style="width:80%; margin: 0 auto;">
								<div style="margin-bottom: 8px;">
									<p style="font-size: 8px; margin:0; padding:0;">
										<b style="background-color:#EEEBFF; padding:2px; color:#0078FF;">· 포트폴리오 소개</b><br>
										<span style="color:#6c757d;">${mainPagePortfolioList.bd_content } </span>
									</p>
								</div>
								<div>
									<div style="font-size: 8px; margin:0; padding:0; margin-bottom:8px;">
										<div>
										<b style="background-color:#EEEBFF; padding:2px; color:#0078FF;">· 사용 개발 기술</b>
										</div>
										<span style="color:#6c757d; margin-bottom:8px;">${mainPagePortfolioList.port_develop } </span>
									</div>
									<div style="font-size: 8px; margin:0; padding:0;">
										<b style="background-color:#EEEBFF; padding:2px; color:#0078FF;">· 경력사항</b>
									</div>
										<c:forEach var="careerdto" items="${mainPagePortfolioList.careerdto }">
											<p style="font-size: 8px; margin:0; padding:0; color:#6c757d;">
											(
											<fmt:formatDate value="${careerdto.ca_start_date}" pattern="yyyy-MM"/>
											~
											<fmt:formatDate value="${careerdto.ca_end_date}" pattern="yyyy-MM"/>
											) 
											${careerdto.ca_title }
											</p>
										</c:forEach>
								</div>
							</div>
						</div>
					  </div>
					</c:forEach>
					<!-- 프로필 종료 -->
				</div>
			</div>
		</div>
	</section>
	<!-- 인기 포트폴리오 슬라이드 종료 -->
	
	<!-- 광고배너2시작 -->
	<br>
	<br>
	<div class="banner" style="text-align:center; background-color:black;">
		<img src="resources/images/bannerimages/banner_sample2.jpg">
	</div>
	<!-- 광고배너1종료 -->
	
	<!--게시판 시작-->
    <div class="container w-75 mt-5">
      <div class="row">
        <div class="col"><!--왼쪽 상단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold" onclick="location.href='noticelist.do'" 
            style="cursor:pointer; background-color:#EEEBFF; padding:10px; 
            border:1px solid lightgray; color:#0078FF;">공지사항 >></h5>
          </div>
          <table class="table table-sm table-hover table-main" style='text-align: center' >
            <thead>
              <tr>
                <th class="col-lg-1">No.</th>
                <th class="col-lg-4">제목</th>
                <th class="col-lg-2">작성자</th>
                <th class="col-lg-2">일자</th>
                <th class="col-lg-1">조회</th>
                <th class="col-lg-1">추천</th>
              </tr>
            </thead>
            <tbody>
	          <c:forEach var="dto" items="${mainPageBoardList }">
	          	<c:if test="${dto.name eq '공지사항' }">
	              <tr>
	                <td>${dto.bd_no }</td>
	                <td><a href="noticedetail.do?bd_no=${dto.bd_no }">${dto.bd_title }</a></td>
	                <td>${dto.m_nickname }</td>
	                <td><fmt:formatDate value="${dto.bd_createddate }" pattern="yy-MM-dd"/></td>
	                <td>${dto.bd_viewcount }</td>
	                <td>${dto.re_recommandcount }</td>
	              </tr>
	             </c:if> 
	          </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col"><!--오른쪽 상단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold" style="background-color:#EEEBFF; padding:10px; border:1px solid lightgray; margin-left:10px; color:#0078FF; cursor:pointer;"
            onclick="location.href='portfoliolist.do'">포트폴리오 >></h5>
          </div>
          <table class="table table-sm table-hover table-main" style='text-align: center' >
            <thead>
              <tr>
            <th class="col-lg-1">No.</th>
            <th class="col-lg-4">제목</th>
            <th class="col-lg-2">작성자</th>
            <th class="col-lg-2">일자</th>
            <th class="col-lg-1">조회</th>
            <th class="col-lg-1">추천</th>
              </tr>
            </thead>
            <tbody>
	          <c:forEach var="dto" items="${mainPageBoardList }">
	          	<c:if test="${dto.name eq '포트폴리오' }">
	              <tr>
	                <td>${dto.bd_no }</td>
	                <td><a href="portfoliodetail.do?bd_no=${dto.bd_no }&m_no=${dto.m_no}">${dto.bd_title }</a></td>
	                <td>${dto.m_nickname }</td>
	                <td><fmt:formatDate value="${dto.bd_createddate }" pattern="yy-MM-dd"/></td>
	                <td>${dto.bd_viewcount }</td>
	                <td>${dto.re_recommandcount }</td>
	              </tr>
	             </c:if> 
	          </c:forEach>            
            </tbody>
          </table>
        </div>
      </div><br>
      <div class="row">
        <div class="col"><!--왼쪽 하단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold" style="background-color:#EEEBFF; padding:10px; border:1px solid lightgray; color:#0078FF; cursor:pointer;" 
            onclick="location.href='projectlist.do'">프로젝트 >></h5>
          </div>
          <table class="table table-sm table-hover table-main" style='text-align: center' >
            <thead>
              <tr>
                <th class="col-lg-1">No.</th>
                <th class="col-lg-4">제목</th>
                <th class="col-lg-2">작성자</th>
                <th class="col-lg-2">일자</th>
                <th class="col-lg-1">조회</th>
                <th class="col-lg-1">추천</th>
              </tr>
            </thead>
            <tbody>
	          <c:forEach var="dto" items="${mainPageBoardList }">
	          	<c:if test="${dto.name eq '프로젝트' }">
	              <tr>
	                <td>${dto.bd_no }</td>
	                <td><a href="projectdetail.do?bd_no=${dto.bd_no }" style="cursor:pointer;">${dto.bd_title }</a></td>
	                <td>${dto.m_nickname }</td>
	                <td><fmt:formatDate value="${dto.bd_createddate }" pattern="yy-MM-dd"/></td>
	                <td>${dto.bd_viewcount }</td>
	                <td>${dto.re_recommandcount }</td>
	              </tr>
	             </c:if> 
	          </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col"><!--오른쪽 하단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold" style="background-color:#EEEBFF; padding:10px; border:1px solid lightgray; margin-left:10px; color:#0078FF; cursor:pointer;"
            onclick="location.href='studylist.do'">스터디 모집 >></h5>
          </div>
          <table class="table table-sm table-hover table-main" style='text-align: center' >
            <thead>
              <tr>
            <th class="col-lg-1">No.</th>
            <th class="col-lg-4">제목</th>
            <th class="col-lg-2">작성자</th>
            <th class="col-lg-2">일자</th>
            <th class="col-lg-1">조회</th>
            <th class="col-lg-1">추천</th>
              </tr>
            </thead>
            <tbody>
	          <c:forEach var="dto" items="${mainPageBoardList }">
	          	<c:if test="${dto.name eq '스터디구인' }">
	              <tr>
	                <td>${dto.bd_no }</td>
	                <td><a href="studydetail.do?bd_no=${dto.bd_no}" style="cursor:pointer;">${dto.bd_title }</a></td>
	                <td>${dto.m_nickname }</td>
	                <td><fmt:formatDate value="${dto.bd_createddate }" pattern="yy-MM-dd"/></td>
	                <td>${dto.bd_viewcount }</td>
	                <td>${dto.re_recommandcount }</td>
	              </tr>
	             </c:if> 
	          </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
<!--게시판 종료-->
</div>
	<!-- FOOTER 시작 -->
	<%@include file="./inc/_footer.jspf" %>
	<!-- FOOTER 종료 -->
	
	<%@include file="./inc/_foot.jspf" %>
	<script type="text/javascript" src="resources/js/slidebar.js?ver=1.1"></script>
	
</body>
</html>