  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#summernote').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });
  
  
  /**/
  
  /*댓글 수정 시 썸머노트 해당 div에 썸머노트 적용*/
  $(function(){
  	$('#apibtn').click(function(){
  		$.ajax({
  			url:'kakaopay.do',
  			dataType:'json',
  			success:function(data){
  				alert(data);
  			} ,
  			error: function(error){
  			 alert(error);
  			 }
  			});
  		});
  	});