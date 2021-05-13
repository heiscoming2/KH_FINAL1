function like_func(bd_no,m_no) {

	let likeno = { "bd_no": bd_no, "m_no": m_no};

	$.ajax({
		url: "like.do", 
		type: "POST", 
		contentType: "application/json",
		dataType: "json", 
		data: JSON.stringify(likeno), 
		success: 
			function(like_check){ 
            $('.heart').toggleClass("is-active");

			if(like_check ) {
 				alert("좋아요");
 				let likecnt = Number($('.likecnt').html());
 				$('.likecnt').html(likecnt+1);
 				
			} else {
 				alert("좋아요 취소")
  				let likecnt = Number($('.likecnt').html());
  				$('.likecnt').html(likecnt-1);			
			}
			
			}
	}); 


}
