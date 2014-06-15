<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
	#content_board table {
		
	}
	#content_board #search_form{
		display: inline;
	}
</style>
<div id="content_board">
<script>
	var $board;
	$('#content_board_category_title').html(category);
	$(document).ready(function(){
		set_board($boards);
	});
	function set_board($val){
		$tbody = $('#content_board tbody');
		$tbody.html('');
		$.each($val, function(index, board){
			var $td = "<td>"+board.pk+"</td>";
			$td += "<td><p onclick='show_content(this)'>"+board.title+"</p></td>"
			$td += "<td>"+board.name+"</td>"
			$td += "<td>"+board.id+"</td>"
			$td += "<td>"+board.created+"</td>"
			$td += "<td>"+board.replies+"</td>"
			$('<tr>').appendTo($tbody).append($td);
		});
	}
	
	function show_content(val){
		$.each($boards, function(index, board){
			if(board.title == $(val).text()){
				$board = $(board);
				$('#board_detail').html('');
				$('#board_detail').append('<hr>');
				$('#board_detail').append(board.content);
				$('#board_detail').append('<hr><br>');
				$('#board_detail').append('<input type="button" value="답글 달기" onclick="write_content()"/>');
				$('#board_detail').append('<br>');
			}
		});
	}
	
	function write_content(){
		$.get('cafe/write_form.jsp', function(page){
			$('#write_form').html(page);
		});
	}
	
	function search_content(type, value){
		if(type == 'title'){
			$.post('get_category_board.ajax', {'category_name':category, 'string':value, 'type':type}, function(result){
				set_board(result);
			});
		}else if(type == 'id'){
			$.post('get_category_board.ajax?type=id', {'category_name':category, 'string':value, 'type':type}, function(result){
				set_board(result);
			});
		}else if(type == 'name'){
			$.post('get_category_board.ajax?type=name', {'category_name':category, 'string':value, 'type':type}, function(result){
				set_board(result);
			});
		}
		return false;
	}
</script>
<h2 id="content_board_category_title"></h2>
	<div id="write_form"></div>
	<div id="board_detail"></div>
	<table border="1">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>아이디</th>
				<th>날짜</th>
				<th>답글</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<select id="search_select">
		<option value="title">제목</option>
		<option value="id">아이디</option>
		<option value="name">이름</option>
	</select>
	<form id="search_form" onsubmit="return search_content(search_select.value, search_word.value)" >
		<input id="search_word" type="search" placeholder="검색"/>
		<input type="submit" value="검색"/>
	</form>
	<button onclick="write_content()">글쓰기</button>
</div>