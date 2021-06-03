function statusChange(r_no,bd_no,ca_status) {
	
	let bool = false;
	if(ca_status=='Y') {
		bool = confirm('합격 처리 하시겠습니까?');
	} else {
		bool = confirm('불합격 처리 하시겠습니까?');
	}
	if(bool) {
		$.ajax({
			 type:"post",
			 url:"companyapplicationstatuschange.do?r_no="+r_no+"&bd_no="+bd_no+"&ca_status="+ca_status,
			 success:function(bool) {
				 if(bool) {
					 location.reload();
				 } else {
					 alert('알 수 없는 오류입니다. 관리자에게 문의하세요.');
				 }
			 },
			 error:function(e) {
				 alert('오류 발생');
				 console.log('오류정보'+e);
			 }
		});
	}
}