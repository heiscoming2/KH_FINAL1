$('document').ready(function() {
	
	
	 var area0 = ["시/도 선택","서울","인천","경기","광주","대구","울산","부산","대전","강원","충북","충남","전북","전남","경북","경남","제주","세종"];
	  var area1 = ["전체","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
	   var area2 = ["전체","계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
	   var area3 = ["전체","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
	   var area4 = ["전체","광산구","남구","동구","북구","서구"];
	   var area5 = ["전체","남구","달서구","동구","북구","서구","수성구","중구","달성군"];
	   var area6 = ["전체","남구","동구","북구","중구","울주군"];
	   var area7 = ["전체","강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
	   var area8 = ["전체","대덕구","동구","서구","유성구","중구"];
	   var area9 = ["전체","강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
	   var area10 = ["전체","제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
	   var area11 = ["전체","계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
	   var area12 = ["전체","군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
	   var area13 = ["전체","광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
	   var area14 = ["전체","경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
	   var area15 = ["전체","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
	   var area16 = ["전체","서귀포시","제주시","남제주군","북제주군"];
	   var area17 = ["세종특별자치시"]
	   
	 // 시/도 선택 박스 초기화
	 $("select[name^=sido]").each(function() {
	  $selsido = $(this);
	  $.each(eval(area0), function() {
	   $selsido.append("<option value='"+this+"'>"+this+"</option>");
	  });
	  $selsido.next().append("<option value=''>구/군 선택</option>");
	 });

	 // 시/도 선택시 구/군 설정
	 $("select[name^=sido]").change(function() {
	  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
	  var $gugun = $(this).next(); // 선택영역 군구 객체
	  $("option",$gugun).remove(); // 구군 초기화

	  if(area == "area0")
	   $gugun.append("<option value=''>구/군 선택</option>");
	  else {
	   $.each(eval(area), function() {
	    $gugun.append("<option value='"+this+"'>"+this+"</option>");
	   });
	  }
	 });
});

function filter_toggle() {
    $(".filter_innerwrap").toggle();
}

function openDetailUrl(url) {
	var _width = '1300';
	var _height = '1000';
	var _left = Math.ceil(( window.screen.width - _width )/2);
	window.open(url,'','width='+_width+',left='+_left+',height='+_height);
}

function selectPage(i) {
	
	var $sidoselect = $('.sidoselect').val();
	var $gugunselect = $('.gugunselect').val();
	var $careerselect = $('.careerselect').val();
	var $eduselect = $('.eduselect').val();
	var $cc_search = $('.cc_search').val();
	
	if(($sidoselect==null || $sidoselect=="" || $sidoselect=="시/도 선택") &&
	   ($gugunselect==null || $gugunselect=="") && 
	   ($careerselect==null || $careerselect=="" || $careerselect=="undefined" || $careerselect=="전체") &&
	   ($eduselect==null || $eduselect=="" || $eduselect=="undefined" || $careerselect=="전체")) {
		location.href='companycrawlinglist.do?page='+i;
	} else {
		location.href='companycrawlinglistandsearch.do?page='+i+'&src_a1='+$sidoselect+'&src_a2='+$gugunselect+'&src_cer='+$careerselect+'&src_edu='+$eduselect+'&src_key='+$cc_search;
		//location.href='companycrawlinglist.do?page='+i;
	}
}

