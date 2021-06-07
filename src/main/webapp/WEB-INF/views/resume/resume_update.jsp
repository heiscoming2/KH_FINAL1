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
            <button class="btn btn-danger" onclick="location.href='resume_delete.do?r_no=${resumeDetailDto.r_no}'">삭제</button>
            <button class="btn btn-success" onclick="location.href='resume_list.do'">목록</button>
            <button class="btn btn-success" onclick="location.href='mypage_user.do'">마이페이지</button>
        </div>
        <br><br>

	<form id="resumeUpdateForm" onsubmit="resumeUpdateAjax(this); return false;"><!--이력서 기본정보 form-->
        <input type="hidden" name="r_no" value="${resumeDetailDto.r_no }" />
        <div class="clearfix"><!--이력서 기본정보 div-->
                <div class="col-8"><!--이력서 제목 작성-->
                    <input type="text" class="form-control form-control-lg" value="${resumeDetailDto.r_title }" placeholder="이력서 제목">
                </div>
                <br>
                <h4>기본정보</h4>
                <br>
                <!--이력서 이미지-->
                <img src="${resumeDetailDto.r_img_path }${resumeDetailDto.r_img }" class="img-thumbnail col-md-6 float-md-end mb-3 ms-md-3" id="image_section" style="width: 180px; height: 180px;" alt="이력서 이미지">
                
                
                <div class="row g-2"><!--이름-->
                    <div class="col-2"><h5>이 름</h5></div>
                    <div class="col-3">            
                        <input type="text" class="form-control col-6 px-2" readonly value="${memberDto.m_name }"/>            
                    </div> 
                </div>
                <br>
                <div class="row g-2"><!--생년월일-->
                    <div class="col-2"><h5>생년월일</h5></div>
                    <div class="col-3">            
                    	<fmt:formatDate value="${memberDto.m_birth }" pattern="yyyy년 MM월 dd일" var="m_birth" />
                        <input type="text" class="form-control col-6 px-2" readonly value="${m_birth}"/>            
                    </div>      
                    <div class="col-1"></div>
                    <div class="col-1"><h5>성별</h5></div>
                    <div class="col-1">
                        <input type="text" class="form-control col-6" readonly value="${memberDto.m_gender }">
                    </div>
                </div>
                <br>
                <div class="row g-2"><!--전화번호-->
                    <div class="col-2"><h5>휴대폰</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" readonly value="${memberDto.m_phone }">            
                    </div>
                </div>
                <br>
                <div class="row g-2"><!--이메일-->
                    <div class="col-2"><h5>이메일</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" readonly value="${memberDto.m_email }">            
                    </div>     
                </div>
                <br>
                <!--주소-->
                <div class="row g-2">
                    <div class="col-2"><h5>주 소</h5></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_postcode" name="r_postcode" value="${resumeDetailDto.r_postcode }" placeholder="우편번호">
                    </div>
                    <div class="col-2">
                            <input class="btn btn-outline-dark btn-sm" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
                    </div>
                </div>
                <div class="row g-2 mt-1">
                    <div class="col-2"></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_roadAddress" name="r_roadAddress" value="${resumeDetailDto.r_roadAddress }" placeholder="도로명주소" readonly>
                    </div>
                    <div class="col-3">
                        <input class="form-control form-control-sm" type="text" id="sample4_jibunAddress" name="r_jibunAddress" value="${resumeDetailDto.r_jibunAddress }" placeholder="지번주소" readonly>
                        <span id="guide" style="color:#999;display:none"></span>
                    </div>
                </div>
                <div class="row g-2 mt-1">
                    <div class="col-2"></div>
                    <div class="col-3">            
                        <input class="form-control form-control-sm" type="text" id="sample4_detailAddress" name="r_detailAddress" value="${resumeDetailDto.r_detailAddress }" placeholder="상세주소">
                    </div>
                    <div class="col-3">
                        <input class="form-control form-control-sm" type="text" id="sample4_extraAddress" name="r_extraAddress" value="${resumeDetailDto.r_extraAddress }" placeholder="참고항목" readonly>
                    </div>
                </div><!--주소 끝-->
                <br>
                <div class="row g-2"><!--포트폴리오-->
                    <div class="col-2"><h5>포트폴리오</h5></div>
                    <div class="col-5">            
                        <input type="text" class="form-control col-6 px-2" name="r_portfolio" value="${resumeDetailDto.r_portfolio }" placeholder="ex) http://www.itpro.com/user">            
                    </div>
                </div>
            <br>
            <div class="row g-2">
                <div class="col-2"><h5>사진등록</h5></div>
                <div class="col-3"> 
                    <input id="input_r_img" class="form-control form-control-sm" name="r_img" type="file">                     
                    <input type="hidden" name="r_img_no" type="text"/>
                </div>  
                <div class="col-sm-1">
                    <input type="button" class="btn btn-outline-dark btn-sm" value="업로드" onclick="uploadFile();">
                </div>   
            </div>
        </div><!--이력서 기본정보 div 끝-->     
        <hr>

            <div class="d-flex justify-content-between">
                <div class="col-6"><sapn><h3>학력사항</h3></sapn></div>
                <div class="col-1"><!--입력 폼 추가 버튼-->
                    <input class="btn btn-outline-dark btn-sm" type="button" id="addBtn" value="+"/>
                    <input class="btn btn-outline-dark btn-sm" type="button" id="delBtn" value="-"/>
                </div>
            </div>
            <!--학력사항 입력폼-->
            <table class="table table-borderless table-sm text-center" id="EdFormTable">
                <thead>
                  <tr>
                    <th class="col-1">입학</th>
                    <th class="col-1">졸업</th>
                    <th class="col-2">학교</th>
                    <th class="col-2">전공</th>
                    <th class="col-2">구분</th>

                    <th class="col-2">졸업여부</th>
                    <th class="col-1">수정</th>
                    <th class="col-1">삭제</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${educationList}" var="item">
                        <tr class="data-select">
                            <input type="hidden" name="ed_no" value="${item.ed_no}" />
                            <td>
                                <fmt:formatDate value="${item.ed_startdate}" pattern="yyyy-MM" var="ed_startdate" />
                                <input type="month" class="form-control" name="ed_startdate" value="${ed_startdate}" />
                            </td>
                            <td>
                                <fmt:formatDate value="${item.ed_gradudate}" pattern="yyyy-MM" var="ed_gradudate" />
                                <input type="month" class="form-control" name="ed_gradudate" value="${ed_gradudate}">
                            </td>
                            <td>
                                <input type="text" class="form-control" name="ed_schoolName" value="${item.ed_schoolName}" />
                            </td>
                            <td>
                                <input type="text" class="form-control" name="ed_major" value="${item.ed_major}" />
                            </td>
                            <td>
                                <select name="ed_school" class="form-select">
                                    <option value="대학원" ${item.ed_school == "대학원" ? "selected" : ""}>대학원</option>
                                    <option value="대학교" ${item.ed_school == "대학교" ? "selected" : ""}>대학교</option>
                                    <option value="고등학교" ${item.ed_school == "고등학교" ? "selected" : ""}>고등학교</option>
                                </select>
                            </td>

                            <td>
                                <select name="ed_graduation" class="form-select">
                                    <option value="졸업" ${item.ed_graduation == "졸업" ? "selected" : ""}>졸업</option>
                                    <option value="휴학" ${item.ed_graduation == "휴학" ? "selected" : ""}>휴학</option>
                                    <option value="중퇴" ${item.ed_graduation == "중퇴" ? "selected" : ""}>중퇴</option>
                                    <option value="졸업예정" ${item.ed_graduation == "졸업예정" ? "selected" : ""}>졸업예정</option>
                                </select>
                            </td>
                            <td>
                                <input class="btn btn-outline-dark btn-sm" type="button" value="수정" onclick="educationUpdate(this);" />
                            </td>
                            <td>
                                <input class="btn btn-outline-dark btn-sm" type="button" value="삭제" onclick="educationDelete(this);" />
                            </td>
                        </tr>
                    </c:forEach>
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
            <table class="table table-borderless table-sm text-center" id="LiFormTable">
                <thead>
                  <tr>
                    <th scope="col">자격증</th>
                    <th scope="col">취득년월</th>
                    <th scope="col">발행기관</th>
                    <th scope="col">수정</th>
                    <th scope="col">삭제</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${licenceList}" var="item">
                        <tr class="data-select">
                            <input type="hidden" name="li_no" value="${item.li_no}" />
                            <td>
                                <input type="text" class="form-control" name="li_title" value="${item.li_title}">
                            </td>
                            <td>
                                <fmt:formatDate value="${item.li_date}" pattern="yyyy-MM-dd" var="li_date" />
                                <input type="date" class="form-control" name="li_date" placeholder="ex) 2010년 03월 - 2013년 02월" value="${li_date}">
                            </td>
                            <td>
                                <input type="text" class="form-control" name="li_organ" value="${item.li_organ}">
                            </td>
                            <td>
                                <input class="btn btn-outline-dark btn-sm" type="button" value="수정" onclick="licenceUpdate(this);"/>
                            </td>
                            <td>
                                <input class="btn btn-outline-dark btn-sm" type="button" value="삭제" onclick="licenceDelete(this);"/>
                            </td>
                        </tr>
                    </c:forEach>
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
            <table class="table table-borderless table-sm text-center" id="CaFormTable">
                <thead>
                  <tr>
                    <th scope="col">회사·기관</th>
                    <th scope="col">시작일</th>
                    <th scope="col">종료일</th>
                    <th scope="col">세부내용</th>
                    
                    <th scope="col">수정</th>
                    <th scope="col">삭제</th>
                  </tr>
                </thead>
                <tbody>
				<c:forEach items="${careerList}" var="item">
					<tr class="data-select">
                        <input type="hidden" name="ca_no" value="${item.ca_no}" />
						<td><input type="text" class="form-control" name="ca_title"	value="${item.ca_title}"></td>
						<td>
							<fmt:formatDate value="${item.ca_start_date}" pattern="yyyy-MM-dd" var="ca_start_date" />
							<input type="date" class="form-control" name="ca_start_date" value="${ca_start_date}">
						</td>
						<td>
							<fmt:formatDate value="${item.ca_end_date}" pattern="yyyy-MM-dd" var="ca_end_date" />
							<input type="date" class="form-control" name="ca_end_date"  value="${ca_end_date}">
						</td>
						<td><input type="text" class="form-control" name="ca_content" value="${item.ca_content}"></td>
						<td>
							<input class="btn btn-outline-dark btn-sm" type="button" value="수정" onclick="careerUpdate(this);" />
						</td>
						<td>
							<input class="btn btn-outline-dark btn-sm" type="button" value="삭제" onclick="careerDelete(this);"/>
						</td>
					</tr>
				</c:forEach>
                </tbody>
            </table>
            
            

            <hr><!---자소서 입력 폼---->
            
            <div>
                <div class="col-6 mb-3"><sapn><h3>자기소개서</h3></sapn></div>
                <div class="form-floating">
                    <textarea class="form-control" name="r_selfletter" style="height: 500px; resize: none;">${resumeDetailDto.r_selfletter }</textarea>
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

<!-- 이력서 폼 스크립트 -->
<script type="text/javascript" src="./resources/js/resume_update.js"></script>
	
</body>
</html>