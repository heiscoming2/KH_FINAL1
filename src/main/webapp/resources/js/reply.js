  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#replyArea').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });
  
  /* 댓글 insert */
  function replyInsert(bd_no,m_no) {
	  
	  let re_content = $('#replyArea').val(); 
	  let replyInsertValue = {
			  "bd_no":bd_no,
			  "m_no":m_no,
			  "re_content":re_content
			  };
	  $.ajax({
		 type:'post',
		 url:'replyinsert.do',
		 data:JSON.stringify(replyInsertValue),
		 contentType:"application/json",
		 dataType:"json",
		 success:function(bool) {
			 if(bool) {
				 location.reload();
			 } else {
				 alert('댓글 등록 실패');ㅣ
			 }
		 },
		 error:function() {
			 alert('오류발생');
		 }
	  });
  }
  
  /*댓글 삭제 버튼 클릭 confirm 후 처리*/
  function delConFirmReply(re_no) {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
	  if(delconfirm) {
		  $.ajax({
			 type:"post",
			 url:"replydelete.do?re_no="+re_no,
			 success:function(bool) {
				 if(bool) {
					 alert('댓글이 삭제되었습니다.');
					 location.reload();
				 }
			 },
			 error:function() {
				 alert('오류 발생');
			 }
			 
		  });
	  }
  }
  
  /*댓글 수정 시 summernote 호출*/
  /*기존 버튼 삭제 및 새로운 버튼 추가*/
  function replyUpdateForm(re_no) {
  	  $('#reply'+re_no).summernote({
  	    height:150
  	  });
  	  let $div = $('.replyBtnWrap'+re_no);
  	  $div.children('.updateformbtn').remove();
  	  $div.children('.deleteformbtn').remove();
	  $div.append("<input type='button' class='btn btn-primary replyupdatebtn' style='margin-right:6px;' " +
	  		      "value='수정완료' onclick='replyUpdate("+re_no+")'></input>");
	  $div.append("<input type='button' class='btn btn-primary replyupdatecancelbtn' " +
	  		      "value='수정취소' onclick='replyUpdateCancel("+re_no+")'></input>");
  }
  
  //수정취소 버튼 누르면 summernote destory하고
  //추가된 버튼들 remove 해준다.
  //그리고 기존 버튼 다시 살려준다.
  function replyUpdateCancel(re_no) {
	  $('#reply'+re_no).summernote('destroy');
	  let $div = $('.replyBtnWrap'+re_no);
	  $div.children('.replyupdatebtn').remove();
	  $div.children('.replyupdatecancelbtn').remove();
	  $div.append("<input type='button' class='btn btn-primary updateformbtn' style='margin-right:6px;' value='수정' " +
	  		      "onclick='replyUpdateForm("+re_no+");'>")
	  $div.append("<input type='button' class='btn btn-primary deleteformbtn' value='삭제' onclick='delConFirmReply()'>");
  }
  
  
  //댓글 수정
  function replyUpdate(re_no) {
	  //let re_content = encodeURIComponent($('#reply'+re_no).summernote('code'));
	  let re_content = $('#reply'+re_no).summernote('code');
	  let replyUpdateValue = {
			  "re_content":re_content,
			  "re_no":re_no
	  };
	  $.ajax({
		 type:"post",
		 url:"replyupdate.do",
		 data:JSON.stringify(replyUpdateValue),
		 contentType:"application/json",
		 dataType:"json",
		 success:function(bool) {
			 if(bool) {
				 location.reload();
			 } else {
				 alert('댓글 수정 실패');
			 }
		 },
		 error:function() {
			 alert('오류 발생');
		 }
	  });
  }
