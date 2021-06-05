<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<script type="text/javascript">
			const message = '${message}';
			if (message > '') {
				alert(message);				
			}
			
			alert("쪽지 전송이 완료 되었습니다");
			/* opener.location.href="note_sendlist.do"; *///쪽지 보내고 보낸 쪽지로 이동
			window.close();
		</script>
	</body>
</html>