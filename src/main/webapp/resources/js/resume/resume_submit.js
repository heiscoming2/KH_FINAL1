function NoMultiChk(chk) { 
	var obj = document.getElementsByName("resumechkbox"); 
	for(var i=0; i<obj.length; i++) { 
		if(obj[i] != chk) { 
			obj[i].checked = false; 
		} 
	} 
}

function resume_submit() {
	const bool = resume_chk();
	if(bool) {
		const c = confirm('선택한 이력서를 제출하시겠습니까?');
		if(c) {
			let obj = document.getElementsByName("resumechkbox"); 
			let bd_no = document.getElementById("bd_no").value;
			for(let i=0; i<obj.length; i++) { 
				if(obj[i].checked) { 
					location.href='resumesubmit.do?r_no='+obj[i].value+'&bd_no='+bd_no;
				} 
			}
		}
	}
}

function resume_chk() {
	var obj = document.getElementsByName("resumechkbox"); 
	let tmp = 0;
	for(var i=0; i<obj.length; i++) { 
		if(obj[i].checked) { 
			tmp++;
		} 
	} 
	if(tmp==0) {
		alert('제출할 이력서를 선택해 주세요.');
		return false;
	} else {
		return true;
	}
}