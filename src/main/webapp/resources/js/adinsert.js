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
	console.log(projects);
	var form = $('#pro_file_form_'+cnt)[0];
	console.log(form);
    // Create an FormData object  
    var data = new FormData(form);  
    data.append('file',$('#pro_file_'+cnt)[0].files[0]);         
    var pro_no = projects[cnt-1].pro_no;
    console.log(pro_no);  

    
    $.ajax({             
    	type: "POST",
        enctype: 'multipart/form-data',  
        url: "multipart.do?pro_no=" + pro_no,  
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
        	location.href = 'projectlist.do';    
        	}   
        },          
        error: function (e) {  
        	console.log("ERROR : ", e);      
            alert("fail");  
        }     
	});   
 
 }
 