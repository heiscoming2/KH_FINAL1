

/*아이디 중복검사*/
$(".id_input").on("propertychange change keyup paste input", function(){

	var m_id = $(".id_input").val();			
	var data = {m_id : m_id}				
	
	$.ajax({
		type : "POST",
		url : "memberIdChk.do",
		data : data,
		success:function(res){
			if(res != 'fail'){
				$(".id_input_re1").css("display","inline-block");
				$(".id_input_re2").css("display","none");
			} else {
				$(".id_input_re2").css("display","inline-block");
				$(".id_input_re1").css("display","none");
			}
		}
	});

});


var regnoCheck = false;

/*사업자번호 중복검사*/
$(".regno_input").on("propertychange change keyup paste input", function(){

	var m_regno = $(".regno_input").val();			
	var data = {m_regno : m_regno}		
	
	$.ajax({
		type : "POST",
		url : "memberRegnoChk.do",
		data : data,
		success:function(res){
			if(res != 'fail'){
				$(".regno_input_re1").css("display","inline-block");
				$(".regno_input_re2").css("display","none");
				regnoCheck = true;
			} else {
				$(".regno_input_re2").css("display","inline-block");
				$(".regno_input_re1").css("display","none");
				regnoCheck = false;
			}
		}
	});

});



/*사업자번호 유효성 검사*/
$(document).ready(function(){
	$(".joinButton").click(function(){
		if(regnoCheck){
		$("#joinBizForm").attr("action","join_biz.do");
		$("#joinBizForm").submit();
	}
	
	});

});

