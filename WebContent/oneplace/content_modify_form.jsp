<%@page import="com.oneplace.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>정보수정</h1>
<%
	Member member = (Member)request.getSession().getAttribute("member");
%>
<script>
	function modify(){
		return false;
	}
</script>
<div id="content_modify_form">
<fieldset>
<legend>회원정보 수정</legend>
<form method="post" action="./" onsubmit="return modify()">
	아이디 : <input type="text" value="<%= member.getId()%>" readonly="readonly"/><br>
	이름 : <input type="text" value="<%= member.getName()%>" readonly="readonly"/><br>
	비밀번호 확인 : <input type="password" name="password" required="required"/><br>
	<input type="submit" value="수정"/><br>
</form>
</fieldset>
<input type="button" value="홈으로" onclick="location.href = './'"/><br>
</div>