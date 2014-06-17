<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<% 
int type = (Integer)session.getAttribute("member_type");
JSONObject member = (JSONObject)session.getAttribute("member"); 
JSONObject cafe = (JSONObject)session.getAttribute("cafe");
%>
<div id="navigation_info">
<script>
	function content_manage_member_form(){
		$.get('cafe/content_manage_member.jsp',function(page){
			$('#contents').html(page);
		});
	}
	
	function content_manage_category_form(){
		$.get('cafe/content_manage_category.jsp',function(page){
			$('#contents').html(page);
		});
	}
	
	function content_manage_cafe_form(){
		$.get('cafe/content_manage_cafe.jsp', function(page){
			$('#contents').html(page);
		});
	}

</script>
	<fieldset>
	<legend>정보</legend>
		카페정보<br>
		멤버정보 - 
		<%
			switch(type){
			case 0:
				%>
				비회원
				<%
				break;
			case 1:
				%>
				가입 신청중
				<%
				break;
			case 2:
				%>
				회원
				<%
				break;
			case 3:
				%>
				카페 관리자
				<%
				break;
			case 4:
				%>
				기관 관리자
				<%
				break;
			}
		 	%> 
		 		<br>
		 	<%
			if(type > 2){ // 메니저 탭
				%> 
				<input type="button" value="회원관리-수락/탈퇴" onclick="content_manage_member_form()"/><br>
				<input type="button" value="카테고리 추가/삭제" onclick="content_manage_category_form()"/><br>
				<%
			}
		 	if(type == 4){
		 		%> 
		 		<input type="button" value="카페 관리" onclick="content_manage_cafe_form()"/><br>
		 		<%
		 	}
		%>
	</fieldset>
</div>