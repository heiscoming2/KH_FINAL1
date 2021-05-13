var code="";
var mailnumCheck = false;//이메일 인증번호 확인

/*아이디 중복검사*/
$(".id_input").on("propertychange change keyup paste input", function(){

	var m_id = $(".id_input").val();			// .id_input에 입력되는 값
	var data = {m_id : m_id}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
	
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

/*이메일 중복 확인*/
$(".mail_input").on("propertychange change keyup paste input", function(){

	var m_email = $(".mail_input").val();
	var data = {m_email : m_email}				
	
	$.ajax({
		type : "POST",
		url : "memberEmailChk.do",
		data : data,
		success:function(res){
			if(res != 'fail'){
				$(".email_input_re1").css("display","inline-block");
				$(".email_input_re2").css("display","none");
			} else {
				$(".email_input_re2").css("display","inline-block");
				$(".email_input_re1").css("display","none");
			}
		}
	});

});

/* 인증번호 이메일 전송 */
$(".mail_check_button").click(function(){
     var email = $(".mail_input").val();        // 입력한 이메일     
    
    $.ajax({        
        type:"GET",
        url:"mailCheck?email=" + email,
        success:function(data){
        	code = data; //전달받은 인증번호를 code에 저장
        }
                
    });
});

/*인증번호 일치 불일치 확인*/
$(".mail_check_input").blur(function(){
	var inputCode = $(".mail_check_input").val(); //비교 코드
	var checkResult = $(".mail_check_input_box_wran"); //비교 결과
    
    $(".mail_check_input").blur(function(){
    
    var inputCode = $(".mail_check_input").val();        // 입력코드    
    var checkResult = $(".mail_check_input_box_warn");    // 비교 결과     
    
    if(inputCode == code){                            // 일치할 경우
        checkResult.html("인증번호가 일치합니다.");
        checkResult.attr("class", "correct"); 
        mailnumCheck = true;       					//인증번호 유효성
    } else {                                            // 일치하지 않을 경우
        checkResult.html("인증번호를 다시 확인해주세요.");
        checkResult.attr("class", "incorrect");
        mailnumCheck = false;  
    } 
    
    });
       
});

/*이메일 인증번호 유효성 검사*/
$(document).ready(function(){
	$(".joinButton").click(function(){
		if(mailnumCheck){
		$("#joinForm").attr("action","join_user.do");
		$("#joinForm").submit();
	}
	
	});

});

