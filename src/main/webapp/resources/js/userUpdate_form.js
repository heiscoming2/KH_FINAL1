var code="";

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
    } else {                                            // 일치하지 않을 경우
        checkResult.html("인증번호를 다시 확인해주세요.");
        checkResult.attr("class", "incorrect");
    } 
    
    });
       
});

