<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function id_pass_find(){
		var email = $('#find_email').val();
		$.get('id_pass_find.ajax?email='+email ,function(result){
			$result = $.parseJSON(result);
			if($result.result == true)
				alert('메일을 확인해주세요');
			else alert('회원이 존재하지 않습니다');
		});
	}
</script>
<div id="content_inquriy_form">
	이메일 <input id="find_email" type="email" name="email"/>
	<button onclick="id_pass_find()">아이디/비밀번호 찾기</button>
</div>