$(function(){
 
    $('#uploadBtn').on('click', function(){
        uploadFile();
    });
 
});
 
function uploadFile(){
    
    var form = $('#profileUpload')[0];
    var formData = new FormData(form[0]);
 
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
