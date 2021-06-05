// 이력서 삭제 버튼 (멀티 삭제 가능)
function resumeListDel() {
	const list = document.querySelectorAll('#table-list input[name=resumeListDel]');
	list.forEach(function (input) {
		const r_no = input.getAttribute('r_no');
		
		var formData = new FormData();
		formData.append("r_no", r_no);
	
		$.ajax({
			type : 'POST',
			url : 'resume_delete_ajax.do',
			data : formData,
			async: false, // ajax를 여러번 날릴 거라면, 반드시 여기서 async: false를 통해, 여러번 날리는게 다 끝나길 기다려주세요! -> Promise, async-await 가 있는데 이건 너무 어려움!
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