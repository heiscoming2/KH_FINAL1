/* 썸머노트 jqeury*/


function chk_null() {
  alert('test');
}


/*썸머노트 설정*/
$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
			height : 200, // 에디터 높이
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '기타 문의사항이나 궁금한 점을 물어보세요' //placeholder 설정
		});
	});
	
	
/*카카오페이 결제*/

$(function(){
	$('#apibtn').click(function(){
		$.ajax({
			url:'/kakaopay.do', 
			dataType:'json' ,
			
			
			success:function(data){
				alert(data)
				
			} ,
			error:function(error){
			alert(error);
			}
		});
	});
});
 
 
 
/* 이미지 업로드 */ 
 
function imageupload(cnt){
	console.log(ad);
	var form = $('#ad_file_form_'+cnt)[0];
	console.log(form);
    // Create an FormData object  
    var data = new FormData(form);  
    data.append('file',$('#ad_file_'+cnt)[0].files[0]);         
    var ad_no = ads[cnt-1].ad_no;
    console.log(ad_no);  

    
    $.ajax({             
    	type: "POST",
        enctype: 'multipart/form-data',  
        url: "admultipart.do?ad_no=" + ad_no,  
        data: data,
        processData: false,    
        contentType: false,      
        cache: false,           
        timeout: 600000,       
        success: function (data) { 
        		alert(data);
        	if(cnt<num){
        	//cnt <= num이면 두 번 돈다 
        		console.log(num+1+"번째");
        		imageupload(++cnt);
        	}   else{
        	location.href = 'adlist.do';    
        	}   
        },          
        error: function (e) {  
        	console.log("ERROR : ", e);      
            alert("fail");  
        }     
	});   
 
 }
 