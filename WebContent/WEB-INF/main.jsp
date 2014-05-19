<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-2.1.1.min.js" type="text/javascript"></script>
<style type="text/css">
	body{
		border : solid;
	}
	aside {
		width : 200px;
		position : absolute;
		right : 20px;		
	}
	fieldset{

	}
	footer{
		position : absolute;
		bottom : 10px;
	}
	li{
		list-style-type : none;
	}
	
	a[class=group_title]{
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
	}
	
</style>
<script>
	var groups = '';
	$(document).ready(function(){
		// 그룹 구분 선택
		$('a[id^=select_group]').bind('click',function(){
			$('#groups_selected').text(this.text);
			groups = this.text;
		});
		
		// 클릭 정보를 넘긴다 - 링크하려고
		$('a[class^=group]').bind('click', function(){
			var $group = $(this);
			var className = $group.attr('class');
			var content = this.text;
			alert(content);
		});
	});
	
	function logout(){
		location.href = './';
	}
	
	function modify(){
		alert('정보수정 클릭');
	}
</script>
</head>
<body>
<header>
	<!-- 모임 이미지 등등 -->
</header>
	<!-- 로그인 정보 출력 -->
	<aside id="info_member">
		<fieldset>
			<legend>로그인 정보</legend>
			<%= request.getAttribute("login_name") %>님 반갑습니다!<br>
			<button onClick="modify();">정보수정</button>
			<button onclick="logout();">로그아웃</button>
		</fieldset>
	</aside>
	<!-- 전체 그룹 표시  -->
	<section id="groups">
		<fieldset>
		<nav id="group_section">
			<a id="select_group_all">전체 그룹</a>
			<a id="select_group_new">새 그룹</a>
			<a id="select_group_join">가입한 그룹</a>
		</nav>
		<h3 id="groups_selected">전체 그룹</h3>
		<label for="search">검색</label><input id="search" type="text" autofocus="autofocus"/><br>
		<ul>
			<li id="groups_group1">
				<a class="group_title">자바를 공부하는 사람들의 모임 블라블라블라블라</a>
				<a class="group_user">자바신</a>
				<a class="group_date">14.03.02</a>
			</li>
			<li id="groups_group2">
				<a class="group_title">동성학원 안드로이드과정</a>
				<a class="group_user">진영곤</a>
				<a class="group_date">14.01.27</a>
			</li>
		</ul>		
		</fieldset>
	</section>
<footer>
<fieldset>
	<!-- 만든이 정보 혹은 바로가기 링크 -->
	만든이 : 김희택
	<address>010-6688-2199</address>
</fieldset>
</footer>
</body>
</html>