<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
	var temp;
	$.get('cafelist.data', function(result){
		result = $.parseJSON(result);
		$.each(result, function(index, val){
			var text = "";
			for(key in val){
				text += key + ":";
				text += val[key];
				text += "<br>";
			}
			$('#cafelist').html($('#cafelist').html() + text + "<hr>");
		})
	})
	$.get('memberlist.data', function(result){
		result = $.parseJSON(result);
		$.each(result, function(index, val){
			var text = "";
			for(key in val){
				text += key + ":";
				text += val[key];
				text += "<br>";
			}
			$('#memberlist').html($('#memberlist').html()+text+"<hr>");
		})
	})
</script>
</head>
<body>
	<div id="cafelist">
	<h1>카페 리스트</h1>
	</div><hr>
	<div id="memberlist">
	<h1>멤버 리스트</h1>
	</div>
</body>
</html>