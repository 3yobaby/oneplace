<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
	$.get('board.data', function(result){
		$result = $.parseJSON(result);
		var $header = $('<tr>');
		var $content = $('tbody');
		for(key in $result[0]){
			$header.append('<th>'+key+'</th>');
		}
		$('<thead>').appendTo($('table')).append($header);
		// body
		$.each($result, function (index, board){
			var $tr = $('<tr>');
			for(key in board){
				$tr.append('<td>'+board[key]+'</td>');
			}
			$content.append($tr);
		});
		
	});
</script>
</head>
<body>
<div>
<table border='1'>
	<tbody></tbody>
</table>
</div>
</body>
</html>