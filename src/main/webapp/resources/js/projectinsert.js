  /* 썸머노트 jqeury*/
  $(document).ready(function() {
    $('#summernote').summernote({
      placeholder: '댓글을 작성해주세요.',
      height:150
    });
  });
  

/*appendChild 적용해보는 중*/
function add_div(){
    var div = document.createElement('div');


    div.innerHTML = document.getElementById('project_appendchild').innerHTML;
    document.getElementById('project_field').appendChild(div);

	}

function remove_div(obj){
	document.getElementById('project_field').removeChild(obj.parentNode);

	}
	