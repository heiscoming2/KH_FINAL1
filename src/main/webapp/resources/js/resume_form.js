/*이미지 업로드*/
$(function(){
 
    $('#uploadBtn').on('click', function(){
        uploadFile();
    });
 
});
 
function uploadFile(){
    
	    var form = $('#profileUpload')[0];
	    var formData = new FormData(form);
    
 
    $.ajax({
    	type : 'POST',
        url : 'profileUpload.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
        	alert("이미지 업로드 성공");
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    })
}

/*개인 회원 회원정보 수정 전송*/
$(document).ready(function(){
	$("#updateUser").click(function(){
		$("#updateForm").attr("action","user_update.do");
		$("#updateForm").submit();	
	});
	
});

/*============================================================*/
/*학력사항 추가*/

$(function () {
	//행개수
 	var count = 0;
	//최대 행개수
	var full_count = 3;
	//추가 버튼 클릭시
	$('#addBtn').click(function () {
	//행추가할때마다 행개수 +1
    ++count;

    //최대 행개수보다 크면 리턴
    if (count > full_count) {
    	alert("최대 5개까지만 가능합니다.");
        return;
    }

    //행추가
    $("#EdFormTable").append(
    '<tr id=addtr'+ count + '>'+
    	'<td><input type="month" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>'+
    	'<td><input type="text" class="form-control" id="ed_school" ></td>'+
    	'<td><input type="text" class="form-control" id="ed_graduation" ></td>'+
    	'<td>'+
    		'<select class="form-select">'+
    			'<option value="1">대학원</option>'+
    			'<option value="2">대학교</option>'+
    			'<option value="3">고등학교</option>'+
    		'</select>'+
    	'</td>'+
    	'<td>'+
    		'<select class="form-select">'+
    			'<option value="1">졸업</option>'+
    			'<option value="2">휴학</option>'+
    			'<option value="3">중퇴</option>'+
    			'<option value="4">재학</option>'+
    		'</select>'+
    	'</td>'+
    '</tr>');
          
});

//삭제 버튼 클릭시
$('#delBtn').click(function () {
//행이 하나밖에 없으면 삭제하지 않기
if (count < 1) {
	alert("더이상 삭제할수 없습니다");
	return;
}
//마지막 라인 삭제
$('#addtr' + count).remove();

	//삭제할때마다 행개수 -1
	count--;
	});

});

/*============================================================*/
/*자격 사항 추가*/

$(function () {
	//행개수
 	var count = 0;
	//최대 행개수
	var full_count = 3;
	//추가 버튼 클릭시
	$('#liaddBtn').click(function () {
	//행추가할때마다 행개수 +1
    ++count;

    //최대 행개수보다 크면 리턴
    if (count > full_count) {
    	alert("최대 5개까지만 가능합니다.");
        return;
    }

    //행추가
    $("#LiFormTable").append(
    '<tr id=liaddtr'+ count + '>'+
    	'<td><input type="month" class="form-control" id="ed_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>'+
        '<td><input type="text" class="form-control" id="ed_school" ></td>'+
        '<td><input type="text" class="form-control" id="ed_graduation" ></td>'+
    '</tr>');
          
});

//삭제 버튼 클릭시
$('#lidelBtn').click(function () {
//행이 하나밖에 없으면 삭제하지 않기
if (count < 1) {
	alert("더이상 삭제할수 없습니다");
	return;
}
//마지막 라인 삭제
$('#liaddtr' + count).remove();

	//삭제할때마다 행개수 -1
	count--;
	});

});

/*============================================================*/
/*교육/경험 사항 추가*/

$(function () {
	//행개수
 	var count = 0;
	//최대 행개수
	var full_count = 3;
	//추가 버튼 클릭시
	$('#caAddBtn').click(function () {
	//행추가할때마다 행개수 +1
    ++count;

    //최대 행개수보다 크면 리턴
    if (count > full_count) {
    	alert("최대 5개까지만 가능합니다.");
        return;
    }

    //행추가
    $("#CaFormTable").append(
    	'<tr id=caAddtr'+ count + '>'+
    		'<td><input type="text" class="form-control" id="ed_date" ></td>'+
    		'<td><input type="date" class="form-control" id="ed_school" ></td>'+
    		'<td><input type="date" class="form-control" id="ed_graduation" ></td>'+
    		'<td><input type="text" class="form-control" id="ed_graduation" ></td>'+
    	'</tr>');
          
});

//삭제 버튼 클릭시
$('#caDelBtn').click(function () {
//행이 하나밖에 없으면 삭제하지 않기
if (count < 1) {
	alert("더이상 삭제할수 없습니다");
	return;
}
//마지막 라인 삭제
$('#caAddtr' + count).remove();

	//삭제할때마다 행개수 -1
	count--;
	});

});

