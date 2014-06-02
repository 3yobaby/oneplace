<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oneplace.data.Member"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
	document.createElement("abc");
</script>
<style type="text/css">
	/* a[class=group_title]{
		float : left;
		width : 15em;
		height : 1em;
		text-overflow : ellipsis;
		overflow : hidden;
	}
	a[class=group_user]{
		float : left;
		width : 5em;
		height : 1em;
		text-overflow : ellipsis;
		overflow : hidden;
	} */
	
	body {
		padding : 50px;
	}
	
	header {
		background-color : #aaaaaa;
		width : 100%;
		height : 100px;
		margin-bottom : 10px;
	}
	
	section {
		height : 500px;
	}
	
	aside {
		height : 800px;
		width : 200px;
		float : left;
	}

	footer{
		background-color : #aaaaaa;
		position : absolute;
		bottom : 0px;
		width : 99%;
		text-align : center;
	}
	footer *{
		display : inline;
	}
</style>
<script>
	$(document).ready(function(){
		
	});

</script>
</head>
<body>
<header id="header">
	<h1>header</h1>
</header>
<aside id="membership_info">
	<jsp:include page="oneplace/member_info.jsp"></jsp:include>
</aside>
<section id="contents">
	<jsp:include page="oneplace/content.jsp"></jsp:include>
</section>
<footer>
	<jsp:include page="oneplace/footer.html"></jsp:include>
</footer>
</body>
</html>