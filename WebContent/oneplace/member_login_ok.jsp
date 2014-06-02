<%@page import="com.oneplace.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function logout(){
		$.get("logout.ajax",function(){
			location.href="./";
		});
	}
</script>
<fieldset>
	<legend>로그인 정보</legend>
	<%= ((Member)session.getAttribute("member")).getName() %>님 반갑습니다!<br>
	<button onClick="modify();">정보수정</button>
	<button onclick="logout();">로그아웃</button>
</fieldset>