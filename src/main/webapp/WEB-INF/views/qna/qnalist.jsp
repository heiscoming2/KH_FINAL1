<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link rel="stylesheet" href="resources/css/qnalist.css">
<title>포트폴리오/프로젝트</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

  <div class="qna_wrap">
        <h3>QNA 게시판</h3>
        <div class="qna_btnwrap">
			<input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='qnainsertform.do'">
		</div>
        
        <table class="qna_table">
			<col width="80px;">
			<col width="500px;">
			<col width="80px;">
			<col width="200px;">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자/작성일</th>
			</tr>
        
            <!-- 게시물 한 줄 시작-->
            <tr>
                <c:choose>
					<c:when test="${empty qna }">
						<td colspan="4" align="center">
							조회할 게시물이 존재하지 않습니다.
						</td>
					</c:when>
					<c:otherwise>

                  	<c:forEach var="qnaDto" items="${qnaList }">
							<!-- 글 번호 시작 --> 
							<td>${qnaDto.bd_no} </td>
							<td>${qnaDto.bd_title} </td>
							<td>${qnaDto.bd_viewcount}</td>
							<td>
							    <div class="qna_profile">
									<img src="https://github.com/mdo.png" alt="mdo" width="35" height="35" class="rounded-circle me-2"> 
									<div class="qna_writer"> 
										<a id="dropdownUser" data-bs-toggle="dropdown"> 
											${qnaDto.bd_wirterip } 
										</a> 
										<!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
										<ul aria-labelledby="dropdownUser">
											<li><a class="dropdown-item" href="#">쪽지보내기</a></li>
											<li><a class="dropdown-item" href="#">이력서 열람</a></li>
										</ul> <!-- 프로필 드롭다운 메뉴 종료 -->
									</div> 
									<span class="qna_regdate"> ${qnaDto.bd_createddate } </span>
								</div>
							</td>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tr>	
		</table>
		</div>
            <!-- 게시물 한 줄 종료 -->
         

        </table>
     
 
<!-- 페이징 시작 -->
<%@include file="../inc/_page.jspf" %>
<!-- 페이징 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>

<script type=text/javascript src="resources/js/address.js"></script>
</body>
</html>