<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	JSONObject cafe = (JSONObject) request.getSession().getAttribute("cafe");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="cafe/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<title>Insert title here</title>
<style>
	aside{
		width : 20%;
		float : left;
		height : 50%;
	}
	section{
		width : 75%;
		height : 50%;
		float : right;
		margin-left: 10px;
	}
	
	fieldset{
		border-radius : 10px;
	}
	
	.hide {
		display: none;
	}
</style>
</head>
<body>
<header>
	<h1><a href="<%= cafe.get("uri") %>"><%= cafe.get("name") %></a></h1>
	<nav>
		<jsp:include page="header_navigation.jsp"></jsp:include>
	</nav>
</header>
<hr>
<aside id="navigation">
	<nav id="member_info">
		<jsp:include page="navigation_info.jsp"></jsp:include>
	</nav>
	<nav id="category">
		<jsp:include page="navigation_category.jsp"></jsp:include>
	</nav>
</aside>
<section id="contents">
	<jsp:include page="content_default.jsp"></jsp:include>
</section>
</body>
</html>