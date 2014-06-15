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
		float : left;
	}
</style>
<div id="content_cafe_list">
<script>
	$(document).ready(function(){
		sel_group('select_group_all');
	});
	var selected_tap = 'select_group_all';
	var cafe_list;
	var org_list;
	function sel_group(val){
		var uri;
		switch(val){
		case 'select_group_all':
			$('#content_search_result legend').text('전체 카페');
			uri = "get_all_cafe.ajax";
			break;
		case 'select_group_join':
			$('#content_search_result legend').text('가입 카페');
			uri = "get_joined_cafe.ajax";
			break;
		case 'select_group_my':
			$('#content_search_result legend').text('내 카페');
			uri = "get_my_cafe.ajax";
			break;
		case 'select_org':
			$('#content_search_result legend').text('기관 정보');
			uri = "get_all_organization.ajax";
			break;
		}
		$.get(uri , function(data){
			temp = data;
			cafe_list = $.parseJSON(data);
			print_list(cafe_list);
		});
	}
	var temp;
	// result is a array
	function print_list(result){
		var num = 1;
		$('tbody').empty();
		$.each(result, function(key, value){
			var name = value.name;
			var manager_id = value.manager_id;
			var created = value.created;
			var detail = value.detail;
			var uri = value.uri;
			$temp = $('<tr>');
			$temp.append('<td><p onclick="select_num(this)">'+ num++ +'</p></td>');
			$temp.append('<td name="title"><p onclick="select_title(this)">'+name + '</p></td>');
			$temp.append('<td name="name"><p onclick="select_name(this)">'+manager_id + '</p></td>');
			$temp.append('<td name="created">'+created + '</td>');
			$temp.append('<td name="uri" class="hide">'+ uri + '</td>');
			$temp.append('<td><button onclick="goCafe(this)">들어가기</button</td>');
			$('tbody').append($temp);
			$('tbody').append('<tr class="hide"><td colspan="5"><p>'+ detail +'</p></td></tr>');
		});
	}
	
	function select_num(selected){
		$s = $(selected);
		// result[$s.text()-1] 선택된 카페
	}
	
	var temp;
	function select_name(selected){
		// 이름 선택
	}
	
	function select_title(selected){
		$s = $(selected);
		$s.parent().parent().next().toggleClass('hide');
	}

	function search_cafe(val){
		var word = $(val).val();
		$.get('search_cafe_by_word.ajax?word='+word, function(result){
			$result = $.parseJSON(result);
			print_cafe($result);
		})
	}
	
	function goCafe(btn){
		var uri = $(btn).parent().prev().text();
		location.href = uri;
	}
</script>
	<div id="navigation_groups">
	<nav id="group_section">
		<a id="select_group_all" onclick="sel_group(id)">전체 카페</a>
		<a id="select_org" onclick="sel_group(id)">기관 정보</a>
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
	<button onclick="content_cafe_make_form()">카페 만들기</button>
	<button onclick="location.href = 'dongsung.org'">카페 들어가기 테스트 dongsung.org</button>
</div>