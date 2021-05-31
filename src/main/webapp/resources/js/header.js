//리스트 가져오는 함수 엔터키나 돋보기 클릭하면 실행
function searchList() {
	const keyword = $('.form-search').val();
	location.href='searchlist.do?keyword='+keyword;
}

//엔터키 이벤트 걸리는곳
function searchKeyEvent() {
	if(event.keyCode==13) {
		//Enter키를 누르면 html 양식 제출을 시도하게 되는데
		//양식 요소에 action 속성이 포함되어있지 않아 동일한 페이지로 리다이렉션된다.
		//리다이렉션을 막기 위해 event.preventDefault();를 써서 막아준다.
		event.preventDefault();
		searchList();
	}
}