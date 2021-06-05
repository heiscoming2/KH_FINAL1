/*이미지 업로드*/
$(function(){
 
    $('#uploadBtn').on('click', function(){
        uploadFile();
    });
 
});

let r_no = 0;

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
        	const resumeInsertForm = document.getElementById('resumeInsertForm');
        	resumeInsertForm.r_img_no.value = data;
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

/*============================================================*/

/*이력서 데이터 전송*/
$(document).ready(function(){
	$("#resumeInsertBtn").click(function(){
		// $("#resumeInsertForm").attr("action","resume_insert.do");
		// $("#resumeInsertForm").submit();
		
		var form = $('#resumeInsertForm')[0];
	    var formData = new FormData(form);
    
 
	    $.ajax({
	    	type : 'POST',
	        url : 'resume_insert.do',
	        data : formData,
	        contentType : false,
	        processData : false,
	        success:function(data){
	        	r_no = data;
	        	alert("이력서 기본 정보 INSERT 성공"); // 여기서는 1-a: insert만 한다-> 수정시에는 1-a:insert가 아니라 update가 되어 햔다
	        	// 이제, r_no가 확보되었으니
	        	
				// 3. 학력사항 목록 insert를 ajax로 하면서, r_no를 사용하고,
				educationInsertList();

	        	// 4. 자격사항 목록 insert를 ajax로 하면서, r_no를 사용하고,
				licenseInsertList();

	        	// 5. 교욱 및 사회경험 insert를 ajax로 하면서, r_no를 사용하고,
				careerInsertList();

	        	// -> 다 끝나면, 이 페이지에서 쫓아내야 한다 -> 왜냐면, 여기서는 방금 작성한 이력서를 수정 못 하기 떔ㄴ이다
				alert('다 됨!');
				location.href = '/upgrade/resume_list.do';
	        },
	        error:function(msg){
	        	alert("통신실패");
			}        
	    
	    })	
	});
	
});


function getFormData(tr) {
	var formData = new FormData();

	const list = tr.querySelectorAll('input, select');
	list.forEach(function (item) {
		const name = item.getAttribute('name');
		const value = item.value; // <input />도, <select />도, value로 값을 가져올 수 있다.
		// console.log({name, value});
		formData.append(name, value); 
	});

	return formData;
}

// 학력사항 목록 저장
function educationInsertList() {
	const list = document.querySelectorAll('#EdFormTable tbody tr.data-insert');
	for (let i = 0; i < list.length; i++) {
		const tr = list[i];
		educationInsert(tr);
	}	
}

function educationInsert(tr) {
	var formData = getFormData(tr);
 
    $.ajax({
    	type : 'POST',
        url : 'educationInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			// alert("학력사항 하나 저장 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    })
}

// 이력서 학력사항 정보 삭제
function educationDelete(buttonObj) {
	const td = buttonObj.parentElement;
	const tr = td.parentElement;
	var formData = getFormData(tr);
	// const input = tr.querySelector('input[name=ed_no]');
	// const ed_no = input.value;
	
	// var formData = new FormData();
	// formData.append("ed_no", ed_no);
 
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
	// const input = tr.querySelector('input[name=ed_no]');
	// const ed_no = input.value;
	
	// var formData = new FormData();
	// formData.append("ed_no", ed_no);
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
			alert("수정 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}



// 자격사항 저장
function licenseInsertList() {
	const list = document.querySelectorAll('#LiFormTable tbody tr.data-insert');
	for (let i = 0; i < list.length; i++) {
		const tr = list[i];
		licenseInsert(tr);
	}	
}

function licenseInsert(tr) {
	// console.log({tr});

	var formData = new FormData();

	const list = tr.querySelectorAll('input, select');
	list.forEach(function (item) {
		const name = item.getAttribute('name');
		const value = item.value; // <input />도, <select />도, value로 값을 가져올 수 있다.
		// console.log({name, value});
		formData.append(name, value); 
	});
 
    $.ajax({
    	type : 'POST',
        url : 'licenseInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			// alert("저장 성공");
        },
        error:function(msg){
        	// alert("통신실패");
		}
    });
}

// 교육 및 사회경험 저장
function careerInsertList() {
	const list = document.querySelectorAll('#CaFormTable tbody tr.data-insert');
	for (let i = 0; i < list.length; i++) {
		const tr = list[i];
		careerInsert(tr);
	}	
}

function careerInsert(tr) {
	// console.log({tr});

	var formData = new FormData();

	const list = tr.querySelectorAll('input, select');
	list.forEach(function (item) {
		const name = item.getAttribute('name');
		const value = item.value; // <input />도, <select />도, value로 값을 가져올 수 있다.
		// console.log({name, value});
		formData.append(name, value); 
	});
 
    $.ajax({
    	type : 'POST',
        url : 'careerInsert.do',
        data : formData,
		async: false,
        contentType : false,
        processData : false,
        success:function(data){
			// alert("저장 성공");
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
    	alert("최대 5개까지만 가능합니다.");
        return;
    }

    //행추가
    $("#EdFormTable").append(
    '<tr class="data-insert">'+
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
    			'<option value="재학">재학</option>'+
    		'</select>'+
    	'</td>'+
		'<td></td>'+
		'<td></td>'+
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
    // '<tr id=liaddtr'+ count + '>'+
    // 	'<td><input type="date" class="form-control" name="li_date" ></td>'+
    //     '<td><input type="text" class="form-control" name="li_title" ></td>'+
    //     '<td><input type="text" class="form-control" name="li_organ" ></td>'+
    // '</tr>'
	'<tr class="data-insert">'+                 
	'	<td><input type="text" class="form-control" name="li_title" ></td>'+
	'	<td><input type="date" class="form-control" name="li_date" placeholder="ex) 2010년 03월 - 2013년 02월"></td>'+
	'	<td><input type="text" class="form-control" name="li_organ" ></td>'+
	'	<td></td>'+
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
    	alert("최대 5개까지만 가능합니다.");
        return;
    }

    //행추가
    $("#CaFormTable").append(
    	// '<tr id=caAddtr'+ count + '>'+
    	// 	'<td><input type="text" class="form-control" id="ed_date" ></td>'+
    	// 	'<td><input type="date" class="form-control" id="ed_school" ></td>'+
    	// 	'<td><input type="date" class="form-control" id="ed_graduation" ></td>'+
    	// 	'<td><input type="text" class="form-control" id="ed_graduation" ></td>'+
    	// '</tr>'
		'<tr>' +
		'	<td><input type="text" class="form-control" name="ca_title" ></td>' +
		'	<td><input type="date" class="form-control" name="ca_start_date" ></td>' +
		'	<td><input type="date" class="form-control" name="ca_end_date" ></td>' +
		'	<td><input type="text" class="form-control" name="ca_content" ></td>' +
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

