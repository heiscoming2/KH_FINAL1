<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/portfolioinsert.css?ver=1.2" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css" rel="stylesheet">
<title>IT PRO portfolio 글 쓰기</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
    <div class="portfolio_insertwrap">
      <form action="portfolioinsert.do" method="post">
         <!-- 포트폴리오 작성 글 영역-->
        <h3>포트폴리오 글 작성</h3>
        <br>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none" id="dropdownaUser"
                    style="font-size:15px;">
                    leehj
                  </a>
                </div>
              </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
              <br>
              <br>
              
         <table class="portfolio_inserttable">
          <h5><b>포트폴리오</b></h5>
            <tr>
              <th><span>* </span>제목</th>
              <td><input type="text" class="form-control" placeholder="제목을 입력해 주세요."></td>
            </tr>
            <tr>
              <th><span>* </span>이름 </th>
              <td><input type="text" class="form-control" readonly>
                  <input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>이메일 </th>
              <td><input type="email" class="form-control" readonly>
                  <input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>전화번호 </th>
              <td><input type="tel" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13" class="form-control" readonly>
                  <input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>최종 학력</th>
              <td><input type=text class="form-control" readonly>
                  <input type="checkbox">비공개</td>
              <!-- <td><input type='month'/> ~ <input type='month'/></td> -->
            </tr>
            <tr>
              <th><span>* </span>경력사항</th>
                
              <td><input type="text" value="재직 중" readonly>   
                <input type=text class="form-control" readonly> </td>
                <br>
              <td><input type='month'/> ~ <input type='month'/></td> 
              <td><input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>사용 개발 기술 </th>
              <td><input type="text" class="form-control" placeholder="ex) Java, Oracle 등"></td>
            </tr>
            <tr>
              <th><span>* </span>포트폴리오 링크 </th>
              <td><input type="text" class="form-control" placeholder="ex) https://www.ITPro.com"></td>
            </tr>
            <tr>
              <th><span>* </span>수상 내역 </th>
              <td><input type="text" class="form-control" placeholder="수상 내역을 입력해 주세요."></td>
            </tr>
          </table>

          <br>
        <br>
        
        <br>
      </form>

      <!-- 포트폴리오 작성 글 영역 종료-->

      <!-- 취소 / 등록 컨펌 버튼 -->
	  <div style="height:80px;">
	    <input type="submit" value="등록" class="btn btn-primary" style="float:right; margin-left:10px;">
	    <input type="button" value="취소" class="btn btn-primary" onclick="location.href='portfliolist.do'" style="float:right;" >
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


</body>
</html>