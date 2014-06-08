<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<script>
	function member_logout(){
		location.href = 'logout.do';
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
	<%= json.get("name")%>님 반갑습니다!<br>
	<button onClick="member_modify();">정보수정</button>
	<button onclick="member_logout();">로그아웃</button>
</fieldset>