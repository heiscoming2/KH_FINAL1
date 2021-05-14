<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/studyinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO 스터디 글 쓰기</title>
</head>
<body>
<%--
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="study_insertwrap mt-5">
      <form action="studyinsert.do" method="post">
        <!-- 스터디 모집 작성 글 영역-->
        <h3>스터디 모집 글 작성</h3>
        <br>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none" id="dropdownaUser"
                    style="font-size:15px;">
                    ${sessionScope.login.m_nickname}
                  </a>
                </div>
              </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
              <br>
              <br>
        <table class="table study_inserttable">
            <tr>
              <th><span>* </span>제목</th>
              <td><input type=text class="form-control" name="bd_title"></td>
            </tr>
            <tr>
              <th><span>* </span>현재 인원수</th>
              <td><input type="number" min=1 class="form-control" value="1" name="st_nowperson"></td>

            </tr>
            <tr>
              <th><span>* </span>모집 인원수</th>
              <td><input type="number" min=1 class="form-control" value="2" name="st_closeperson"></td>

          </tr>
            <tr>
              <th><span>* </span>지역</th>
              <td style="display: flex;">
                <select class="sidoselect form-control" name="st_addr1" onchange="change(this.selectedIndex);">
                       <option value=''>전체</option>
                       <option value='서울'>서울</option>
                       <option value='경기'>경기</option>
                       <option value='대구'>대구</option>
                       <option value='인천'>인천</option>
                       <option value='광주'>광주</option>
                       <option value='대전'>대전</option>
                       <option value='울산'>울산</option>
                       <option value='부산'>부산</option>
                       <option value='강원'>강원</option>
                       <option value='충북'>충북</option>
                       <option value='충남'>충남</option>
                       <option value='전북'>전북</option>
                       <option value='전남'>전남</option>
                       <option value='경북'>경북</option>
                       <option value='경남'>경남</option>
                       <option value='제주'>제주</option>
                    </select>                                                  
	  	          <select class="form-control gugunselect" id="gugunselect" name="st_addr2">
	  	          	   <option value=''>전체</option>
	  	          </select>
                <input type="text" class="form-control" name="st_addrdetail">
              </td>
            </tr>
        </table>
        <textarea id="summernote" name="bd_content"></textarea>
        <br>
      <!-- 스터디 모집 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="submit" value="등록" class="btn btn-primary" style="float:right; margin-left:10px;">
	    <input type="button" value="취소" class="btn btn-primary" onclick="location.href='studylist.do'" style="float:right;" >
	   </div>
    </form>
    
    </div> 
<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<!-- 썸머노트 JS -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<!-- STUDYINSERT 개별 JS -->
<script type="text/javascript" src="resources/js/studyinsert.js?ver=1.1"></script>
<!-- 주소 정보 JS -->
<script type="text/javascript" src="resources/js/address.js"></script>
 --%>
</body>
</html>