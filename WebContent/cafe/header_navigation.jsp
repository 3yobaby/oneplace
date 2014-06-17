<%@page import="com.oneplace.database.get.CafeDB"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject member  = (JSONObject)session.getAttribute("member");
	CafeDB db = new CafeDB();
	JSONObject cafe = db.getCafeById((String)member.get("id"));
%>
    <style>
    	#header_navigation{
    		border: 1px;
    		background-color: gray;
    		border-radius : 5px;
    	}
    	#header_navigation > a{
    		text-decoration: none;
    		color: white;
    		margin-right: 10px;
    	}
    </style>
<div id="header_navigation">
	<a href="./">검색 페이지</a>
	<% if(session.getAttribute("member") != null){
		%>
			<a href="<%= cafe.get("uri") %>">내 카페</a>
		<%
	} %>
</div>