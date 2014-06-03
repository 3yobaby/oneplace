<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#content_Cafe_make_form input{
		
	}
</style>
<script>
	function cafe_word_add(){
		return false;
	}
	
	var ccmc = false;
	function content_cafe_make_check(cn, on, ca){
		if(!check_cafe_name()){
			$(cn).val('');
			$(cn).attr('placeholder','중복입니다');
		}else if(!check_org_name()){
			$(on).val('');
			$(on).attr('placeholder','중복입니다');
		}else if(!check_cafe_addr()){
			$(ca).val('');
			$(ca).attr('placeholder','중복입니다');
		}
		return ccmc;
	}
	
	// 비동기.........
	function check_cafe_name(){
		$.get('check_cafe_name.ajax', function(result){
			return result;
		});
		return false;
	}
	
	function check_org_name(){
		return false;
	}
	
	function check_cafe_addr(){
		return false;
	}
</script>
<div id="content_cafe_make_form" onsubmit="return content_cafe_make_check(cafe_name, org_name, cafe_addr)">
	<form action="#" method="post">
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
		<label for="cafe_words">카페 검색어</label><input type="text"/>
		<button onclick="return cafe_word_add()">추가</button>
		<input type="submit" value="카페 만들기"/>
	</form>
</div>