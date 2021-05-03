<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 주소 api스크립트 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="./resources/js/resume_form.js"></script> 
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>이력서 등록</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container-sm mt-5 mb-5" style="max-width: 1100px;">
        <form>
            
            <!--이력서 제목 작성-->
            <div class="d-flex justify-content-between">
                <div class="col-6">
                <div class="d-flex justify-content-center">
                    <input type="text" class="form-control form-control-lg" aria-label="r_title" placeholder="이력서 제목을 입력하세요">
                </div>
                </div>
                <div class="col-1">
                    <button class="btn btn-primary" type="button">목록</button>
                </div>
            </div>
            <br>
            <h3>기본정보</h3>
            <br>
            <div class="clearfix">
                <!--이력서 이미지-->
                <img src="./resources/images/profileimages/testprofile.jpg" class="img-thumbnail col-md-6 float-md-end mb-3 ms-md-3" style="width: 170px; height: 180px;" alt="이력서 이미지">
                
                <!--기본 인적사항 입력폼-->              
                <div class="row g-2">
                    <div class="col-2"><h5>이 름</h5></div>
                    <div class="col-3">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_name" placeholder="이름을 입력해 주세요">            
                    </div> 
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>생년월일</h5></div>
                    <div class="col-3">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_birth" placeholder="ex) 19810101">            
                    </div>      
                    <div class="col-2"><!--성별 체크버튼-->
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="r_gender" id="r_gender" value="male">
                            <label class="form-check-label" for="r_gender">남</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="r_gender" id="r_gender" value="female" checked>
                            <label class="form-check-label" for="r_gender">여</label>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>휴대폰</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_phone" placeholder=" - 제외하고 입력">            
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>이메일</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_email" placeholder="이메일을 입력해 주세요">            
                    </div>     
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>주 소</h5></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_postcode" placeholder="우편번호">
                    </div>
                    <div class="col-2">
                            <input class="btn btn-outline-dark btn-sm" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
                    </div>
                </div>
                <div class="row g-2 mt-1">
                    <div class="col-2"></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_roadAddress" placeholder="도로명주소" readonly>
                    </div>
                    <div class="col-3">
                        <input class="form-control form-control-sm" type="text" id="sample4_jibunAddress" placeholder="지번주소" readonly>
                        <span id="guide" style="color:#999;display:none"></span>
                    </div>
                </div>
                <div class="row g-2 mt-1">
                    <div class="col-2"></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_detailAddress" placeholder="상세주소">
                    </div>
                    <div class="col-3">
                        <input class="form-control form-control-sm" type="text" id="sample4_extraAddress" placeholder="참고항목" readonly>
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>포트폴리오</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_addr" placeholder="ex) http://www.itpro.com/user">            
                    </div>
                </div>
                <br>
                <div class="row g-2">
                    <div class="col-2"><h5>사진등록</h5></div>
                    <div class="col-3"> 
                        <input class="form-control form-control-sm" id="r_img" type="file">                     
                    </div>     
                </div>
            </div>     
            
            <hr><!---학력사항 입력 폼---->

            <div class="d-flex justify-content-between">
                <div class="col-6">
                    <sapn><h3>학력사항</h3></sapn>
                </div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <button class="btn btn-outline-dark btn-sm" type="button" id="edForm_p" value="추가">+</button>
                    <button class="btn btn-outline-dark btn-sm" type="button" id="edForm_m" value="삭제">-</button>
                </div>
            </div>
            <br>
            <div class="row g-3" id="edForm">
                <div class="col-md-4">
                    <label class="form-label">입학년월</label>
                    <input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"><br>
                    <input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월">
                </div>
                <div class="col-md-4">
                    <label class="form-label">학교 및 전공</label>
                    <input type="text" class="form-control" id="ed_school" placeholder="ex) OO대학교 OO과"><br>
                    <input type="text" class="form-control" id="ed_school" placeholder="ex) OO대학교 OO과">
                </div>
                <div class="col-md-4">
                    <label class="form-label">졸업여부</label>
                    <input type="text" class="form-control" id="ed_graduation" placeholder="졸업 또는 졸업예정"><br>
                    <input type="text" class="form-control" id="ed_graduation" placeholder="졸업 또는 졸업예정">
                </div>
            </div>

            <hr><!---자격사항 입력 폼---->

            <div class="d-flex justify-content-between">
                <div class="col-6">
                    <sapn><h3>자격사항</h3></sapn>
                </div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <button class="btn btn-outline-dark btn-sm" type="button" id="liForm_p">+</button>
                    <button class="btn btn-outline-dark btn-sm" type="button" id="liForm_m">-</button>
                </div>
            </div>
            <br>
            <div class="row g-3">
                <div class="col-md-4">
                    <label class="form-label">자격면허</label>
                    <input type="text" class="form-control" id="li_title" placeholder="ex) 정보처리기사"><br>
                    <input type="text" class="form-control" id="li_title" placeholder="ex) 정보처리기사">
                </div>
                <div class="col-md-4">
                    <label class="form-label">취득일자</label>
                    <input type="text" class="form-control" id="li_date" placeholder="ex) 2021년 01월 01일"><br>
                    <input type="text" class="form-control" id="li_date" placeholder="ex) 2021년 01월 01일">
                </div>
                <div class="col-md-4">
                    <label class="form-label">발행기관</label>
                    <input type="text" class="form-control" id="li_organ" placeholder="한국산업인력공단"><br>
                    <input type="text" class="form-control" id="li_organ" placeholder="한국산업인력공단">
                </div>
            </div>
            
            <hr><!---교육 및 사회경험 입력 폼---->
            
            <div class="d-flex justify-content-between">
                <div class="col-6">
                    <sapn><h3>교육 및 사회경험</h3></sapn>
                </div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <button class="btn btn-outline-dark btn-sm" type="button" id="caForm_p">+</button>
                    <button class="btn btn-outline-dark btn-sm" type="button" id="caForm_m">-</button>
                </div>
            </div>
            <br>
            <div class="row g-3">
                <div class="col-md-4">
                    <label class="form-label">회사·기관명</label>
                    <input type="text" class="form-control" id="li_title" placeholder="ex) KH정보교육원"><br>
                    <input type="text" class="form-control" id="li_title" placeholder="ex) KH정보교육원">
                </div>
                <div class="col-md-4">
                    <label class="form-label">근무·교육기간</label>
                    <input type="text" class="form-control" id="li_date" placeholder="ex) 2010년 03월 - 2013년 02월"><br>
                    <input type="text" class="form-control" id="li_date" placeholder="ex) 2010년 03월 - 2013년 02월">
                </div>
                <div class="col-md-4">
                    <label class="form-label">업무 및 교육내용</label>
                    <input type="text" class="form-control" id="li_organ" placeholder="ex) 프로그래밍"><br>
                    <input type="text" class="form-control" id="li_organ" placeholder="ex) 프로그래밍">
                </div>
            </div>

            <hr><!---자소서 입력 폼---->
            
            <div>
                <div class="col-6">
                    <sapn><h3>자기소개서</h3></sapn>
                </div><br>
                <div class="form-floating">
                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 500px; resize: none;"></textarea>
                  </div>
            </div>

            <br><br>
            <div class="d-grid gap-2 col-3 mx-auto">
                <button class="btn-lg btn-primary" type="submit">저장</button>
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