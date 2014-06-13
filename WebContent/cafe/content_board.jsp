<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		$('#content_board_category_title').html('카테고리 : ' + category);
	});
	$.post('get_category_board.ajax', {'category_name':category}, function(result){
		$result = $.parseJSON(result);
		$thead = $('#content_board thead');
		$tbody = $('#content_board tbody');
		$.each($result, function(index, board){
			var $td = "<td>"+board.pk+"</td>";
			$td += "<td><p onclick='show_content(this)'>"+board.title+"</p></td>"
			$td += "<td>"+board.created+"</td>"
			$td += "<td>"+board.replies+"</td>"
			$('<tr>').appendTo($tbody).append($td);
			$td = "<td colspan='4' class='hide'>"+board.content+"</td>";
			$('<tr>').appendTo($tbody).append($td);
		});
	});
	function show_content(val){
		$(val).parent().parent().next().children().toggleClass('hide');
	}
	
	function write_content(){
		$.get('cafe/write_form.jsp', function(page){
			$('#write_form').html(page);
		});
	}
</script>
<style>
	$content_board table {
		
	}
</style>
<h2 id="content_board_category_title"></h2>
<div id="write_form"></div>
<div id="content_board">
	<table border="1">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>날짜</th>
				<th>답글</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<button onclick="write_content()">글쓰기</button>
</div>