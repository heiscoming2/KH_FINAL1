$(function(){

	//검색어가 있는 경우 실행
	if(document.getElementById("h_a1")) {

		//hidden태그에 담긴 값을 변수에 저장
		let h_a1 = $('#h_a1').val();
		let h_a2 = $('#h_a2').val();
		let h_stat = $('#h_stat').val();
		let h_key = $('#h_key').val();
		
		//지역1 값 초기화
		$('.sidoselect').val($('#h_a1').val());
		
		//지역1의 selected idx 값을 받아온다.
		let sidoselectidx = $('.sidoselect option').index($('.sidoselect option:selected'));
		
		//해당 idx값으로 지역2의 select를 결정한다.
		change(sidoselectidx);
		
		//지역2의 값이 '' 이면 eq0 (전체)를 selected 해주고
		//값이 있으면 그 값을 selected 해준다.
		if(h_a2=='') {
			$('.gugunselect option:eq(0)').prop("selected",true);
		} else {
			$('.gugunselect').val(h_a2);
		}
		
		//모집여부 selected 되게끔 해준다.
		//얘는 selecte에서 ''값 = 전체라, 공백이 아닌 경우만 값이 채워지게끔 처리를 하면됨
		if(h_stat!='') {
			$('.status').val(h_stat);
		}
		
		//key는 (문자열이 들어가니까 ''값이 들어가도 상관없음 그냥 값을 바로 대입)
		$('.search-bar').val(h_key);
		
		//필터를 일단 펼쳐준다.
		loc_filter();
		
	}
});

function enterKey() {
	//키가 입력될때마다 함수 실행됨,
	//keyCode==13 (엔터키) 인경우 selectPage 실행되도록 처리
	if(window.event.keyCode==13) {
		selectPage(1);
	}
}

function loc_filter() {
	$('.loc_toggle').toggle();
}

function selectPage(i) {
	let $sidoselect = $('.sidoselect').val();
	let $gugunselect = $('.gugunselect').val();
	let $status = $('.status').val();
	let $searchbar = $('.search-bar').val();
	if( ($sidoselect==null||$sidoselect=="") &&
		($gugunselect==null||$gugunselect=="") &&
		($status==null||$status=="") &&
		($searchbar==null||$searchbar=="")
	   ) {
		location.href='studylist.do?page='+i;
	} else {
		if($searchbar.length==1) {
			alert('검색어는 두 글자 이상 입력해야 합니다.');
			return false;
		}
		location.href='studysearch.do?page='+i+'&a1='+$sidoselect+'&a2='+$gugunselect+'&stat='+$status+'&key='+$searchbar;
	}
}

