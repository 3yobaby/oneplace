<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#content_Cafe_make_form input{
		
	}
</style>
<script>
	var submit = false;
	var temp = {};
	function content_cafe_make_check(){
		if(submit)
			return true;
		$cn = $('#cafe_name');
		$og = $('#org_name');
		$ca = $('#cafe_addr');
		temp['cafe_name'] = $cn.val();
		temp['org_name'] = $og.val();
		temp['cafe_addr'] = $ca.val();
		$.post('cafe_create_check.ajax', temp, function(result){
			$result = $.parseJSON(result);
			if($result.cn_check == false){
				alert('카페 이름 중복');
				return;
			}
			if($result.on_check == false){
				alert('존재하지 않는 기관');
				return;
			}
			if($result.ca_check == false){
				alert('주소가 중복');
				return;
			}
			submit = true;
			$('#cafe_make_form').submit();
		});
		return false;
	}
	
	var words = {};
	var index = 0;
	function cafe_word_add(){
		var $temp = $('#cafe_search_word');
		words[index++] = $temp.val();
		var result = "검색어 : ";
		for(key in words){
			result += words[key] + " ";
		}
		$('#word_list').html(result);
	}
</script>
<div id="content_cafe_make_form">
	<form id="cafe_make_form" action="#" method="post" onsubmit="return content_cafe_make_check()">
		<h1>카페 만들기</h1>
		<label for="cafe_name">카페 이름</label>
		<input id="cafe_name" name="cafe_name" type="text"/><br>
		<label for="org_name">기관 이름</label>
		<input id="org_name" name="org_name" type="text"/><br>
		<label for="cafe_addr">카페 주소</label>
		<input id="cafe_addr" name="cafe_addr" type="text"/><br>
		<label for="cafe_open">공개</label>
		<input id="cafe_open" name="cafe_open" type="radio" value="true"/>
		<label for="cafe_open">비공개</label>
		<input id="cafe_open" name="cafe_open" type="radio" value="false"/><br>
		<label for="cafe_join_rule">가입밪식</label>
		<input id="cafe_join_rule" name="cafe_join_rule" type="radio" value="1"/>바로가입<br>
		<input id="cafe_join_rule" name="cafe_join_rule" type="radio" value="2"/>신청 후 가입<br>
		<label for="cafe_detail">카페 설명</label>
		<textarea id="cafe_detail" name="cafe_datail" cols="40" rows="5">
		</textarea><br>
		<label for="cafe_words">카페 검색어</label><input id="cafe_search_word" type="text"/>
		<input type="button" onclick="cafe_word_add()" value="추가">
		<p id="word_list"></p>
		<input type="submit" value="카페 만들기"/>
	</form>
	<button onclick="location.href='./'">홈으로</button>
</div>