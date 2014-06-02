<%@page import="com.oneplace.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%= ((Member)session.getAttribute("member")).getName() %>님 반갑습니다!<br>
	<button onClick="member_modify();">정보수정</button>
	<button onclick="member_logout();">로그아웃</button>
</fieldset>