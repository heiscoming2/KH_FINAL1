/* 썸머노트 jqeury*/


function chk_null() {
  alert('test');
}


/*썸머노트 설정*/
$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
			height : 100, // 에디터 높이
			minHeight : null, // 최소 높이
			maxHeight : null, // 최대 높이
			focus : true, // 에디터 로딩후 포커스를 맞출지 여부
			lang : "ko-KR", // 한글 설정
			placeholder : '기타 문의사항이나 궁금한 점을 물어보세요' //placeholder 설정
		});
	});
	
	


 
 