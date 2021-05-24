
function selectPage(i) {
	location.href='projectlist.do?page='+i
}



$(function(){
	if(document.getElementById("h_a1")) {

		//최신순
		let h_a1 = $('#h_a1').val();
		
		$('.howAsc').val($('#h_a1').val());
		
		//지역1의 selected idx 값을 받아온다.
		let howAscidx = $('.howAsc option').index($('.howAsc option:selected'));
		
		//추천순
		if(h_a2=='') {
			$('.gugunselect option:eq(0)').prop("selected",true);
		} else {
			$('.gugunselect').val(h_a2);
		}
		
		
		
		//필터를 일단 펼쳐준다.
		loc_filter();
		
	}
});