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
        <button class="btn btn-default" data-bs-toggle="modal" data-bs-target="#sendmessage">쓰기</button>
        <button class="btn btn-default">삭제</button>

        <table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                	<th class="col-1">선택</th>
                    <th class="col-3">등록일</th>
                    <th class="col-3">보낸 사람</th>
                    <th class="col-5">제목</th>
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
								<td class="col-3"><fmt:formatDate value="${receiveList.n_sendDate }" /></td>
								<td class="col-3">${receiveList.n_sender }</td>
								<td class="col-5"><a href="#?n_no=${receiveList.n_no }" style="color:black;">${receiveList.n_title }</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>                           
            </tbody>
        </table>
    </div>
    
    <!--쪽지 작성창-->
    <div class="modal fade" id="sendmessage" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">쪽지 쓰기</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">받는사람:</label>
                  <input type="text" class="form-control" id="recipient-name" placeholder="아이디 입력">
                </div>
                <div class="mb-3">
                  <label for="recipient-title" class="col-form-label">제목:</label>
                  <input type="text" class="form-control" id="recipient-name" maxlength="10" placeholder="10자내 입력 가능">
                </div>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">내용:</label>
                  <textarea class="form-control" id="message-text" maxlength="200" style="height: 150px" placeholder="200자내 입력 가능"></textarea>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="닫기">
              <input type="button" class="btn btn-primary" value="보내기">
            </div>
          </div>
        </div>
      </div>
    


<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>