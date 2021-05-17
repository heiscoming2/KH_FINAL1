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

function chk_null() {
  alert('test');
}

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
			$(el).summernote('editor.insertImage',data.url);
			alert(data.url);
		}
	});
}
