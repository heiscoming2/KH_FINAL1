function selectPage(i) {
	const m_no = $('#writer_mno').val();
	const category = $('#category').val();
	const keyword = $('#keyword').val();
	if(keyword==null||keyword==''||keyword=="") {
		location.href='postlookup.do?page='+i+'&m_no='+m_no+'&category='+category;
	} else {
		location.href='postlookup.do?page='+i+'&m_no='+m_no+'&category='+category+'&keyword='+keyword;
	}
}


$(function(){
	const category = $('#category').val();
	$('.cate'+category).css('font-weight','bold').css('font-size','18px');
});


function selectCate(category) {
	const m_no = $('#writer_mno').val();
	location.href='postlookup.do?m_no='+m_no+'&category='+category;
}


// 선택 삭제 버튼 (멀티 삭제 가능)
function receiveListDel() {
	const list = document.querySelectorAll('#table-list input[name=postListDel]');
	list.forEach(function (input) {
		const n_no = input.getAttribute('n_no');
		
		var formData = new FormData();
		formData.append("n_no", n_no);
	
		$.ajax({
			type : 'POST',
			url : 'boardDeleteAjax.do',
			data : formData,
			async: false, 
			contentType : false,
			processData : false,
			success:function(data){
				console.log({data});
				 alert("삭제 성공");
			},
			error:function(msg){
				 alert("통신실패");
			}
		});
	});

	alert('삭제가 완료 되었습니다.');
	location.reload();
}

