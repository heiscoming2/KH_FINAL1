<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<link href="resources/css/loader.css" rel="stylesheet">
<title>샘플 페이지 입니다.</title>
</head>
<body>
<div class="wrap">

<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->
	<br><br><br><br>
	<h5 class="text-center">채용 정보를 가져오고 있습니다</h5>
	<h5 class="text-center">약 20초 소요 (완료 시 자동으로 페이지 이동)</h5>
	<div id="loader"></div>
	<br><br><br><br><br><br><br><br>
<!-- 본문 종료 -->
<!-- 하이라이트 효과를 주기 위해 사용 -->
<input type="hidden" class="cateli" value="crawcomli">      
</div>
<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>


<!-- 컨트롤러 -->
<script type="text/javascript">

	window.onload=function(){
		location.href="companycrawlingupdate.do";
	}

</script>
</body>
</html>