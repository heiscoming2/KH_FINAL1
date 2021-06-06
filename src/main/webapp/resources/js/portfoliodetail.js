  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#summernote').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
    
    $('.detail_no').text(window.location.href+" (클릭 시 클립보드 저장)");
    
  });
  
  
  /* 게시글 삭제 버튼 클릭 confirm*/
  function delConfirm(bd_no) {
	  let delconfirm = confirm('정말 삭제하시겠습니까?');
	  if(delconfirm) {
		  location.href='portfoliodelete.do?bd_no='+bd_no;
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
  
  