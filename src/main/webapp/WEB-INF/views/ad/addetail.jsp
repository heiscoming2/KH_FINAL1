<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../inc/_head.jspf"%>
<link href="resources/css/addetail.css" rel="stylesheet">
<!-- 썸머노트 CSS -->
<link href="resources/css/summernote/summernote-lite.css"
	rel="stylesheet">
<!-- 좋아요 css -->
<link href="resources/css/likebutton.css?ver=1.1" rel="stylesheet">

<title>IT PRO 상세보기</title>
</head>
<body>
	<div class="wrap">
		<!-- HEADER 시작 -->
		<%@include file="../inc/_header.jspf"%>
		<!-- HEADER 종료 -->

		<!-- 본문 시작 -->
		<div class="ad_detailwrap mt-5">
			<h4>광고문의 상세</h4>
			<!-- QNA 디테일 영역 -->
			<table class="table table-bordered" style="width: 100%;">
				<tr>
					<td>
						<!-- 프로필이미지, 아이디, 작성일 영역 시작 -->
						<div class="profile_wrap">
							<!-- 프로필 이미지 영역 -->
							<img src="${dto.m_img_path }${dto.m_img }" alt="mdo" width="35"
								height="35" class="rounded-circle me-2 profile_img">
							<!-- 프로필 아이디 표시 영역 -->
							<span class="profile_id"> <a
								class="d-flex align-items-center text-decoration-none dropdown-toggle"
								id="dropdownaUser" data-bs-toggle="dropdown"
								aria-expanded="false"> ${dto.m_nickname } </a> <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
								<ul class="dropdown-menu text-small shadow"
									aria-labelledby="dropdownaUser">

									<li><a class="dropdown-item" href="#">쪽지보내기</a></li>
									<li><a class="dropdown-item" href="#">이력서 열람</a></li>
								</ul>
							</span> <span class="reg_date"> <fmt:formatDate
									value="${dto.bd_createddate }" pattern="yyyy-MM-dd HH:mm:ss" />
								(작성) <c:if test="${dto.bd_modifydate ne null }">
									<fmt:formatDate value="${dto.bd_modifydate }"
										pattern="yyyy-MM-dd HH:mm:ss" /> (수정)
				</c:if>
							</span>

						</div> <!-- 프로필이미지, 아이디, 작성일 div 종료 --> <!-- 글 번호 / 제목 영역 시작 -->
						<div style="margin: 10px 0px;">
							<div class="ad_insertwrap">

								<input type="hidden" name="m_no"
									value="${sessionScope.login.m_no}">
								<!--ad 작성 글 영역-->
								<br>
								<!-- 프로필이미지, 아이디, 작성일 div -->

								<br> <br>

								<table class="table ad_inserttable">
									<tr>
										<th><span>* </span>제목</th>
										<td>${dto.bd_title }</td>
									</tr>
									<tr>
										<th><span>* </span>업종</th>
										<td>${dto.ad_comtype }</td>
									</tr>
									<tr>
										<th><span>* </span>업체명</th>
										<td>${dto.ad_comname }</td>
									</tr>
									<tr>
										<th><span>* </span>희망광고기간</th>
										<td><fmt:formatDate value="${dto.ad_startdate }"
												pattern="yyyy-MM-dd" /> ~ <fmt:formatDate
												value="${dto.ad_enddate }" pattern="yyyy-MM-dd" /></td>
									</tr>
									<tr>
										<th><span>* </span>가격</th>
										<td>${dto.ad_price }</td>
									</tr>
									<tr>
										<th><span>* </span>광고 파일 다운로드</th>
										<td><form action="addownload.do" method="post">
												<input type="hidden" name="name"
													value="${dto.ad_img_path }${dto.ad_img }"> <input
													type="submit" value="download">
											</form></td>
									</tr>
									<tr>
										<th><span>* </span>이미지 링크주소</th>
										<td>${dto.ad_url }</td>
									</tr>
									<tr>
										<c:choose>
											<c:when test="${sessionScope.login.m_auth ne 'Y'}">
												<th><span>* </span>진행상태</th>
												<td><select class="form-control" name="ad_status"
													onFocus='this.initialSelect = this.selectedIndex;'
													onChange='this.selectedIndex = this.initialSelect;'>
														<option value="1/5" <c:if test="${dto.ad_status eq '1/5'}" >selected</c:if>>결제대기</option>
														<option value="2/5" <c:if test="${dto.ad_status eq '2/5'}" >selected</c:if>>결제진행</option>
														<option value="3/5" <c:if test="${dto.ad_status eq '3/5'}" >selected</c:if>>결제완료</option>
														<option value="4/5" <c:if test="${dto.ad_status eq '4/5'}" >selected</c:if>>광고게시중</option>
														<option value="5/5" <c:if test="${dto.ad_status eq '5/5'}" >selected</c:if>>광고종료</option>
												</select></td>
											</c:when>
											<c:otherwise>
												<th><span>* </span>진행상태</th>
												<td><select class="form-control" name="ad_status">
														<option value="1/5"
															<c:if test="${dto.ad_status eq '1/5'}" >selected</c:if>>결제대기</option>
														<option value="2/5"
															<c:if test="${dto.ad_status eq '2/5'}" >selected</c:if>>결제진행</option>
														<option value="3/5"
															<c:if test="${dto.ad_status eq '3/5'}" >selected</c:if>>결제완료</option>
														<option value="4/5"
															<c:if test="${dto.ad_status eq '4/5'}" >selected</c:if>>광고게시중</option>
														<option value="5/5"
															<c:if test="${dto.ad_status eq '5/5'}" >selected</c:if>>광고종료</option>
												</select></td>
											</c:otherwise>

										</c:choose>
									</tr>

								</table>


								<br>

							</div>
							<!-- 글 번호 / 제목 영역 종료 -->

							<br>
							<div style="float: right;">
								<!-- 작성자에게만 보여질 버튼 -->
								<button type="button" id="apibtn">
									<img src="resources/images/kakaoimg.png" alt="">
								</button>
								<input type="button" value="수정" class="btn btn-primary"
									onclick="location.href='adupdateform.do?bd_no=${dto.bd_no}'">
								<input type="button" value="삭제" class="btn btn-primary"
									onclick="location.href='addelete.do?bd_no=${dto.bd_no}'">
							</div>
							<!-- 작성자에게만 보여질 버튼 종료 -->

							<!--            필수 입력 정보 노출 시작
            <div style="font-weight:bold; font-size: 15px; padding:10px 0px;"> 
              첨부 파일: 111.zip
            </div>
            필수 입력 정보 노출 종료 -->
							<br>
							<!-- 글 내용 시작 -->
							<div class="detail_content">
								${dto.bd_content } <br> <br>

							</div>


							<!-- 좋아요 버튼 시작 -->
							<div class="text-center">
								<div
									class="heart <c:if test='${likecheck eq 1 }'>is-active</c:if>"
									onclick="
				<c:if test='${login ne null}'> like_func(${dto.bd_no}, ${login.m_no }) </c:if>
				<c:if test='${login eq null}'> alert('로그인해주세요.')</c:if>"
									style="margin: 0 auto;">
									<span
										style="color: orange; font-size: 12px; font-weight: bold;">추천수<span
										class="likecnt">${dto.bd_recommandcount}</span></span>
								</div>
							</div>
							<!-- 좋아요 버튼 종료 -->

							<!-- 글 내용 종료 -->
					</td>
				</tr>
			</table>
			<input type="hidden" id="bd_no" value="${dto.bd_no }">
			<!-- AD 영역 종료-->

			<!-- 본문 / 댓글 중간 여백 영역 시작 -->
			<div style="width: 100%; display: block; height: 80px;">
				<input type="button" class="btn btn-primary" value="뒤로가기"
					style="float: right;" onclick="location.href='adlist.do'">
			</div>
			<!-- 본문 / 댓글 중간 여백 영역 종료 -->




			<!-- 댓글 영역 시작 -->
			<jsp:include page="../reply/reply.jsp">
				<jsp:param name="replyListDto" value="${replyListDto }"></jsp:param>
			</jsp:include>


			<!-- 댓글 영역 끝 -->
		</div>

		<!-- 본문 종료 -->

	</div>
	<!-- FOOTER 시작 -->
	<%@include file="../inc/_footer.jspf"%>
	<!-- FOOTER 종료 -->

	<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
	<%@include file="../inc/_foot.jspf"%>
	<!-- 썸머노트 JS -->
	<script src="resources/js/summernote/summernote-lite.js"></script>
	<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<script type="text/javascript" src="resources/js/addetail.js?ver=2.7"></script>
	<!-- 댓글 js -->
	<script type="text/javascript" src="resources/js/reply.js?ver=1.3"></script>
	<!-- 좋아요 js -->
	<script type="text/javascript" src="resources/js/likebutton.js?ver=1.2"></script>


</body>
</html>