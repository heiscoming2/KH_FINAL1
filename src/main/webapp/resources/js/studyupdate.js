//주소값 초기화
$(document).ready(function(){
	/* 썸머노트 jqeury*/
	$('#summernote').summernote({
	  placeholder: '상세 내용을 입력해주세요.',
	  height:500
	});
	
	//히든에 담긴 주소 값을 받아와서
	let st_addr1 = $('#h_addr1').val();
	let st_addr2 = $('#h_addr2').val();
	let st_addrdetail = $('#h_addrdetail').val();
	
	
	$('.sidoselect').val(st_addr1);
	
	change(3);
	
	//$('.gugunselect').val(st_addr2);
	$('.st_addrdetail').val(st_addrdetail);
	
});