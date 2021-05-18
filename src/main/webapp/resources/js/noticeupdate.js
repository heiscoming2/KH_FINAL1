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
	
	//일단 주소 1에 해당 하는 값을 채워주고
	$('.sidoselect').val(st_addr1);
	
	//selected된 index 값을 받아서
	let sidoselectedindex = $('.sidoselect option').index($('.sidoselect option:selected'));
	
	//해당 인덱스 값에 맞는 2번째 주소로 변환한뒤
	change(sidoselectedindex);
	
	//2번째 주소를 히든 태그에 담긴값으로 selected 한다.
	$('.gugunselect').val(st_addr2);
	
	//디테일 주소도 추가해준다.
	$('.st_addrdetail').val(st_addrdetail);
	
});