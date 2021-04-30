$(document).ready(function() {
	
	//h_addr1 이 null 이 아니라면 검색조건이 있다는거니까 검색 내용으로 채워준다. 
	if(document.getElementById("h_addr1")) {
		let h_addr1 = document.getElementById("h_addr1").value;
		let h_addr2 = document.getElementById("h_addr2").value;
		let h_careerselect = document.getElementById("h_careerselect").value;
		let h_eduselect = document.getElementById("h_eduselect").value;
		let h_searchbox = document.getElementById("h_searchbox").value;
		
		//지역 1의 값을 초기화
		document.getElementById("sidoselect").value=h_addr1;
		//지역 1 selected, index 값을 받아와서
		var sidoselectidx = $("#sidoselect option").index($("#sidoselect option:selected"));
		//해당 index의 구군(뒷주소)로 option을 변경해주는 chagne함수 실행
		if(sidoselectidx!=null) {
			change(sidoselectidx);
		}
		
		//그리고 addr2를 넘어온 값이 % 이면 eq0(전체) 으로 selected 해준다.
		//addr2 가 %로 넘어온 경우는, addr2가 전체인 경우 %로 문자를 변경해서
		//쿼리문에서 모든 지역정보를 받아올 수 있도록 수정해주기 위함
		if(h_addr2=='') {
			$("#gugunselect option:eq(0)").prop("selected",true);
		} else {
			document.getElementById("gugunselect").value=h_addr2;
		}
		document.getElementById("careerselect").value=h_careerselect;
		document.getElementById("eduselect").value=h_eduselect;
		document.getElementById("searchbox").value=h_searchbox;
	}
});



function filter_toggle() {
	$(".filter_innerwrap").toggle();
}

function openDetailUrl(url) {
	var _width = '1300';
	var _height = '1000';
	var _left = Math.ceil((window.screen.width - _width) / 2);
	window.open(url, '', 'width=' + _width + ',left=' + _left + ',height='
			+ _height);
}

function selectPage(i) {

	var $sidoselect = $('.sidoselect').val();
	var $gugunselect = $('.gugunselect').val();
	var $careerselect = parseInt($('.careerselect').val());
	var $eduselect = parseInt($('.eduselect').val());
	var $cc_search = $('.cc_search').val();

	if (($sidoselect == null || $sidoselect == "")
	 && ($gugunselect == null || $gugunselect == "" || $gugunselect == "전체")
	 && ($careerselect == 4)
	 && ($eduselect == 4)) {
		location.href = 'companycrawlinglist.do?page=' + i;
	} else {
		location.href = 'companycrawlinglistandsearch.do?page=' + i
				+ '&src_a1=' + $sidoselect + '&src_a2=' + $gugunselect
				+ '&src_cer=' + $careerselect + '&src_edu=' + $eduselect
				+ '&src_key=' + $cc_search;
	}
}
