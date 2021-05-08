$(document).ready(function(){
	$('.detail_no').text(window.location.href);
});

  /* 게시글 삭제 버튼 클릭 confirm*/
  function delConfirm(bd_no) {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
	  if(delconfirm) {
		  location.href='studydelete.do?bd_no='+bd_no;
	  }
  }

  /*모집여부 confirm*/
  function statusChangeConfirm() {
	  let delconfirm = confirm('모집완료로 전환하시겠습니까?');
  }
 
  