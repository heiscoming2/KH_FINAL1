<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 주소 api스크립트 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="./resources/js/resume_address.js"></script> 
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>이력서 수정</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container-sm mt-5 mb-5" style="max-width: 1100px;">

        <h3>이력서 수정</h3> 	
        <div class="float-end">
            <button class="btn btn-danger" onclick="location.href='resume_update.do'">삭제</button>
            <button class="btn btn-success" onclick="location.href='resume_list.do'">목록</button>
            <button class="btn btn-success" onclick="location.href='mypage_user.do'">마이페이지</button>
        </div>
        <br><br>

        <div class="clearfix"><!--이력서 기본정보 div-->
            <form><!--이력서 기본정보 form-->
                <div class="col-8"><!--이력서 제목 작성-->
                    <input type="text" class="form-control form-control-lg" aria-label="r_title" placeholder="이력서 제목">
                </div>
                <br>
                <h4>기본정보</h4>
                <br>
                <!--이력서 이미지-->
                <img src="/img/test.jpg" class="img-thumbnail col-md-6 float-md-end mb-3 ms-md-3" style="width: 180px; height: 180px;" alt="이력서 이미지">
                
                <div class="row g-2"><!--이름-->
                    <div class="col-2"><h5>이 름</h5></div>
                    <div class="col-3">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_name" placeholder="이름을 입력해 주세요" value=""/>            
                    </div> 
                </div>
                <br>
                <div class="row g-2"><!--생년월일-->
                    <div class="col-2"><h5>생년월일</h5></div>
                    <div class="col-3">            
                        <input type="date" class="form-control col-6 px-2" aria-label="r_birth" placeholder="ex) 19810101">            
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
                <div class="row g-2"><!--전화번호-->
                    <div class="col-2"><h5>휴대폰</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_phone" maxlength="13" placeholder=" -포함 입력" value="">            
                    </div>
                </div>
                <br>
                <div class="row g-2"><!--이메일-->
                    <div class="col-2"><h5>이메일</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_email" placeholder="이메일을 입력해 주세요" value="">            
                    </div>     
                </div>
                <br>
                <!--주소-->
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
                </div><!--주소 끝-->
                <br>
                <div class="row g-2"><!--포트폴리오-->
                    <div class="col-2"><h5>포트폴리오</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" aria-label="r_addr" placeholder="ex) http://www.itpro.com/user">            
                    </div>
                </div>
            </form><!--기본정보 입력 form 끝-->
            <br>
            <form><!--이미지 업로드 form-->
                <div class="row g-2">
                    <div class="col-2"><h5>사진등록</h5></div>
                    <div class="col-3"> 
                        <input class="form-control form-control-sm" id="r_img" type="file">                     
                    </div>  
                    <div class="col-sm-1">
                        <input type="submit" class="btn btn-outline-dark btn-sm" value="업로드">
                    </div>   
                </div>
            </form><!--이미지 업로드 form 끝-->
        </div><!--이력서 기본정보 div 끝-->     
        <hr>

        <form><!--학력/교육/자격증/자소서 form-->
            <div class="d-flex justify-content-between">
                <div class="col-6"><sapn><h3>학력사항</h3></sapn></div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <input class="btn btn-outline-dark btn-sm" type="button" id="addBtn" value="+"/>
                    <input class="btn btn-outline-dark btn-sm" type="button" id="delBtn" value="-"/>
                </div>
            </div>
            <!--학력사항 입력폼-->
            <table class="table table-borderless table-sm" id="EdFormTable">
                <thead>
                  <tr>
                    <th scope="col">입학졸업</th>
                    <th scope="col">학교</th>
                    <th scope="col">전공</th>
                    <th scope="col">구분</th>
                    <th scope="col">졸업여부</th>
                  </tr>
                </thead>
                <tbody>
                  <tr><!--첫째줄-->
                    <td><input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                    <td>
                        <select class="form-select">
                        <option value="1">대학원</option>
                        <option value="2">대학교</option>
                        <option value="3">고등학교</option>
                        </select>
                    </td>
                    <td>
                        <select class="form-select">
                        <option value="1">졸업</option>
                        <option value="2">휴학</option>
                        <option value="3">중퇴</option>
                        <option value="4">재학</option>
                        </select>
                    </td>
                  </tr>
                  <tr><!--둘째줄-->
                    <td><input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                    <td>
                        <select class="form-select" aria-label="Default select example">
                        <option value="1">대학원</option>
                        <option value="2">대학교</option>
                        <option value="3">고등학교</option>
                        </select>
                    </td>
                    <td>
                        <select class="form-select" aria-label="Default select example">
                        <option value="1">졸업</option>
                        <option value="2">휴학</option>
                        <option value="3">중퇴</option>
                        <option value="4">재학</option>
                        </select>
                    </td>
                  </tr>                 
                </tbody>
            </table>
            

            <hr><!---자격사항 입력 폼---->

            <div class="d-flex justify-content-between">
                <div class="col-6"><sapn><h3>자격사항</h3></sapn></div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <input class="btn btn-outline-dark btn-sm" type="button" id="liaddBtn" value="+"/>
                    <input class="btn btn-outline-dark btn-sm" type="button" id="lidelBtn" value="-"/>
                </div>
            </div>
            <!--자격사항 입력폼-->
            <table class="table table-borderless table-sm" id="LiFormTable">
                <thead>
                  <tr>
                    <th scope="col">자격증</th>
                    <th scope="col">취득년월</th>
                    <th scope="col">발행기관</th>
                  </tr>
                </thead>
                <tbody>
                  <tr><!--첫째줄-->
                    <td><input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                  </tr>
                  <tr><!--둘째줄-->
                    <td><input type="text" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                  </tr>                 
                </tbody>
            </table>
            
            <hr><!---교육 및 사회경험 입력 폼---->
            
            <div class="d-flex justify-content-between">
                <div class="col-6"><sapn><h3>교육 및 사회경험</h3></sapn></div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <input class="btn btn-outline-dark btn-sm" type="button" id="caAddBtn" value="+">
                    <input class="btn btn-outline-dark btn-sm" type="button" id="caDelBtn" value="-">
                </div>
            </div>
            <!--교육 및 사회경험 입력폼-->
            <table class="table table-borderless table-sm" id="CaFormTable">
                <thead>
                  <tr>
                    <th scope="col">회사·기관</th>
                    <th scope="col">시작일</th>
                    <th scope="col">종료일</th>
                    <th scope="col">세부내용</th>
                  </tr>
                </thead>
                <tbody>
                  <tr><!--첫째줄-->
                    <td><input type="text" class="form-control" id="ed_date" ></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                  </tr>
                  <tr><!--둘째줄-->
                    <td><input type="text" class="form-control" id="ed_date" ></td>
                    <td><input type="text" class="form-control" id="ed_school" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                    <td><input type="text" class="form-control" id="ed_graduation" ></td>
                  </tr>                 
                </tbody>
            </table>
            

            <hr><!---자소서 입력 폼---->
            
            <div>
                <div class="col-6 mb-3"><sapn><h3>자기소개서</h3></sapn></div>
                <div class="form-floating">
                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 500px; resize: none;"></textarea>
                </div>
            </div>
        </form><!--학력/교육/자격증/자소서 form 끝-->
        <br><br>
        <div class="d-grid gap-2 col-3 mx-auto"><!--form 2개 같이 submit-->
            <button class="btn-lg btn-primary" type="submit">저장</button>
        </div>
    </div>



<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<!-- 이력서 폼 스크립트 -->
<script type="text/javascript" src="./resources/js/resume_form.js"></script> 
	
</body>
</html>