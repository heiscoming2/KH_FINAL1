function uploadFile(){
	    
	var formData = new FormData();
	formData.append('r_img', $('#input_r_img')[0].files[0]); 
    
 
    $.ajax({
    	type : 'POST',
        url : 'resumeProfile.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
        	const resumeUpdateForm = document.getElementById('resumeUpdateForm');
        	resumeUpdateForm.r_img_no.value = data;
        	alert("이미지 업로드 성공");
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    })
}

/*이미지 미리보기*/
function readURL(input) {
 if (input.files && input.files[0]) {
  var reader = new FileReader();
  
  reader.onload = function (e) {
   $('#image_section').attr('src', e.target.result);  
  }
  
  reader.readAsDataURL(input.files[0]);
  }
}
 
$("#input_r_img").change(function(){
   readURL(this);
});


function resumeUpdateAjax(formObj) {
	var formData = new FormData();
	formData.append('r_detailAddress', formObj.r_detailAddress.value);
	formData.append('r_extraAddress', formObj.r_extraAddress.value);
	formData.append('r_img_no', formObj.r_img_no.value);
	formData.append('r_jibunAddress', formObj.r_jibunAddress.value);
	formData.append('r_no', formObj.r_no.value);
	formData.append('r_portfolio', formObj.r_portfolio.value);
	formData.append('r_postcode', formObj.r_postcode.value);
	formData.append('r_roadAddress', formObj.r_roadAddress.value);
	formData.append('r_selfletter', formObj.r_selfletter.value);
 
    $.ajax({
    	type : 'POST',
        url : 'resume_update_ajax.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
        	alert('다 됨!');
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    });
}