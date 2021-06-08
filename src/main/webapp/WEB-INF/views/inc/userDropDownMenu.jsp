<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser">

	<c:if test="${sessionScope.login.m_no ne param.m_no }">
		<li><a class="dropdown-item" onclick="window.open('noteForm.do?m_nickname=${param.m_nickname}', '쪽지 작성 팝업', 'width=500, height=500, left=100, top=50');">쪽지보내기</a></li>
	</c:if>
	<li><a class="dropdown-item" href="postlookup.do?m_no=${param.m_no }">작성 글 조회</a></li>
	<c:if test="${sessionScope.login.m_type eq '기업회원' }">
		<li><a class="dropdown-item" href="#">이력서 열람</a></li>
	</c:if>
</ul>