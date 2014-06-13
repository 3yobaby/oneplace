<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var category;
	function select_category(cat){
		category = $(cat).text();
		$.post('cafe/content_board.jsp',function(page){
			$('#contents').html(page);
		});
	}
	$(document).ready(function(){
		$.get('get_all_category.ajax', function(categories){
			var $c = $.parseJSON(categories);
			var $result = $('#category_result');
			$.each($c, function(index, category){
				$result.append('<p onclick="select_category(this)">'+category.name+'</p>');
			});
		});
	});
	function get_all_board(){
		$.get('get_all_board.ajax',function(result){ // result is category array. category is board array
			var $result = $.parseJSON(result);
			var $c = $('#contents');
			$c.text('');
			$.each($result, function(index, category){
				$c.append('<h2>'+category.name+'</h2>');
				$.each(category.boards, function(index, board){
					$c.append('<p>'+board.title+'</p>');
				})
			});
		});
	}
</script>
<div id="navigation_category">
<fieldset>
<legend>카테고리 목록</legend>
	<a href="javascript:get_all_board()">전체 글</a>
	<p>내가 쓴 글</p><hr>
	<br>
	<div id="category_result"></div>
</fieldset>
</div>