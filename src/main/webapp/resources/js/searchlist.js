function selectPage(i) {
	const category = $('#category').val();
	const keyword = $('#keyword').val();
	location.href='searchlist.do?keyword='+keyword+'&category='+category+'&page='+i;
}


$(function(){
	const category = $('#category').val();
	$('.cate'+category).css('font-weight','bold').css('font-size','18px');
});


function selectCate(category) {
	const keyword = $('#keyword').val();
	location.href='searchlist.do?keyword='+keyword+'&category='+category;
}