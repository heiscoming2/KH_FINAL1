function selectPage(i) {
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
	const m_no = $('#keyword').val();
	location.href='postlookup.do?m_no='+m_no+'&category='+category;
}