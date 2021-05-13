<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf"%>
<title>샘플 페이지 입니다.</title>
</head>
<body>
	<!-- HEADER 시작 -->
	<%@include file="../inc/_header.jspf"%>
	<!-- HEADER 종료 -->

	<!-- 본문 시작 -->

	<table border="1" >
		
		<tr>
			<th>nickname</th>
			<td>${dto.m_nickname }</td>
		</tr>
		<tr>
			<th>type</th>
			<td>${dto.m_type }</td>
		</tr>
		<tr>
			<th>gender</th>
			<td>${dto.m_gender }</td>
		</tr>
        <tr>
			<th>regdate</th>
			<td>${dto.m_regdate }</td>
		</tr>
        <tr>
			<th>act</th>
			<td>${dto.m_act }</td>
		</tr>
        <tr>
			<th>used</th>
			<td>${dto.m_used }</td>
		</tr>
        <tr>
			<th>auth</th>
			<td>${dto.m_auth }</td>
		</tr>
        <tr>
			<th>name</th>
			<td>${dto.m_name }</td>
		</tr>
        <tr>
			<th>birth</th>
			<td>${dto.m_birth }</td>
		</tr>
        <tr>
			<th>addr</th>
			<td>${dto.m_addr }</td>
		</tr>
   <%-- <tr>
			<th>regno</th>
			<td>${dto.m_regno }</td>
		</tr>
       <tr>
			<th>admin_cert</th>
			<td>${dto.m_admin_cert }</td>
		</tr>--%>
    	<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='member_list.do'">
				<input type="button" value="수정" onclick="location.href='member_updateform.do?m_no=${dto.m_no}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.m_no}'">
			</td>
		</tr>
	</table>
	<!-- 쪽지보내기 -->
    <input type="button" value="쪽지보내기" onclick="">


	<!-- 본문 종료 -->

	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>

</body>
</html>