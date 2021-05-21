<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>IT PRO</title>
<%@include file="./inc/_head.jspf" %>
<link rel="stylesheet" type="text/css" href="resources/css/slidebar.css?ver=1.1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

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
		<input type="button" class="btn btn-primary" value="회원가입하고 포트폴리오 등록하기">
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
					<b>TOP 10 포트폴리오</b> <input type="button" class="btn btn-primary ml-3" value="더 보기">
				</h5>
				
				<div class="owl-carousel">
					<!-- 프로필 시작 -->
					<c:forEach begin="0" end="20" step="1" varStatus="loop">
					<div class="testimonial-box">
						<div class="d-flex justify-content-center align-items-center mb-2">
							<img src="testimages/testprofile.jpg" alt="" class="user-img mr-2">
							<div>
								<h6 class="mb-0"><b>&nbsp;&nbsp;hyojun9292</b>
								</h6>

								<p class="text-muted mb-0" style="font-size: 8px; margin:0; padding:0;">
									&nbsp;&nbsp;&nbsp;
									<span style="text-decoration: underline;">
										92.10.24
									</span>
									<span>
										&nbsp;(N년차)
									</span>
									<br>
									&nbsp;&nbsp;&nbsp;<span style="color:black">
										<b>프론트 개발</b>
									</span>
								</p>
							</div>
						</div>
						<hr class="mb-2" style="width:80%; margin: 0 auto; color:#212529;">
						<div style="width:80%; margin: 0 auto;">
							<div style="margin-bottom: 8px;">
								<p style="font-size: 8px; margin:0; padding:0;">
									<b>· 주 사용 언어</b><br>
									<span style="color:#6c757d;">REACT ANGULAR JAVASCRIPT </span>
								</p>
							</div>
							<div style="margin-bottom: 8px;">
								<div style="font-size: 8px; margin:0; padding:0;"><b>· 최근 대표 이력</b></div>
								<p style="font-size: 8px; margin:0; padding:0; color:#6c757d;">(2018.06~2020.03) ㅇㅇ회사 근무
								</p>
								<p style="font-size: 8px; margin:0; padding:0; color:#6c757d;">(2018.06~2020.03) KH학원
								</p>
							</div>
							<div>
								<p style="font-size: 8px; margin:0; padding:0;"><b>· 최근 개발 프로젝트</b></p>
								<p style="font-size: 8px; margin:0; padding:0; color:#6c757d;">(2018.06~2020.03) 요리 소개
									사이트 개발</p>
								<p style="font-size: 8px; margin:0; padding:0; color:#6c757d;">(2018.06~2020.03) 무언가를
									개발개발</p>
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
            <h5 class="fw-bold" onclick="location.href='noticelist.do'" style="cursor:pointer;">공지사항</h5>
          </div>
          <table class="table table-sm table-hover" style='text-align: center' >
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
              <tr>
                <td>1</td>
                <td>광고 결제 방법</td>
                <td>관리자</td>
                <td>20-00-00</td>
                <td>10</td>
                <td>5</td>
              </tr>
              <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>3</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>4</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>5</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="col"><!--오른쪽 상단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold">베스트 게시글</h5>
          </div>
          <table class="table table-sm table-hover" style='text-align: center' >
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
              <tr>
                <td>1</td>
                <td>팀플 성공법</td>
                <td>황시목</td>
                <td>20-00-00</td>
                <td>10</td>
                <td>5</td>
              </tr>
              <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>3</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>4</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>5</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div><br>
      <div class="row">
        <div class="col"><!--왼쪽 하단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold">베스트 프로젝트</h5>
          </div>
          <table class="table table-sm table-hover" style='text-align: center' >
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
              <tr>
                <td>1</td>
                <td>프로젝트입니다</td>
                <td>김자바</td>
                <td>20-00-00</td>
                <td>10</td>
                <td>5</td>
              </tr>
              <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>3</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>4</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>5</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="col"><!--오른쪽 하단 게시판 목록-->
          <div class="row" style="text-align: center">
            <h5 class="fw-bold">스터디</h5>
          </div>
          <table class="table table-sm table-hover" style='text-align: center' >
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
              <tr>
                <td>1</td>
                <td>스터디원 구인</td>
                <td>홍길동</td>
                <td>20-00-00</td>
                <td>10</td>
                <td>5</td>
              </tr>
              <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>3</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>4</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>5</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
<!--게시판 종료-->

	<!-- FOOTER 시작 -->
	<%@include file="./inc/_footer.jspf" %>
	<!-- FOOTER 종료 -->
	
	<%@include file="./inc/_foot.jspf" %>
	<script type="text/javascript" src="resources/js/slidebar.js?ver=1.1"></script>
	
</body>
</html>