<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	#login_form button {
		width : 100%
	}
</style>
<script>
	function join_form_join(){
		$.get('oneplace/content_join_form.jsp',function(){
			$(contents).html(data);
		});
	}
	function join_form_find(){
		$.get('oneplace/content_inquiry_form.html',function(data){
			$(contents).html(data);
		});
	}
</script>
<div id="login_form">
	<fieldset>
		<button onclick="join_form_join();">회원가입</button>
		<button onclick="join_form_find();">아이디 / 비밀번호 찾기</button>
		<form method="post" action="login.do">
			<input type="text" id="login_id" name="login_id" placeholder="아이디"/><br>
			<input type="password" id="login_pass" name="login_pass" placeholder="비밀번호"/><br>
			<input type="submit" value="로그인"/>
		</form>
	</fieldset>
</div>