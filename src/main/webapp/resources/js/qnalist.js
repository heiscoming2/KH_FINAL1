

function selectPage(i) {
	
	let $searchbar = $('.search-bar').val();
	if( ($searchbar==null||$searchbar=="")
	   ) {
		location.href='qnalist.do?page='+i;
	} else {
		if($searchbar.length==1) {
			alert('검색어는 두 글자 이상 입력해야 합니다.');
			return false;
		}
		location.href='qnasearch.do?page='+i+'&key='+$searchbar;
	}
}
