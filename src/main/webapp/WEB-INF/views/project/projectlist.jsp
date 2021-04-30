<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- head : 공통적으로 사용될 css 파일이 담김 (부트스트랩, common.css) -->
<%@include file="../inc/_head.jspf" %>
<title>샘플 페이지 입니다.</title>
</head>
<body>
<!-- HEADER 시작 -->
<%@include file="../inc/_header.jspf" %>
<!-- HEADER 종료 -->

<!-- 본문 시작 -->

  <div class="study_wrap">
        <h3>프로젝트 게시판</h3>
        <div class="study_btnwrap" float=right;>
            <input type="button" class="btn btn-success" value="글쓰기" onclick="location.href='guininsertform.html'">
        </div>
        <table class="table table-bordered study_table">
            <!-- 게시물 한 줄 시작-->
            <tr>
                <td>
                    <!-- 글 번호 span -->
                    <span class="study_no">
                        <a href="guindetail.html">
                            &nbsp;1
                        </a>
                    </span>
                    <!-- 글 번호 span 끝 -->

                    <!-- 글 제목 / 댓글 시작-->
                    <div class="study_title">
                        <a href="guindetail.html">
                            &nbsp;[프로젝트] 참여 프로젝트 공유
                            <span>[2]</span>
                        </a>
                    </div>
                    <!-- 글 제목 / 댓글 종료 -->


                    <!-- 프로필 영역 wrap 시작 -->
                    <div class="study_profile">
                        <img src="https://github.com/mdo.png" alt="mdo" width="35" height="35"
                            class="rounded-circle me-2">
                        <span class="study_writer">
                            <a class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
                                data-bs-toggle="dropdown">
                                leehj
                            </a>
                            <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
                            <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
                                <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
                                <li><a class="dropdown-item" href="#">이력서 열람</a></li>
                            </ul>
                            <!-- 프로필 드롭다운 메뉴 종료 -->
                        </span>
                        <span class="study_regdate">
                            2021-04-12 00:00
                        </span>
                    </div>
                    <!-- 프로필 영역 wrap 종료 -->
                </td>
            </tr>
            <!-- 게시물 한 줄 종료 -->
         

        </table>
        <!-- 페이징 -->
        <div class="text-center">
            <ul class="pagination" style="justify-content: center;">
                <li class="page-item"><a class="page-link" onclick="">이전</a></li>
                <li class="page-item">
                    <a style="color:red;" class="page-link" onclick="">
                        <b>1</b>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" onclick="">2</a>
                </li>
                <li><a class="page-link" onclick="page_next();">다음</a></li>
            </ul>
        </div>
        <!-- 페이징 끝-->

        <!-- 검색창 -->
        <div class="text-center mb-5">
            <input name="searchbox" type="text" placeholder="검색" value="" class="form-control search-bar"
                onkeyup="store_search_ent();" style="width:200px; display:inline-block; padding-bottom:11px;">
            <input type="button" class="btn btn-primary" value="검색" onclick="store_search();">
        </div>
        <!-- 검색창 끝 -->
    </div>
    <!-- 스터디 전체 영역 -->


<!-- 본문 종료 -->

<!-- FOOTER 시작 -->
<%@include file="../inc/_footer.jspf" %>
<!-- FOOTER 종료 -->

<!-- foot : 공통적으로 사용될 js 파일이 담김 (jquery,부트스트랩 js) -->
<%@include file="../inc/_foot.jspf" %>
	
</body>
</html>