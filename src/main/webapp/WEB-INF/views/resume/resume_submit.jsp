<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>이력서 상세보기</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container-sm mt-5 mb-5" style="max-width: 1000px;">
 		<h1>이력서 제출</h1>
 		<img src="resources/images/companyimages/companylistsampleone.png" style="position:relative; left:-50px;"/>
 		<br><br>
 		<h3>이력서 목록</h3> 	
        <button class="btn btn-primary" onclick="location.href='resume_form.do'">등록</button>
        <input class="btn btn-danger" type="button" value="삭제" onclick="resumeListDel();">
        
        <br><br>
        
        <table class="table table-bordered table-hover text-center" >
            <thead>
                <tr class="d-flex">
                    <th class="col-1"><input type="checkbox"></th>
                    <th class="col-6">이력서</th>
                    <th class="col-3">등록일</th>
                    <th class="col-2">수정</th>
                </tr>
            </thead>
            <tbody><!--작성된 이력서 목록-->
				<c:choose>
					<c:when test="${empty resumeList }">
						<tr class="d-flex">
							<td class="col-12">=====작성된 이력서가 없습니다.=====</td>							
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${resumeList }" var="resumeList">
							<tr class="d-flex">
								<td class="col-1"><input type="checkbox" name="resumeListDel" value="${resumeList.r_no }"></td>
								<td class="col-6"><a href="resume_detail.do?r_no=${resumeList.r_no }" style="color: black;">${resumeList.r_title }</a></td>
								<td class="col-3"><fmt:formatDate value="${resumeList.r_regdate }" pattern="yyyy-MM-dd"/></td>
								<td class="col-2">
									<button class="btn btn-primary btn-sm" onclick="location.href='resume_update.do'">수정</button>
								</td>
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