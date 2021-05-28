<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>보낸쪽지</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 	<div class="container mt-5 mb-5" >
 
		 <h3>보낸 쪽지</h3>
        <button class="btn btn-default" onclick="location.href='mypage_user.do'">마이페이지</button>
        <button class="btn btn-default" onclick="location.href='note_receivelist.do'">받은쪽지</button>
        <button class="btn btn-default" data-bs-toggle="modal" data-bs-target="#sendmessage">쓰기</button>
        <button class="btn btn-default">삭제</button>

        <table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                    <th class="col-1">선택</th>
                    <th class="col-1">NO.</th>
                    <th class="col-2">등록일</th>
                    <th class="col-4">받는사람</th>
                    <th class="col-4">내용</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
					<c:when test="${empty noteList }">
						<tr class="d-flex">
							<td class="col-12">=====보낸 쪽지가 없습니다.=====</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${noteList }" var="noteList">
							<tr class="d-flex">
								<td class="col-1"><input type="checkbox"></td>
								<td class="col-1">${noteList.n_no }</td>
								<td class="col-2"><fmt:formatDate value="${noteList.n_date }" pattern="yy-MM-dd" /></td>
								<td class="col-4">${noteList.n_receiver }</td>
								<td class="col-4">${noteList.n_content }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>                   
            </tbody>
        </table>
    </div>
    


<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>