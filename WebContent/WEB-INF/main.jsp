<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oneplace.data.Member"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-1.11.1.min.js" type="text/javascript"></script>
<style type="text/css">
	body{
		border : solid;
		padding : 20px;
	}
	aside {
		width : 200px;
		position : absolute;
		right : 20px;
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
	
	nav#group_section{
		margin : 5px;
	}
	
	nav#group_section > *{
		margin : 30px;
	}
	footer{
		position : absolute;
		width : 100%;
		bottom : 10px;
		text-align : center;
	}
	footer *{
		display : inline;
	}
</style>
<script>
	$(document).ready(function(){
	
	});
	var selected_tap = 'select_group_all';
	var result;
	function sel_group(val){
		switch(val){
		case 'select_group_all':
		case 'select_group_new':
		case 'select_group_join':
		case 'select_group_my':
			$.get('cafeSearch.ajax?select=' + val , function(data){
				result = $.parseJSON(data);
				$.each(result, function(){
					var temp = this.title + this.name + this.date;
					$('#ajax_result').text($('#ajax_result').text() + temp);
				});
			});
			break;
		}
	}
	
	// 선택된 그룹 선택 탭 클레스 추가
	function select_group(val){
		
	}

</script>
</head>
<body>
<header>
	<!-- 모임 이미지 등등 -->
</header>
	<!-- 로그인 정보 출력 -->
<aside id="info_member">
	<jsp:include page="info_member.jsp"></jsp:include>
</aside>
	<!-- 전체 그룹 표시  -->
<section id="groups">
	<nav id="group_section">
		<a id="select_group_all" onclick="sel_group(id)">전체 카페</a>
		<a id="select_group_new" onclick="sel_group(id)">새 카페</a>
		<a id="select_group_join" onclick="sel_group(id)">가입한 카페</a>
		<a id="select_group_my" onclick="sel_group(id)">내 카페</a>
	</nav>
	<input id="search" type="text" autofocus="autofocus"/><br>
	<div id="cafe_list">
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
	</div>
	<div id="ajax_result">
	
	</div>
</section>
<footer>
	<!-- 만든이 정보 혹은 바로가기 링크 -->
	만든이 : 김희택 <address>010-6688-2199</address>
</footer>
</body>
</html>