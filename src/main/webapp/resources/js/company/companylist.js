$(function(){
	$('.study_wrap').remove();
	const img = "<div style='text-align:center;'>" +
			    "<img src='resources/images/companyimages/companylistsampleheader.png' style='cursor:pointer;'/>" +
			    "<img src='resources/images/companyimages/companylistsampleone.png' style='position:relative; left:-17px; top:5px; cursor:pointer;' onclick='test()' />" +
			    "<img src='resources/images/companyimages/companylistsamplecontent.png' style='cursor:pointer;'/>" +
			    "</div>";
	$('.content').append(img);
});

function test() {
	location.href='companydetail.do'
}