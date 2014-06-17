<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONArray categories = (JSONArray)session.getAttribute("categories");
%>
<h2>카테고리 관리</h2>
<div id="content_manage_category">
	<script>
		function modify_category(form){
			$.post('modify_category.ajax', $(form).serialize(),function(result){
				if(result == 'true')
					location.reload();
			});
			return false;
		}
	</script>
	<% 
	for(int i=0; i<categories.size(); i++){ 
		JSONObject category = ((JSONObject)categories.get(i));
	%>
	<fieldset>
	<form onsubmit="return modify_category(this)">
		<input type="hidden" name="pk" value="<%= category.get("pk")%>"/>
		이름 : <input type="text" name="name" value="<%= category.get("name") %>"/><br>
		공개 :
		<label for="radio_all">전체공개</label>
		<input id="radio_all" name="visibility" type="radio" value="all" 
		<% if(category.get("visibility").equals("all")){ %> checked="checked" <% }%>/>
		<label for="radio_private">비공개</label>
		<input id="radio_private" name="visibility" type="radio" value="none"
		<% if(category.get("visibility").equals("none")){ %> checked="checked" <% }%> /><br>
		생성 : <%= category.get("created") %><br>
		타입 : 
		<select name="type">
			<% 
			if(category.get("type").equals("default")) {
				%> <option value="default" selected="selected">default</option> <%
			}
			%>
		</select><br>
		<input type="submit" value="수정"/>
	</form>
	</fieldset>
	<% 
	}
	%>
</div>