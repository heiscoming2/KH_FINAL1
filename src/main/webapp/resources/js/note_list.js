// 받은 쪽지 삭제 버튼 (멀티 삭제 가능)
function receiveListDel() {
	const list = document.querySelectorAll('#table-list input[name=receiveListDel]');
	list.forEach(function (input) {
		const n_no = input.getAttribute('n_no');
		
		var formData = new FormData();
		formData.append("n_no", n_no);
	
		$.ajax({
			type : 'POST',
			url : 'note_delete_ajax.do',
			data : formData,
			async: false, 
			contentType : false,
			processData : false,
			success:function(data){
				console.log({data});
				// alert("삭제 성공");
			},
			error:function(msg){
				// alert("통신실패");
			}
		});
	});

	alert('삭제가 완료 되었습니다.');
	location.reload();
}


// 보낸 쪽지 삭제 버튼 (멀티 삭제 가능)
function sendListDel() {
	const list = document.querySelectorAll('#table-list input[name=sendListDel]');
	list.forEach(function (input) {
		const n_no = input.getAttribute('n_no');
		
		var formData = new FormData();
		formData.append("n_no", n_no);
	
		$.ajax({
			type : 'POST',
			url : 'note_delete_ajax.do',
			data : formData,
			async: false, 
			contentType : false,
			processData : false,
			success:function(data){
				console.log({data});
				// alert("삭제 성공");
			},
			error:function(msg){
				// alert("통신실패");
			}
		});
	});

	alert('삭제가 완료 되었습니다.');
	location.reload();
}