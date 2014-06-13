<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#content_Cafe_make_form input{
		
	}
</style>
<script>
	var submit = false;
	function content_cafe_make(){
		var temp = $('#cafe_make_form').serialize();
		temp += "&detail=" + $('#cafe_detail').val();
		$.post('make_cafe.ajax', temp, function(result){
			if(result == "true"){
				
			}
		});
		return false;
	}
	
	var temp = {}; // search words
	var index = 0;
	function cafe_word_add(){
		var val = $('#cafe_search_word').val();
		var $words = $('input[name=search_words]');
		for(key in temp){
			if(temp[key] == val)
				return;
			else{
				$words.val($words.val() + "|");				
			}
		}
		$words.val($words.val() + val);
		temp[index++] = val;
		var result = "검색어 : ";
		for(key in temp){
			result += temp[key] + " ";
		}
		$('#words').html(result);
	}
	function search_organization(){
		var temp = {};
		temp.name = $('#org_search').val();
		$.post('get_organization.ajax', temp, function(result){
			if(result == ""){
				$('#org_search').val("");
				$('#org_search').attr('placeholder', '기관이 존재하지 않습니다');
			}else{
				var $result = $.parseJSON(result);
				$('#org_name').val($result[0].name);
				$('#org_uri').val($result[0].uri);
			}
		});
	}
</script>
<div id="content_cafe_make_form">
	<form id="cafe_make_form" onsubmit="return content_cafe_make()">
		<h1>카페 만들기</h1>
		<input id="cafe_name" name="name" type="text" autofocus="autofocus" placeholder="카페이름"/><br>
		<input id="org_name" type="text" readonly="readonly" placeholder="기관이름"/>
		<input id="org_uri" name="organization_uri" type="text" readonly="readonly" placeholder="기관주소"/><br>
		<input type="text" id="org_search" placeholder="기관 이름을 적어서 찾아주세요" size="30"/>
		<input type="button" value="찾기" onclick="search_organization()"><br>
		<label for="cafe_addr">카페 주소</label>
		<input id="cafe_addr" name="uri" type="text" placeholder="카페주소"/><br>
		<label for="cafe_search">공개</label>
		<input id="cafe_search" name="is_search" type="radio" value="true"/>
		<label for="cafe_search">비공개</label>
		<input id="cafe_search" name="is_search" type="radio" value="false"/><br>
		<label for="cafe_join_rule">가입밪식</label>
		<input id="cafe_join_rule" name="join_rule" type="radio" value="1"/>바로가입<br>
		<input id="cafe_join_rule" name="join_rule" type="radio" value="2"/>신청 후 가입<br>
		<label for="cafe_detail">카페 설명</label>
		<textarea id="cafe_detail" name="datail" cols="40" rows="5">
		</textarea><br>
		<label for="cafe_words">카페 검색어</label>
		<input id="cafe_search_word" type="text"/>
		<input type="button" onclick="cafe_word_add()" value="추가">
		<input type="hidden" name="search_words"/>
		<p id="words"></p>
		<input type="submit" value="카페 만들기"/>
	</form>
	<button onclick="location.href='./'">홈으로</button>
</div>