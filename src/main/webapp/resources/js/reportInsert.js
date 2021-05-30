
/* 신고 insert popup*/

	function reportInsert(bd_no){
		window.open("reportinsertform.do?bd_no="+bd_no, "신고등록", "width=550, height=300, left=100, top50")
	
	}

var data;
function setData(dto){
	data = JSON.parse(dto);
}

 