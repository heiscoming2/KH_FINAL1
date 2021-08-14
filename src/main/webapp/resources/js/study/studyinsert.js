/* 썸머노트 jqeury*/
$(document).ready(function() {
   $('#summernote').summernote({
     placeholder: '상세 내용을 입력해주세요.',
     height:500,
	 callbacks: {
		  onImageUpload: function(files, editor, welEditable) {
			  for(var i = files.length - 1; i >= 0; i--) {
				  sendFile(files[i],this)
			  }
		  }
	  }
   });
});


function sendFile(file,el) {
	var form_data = new FormData();
	form_data.append('file',file);
	$.ajax({
		data:form_data,
		type:"POST",
		url:'uploadsummernoteimage.do',
		cache:false,
		contentType:false,
		processData:false,
		success:function(data) {
			if(data==null) {
				alert("잘못된 이미지 입니다.");
			} else {
				$(el).summernote('editor.insertImage',data.url);
			}
		}, 
		error:function(e) {
			alert("오류발생");
			console.log(e);
		}
	});
}


