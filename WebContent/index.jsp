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
		width : 75%;
		height : 500px;
		float : left;
	}
	
	aside {
		width : 20%;
		height : 500px;
		float : left;
	}

	footer{
		background-color : #aaaaaa;
		position : fixed;
		bottom : 0px;
		width : 99%;
		text-align : center;
	}
	footer *{
		display : inline;
	}
</style>
</head>
<body>
<header id="header">
	<h1>검색 페이지</h1>
</header>
<aside id="member_info">
	<nav>
		<jsp:include page="oneplace/member_info.jsp"></jsp:include>
	</nav>
</aside>
<section id="contents">
	<jsp:include page="oneplace/content.jsp"></jsp:include>
</section>
<footer>
	<jsp:include page="oneplace/footer.html"></jsp:include>
</footer>
</body>
</html>