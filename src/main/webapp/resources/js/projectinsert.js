  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#summernote').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });
  
var num = 0;
/*append 적용해보는 중*/
function add_div(){
if(num>5){
	alert("5개 이상 프로젝트는 추가가 불가능합니다");
	return;
}
num++;
var html = `
			<table id="project_table_${num}" class="project_inserttable">
            <tr>
              <th><span>* </span>제목</th>
              <td><input type=text class="form-control" name="bd_title" id="bd_title_${num}"></td>
            </tr>
            <tr>
            <th><span>* </span>설명 </th>
            <td><input type=text name="bd_content" id="bd_content_${num}"></td>
            </tr>
            
            <tr>
              <th><span>* </span>프로젝트 제목</th>
              <td><input type=text class="form-control" placeholder="프로젝트 제목을 입력해 주세요." name="pro_title" id="pro_title_${num}"></td>
            </tr>
            <tr>
              <th><span>* </span>프로젝트 기간</th>
              <td><input type='date' name="pro_start" id="pro_start_${num}"/> ~ <input type='date' name="pro_end"  id="pro_end_${num}"/></td>

            </tr>
            <tr>
              <th><span>* </span>프로젝트 파일</th>
              <td><input type="file" value="첨부 파일" name="pro_file" id="pro_file_${num}"></td>

          </tr>
            <tr>
              <th><span>* </span>프로젝트 링크(Git) </th>
              <td><input type="text" class="form-control" placeholder="ex) https://github.com/heiscoming2/KH_FINAL1" name="pro_link" id="pro_link_${num}"></td>
            </tr>
            <tr>
              <th><span>* </span>ERD 링크 </th>
              <td><input type="text" class="form-control" placeholder="ex) https://www.erdcloud.com/d/iKXvArFPz8qqZmiQD" name="pro_erd" id="pro_erd_${num}"></td>
            </tr>
            <tr>
              <th><span>* </span>개발 환경 </th>
              <td><input type="text" class="form-control" placeholder="ex) Java, HTML/CSS, API(지도, 결제) 등" name="pro_develop" id="pro_develop_${num}"></td>
            </tr>
            <tr>
              <th><span>* </span>개발 목표 </th>
              <td><input type="text" class="form-control" placeholder="개발 목표를 입력해 주세요." name="pro_goal" id="pro_goal_${num}"></td>
            </tr>
            <tr>
            <th><span>* </span>구현 기능 </th>
            <td><textarea  name="pro_function" id="pro_function_${num}"></textarea></td>
            </tr>
            </table>
            `;
            $("#project_insert").append(html);

	}
	
	/* 처음에 한 번 보여주기 */
	add_div();

function remove_div(){
	$("#project_table_"+num).remove();
	num--;

	}
	

function project_submit(){
	var projectinsertsubmits = [];
	for (let i=1; i<=num; i++){
		var projectinsertobj = {};
		projectinsertobj.bd_title = $("#bd_title_"+i).val();
		projectinsertobj.bd_content = $("#bd_content_"+i).val();
		projectinsertobj.pro_title = $("#pro_title_"+i).val();
		projectinsertobj.pro_start = $("#pro_start_"+i).val();
		projectinsertobj.pro_end = $("#pro_end_"+i).val();
		projectinsertobj.pro_link= $("#pro_link_"+i).val();
		projectinsertobj.pro_erd = $("#pro_erd_"+i).val();
		projectinsertobj.pro_develop = $("#pro_develop_"+i).val();
		projectinsertobj.pro_goal = $("#pro_goal_"+i).val();
		projectinsertobj.pro_function = $("#pro_function_"+i).val();
		projectinsertobj.m_no = $("#m_no").val();
		
		
		projectinsertsubmits.push(projectinsertobj);
	}
	console.log(projectinsertsubmits);
	var settings = {
	  "url": "projectinsert.do",
	  "method": "POST",
	  "headers": {
    		"Content-Type": "text/plain"
  		},
	  "data":JSON.stringify(projectinsertsubmits)
	};
	
	$.ajax(settings).done(function (response) {
	  console.log(response);
	  location.href="projectlist.do";
	});

}
	