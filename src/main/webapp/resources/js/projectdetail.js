$(document).ready(function(){
	$('.detail_no').text(window.location.href+" (클릭 시 클립보드 저장");
	//detail 페이지에서 현재 주소를 보여주기 위함
});


  /* 게시글 삭제 버튼 클릭 confirm*/
  function delConfirm(bd_no) {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
	  if(delconfirm) {
		  location.href='studydelete.do?bd_no='+bd_no;
	  }
  }