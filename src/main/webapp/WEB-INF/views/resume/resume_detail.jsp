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
        	<button class="btn btn-danger" onclick="location.href='resume_delete.do?r_no=${resumeDetailDto.r_no}'">삭제</button>
        	<button class="btn btn-primary" onclick="location.href='resume_update.do?r_no=${resumeDetailDto.r_no}'">수정</button>
            <button class="btn btn-success" onclick="location.href='resume_list.do'">목록</button>
            <button class="btn btn-success" onclick="location.href='mypage_user.do'">마이페이지</button>
        </div>
        <br><br>
        <form>
            <div class="col-10 mb-4">
                <h4 class="fw-bold text-center">이력서 제목 어쩌구 저쩌구</h4>
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
                    <div class="col-2">            
                        <span class="fs-5">${memberDto.m_birth }</span>           
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
                        <span class="fs-5"></span>         
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">이메일</h5></div>
                    <div class="col-5">            
                        <span class="fs-5"></span>           
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
            <table class="table table-borderless table-sm" style='text-align: center'>
                <thead>
                  <tr>
                    <th class="col-4">입학졸업</th>
                    <th class="col-2">학교</th>
                    <th class="col-2">전공</th>
                    <th class="col-2">구분</th>
                    <th class="col-2">졸업여부</th>
                  </tr>
                </thead>
                <tbody>
                    <!-- 
                  <tr>
                    <td>2010년 03월 - 2013년 02월</td>
                    <td>서울대</td>
                    <td>컴공</td>
                    <td>대학교</td>
                    <td>졸업</td>
                  </tr>
                  -->      
                  <c:forEach items="${educationList}" var="education">
					<tr>
	                    <td>2010년 03월 - 2013년 02월</td>
	                    <td>${education.ed_schoolName}</td>
	                    <td>${education.ed_major}</td>
	                    <td>${education.ed_school}</td>
	                    <td>${education.ed_graduation}</td>
                  	</tr>
				</c:forEach>           
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
                    <tr><!--첫째줄-->
                        <td>2010년 03월 - 2013년 02월</td>
                        <td>서울대학교</td>
                        <td>컴퓨터공학과</td>
                      </tr>  
                  <tr><!--둘째줄-->
                    <td>2010년 03월 - 2013년 02월</td>
                    <td>서울대</td>
                    <td>컴공</td>
                  </tr>                 
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
                    <tr><!--첫째줄-->
                        <td>2010년 03월 - 2013년 02월</td>
                        <td>서울대학교</td>
                        <td>컴퓨터공학과</td>
                        <td>대학교</td>
                      </tr>  
                  <tr><!--둘째줄-->
                    <td>2010년 03월 - 2013년 02월</td>
                    <td>서울대</td>
                    <td>컴공</td>
                    <td>대학교</td>
                  </tr>                 
                </tbody>
            </table>

            <hr><!---자소서---->
            
            <div>
                <div>
                    <sapn><h4 class="fw-bold">자기소개서</h4></sapn>
                </div>
                <div>
                    <div class="lh-base" style="height: 500px; white-space:pre-wrap; "> 미국 제약사 화이자가 올해 안에 알약 형태의 신종 코로나바이러스 감염증(코로나19) 치료제를 출시할 수 있을 것으로 전망했다. 앨버트 불라 화이자 최고경영자(CEO)는 27일(현지시간) CNBC방송에 출연해 코로나19 치료를 위한 
                        경구용 항바이러스제의 임상시험이 잘 진행돼 미국 식품의약국(FDA)의 사용 승인을 받는다면 연말까지 미국 전역에 보급할 수 있다고 밝혔다.
                        현재 초기 임상시험 단계인 화이자의 경구용 항바이러스제는 코로나19 초기 증상을 보이는 환자들이 병원에 가지 않고 
                        집에서도 간편하게 복용할 수 있어 코로나19 대유행에서 '게임 체인저'가 될 것으로 보건 전문가들은 기대하고 있다.

                    
                    I can feel a phoenix inside of me. 
                    Maybe a reason why all the doors are closed. 
                    We go higher and higher. Passport stamps, she's cosmopolitan. 
                    Someone said you had your tattoo removed. 
                    All my girls vintage Chanel baby. 
                    Someone said you had your tattoo removed.</div>
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