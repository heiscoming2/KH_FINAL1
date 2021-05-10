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
        <form>
        
            <div class="d-flex justify-content-between">
                <div class="col-10 text-center">
                    <span class="fs-2 fw-bold">이력서 제목 어쩌구 저쩌구</span>
                </div>
                <div class="col-2">
                    <button class="btn btn-primary" type="button" onclick="location.href='resume_list.do'">목록</button>
                    <button class="btn btn-primary" type="button" onclick="location.href='resume_update.do'">수정</button>
                </div>
            </div>
            <br><br>
            <h3 class="fw-bold">기본정보</h3>
            <br>
            <div class="clearfix">
                <!--이력서 이미지-->
                <img src="./resources/images/profileimages/testprofile.jpg" class="img-thumbnail col-md-6 float-md-end mb-3 ms-md-3" style="width: 200px; height: 200px;" alt="이력서 이미지">
                
                <!--기본 인적사항-->              
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">이 름</h5></div>
                    <div class="col-3">            
                        <span class="fs-5">아무개</span>            
                    </div> 
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">생년월일</h5></div>
                    <div class="col-2">            
                        <span class="fs-5">1999.02.01</span>           
                    </div>      
                    <div class="col-1"><h5 class="fw-bold">성별</h5></div>
                    <div class="col-1">
                        <span class="fs-5">여</span>
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">휴대폰</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">000-0000-0000</span>         
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">이메일</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">amu@itpro.com</span>           
                    </div>     
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">주 소</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">서울시 강남구 역삼동 어쩌구</span>            
                    </div>     
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5 class="fw-bold">포폴 링크</h5></div>
                    <div class="col-5">            
                        <span class="fs-5">http://itpro.com/user1/portfolio</span>           
                    </div>     
                </div>
            </div>     
            
            <hr><!---학력사항---->

            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h3 class="fw-bold">학력사항</h3></sapn>
                </div>
            </div><br>
            <div class="row g-3 text-center" id="edForm">
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">입학년월</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">학교 및 전공</label>
                    <p class="fs-6">대학교 컴퓨터공학과</p>
                    <p class="fs-6">고등학교 졸업</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">졸업여부</label>
                    <p class="fs-6">졸업 예정</p>
                    <p class="fs-6">졸업</p>
                </div>
            </div>

            <hr><!---자격사항---->

            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h3 class="fw-bold">자격사항</h3></sapn>
                </div>
            </div>
            <br>
            <div class="row g-3 text-center">
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">자격면허</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">취득일자</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">발행기관</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
            </div>
            
            <hr><!---교육 및 사회경험---->
            
            <div class="row justify-content-between">
                <div class="col-6">
                    <sapn><h3 class="fw-bold">교육 및 사회경험</h3></sapn>
                </div>
            </div>
            <br>
            <div class="row g-3 text-center">
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">회사·기관명</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">기간</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
                <div class="col-md-4">
                    <label class="form-label fs-5 fw-bold">업무 및 교육내용</label>
                    <p class="fs-6">2019년 02월 - 2021년 08월</p>
                    <p class="fs-6">2016년 02월 - 2018년 03월</p>
                </div>
            </div>

            <hr><!---자소서---->
            
            <div>
                <div>
                    <sapn><h3 class="fw-bold">자기소개서</h3></sapn>
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