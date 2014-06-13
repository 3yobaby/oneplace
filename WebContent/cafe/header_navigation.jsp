<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<a href="./">돌아가기</a>
	<% if(session.getAttribute("member") != null){
		%> 
		<a href="#">내 카페</a>
		<%
	} %>
</div>