<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#navigation_groups #group_section{
		margin : 5px;
	}
	
	#navigation_groups #group_section > *{
		margin : 30px;
	}
	
	#content_search_result{

	}
	
	#content_cafe_list{
		float : right;
	}
</style>
<script>
	$(document).ready(function(){
		sel_group('select_group_all');
	});
	var selected_tap = 'select_group_all';
	var cafe_list;
	function sel_group(val){
		switch(val){
		case 'select_group_all':
			$('#content_search_result legend').text('전체 카페');
			break;
		case 'select_group_new':
			$('#content_search_result legend').text('새 카페');
			break;
		case 'select_group_join':
			$('#content_search_result legend').text('가입 카페');
			break;
		case 'select_group_my':
			$('#content_search_result legend').text('내 카페');
			break;
		}
		$.get('cafeSearch.ajax?select=' + val , function(data){
			cafe_list = $.parseJSON(data);
			print_cafe(cafe_list);
		});
	}

	// result is a array
	function print_cafe(result){
		var num = 1;
		$('tbody').empty();
		$.each(result, function(key, value){
			var title = value.title;
			var name = value.name;
			var date = value.date;
			$('tbody').append('<tr>');
			$('tbody').append('<td><p onclick="select_num(this)">'+ num++ +'</p></td>');
			$('tbody').append('<td class="title"><p onclick="select_title(this)">'+title + '</p></td>');
			$('tbody').append('<td class="name"><p onclick="select_name(this)">'+name + '</p></td>');
			$('tbody').append('<td class="date">'+date + '</td>');
			$('tbody').append('</tr>');
		});
	}
	
	function select_num(selected){
		$s = $(selected);
		alert($s.text());
		// result[$s.text()-1] 선택된 카페
	}
	
	function select_name(selected){
		$s = $(selected);
		alert($s.text());
	}
	
	function select_title(selected){
		$s = $(selected);
		alert($s.text());
	}

	function search_cafe(val){
		var word = $(val).val();
		$.get('search_cafe_by_word.ajax?word='+word, function(result){
			$result = $.parseJSON(result);
			print_cafe($result);
		})
	}
</script>
<div id="content_cafe_list">
	<div id="navigation_groups">
	<nav id="group_section">
		<a id="select_group_all" onclick="sel_group(id)">전체 카페</a>
		<a id="select_group_new" onclick="sel_group(id)">새 카페</a>
		<a id="select_group_join" onclick="sel_group(id)">가입한 카페</a>
		<a id="select_group_my" onclick="sel_group(id)">내 카페</a>
	</nav>
		<input id="search" type="search" autofocus="autofocus" placeholder="검색어를 입력하세요"/>
		<button onclick="search_cafe(search)">검색</button>
	</div>
	<div id="content_search_result">
	<fieldset>
		<legend>전체 목록</legend>
		<table>
			<tbody>
				
			</tbody>
		</table>
	</fieldset>
	</div>
	<button onclick="location.href = '../CafePlace/testcafe.cafe'">카페 들어가기 테스트</button>
</div>