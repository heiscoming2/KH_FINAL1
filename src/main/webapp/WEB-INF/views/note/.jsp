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
 	<h3>쪽지 작성</h3> 
 	<table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                	<th class="col-1"><input type="checkbox"></th>
                    <th class="col-3">등록일</th>
                    <th class="col-3">보낸 사람</th>
                    <th class="col-5">제목</th>
                </tr>
            </thead>
            <tbody> 
            	<tr class="d-flex">
            		<td class="col-1"><input type="checkbox"></td>
					<td class="col-3">등록일이여</td>
					<td class="col-3">사람이여</td>
					<td class="col-5">제목이여</td>
				</tr>						                   
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