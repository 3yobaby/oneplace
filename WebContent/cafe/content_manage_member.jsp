<%@page import="com.oneplace.database.get.CafeMemberDB"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.oneplace.database.get.MemberDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	JSONObject member = (JSONObject)session.getAttribute("member");
	JSONObject cafe = (JSONObject)session.getAttribute("cafe");
	CafeMemberDB db = new CafeMemberDB();
	JSONArray members = null;
	if(cafe.get("manager_id").equals(member.get("id"))){
		members = db.getMemberArray((String)cafe.get("uri"));	
	}else{
		response.sendRedirect((String)cafe.get("uri"));
	}
	db.close();
%>
<script>
	function remove_member(val){
		$.get('remove_member.ajax?id='+val,function(result){
			alert(result);
		});
	}
</script>
<div id="content_manage_member">
	<fieldset>
		<legend>회원 관리</legend>
	<fieldset>
		<legend>회원 목록</legend>
		<div id="content_manage_member_list">
<%--{"cafe_uri":"dongsung.org","member_type":0,"manager_id":"dongsung","member_id":"3yobaby"}, --%>
			<%
				for(int i=0; i< members.size(); i++){
					JSONObject temp = (JSONObject)members.get(i);
			%>
			<fieldset>
			아이디 : <%= temp.get("member_id") %><br>
			타입 : <%= temp.get("member_type") %>
			<input type="button" value="탈퇴" onclick="remove_member('<%= temp.get("member_id")%>')"/>
			</fieldset>
			<%
				}
			%>
		</div>
	</fieldset>
	<fieldset>
		<legend>카페 가입 신청</legend>
	</fieldset>
	</fieldset>
</div>