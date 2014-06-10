<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<h1>정보수정</h1>
<%
	JSONObject member = (JSONObject)request.getSession().getAttribute("member");
%>
<script>
	var submit = false;
	function modify(form){
		if(submit)
			return true;
		$.get('pass_check.ajax?pass=' +form.pass.value, function(result){
			if(result == "true"){
				submit = true;
				alert('수정되었습니다');
				$('#content_modify_form form').submit();
			}else{
				alert('비밀번호가 일치하지 않습니다');
			}
		});
		return false;
	}
</script>
<div id="content_modify_form">
<fieldset>
<legend>회원정보 수정</legend>
<form method="post" action="modify_member.do" onsubmit="return modify(this)">
	아이디 : <input type="text" id="id" name="id" value="<%= member.get("id")%>" readonly="readonly"/><br>
	이름 : <input type="text" id="name" name="name" value="<%= member.get("name")%>" readonly="readonly"/><br>
	비밀번호 확인 : <input type="password" id="pass" name="pass" required="required"/><br>
	이메일	: <input type="email" name="email" id="email" placeholder="이메일" value="<%= member.get("email") %>"/><br>
	전화번호 :	<input type="tel" name="tel" id="tel" placeholder="전화번호" value="<%= member.get("tel") %>"/>
	<input type="submit" value="수정"/><br>
</form>
</fieldset>
<input type="button" value="홈으로" onclick="location.href = './'"/><br>
</div>