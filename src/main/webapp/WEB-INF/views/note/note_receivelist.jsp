<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>받은쪽지</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container mt-5 mb-5" style="max-width: 1000px;">
 		<h3>받은 쪽지</h3> 
 
        <button class="btn btn-default" onclick="location.href='mypage_user.do'">마이페이지</button>
        <button class="btn btn-default" onclick="location.href='note_sendlist.do'">보낸쪽지</button>
        <input type="button" class="btn btn-default" onclick="noteForm();" value="쓰기">
        <button class="btn btn-default">삭제</button>

        <table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                	<th class="col-1"><input type="checkbox"></th>
                    <th class="col-2">등록일</th>
                    <th class="col-2">보낸 사람</th>
                    <th class="col-7">제목</th>
                </tr>
            </thead>
            <tbody> 
				<c:choose>
					<c:when test="${empty receiveList }">
						<tr class="d-flex">
							<td class="col-12">=====받은 쪽지가 없습니다.=====</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${receiveList }" var="receiveList">
								<tr class="d-flex">
								<td class="col-1"><input type="checkbox"></td>
								<td class="col-2"><fmt:formatDate value="${receiveList.n_sendDate }" /></td>
								<td class="col-2">${receiveList.n_sender }</td>
								<td class="col-7"><a href="noteRead.do?n_no=${receiveList.n_no }" style="color:black;">${receiveList.n_title }</a></td>
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

<!-- 쪽지 작성 팝업 스크립트 -->
<script type="text/javascript" src="resources/js/note_form.js?ver=1.2"></script>
	
</body>
</html>