/* 썸머노트 jqeury*/

function fileUpload() {
	
	var formData = new FormData();
	formData.append('ad_file', $('#ad_file')[0].files[0]); 
    
 
    $.ajax({
    	type : 'POST',
        url : 'adfileupload.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
        	$('#ad_img').val(data.ad_img);
        	$('#ad_img_path').val(data.ad_img_path);
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    })


}

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
	
	

 var adsubmits;
function ad_submit(){
	var adsubmits = [];
		var adinsertobj = {};
		adinsertobj.ad_no = $("#ad_no").val();
		adinsertobj.ad_comtype = $("#ad_comtype").val();
		adinsertobj.ad_comname = $("#ad_comname").val();
		adinsertobj.ad_startdate = $("#ad_startdate").val();
		adinsertobj.ad_enddate = $("#ad_enddate").val();
		adinsertobj.ad_url = $("#ad_url").val();
		adinsertobj.ad_price= $("#ad_price").val();
		adinsertobj.ad_status = $("#ad_status").val();
		adinsertobj.m_no = $("#m_no").val();
		adinsertobj.bd_no = $("#bd_no").val();
		adinsertobj.bd_title = $("#bd_title").val();
		adinsertobj.bd_content = $("#bd_content").val();
		adinsertobj.m_nickname = $("#m_nickname").val();
		
		
		adsubmits.push(adinsertobj);
	}
	console.log(adsubmits);
	var settings = {
	  "url": "adinsert.do",
	  "method": "POST",
	  "headers": {
    		"Content-Type": "text/plain"
  		},
	  "data":JSON.stringify(adsubmits)
	};
	
	$.ajax(settings).done(function (response) {
	  console.log(response);
	  projects = JSON.parse(response);
	  
	  imageupload(1);
	  
	  
	});


function imageupload(cnt){
	console.log(ads);
	var form = $('#ad_file_form')[0];
	console.log(form);
    // Create an FormData object  
    var data = new FormData(form);  
    data.append('file',$('#ad_file')[0].files[0]);         
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
        		alert("글 작성 완료");
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
 
 
