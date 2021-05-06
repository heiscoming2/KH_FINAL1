function loc_filter() {
	$('.loc_toggle').toggle();
}

function selectPage(i) {
	alert('test');
	console.log('test');
	let $sidoselect = $('.sidoselect').val();
	let $gugunselect = $('.gugunselect').val();
	let $status = $('.status').val();
	let $searchbar = $('.search-bar').val();
	alert($sidoselect);
	alert($gugunselect);
	alert($status);
	alert($searchbar);	
	if( ($sidoselect==null||$sidoselect=="") &&
		($gugunselect==null||$gugunselect=="") &&
		($status==null||$status=="") &&
		($searchbar==null||$searchbar=="")
	   ) {
		location.href='studylist.do?page='+i;
	} else {
		location.href='studysearch.do?page='+i+'&a1='+$sidoselect+'&a2='+$gugunselect+'&stat='+$status+'&key='+$searchbar;
	}
}

