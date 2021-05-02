  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#replyArea').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });

  /* 게시글 삭제 버튼 클릭 confirm*/
  function delConfirm() {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
  }
  
  /*댓글 삭제 버튼 클릭 confirm*/
  function delConFirmReply() {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
  }
  
  /*댓글 수정 시 summernote 호출*/
  function reply() {
  	  $('#reply1').summernote({
  	    height:150
  	  });
  }

  /*모집여부 confirm*/
  function statusChangeConfirm() {
	  let delconfirm = confirm('모집완료로 전환하시겠습니까?');
  }
 