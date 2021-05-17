<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>로그인</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

 <div class="container mt-5 mb-5">
        <button class="btn btn-primary">등록</button>
        <button class="btn btn-danger">삭제</button><br><br>

        <table class="table table-bordered table-hover text-center">
            <thead>
                <tr class="d-flex">
                    <th class="col-1">선택</th>
                    <th class="col-1">번호</th>
                    <th class="col-5">제목</th>
                    <th class="col-2">등록일</th>
                    <th class="col-3">수정여부</th>
                </tr>
            </thead>
            <tbody>
                <tr class="d-flex">
                    <td class="col-1"><input type="checkbox"></td>
                    <td class="col-1">1</td>
                    <td class="col-5">똑같넹</td>     
                    <td class="col-2">21-00-00</td>                
                    <td class="col-3">
                        <button class="btn btn-primary btn-sm">수정</button>
                        <button class="btn btn-danger btn-sm">삭제</button>
                    </td>
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