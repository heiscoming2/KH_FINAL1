/* 썸머노트 jqeury*/
$(document).ready(function() {
   $('#summernote').summernote({
     placeholder: '상세 내용을 입력해주세요.',
     height:500
   });
});

function chk_null() {
  alert('test');
}

/*function showHidden(){
    if($("input:checkbox[id='customControlAutosizing']").is(":checked") == true) {
        $('#is_phone_open').attr('disabled', false);    
    } else {
        $('#is_phone_open').attr('disabled', true);
    }    
}*/
