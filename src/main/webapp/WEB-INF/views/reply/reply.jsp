<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   


      <table class="table table-bordered" style="width:100%;">
      
      <!-- 댓글 갯수 및 여백 시작 -->
        <tr>
          <td style="margin:0; padding:0;">
            <div style="background-color: rgb(230, 230, 230); margin:0; padding:15px 0px;">&nbsp;&nbsp;댓글&nbsp;${replyCnt }</div>
          </td>
        </tr>
      <!-- 댓글 갯수 및 여백 종료 --> 
	
	<c:choose>
	 <c:when test="${empty replyListDto }">
	 	<tr>
	 		<td align="center">
	 			<b>첫번째 댓글을 작성해보세요!</b>
	 		</td>
	 	</tr>
	 </c:when>
	 <c:otherwise>
	  <c:forEach var="replyListDto" items="${replyListDto }">
	  <!-- 댓글 LIST 시작 -->
        <tr>
          <td>
              <!-- 프로필이미지, 아이디, 작성일 div -->
              <div>
                <div class="replyBtnWrap${replyListDto.re_no }" style="float:right;">
                <!-- 수정/삭제는 현재 세션회원번호와, 댓글작성회원번호replyListDto.m_no 가 일치하는 경우에만 보여주면될듯 -->
                <c:if test="${sessionScope.login ne null }">
	              <input type="button" class="btn btn-primary rereplyinsertformbtn" value="답글" onclick="rereplyInsertForm(${dto.bd_no},${sessionScope.login.m_no},${replyListDto.re_no});">
                </c:if>
                <c:if test="${sessionScope.login ne null && sessionScope.login.m_no eq replyListDto.m_no }">
	               <input type="button" class="btn btn-primary updateformbtn" value="수정" onclick="replyUpdateForm('${replyListDto.re_no}');">
	               <input type="button" class="btn btn-primary deleteformbtn" value="삭제" onclick="delConFirmReply('${replyListDto.re_no}')">
                </c:if>
                </div>
             	  <!-- 여기 마진 left를 댓글 뎁스로 구해야됨 -->
              <div id=reretestdiv style="margin-left:<c:if test="${replyListDto.re_depth>1}">${(replyListDto.re_depth)*30}px;</c:if>">
	              <!-- 답글 이미지랑, 타겟 댓글 닉네임 -->
	              <!-- 위엔 닉네임 밑에는 이미지 보여주면될듯 -->
	              <c:if test="${replyListDto.re_depth ne 0 }">
	              <div style="float:left;">
	              	<ul style="list-style:none; padding:0; width:120px; text-align:right; margin-right:30px;">
	              	    <li style="color:gray; font-size:8px;">To.</li>
	              		<li style="color:gray; font-size:12px;">${replyListDto.targetid}</li>
	              		<li><img src="boardimages/replyarrow.png" width="35" height="35"></li>
	              	</ul>
	              </div>
	              </c:if>		
              
              <div>  
	              <img src="${replyListDto.m_img_path }${replyListDto.m_img }" alt="mdo" width="35" height="35" class="rounded-circle me-2"
	                style="float: left; margin-top: 5px;">
	              <div>
	                <a class="align-items-center text-decoration-none dropdown-toggle" id="dropdownaUser"
	                  style="font-size:15px;" data-bs-toggle="dropdown" aria-expanded="false">
	                  ${replyListDto.m_nickname }
	                </a>
	                <!-- 프로필 드롭다운 메뉴(이력서 열람은 나중에 기업회원만 보이게 해야됨) -->
	                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownaUser">
	                    <li><a class="dropdown-item" href="#">쪽지보내기</a></li>
	                    <li><a class="dropdown-item" href="#">이력서 열람</a></li>
	                </ul>
	                <!-- 게시글 작성자의 회원번호와 댓글 작성자의 회원 번호가 일치하면 작성자를 표시해준다. -->
	                <c:if test="${dto.m_no eq replyListDto.m_no }">
		                <a style="border:1px solid red; border-radius:5px; width:35px; height:20px; font-size:12px; padding:3px; color:red; margin-left:5px;">
		                	작성자 
		                </a>
	                </c:if>
	              </div>
	              <span style="font-size: 10px; color:rgb(112, 112, 112); position: relative; bottom:5px;">
	              	[ IP : ${replyListDto.re_writerip } ]
	                <fmt:formatDate value="${replyListDto.re_createddate }" pattern="yyyy-MM-dd HH:mm:ss"/> (작성됨)
	                <c:if test="${replyListDto.re_modifydate ne null }">
	                <fmt:formatDate value="${replyListDto.re_modifydate }" pattern="yyyy-MM-dd HH:mm:ss"/> (수정됨)
	                </c:if>
	                </span>
                 </div>
               </div> 
            </div> 
            <!-- 프로필이미지, 아이디, 작성일 div 끝 -->
            <!-- 댓글 컨텐츠 영역 시작 -->

            <div id="reply${replyListDto.re_no}" class="mt-3"> 
	            <c:choose>
	            	<c:when test="${replyListDto.re_ishidden eq 'Y'}"><span style="font-size:12px;">사용자가 삭제한 댓글입니다.</span></c:when>
	            	<c:otherwise>${replyListDto.re_content }</c:otherwise>
	            </c:choose>
            </div>
            <!-- 댓글 컨텐츠 영역 종료 -->
            
            <!-- 대댓글 작성 시 여길로 썸머노트 입력폼 쏴준다 -->
            <!-- 답글 클릭시 여기에다가 버튼을 만들어서 달아준다. -->
                            
          </td>
        </tr>
        </c:forEach>
        </c:otherwise>
	</c:choose>
		
	
	<!-- 댓글 LIST 종료 -->	
	
    <!-- 댓글 작성 영영 시작 -->
    <!-- 로그인 세션이 null이 아닌 경우 (있으면) 세션에서 회원 정보를 가져와 뿌려놓는다. -->
    <!-- 세션이 없는 경우 로그인 후 댓글 작성을 보여준다. -->
	<c:choose>
		<c:when test="${sessionScope.login ne null }">
        <tr>
          <td>
            <div class="comment_wrap">
              <img src="${sessionScope.login.m_img_path }${sessionScope.login.m_img}" alt="mdo" width="35" height="35" class="rounded-circle me-2"
                style="float: left; margin-top: 5px;">
                <a class="" id=""
                  style="font-size:15px; color:black; position:relative; top:10px;">
                  ${sessionScope.login.m_nickname }
                </a>
            </div>
            <br>
            <br>
			 <textarea id="replyArea" name="re_content"></textarea>
	         <br>
	         <input type="button" onclick="replyInsert(${dto.bd_no},${sessionScope.login.m_no });" class="btn btn-primary" value="댓글 등록" style="float:right;">
            <br>
			</td>
		</tr>
		</c:when>
      <c:otherwise>
        <tr>
          <td class="text-center">
            <div><b>로그인 후 댓글 작성 가능</b></div>
          </td>
        </tr>
      </c:otherwise>
	</c:choose>
	<!-- 댓글 작성 영영 종료 -->
   </table>
	
