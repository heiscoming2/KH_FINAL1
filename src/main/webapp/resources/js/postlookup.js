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

//전체선택
function allcheck(checked) {
	var chk = document.getElementsByName("chk");
	for(var i=0; i<chk.length; i++) {
		chk[i].checked=checked;
	}
}

//선택 게시글 삭제
function muldel() {
	
	if(muldelConfirm()==false) {
		return false;
	}
	
	let chk = document.getElementsByName("chk");
	var muldelarr = [];
	for(let i=0; i<chk.length; i++) {
		if(chk[i].checked==true) {
			let tmp = {};
			tmp.bd_no = document.getElementsByName("bd_no")[i].value;
			tmp.bc_code = document.getElementsByName("bc_code")[i].value;
			muldelarr.push(tmp);
		}
	}
	
	$.ajax({
	    url : 'muldel.do',
	    contentType: 'application/json',
	    method : 'POST',
	    data : JSON.stringify(muldelarr),
	    success : function(i) {
	    	alert(i+'개의 게시글을 삭제하였습니다.');
	    	location.reload();
	    },
	    error : function (e) {
	    	alert('멀티 딜리트중 오류 발생');
	    	console.log(e);
	    }
	});
}

function muldelConfirm() {
	if($("#muldelform input:checked").length==0) {
		alert('삭제할 게시글이 선택되지 않았습니다.');
		return false;
	} else {
		return confirm('선택한 게시물을 삭제 하시겠습니까?');
	}	
}



