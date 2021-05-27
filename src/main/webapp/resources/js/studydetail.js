$(document).ready(function(){
	$('.detail_no').text(window.location.href+" (클릭 시 클립보드 저장)");
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
  
  /* 주소 클립보드 복사*/
  function CopyUrlToClipBoard() {
	  //엘리먼트를 하나 만들어서 거기에 값을 넣고 select를 해서 복사하는 방식
	  
	  //그래서 더미라는 변수에 input 태그를 만들고 거기에 url을 value로 넣고, 
	  //해당 엘리먼트를 select(드래그처럼) 선택시켜놓고 (그럼 주소가 선택이된다.)
	  //그리고 선택된 내용을 복사하게 처리를했고
	  //복사가 끝나면 input 태그를 다시 지워주는 과정임
	  
      let dummy   = document.createElement("input");
      let text    = location.href;
      document.body.appendChild(dummy);
      dummy.value = text;
      dummy.select();
      document.execCommand("copy");
      document.body.removeChild(dummy);
      alert(location.href+"\n클립보드에 저장되었습니다.");
      
  }
  
  function studyJoinApply(bd_no,m_no) {
	  
	  
	  var sj_message = $('input[name="sj_message"]').val();
	  if(sj_message==null||sj_message=='') {
		  alert('자기소개를 입력해주세요.');
		  return false;
	  }
	  var data = {
			  "bd_no":bd_no,
			  "m_no":m_no,
			  "sj_message":sj_message
	  }
	  
	  $.ajax({
		 type:"post",
		 url:"studyjoinapply.do",
		 dataType:"json",
		 data:JSON.stringify(data),
		 contentType:"application/json",
		 success:function(data) {
			 alert(data.msg)
			 if(data.dto!=null) {
				 location.reload();
			 }
		 },
		 error:function(e) {
			 console.log("오류정보 : "+e);
			 alert('오류발생');
		 }
	  });
  }
  
  function studyJoinListToggle() {
	  $('.studyjoinlist').toggle();
  }
  
  function studyJoinApplyListToggle() {
	  $('.studyjoinapplylist').toggle();
  }  