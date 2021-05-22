
/* 신고 insert popup*/

	function reportInsert(bd_no){
		window.open("reportinsertform.do?bd_no="+bd_no, "신고등록", "width=400, height=300, left=100, top50")
	
	}

var settings = {
  "url": "http://localhost:8787/upgrade/category",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Cookie": "JSESSIONID=D0EC57FF9DF14AE65ED74C3C6239D8A2"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
  var cate = JSON.parse(response);
	$("#title").text(data.bd_title);
	$("#catename").text(cate.find(item=>item.code==data.bc_code).name);
});
var data;
function setData(dto){
	data = JSON.parse(dto);
}

 