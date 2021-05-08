function login(){
		var m_id = $("#m_id").val().trim();
		var m_pw = $("#m_pw").val().trim();
		
		console.log(m_id+"/"+m_pw);
		
		var loginVal = {
				"m_id":m_id,
				"m_pw":m_pw
		};
		
		if(m_id == null || m_id =="" ||m_pw == null || m_pw == ""){
			alert("ID 및 PW를 확인해 주세요");
		}else{
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data:JSON.stringify(loginVal),
				contentType:"application/json",
				dataType:"json",
				success:function(msg){
					if(msg.check == true){
						location.href="main.do";
					}else{
						$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.");
					}
					
				},
				error:function(msg){
					alert("통신실패");
				}
			});
		}
	}