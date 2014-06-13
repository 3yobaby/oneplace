<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function write_form(){
		$.get('cafe/content_write.jsp',function(result){
			$('#contents').html(result);
		});
	}
	
	function content_manage_form(){
		$.get('cafe/content_manage_member.jsp',function(page){
			$('#contents').html(page);
		});
	}
	
	function content_category_form(){
		$.get('cafe/content_manage_category.jsp',function(page){
			$('#contents').html(page);
		});
	}

</script>
<% JSONObject member = (JSONObject)session.getAttribute("member"); %>
<div id="member_info">
	<fieldset>
	<legend>정보</legend>
		카페정보, 회원정보....<br>
		<input type="button" value="회원관리-수락/탈퇴" onclick="content_manage_form()"/><br>
		<input type="button" value="카테고리 추가/삭제" onclick="content_category_form()"/>
	</fieldset>
	<input type="button" value="글쓰기" onclick="write_form()"/>
</div>