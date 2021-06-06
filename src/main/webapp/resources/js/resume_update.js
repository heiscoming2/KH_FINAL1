function uploadFile(){
	    
	var formData = new FormData();
	formData.append('r_img', $('#input_r_img')[0].files[0]); 
    
 
    $.ajax({
    	type : 'POST',
        url : 'resumeProfile.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
        	const resumeUpdateForm = document.getElementById('resumeUpdateForm');
        	resumeUpdateForm.r_img_no.value = data;
        	alert("이미지 업로드 성공");
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    })
}

/*이미지 미리보기*/
function readURL(input) {
 if (input.files && input.files[0]) {
  var reader = new FileReader();
  
  reader.onload = function (e) {
   $('#image_section').attr('src', e.target.result);  
  }
  
  reader.readAsDataURL(input.files[0]);
  }
}
 
$("#input_r_img").change(function(){
   readURL(this);
});


function resumeUpdateAjax(formObj) {
	var formData = new FormData();
	formData.append('r_detailAddress', formObj.r_detailAddress.value);
	formData.append('r_extraAddress', formObj.r_extraAddress.value);
	formData.append('r_img_no', formObj.r_img_no.value);
	formData.append('r_jibunAddress', formObj.r_jibunAddress.value);
	formData.append('r_no', formObj.r_no.value);
	formData.append('r_portfolio', formObj.r_portfolio.value);
	formData.append('r_postcode', formObj.r_postcode.value);
	formData.append('r_roadAddress', formObj.r_roadAddress.value);
	formData.append('r_selfletter', formObj.r_selfletter.value);
 
    $.ajax({
    	type : 'POST',
        url : 'resume_update_ajax.do',
        data : formData,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
        	alert('이력서 수정이 완료되었습니다.');
        	location.href = '/upgrade/resume_list.do';
        },
        error:function(msg){
        	alert("통신실패");
		}        
    
    });
}





/*==============학력, 경력, 경험 리스트(목록) 수정삭제==============*/
// tr을 formdata로 만들어줌
function getFormData(tr) {
	var formData = new FormData();

	const list = tr.querySelectorAll('input, select');
	list.forEach(function (item) {
		const name = item.getAttribute('name');
		const value = item.value; 			// <input />도, <select />도, value로 값을 가져올 수 있다.
		// console.log({name, value});
		formData.append(name, value); 
	});

	return formData;
}


// 이력서 학력사항 목록 저장
function educationInsert(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'educationInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("등록 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}


// 이력서 학력사항 정보 삭제
function educationDelete(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	var formData = getFormData(tr);
	 
    $.ajax({
    	type : 'POST',
        url : 'educationDelete.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			tr.remove();
			alert("삭제 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}

// 이력서 학력사항 정보 수정
function educationUpdate(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'educationUpdate.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("등록 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}

// 자격사항 목록 저장
function licenceInsert(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'licenceInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("등록 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}


// 이력서 자격사항 정보 삭제
function licenceDelete(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'licenceDelete.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			tr.remove();
			alert("삭제 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}


// 이력서 자격사항 정보 수정
function licenceUpdate(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'licenceUpdate.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("수정 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}



// 이력서 경험사항 목록 저장
function careerInsert(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'careerInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("등록 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}

// 이력서 경험사항 목록 정보 삭제
function careerDelete(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'careerDelete.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			tr.remove();
			alert("삭제 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}

// 이력서 경험사항 목록  정보 수정
function careerUpdate(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'careerUpdate.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			console.log({data});
			alert("수정 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}


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
    	alert("최대 추가개수 초과");
        return;
    }

    //행추가
    $("#EdFormTable").append(
    '<tr class="data-insert" id=addtr'+ count +'>'+
    	'<td><input type="month" class="form-control" name="ed_startdate"></td>'+
    	'<td><input type="month" class="form-control" name="ed_gradudate"></td>'+
    	'<td><input type="text" class="form-control" name="ed_schoolName" ></td>'+
    	'<td><input type="text" class="form-control" name="ed_major" ></td>'+
    	'<td>'+
    		'<select name="ed_school" class="form-select">'+
    			'<option value="대학원">대학원</option>'+
    			'<option value="대학교">대학교</option>'+
    			'<option value="고등학교">고등학교</option>'+
    		'</select>'+
    	'</td>'+

    	'<td>'+
    		'<select name="ed_graduation"  class="form-select">'+
    			'<option value="졸업">졸업</option>'+
    			'<option value="휴학">휴학</option>'+
    			'<option value="중퇴">중퇴</option>'+
    			'<option value="졸업예정">졸업예정</option>'+
    		'</select>'+
    	'</td>'+
		'<td><input class="btn btn-outline-dark btn-sm" type="button" value="추가" onclick="educationInsert(this);" /></td>'+
		'<td></td>'+
    '</tr>');
          
});

//삭제 버튼 클릭시
$('#delBtn').click(function () {
//행이 하나밖에 없으면 삭제하지 않기
if (count < 1) {
	alert("최대 추가개수 초과");
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
    	alert("최대 추가개수 초과");
        return;
    }

    //행추가
    $("#LiFormTable").append(    
	'<tr class="data-insert" id=liaddtr'+ count +'>'+                 
	'	<td><input type="text" class="form-control" name="li_title" ></td>'+
	'	<td><input type="date" class="form-control" name="li_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>'+
	'	<td><input type="text" class="form-control" name="li_organ" ></td>'+
	'	<td><input class="btn btn-outline-dark btn-sm" type="button" value="추가" onclick="licenceInsert(this);"/></td>'+
	'	<td></td>'+
	'</tr>'
	);
          
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
    	alert("최대 추가개수 초과");
        return;
    }

    //행추가
    $("#CaFormTable").append(    	
		'<tr class="data-insert" id=caAddtr'+ count +'>' +
		'	<td><input type="text" class="form-control" name="ca_title" ></td>' +
		'	<td><input type="date" class="form-control" name="ca_start_date" ></td>' +
		'	<td><input type="date" class="form-control" name="ca_end_date" ></td>' +
		'	<td><input type="text" class="form-control" name="ca_content" ></td>' +
		'	<td><input class="btn btn-outline-dark btn-sm" type="button" value="추가" onclick="careerInsert(this);" /></td>'+
		'	<td></td>'+
		'</tr>'
	);
          
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
