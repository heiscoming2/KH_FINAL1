  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#replyArea').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150,
      lang: 'ko-KR'
    });
  });
  
  /* 신고 insert popup*/

	function reportreplyInsert(re_no){
		window.open("reportreplyinsertform.do?re_no="+re_no, "신고등록", "width=550, height=300, left=100, top50")
	}
  
  
  
  
  /* 댓글 insert */
  function replyInsert(bd_no,m_no,re_parentno) {
	  let re_content;
	  if(re_parentno==null) {
		  re_content = $('#replyArea').val(); 
	  } else {
		  re_content = $('#rereply'+re_parentno).val();
	  }
	  let replyInsertValue = {
			  "bd_no":bd_no,
			  "m_no":m_no,
			  "re_content":re_content,
			  "re_parentno":re_parentno
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
				 alert('댓글 등록 실패');
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
  
  
  /*댓글 수정 시 summernote 호출*/
  /*기존 버튼 삭제 및 새로운 버튼 추가*/
  function replyUpdateForm(re_no) {
  	  
  	  rereplyInsertCancel(re_no);
  	  //reretestdiv 의 마진 값을 가져온다.
  	  //썸머노트 마진값을 주기위해
  	  let reretestdiv = $('#rerediv'+re_no).css('margin-left').replace(/[^-\d\.]/g, '');
  	  console.log(reretestdiv);
  	  
  	  $('#reply'+re_no).summernote({
  	    height:150,
  	    tabsize:3,
  	    lang: 'ko-KR'
  	  });
  	  
  	  let $div = $('.replyBtnWrap'+re_no);
  	  $div.children('.updateformbtn').remove();
  	  $div.children('.deleteformbtn').remove();
  	  $div.children('.rereplyinsertformbtn').remove();
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
	  $div.append("<input type='button' class='btn btn-primary rereplyinsertformbtn' style='margin-right:6px;' value='답글' onclick='rereplyInsertForm("+re_no+");'>");
	  $div.append("<input type='button' class='btn btn-primary updateformbtn' style='margin-right:6px;' value='수정' " +
	  		      "onclick='replyUpdateForm("+re_no+");'>");
	  $div.append("<input type='button' class='btn btn-primary deleteformbtn' value='삭제' onclick='delConFirmReply("+re_no+")'>");
  }
  
  

  
  
  //대댓글 INSERT FORM
  function rereplyInsertForm(bd_no,m_no,re_no) {
	   
	    $('#reply'+re_no).after("<br id='rebr"+re_no+"'><textarea id='rereply"+re_no+"'></textarea>");
	    $('#rereply'+re_no).after("<br id='rerebr"+re_no+"'><div class='rereplyBtnWrap"+re_no+"'style='float:right;'>");
	    
	    
	    $('#rereply'+re_no).summernote({
	        placeholder: '답글을 작성해주세요.',
	        height:150
	    });
	    
	    let $div = $('.rereplyBtnWrap'+re_no);
	    
		$div.append("<input type='button' class='btn btn-primary rereplyinsert' style='margin-right:6px;' value='답글 등록' " +
	  		        "onclick='replyInsert("+bd_no+","+m_no+","+re_no+");'>");
		
	  	//위에 답글 버튼을 onclick 속성 변경을 위해 div를 선택 후 속성을 변경한다.
	  	$div = $('.replyBtnWrap'+re_no);
	    $div.children('.rereplyinsertformbtn').attr('onclick',"rereplyInsertCancel("+bd_no+","+m_no+","+re_no+");");
	    
  }
  
  
  //대댓글 INSERT FORM 취소
  //onclick 속성을 다시 변경해주어야한다.
  function rereplyInsertCancel(bd_no,m_no,re_no) {
	  //썸머노트 닫고
	  //답글등록 버튼 제거하고
	  //insert form 열리면서 만든거 다 지워준다.
	  //답글 onclick 속성 다시 insertform으로 변경해주고
	  
	  let $div = $('#rereply'+re_no);
	  $div.summernote('destroy');
	  $div.empty();
	  $div.remove();
	  
	  $('#rebr'+re_no).remove();
	  $('#rerebr'+re_no).remove();
	  
	  //댓글 등록 버튼 삭제
	  $('.rereplyBtnWrap'+re_no).remove();
	  
	  $div = $('.rereplyBtnWrap'+re_no);
	  $div.children('.rereplyinsert').remove();
	  
	  $div = $('.replyBtnWrap'+re_no);
	  $div.children('.rereplyinsertformbtn').attr('onclick',"rereplyInsertForm("+bd_no+","+m_no+","+re_no+");");
  }
  
  
  
  
  
