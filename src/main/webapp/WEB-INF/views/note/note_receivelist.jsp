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

 <div class="container mt-5 mb-5" >
 		<h3>받은 쪽지</h3> 
 
        <button class="btn btn-default" onclick="location.href='mypage_user.do'">마이페이지</button>
        <button class="btn btn-default" onclick="location.href='note_sendlist.do'">보낸쪽지</button>
        <button class="btn btn-default" data-bs-toggle="modal" data-bs-target="#sendmessage">쓰기</button>
        <button class="btn btn-default">삭제</button>

        <table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                	<th class="col-1">선택</th>
                    <th class="col-1">NO.</th>
                    <th class="col-2">등록일</th>
                    <th class="col-4">보낸사람</th>
                    <th class="col-4">내용</th>
                </tr>
            </thead>
            <tbody>
				<tr class="d-flex">
					<td class="col-1"><input type="checkbox"></td>
					<td class="col-1">1</td>
					<td class="col-2">21-06-01</td>
					<td class="col-4" data-bs-toggle="modal"
						data-bs-target="#sendmessage">보낸사람이여</td>
					<td class="col-4">쪽지에여</td>
				</tr>
				<%-- 
				<c:choose>
					<c:when test="${empty noteList }">
						<tr class="d-flex">
							<td class="col-12">=====받은 쪽지가 없습니다.=====</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${noteList }" var="noteList">
								<tr class="d-flex">
								<td class="col-1"><input type="checkbox"></td>
								<td class="col-1">${noteList.n_no }</td>
								<td class="col-2"><fmt:formatDate value="${noteList.n_date }" pattern="yy-MM-dd" /></td>
								<td class="col-4">${noteList.n_send }</td>
								<td class="col-4">${noteList.n_content }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>  --%>                                  
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
                  <input type="text" class="form-control" id="recipient-name">
                </div>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">내용:</label>
                  <textarea class="form-control" id="message-text" maxlength="300" style="height: 150px"></textarea>
                  <span>보낸시간 : 2021-00-00</span>
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