<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	#login_form button {
		width : 100%
	}
</style>
<script>
	function join_form_join(){
		$.get('oneplace/content_join_form.jsp',function(data){
			$(contents).html(data);
		});
	}
	function join_form_find(){
		$.get('oneplace/content_inquiry_form.jsp',function(data){
			$(contents).html(data);
		});
	}
	function login_form_login(id, pass){
		var temp = {};	
		temp.id = id;
		temp.pass = pass;
		$.post('login.ajax',temp, function(result){
			alert("result :"  + result);
			if(result == 'true'){
				$.get('oneplace/member_login_ok.jsp',function(page){
					$('#login_form').html(page);
				});
			}else{
				alert('로그인 실패');
			}
		});
	}
</script>
<div id="login_form">
	<fieldset>
		<button onclick="join_form_join();">회원가입</button>
		<button onclick="join_form_find();">아이디 / 비밀번호 찾기</button>
		<input type="text" id="login_id" name="login_id" placeholder="아이디"/><br>
		<input type="password" id="login_pass" name="login_pass" placeholder="비밀번호"/><br>
		<button onclick="login_form_login(login_id.value, login_pass.value)">로그인</button>
	</fieldset>
</div>