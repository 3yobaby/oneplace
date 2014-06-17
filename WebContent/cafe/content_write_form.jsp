<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject category = (JSONObject)session.getAttribute("category");
%>
<div id="content_write_form">
<script>
	function content_write_submit(){
		var $form = $('#content_write_form form');
		$.post('make_board.ajax', $form.serialize(), function(result){
			alert(result);
		});
		return false;
	}
</script>
<form>
	<input type="hidden" name="category_pk" value="<%= category.get("pk")%>"/>
	<input type="text" id="title" name="title" placeholder="제목" size="40"/>
	<textarea name="content" rows="10" cols="100"></textarea><br>
	<input type="button" onclick="content_write_submit()" value="확인"/>
	<input type="button" value="취소" onclick="return write_form_cancel()"/>
</form>
</div>