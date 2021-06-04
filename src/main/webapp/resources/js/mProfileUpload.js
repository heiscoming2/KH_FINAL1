$(function(){
 
    $('#uploadBtn').on('click', function(){
        uploadFile();
    });
 
});
 
function uploadFile(){
    
	    var form = $('#profileUpload')[0];
	    var formData = new FormData(form);
    
 
    $.ajax({
    	type : 'POST',
        url : 'profileUpload.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
        	alert("이미지 업로드 성공");
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    })
}

/* 이미지 미리보기*/
function readURL(input) {
 if (input.files && input.files[0]) {
  var reader = new FileReader();
  
  reader.onload = function (e) {
   $('#image_section').attr('src', e.target.result);  
  }
  
  reader.readAsDataURL(input.files[0]);
  }
}
 
$("#imgInput").change(function(){
   readURL(this);
});


/*개인 회원 회원정보 수정 전송*/
$(document).ready(function(){
	$("#updateUser").click(function(){
		$("#updateForm").attr("action","user_update.do");
		$("#updateForm").submit();	
	});
	
});

/*기업 회원 회원정보 수정 전송*/
$(document).ready(function(){
	$("#updateBiz").click(function(){
		$("#updateForm").attr("action","biz_update.do");
		$("#updateForm").submit();	
	});	
});
