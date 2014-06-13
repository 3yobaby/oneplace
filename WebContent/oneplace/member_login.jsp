<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	#login_form button {
		width : 100%
	}
</style>
<script>
	function member_form_join(){
		$.get('oneplace/content_join_form.jsp',function(data){
			$(contents).html(data);
		});
	}
	function member_form_find(){
		$.get('oneplace/content_inquiry_form.jsp',function(data){
			$(contents).html(data);
		});
	}
	function member_form_login(v1, v2){
		var temp = {};	
		temp.id = v1;
		temp.pass = v2;
		$.post('login.ajax',temp, function(result){
			if(result == 'true'){
				location.href = "./";
			}else{
				alert('로그인 실패');
			}
		});
	}
</script>
<div id="member_login">
	<fieldset>
		<button onclick="member_form_join();">회원가입</button>
		<button onclick="member_form_find();">아이디 / 비밀번호 찾기</button>
		<input type="text" id="login_id" placeholder="아이디"/><br>
		<input type="password" id="login_pass"placeholder="비밀번호"/><br>
		<button onclick="member_form_login(login_id.value, login_pass.value)">로그인</button>
	</fieldset>
</div>