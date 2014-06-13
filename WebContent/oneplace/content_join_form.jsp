<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	#content_join_form input{
		width : 40em;
		height : 20px;
		margin-bottom : 10px;
	}
	#content_join_form fieldset {
		border-color : #eee;
	}
</style>
<script>
	function isvalid(p1, p2){
		if(p1.value != p2.value){
			p2.value = '';
			$(p2).attr('placeholder','비밀번호가 다릅니다');
			return false;
		}
		$.get('id_dup_check.ajax?id='+$('#id').val(), function(result){
			if(result == "false"){ // not dup id
				alert('11');
				submit();
			}
		});
		return false;
	}
	function submit(){
		$.post('join.ajax', $('#join_form').serialize(), function(result){
			if(result == "false"){
				alert('가입실패');
				set_html_content('oneplace/content_join_form.jsp');
			}else{
				location.href = './';
			}
		});
	}
</script>
<div id="content_join_form">
<form id="join_form" onsubmit="return isvalid(pass, pass2)">
	<fieldset>
		<input type="text" name="id" placeholder="아이디" required/>
		<input type="password" name="pass" placeholder="비밀번호" required/>
		<input type="password" name="pass2" placeholder="비밀번호 재확인" required/>
		<input type="text" name="name" placeholder="이름" required/>
		<input type="email" name="email" placeholder="이메일"/>
		<input type="tel" name="tel" placeholder="전화번호" />
		<input type="submit" value="가입하기" />
	</fieldset>
</form>
<input type="button" onclick="location.href = './'" value="홈으로"/>
</div>