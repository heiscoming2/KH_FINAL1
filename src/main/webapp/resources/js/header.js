//리스트 가져오는 함수 엔터키나 돋보기 클릭하면 실행
function searchList() {
	const searchkey = $('.form-search').val()
	alert(searchkey);
}

//엔터키 이벤트 걸리는곳
function searchKeyEvent() {
	if(event.keyCode==13) {
		searchList();
	}
}