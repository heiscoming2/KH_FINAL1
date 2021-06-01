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
      <input type="hidden" name="m_no" value="${sessionScope.login.m_no}">
      
      
         <!-- 포트폴리오 작성 글 영역-->
        <h3>포트폴리오 글 작성</h3>
        <br>
        
             <!-- 프로필이미지, 아이디, 작성일 div -->
			<div>
				<img src="${sessionScope.login.m_img_path}${sessionScope.login.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                  style="float: left;">
                <div style="position: relative; top:5px;">
                  <a class="d-flex align-items-center text-decoration-none" style="font-size:15px;">
                    ${sessionScope.login.m_nickname}
                  </a>
				</div>
              </div> <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
              <br>
              <br>
              
              
         <h5><b>포트폴리오</b></h5>  
         <table class="portfolio_inserttable"> 
            <tr>
              <th><span>* </span>제목</th>
              <td><input type="text" class="form-control" name="bd_title" placeholder="제목을 입력해 주세요."></td>
            </tr>
            <tr>
              <th><span>* </span>이름 </th>
              <td><input type="text" class="form-control" value="${dto.member.m_nickname }" readonly></td>
              <td><input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>이메일 </th>
              <td><input type="email" class="form-control" value="${dto.member.m_email }"  readonly></td>
              <td><input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>전화번호 </th>
              <td><input type="tel" class="form-control" value="${dto.member.m_phone }" readonly></td>
              <td><input type="checkbox">비공개</td>
            </tr>
            <tr>
              <th><span>* </span>최종 학력</th>
              <td>
              <c:if test="${dto.edu ne null }">
              <input type=text class="form-control" value="${dto.edu.ed_school }" readonly>
              </c:if>
              <c:if test="${dto.edu eq null }">
              <input type=text class="form-control" readonly>
              </c:if>
              </td>
              <td><input type="checkbox">비공개</td>
              <!-- <td><input type='month'/> ~ <input type='month'/></td> -->
            </tr>
            
            
            <c:forEach var="career" items="${dto.career }" varStatus="status">
            <tr>
              <th><span>* </span>경력사항</th>             
              <td>
              <input type="text" value="재직 중" readonly>   
                <input type=text class="form-control" value="${career.ca_title }" readonly> </td>
                <br>
              <td><input type='text' value="${career.ca_start_date }" readonly /></td>         
              <td><input type="checkbox">비공개</td>
            </tr>
             </c:forEach>
            
            <tr>
              <th><span>* </span>사용 개발 기술 </th>
              <td><input type="text" class="form-control" name="port_develop" placeholder="ex) Java, Oracle 등"></td>
            </tr>
            <tr>
              <th><span>* </span>포트폴리오 링크 </th>
              <td><input type="text" class="form-control" name="port_link" placeholder="ex) https://www.ITPro.com"></td>
            </tr>
            <tr>
              <th><span>* </span>수상 내역 </th>
              <td><input type="text" class="form-control" name="port_prize" placeholder="수상 내역을 입력해 주세요."></td>
            </tr>
            <tr>
              <th><span>* </span>포트폴리오 소개</th>
              <td><input type="text" class="form-control" name="bd_content" placeholder="내용을 입력해 주세요."></td>
            </tr>
            
          </table>

          <br>
        <br>
        
        <br>
        
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

<!-- 포트폴리오 insert 개별 JS -->
<script type="text/javascript" src="resources/js/portfolioinsert.js?ver=1.2"></script>


</body>
</html>