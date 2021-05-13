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

  /*모집여부 confirm*/
  function statusChangeConfirm(no) {
	  let delconfirm = confirm('모집 상태를 전환하시겠습니까?');
	  console.log(no);
	  if(delconfirm) {
		  let bd_no={"bd_no":no};
		  $.ajax({
			 type:"post",
			 url:"studystatchange.do",
			 dataType:"json",
			 data:JSON.stringify(bd_no),
			 contentType:"application/json",
			 success:function(bool) {
				 if(bool) {
					 alert('전환되었습니다');
					 location.reload();
				 }
			 },
			 error:function() {
				 alert('오류 발생');
			 }
		  });
	  }
  }
 
  