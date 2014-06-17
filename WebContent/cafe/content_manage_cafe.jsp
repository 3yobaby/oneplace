<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int type = (Integer)session.getAttribute("member_type");
	JSONObject cafe = (JSONObject)session.getAttribute("cafe");
	String isOrganization = (String)cafe.get("is_organization");
	if(type != 4 || !Boolean.valueOf(isOrganization))
		response.sendRedirect("./");
	JSONArray cafes = (JSONArray)session.getAttribute("cafes");
%>
<script>
	function modify_cafe_state(form){
		$.post('modify_cafe_organization.ajax', $(form).serialize(), function(result){
			alert(result);
		});
		return false;
	}
</script>
<div>
	<fieldset>
	<legend>카페 관리</legend>
	<% for(int i=0; i<cafes.size(); i++){
		JSONObject temp = (JSONObject)cafes.get(i);
		%>
		<form onsubmit="return modify_cafe_state(this)">
		<fieldset>
			<input type="hidden" name="pk" value="<%= temp.get("pk") %>"/>
			<input type="hidden" name="organization_uri" value="<%= temp.get("organization_uri")%>"/>
			주소 : <input type="text" value="<%= temp.get("cafe_uri")%>" readonly="readonly"/>
			<input type="button" onclick="javascript:location.href=<%= temp.get("cafe_uri") %>" value="바로가기"/><br>
			가입 : 
			<select name="joined">
			<option value="true" <% if(temp.get("joined").equals("true")){%> selected="selected"<%}%>>가입</option>
			<option value="false" <% if(temp.get("joined").equals("false")){%> selected="selected"<%}%>>비가입</option>
			</select>
			<br>
			<input type="submit" value="수정"/>
		</fieldset>
		</form>
		<%
	}
	%>
	</fieldset>
</div>