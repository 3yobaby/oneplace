<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<div id="member_login_ok">
<script>
	function member_logout(){
		$.get('logout.ajax', function(){
			location.href = "./";
		})
	}
	function member_modify(){
		$.get('oneplace/content_modify_form.jsp', function(data){
			$('#contents').html(data);
		});
	}
</script>
<fieldset>
	<legend>로그인 정보</legend>
	<% 
		JSONObject json = ((JSONObject)session.getAttribute("member"));
	%>
	아이디 : <%= json.get("id")%><br>
	이름 : <%= json.get("name")%><br>
	<button onClick="member_modify();">정보수정</button>
	<button onclick="member_logout();">로그아웃</button>
</fieldset>
</div>