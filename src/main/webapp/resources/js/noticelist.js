
function enterKey() {
	//키가 입력될때마다 함수 실행됨,
	//keyCode==13 (엔터키) 인경우 selectPage 실행되도록 처리
	if(window.event.keyCode==13) {
		selectPage(1);
	}
}


function selectPage(i) {

	let $searchbar = $('.search-bar').val();
	if( ($searchbar==null||$searchbar=="") ) {
		location.href='noticelist.do?page='+i;
	} else {
		if($searchbar.length==1) {
			alert('검색어는 두 글자 이상 입력해야 합니다.');
			return false;
		}
		location.href='noticelist.do?page='+i+'&key='+$searchbar;
	}
}

