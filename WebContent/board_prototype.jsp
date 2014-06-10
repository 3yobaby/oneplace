<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
	$.get('board.data', function(result){
		alert(result);
		$('div').html(result);
	});
</script>
</head>
<body>
<div>

</div>
</body>
</html>