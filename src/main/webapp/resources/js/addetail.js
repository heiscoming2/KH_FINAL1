  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#summernote').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });
  
  
  /**/
  
 
  	
/* kakaopay */

$(function(){

	$('#apibtn').click(function(){
		$.ajax({
			type:'post',
		 	url:'kakaopay.cls' ,
		 	dataType:'json' ,
		 	success:function(data){
		 		var box = data.next_redirect_pc_url;
		 		window.open(box,'kakaopay','width=500, height=500 menubar=no, status=no, toolbar=no' );
		 		
		 	} ,
		 	error:function(error){
		 	alert(error);
			}
		});
	
	});
	
});  	  	
  	
  function adstatusChange() {
 	let bd_no = $('#bd_no').val(); 	
 	location.href='adstatuschange.do?bd_no='+bd_no;
 }  	
  	
  	
  	
  	