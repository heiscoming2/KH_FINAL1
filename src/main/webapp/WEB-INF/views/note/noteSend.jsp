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
			window.close();
		</script>
	</body>
</html>