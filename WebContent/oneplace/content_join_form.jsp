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
<div id="join_form">
<form action="join.ajax" method="post">
	<fieldset>
		<input type="text" name="join_id" placeholder="아이디" required/>
		<input type="password" name="join_id" placeholder="비밀번호" required/>
		<input type="password" name="join_id2" placeholder="비밀번호 재확인" required/>
		<input type="text" name="join_name" placeholder="이름" required/>
		<input type="email" name="join_email" placeholder="이메일"/>
		<input type="tel" name="join_tel1" placeholder="전화번호" />
		<input type="submit" value="가입하기" />
	</fieldset>
</form>
</div>