<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="navigation_category">
<script>
	var $categories;
	var $boards;
	var $board;
	$(document).ready(function(){
		$.get('get_all_category.ajax', function(categories){
			$categories = $.parseJSON(categories);
			var $result = $('#category_result');
			$.each($categories, function(index, category){
				$result.append('<p onclick="select_category(this)">'+category.name+'</p>');
			});
		});
	});
	
	function select_category(cat){
		category = $(cat).text();
		$.post('get_board.ajax',{'category':category},function(result){
			$boards = $.parseJSON(result);
			$.get('cafe/content_board.jsp', function(page){
				$('#contents').html(page);
			});
		});
	}
	
	function navigation_category_all_board(){
		$.get('get_all_board.ajax',function(result){
			category = "전체 글";
			$boards = $.parseJSON(result);
			$.get('get_all_board.ajax',function(result){
				$boards = $.parseJSON(result);
				$.get('cafe/content_board.jsp', function(page){
					$('#contents').html(page);
				});
			});
		});
	}
	function navigation_category_my_board(){
		$.get('get_all_my_board.ajax', function(result){
			category = "내가 쓴 글";
			$boards = $.parseJSON(result);
			$.get('cafe/content_board.jsp', function(page){
				$('#contents').html(page);
			});
		});
	}
</script>
<fieldset>
<legend>카테고리 목록</legend>
	<p onclick="navigation_category_all_board()">전체 글</p>
	<p onclick="navigation_category_my_board()">내가 쓴 글</p>
	<br>
	<div id="category_result"></div>
</fieldset>
</div>