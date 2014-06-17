<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
int type = (Integer)session.getAttribute("member_type");
JSONArray categories = (JSONArray)session.getAttribute("categories");
%>
<script>
	function select_category(ca_pk){
		$.get('get_board.ajax?pk='+ca_pk,function(result){
			if(result == 'true'){
				$.get('cafe/content_board.jsp', function(page){
					$('#contents').html(page);
				});
			}
		});
	}
	function navigation_category_all_board(){
		$.get('get_all_board.ajax', function(result){
			if(result == "true"){
				$.get('cafe/content_board.jsp', function(page){
					$('#contents').html(page);
				});	
			}
		});
	}
</script>
<div id="navigation_category">
<fieldset>
<legend>카테고리 목록</legend>
	<p onclick="navigation_category_all_board()">전체 글</p>
	<p onclick="navigation_category_my_board()">내가 쓴 글</p>
	<br>
	<div id="category_result">
		<% for(int i=0 ; i<categories.size(); i++){
			JSONObject category = (JSONObject)categories.get(i);
		%>
		<p onclick="select_category(<%= category.get("pk") %>)"><%= category.get("name") %></p>
		<%} %>
	</div>
</fieldset>
</div>