<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<div id="navigation_info">
<script>
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
<% 
	JSONObject member = (JSONObject)session.getAttribute("member"); 
	JSONObject cafe = (JSONObject)session.getAttribute("cafe");
%>
	<fieldset>
	<legend>정보</legend>
		카페정보<br>
		
		멤버정보<br>
		<%
			if(cafe.get("manager_id").equals(member.get("id"))){ // 메니저 탭
				%> 
				<input type="button" value="회원관리-수락/탈퇴" onclick="content_manage_form()"/><br>
				<input type="button" value="카테고리 추가/삭제" onclick="content_category_form()"/>
				<%
			}else{ // 사용자 탭
				%>
					
				<%
			}
		%>
	</fieldset>
</div>