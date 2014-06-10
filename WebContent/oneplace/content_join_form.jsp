<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	#join_form input{
		width : 40em;
		height : 20px;
		margin-bottom : 10px;
	}
	#join_form fieldset {
		border-color : #eee;
	}
</style>
<script>
	var dup_check = false;
	function isvalid(p1, p2){
		if(p1.value != p2.value){
			p2.value = '';
			$(p2).attr('placeholder','비밀번호가 다릅니다');
			return false;
		}
		//아이디 중복체크	id_dup_check.ajax
		$.get('id_dup_check.ajax?join_id='+p1.value, function(result){
			if(result == 'false'){ // not dup id
				dup_check = true;
				join.submit();
			}
			else return false;			
		});
		return dup_check;
	}
</script>
<div id="join_form">
<form id="join" action="join.do" method="post" onsubmit="return isvalid(join_pass, join_pass2)">
	<fieldset>
		<input type="text" name="join_id" placeholder="아이디" required/>
		<input type="password" name="join_pass" placeholder="비밀번호" required/>
		<input type="password" name="join_pass2" placeholder="비밀번호 재확인" required/>
		<input type="text" name="join_name" placeholder="이름" required/>
		<input type="email" name="join_email" placeholder="이메일"/>
		<input type="tel" name="join_tel1" placeholder="전화번호" />
		<input type="submit" value="가입하기" />
	</fieldset>
</form>
<input type="button" onclick="location.href = './'" value="홈으로"/>
</div>