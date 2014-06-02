<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#navigation_groups #group_section{
		margin : 5px;
	}
	
	#navigation_groups #group_section > *{
		margin : 30px;
	}
	
	.title{
		width : 700px;
	}
	
	.name{
	
	}
	
	.date{
	
	}
</style>
<script>
	var selected_tap = 'select_group_all';
	var result;
	function sel_group(val){
		switch(val){
		case 'select_group_all':
		case 'select_group_new':
		case 'select_group_join':
		case 'select_group_my':
			$.get('cafeSearch.ajax?select=' + val , function(data){
				$('tbody').empty();
				$.each($.parseJSON(data),function(key, value){
					var title = value.title;
					var name = value.name;
					var date = value.date;
					$('tbody').append('<tr>');
					$('tbody').append('<td class="title">'+title + '</td>');
					$('tbody').append('<td class="name">'+name + '</td>');
					$('tbody').append('<td class="date">'+date + '</td>');
					$('tbody').append('</tr>');
				});
				
			});
			break;
		}
	}
	
	// 선택된 그룹 선택 탭 클레스 추가
	function select_group(val){
		
	}
</script>
<div id="navigation_groups">
<nav id="group_section">
	<a id="select_group_all" onclick="sel_group(id)">전체 카페</a>
	<a id="select_group_new" onclick="sel_group(id)">새 카페</a>
	<a id="select_group_join" onclick="sel_group(id)">가입한 카페</a>
	<a id="select_group_my" onclick="sel_group(id)">내 카페</a>
</nav>
	<input id="search" type="text" autofocus="autofocus" placeholder="검색어를 입력하세요"/>
</div>
<div id="search_result">
	<table border="1">
		<tbody>
			
		</tbody>
	</table>
</div>