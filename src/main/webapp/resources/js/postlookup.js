function selectPage(i) {
	const m_no = $('#session_mno').val();
	const category = $('#category').val();
	location.href='postlookup.do?page='+i+'&m_no='+m_no+'&category='+category;
}


$(function(){
	const category = $('#category').val();
	$('.cate'+category).css('font-weight','bold').css('font-size','18px');
});


function selectCate(category) {
	const m_no = $('#session_mno').val();
	location.href='postlookup.do?m_no='+m_no+'&category='+category;
}