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
