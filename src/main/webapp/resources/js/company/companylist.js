$(function(){
	$('.study_wrap').remove();
	const img = "<div style='text-align:center;'>" +
			    "<img src='resources/images/companyimages/companylistsampleheader.png'/>" +
			    "<img src='resources/images/companyimages/companylistsampleone.png' style='position:relative; left:-17px; top:5px;' onclick='test()'/>" +
			    "<img src='resources/images/companyimages/companylistsamplecontent.png'/>" +
			    "</div>";
	$('.content').append(img);
});

function test() {
	location.href='companydetail.do'
}