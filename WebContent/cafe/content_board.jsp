<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JSONArray boards = (JSONArray)session.getAttribute("boards");
JSONObject category = (JSONObject)session.getAttribute("category");
%>
    <style>
	#content_board table {
		
	}
	#content_board #search_form{
		display: inline;
	}
	
	#board_title {
		cursor: default;
	}
</style>
<div id="content_board">
<script>
	function select_title(tag){
		$(tag).parent().parent().next().children().toggleClass('hide');
	}
	function reply(pk){
		$.get('cafe/content_write_form.jsp',function(page){
			alert(page);
			$('#write_form').html(page);
		});
	}
	
	function select_reply(pk){
		$.get('', function(){
			
		});
	}
	function write_board(){
		$.get('cafe/content_write_form.jsp', function(page){
			$('#write_form').html(page);	
		});
	}
</script>
<h2 id="content_board_category_title"><%= category.get("name")%></h2>
	<div id="write_form"></div>
	<div id="board_detail">
		<table border="1">
		<tr>
			<td>제목</td>
			<td>아이디</td>
			<td>이름</td>
			<td>답글</td>
			<td>날짜</td>
		</tr>
		<%for(int i=0; i<boards.size(); i++){ 
			JSONObject board = (JSONObject)boards.get(i);
		%>
		<tr>
			<td id="board_title">
				<span onclick="select_title(this)"><%= board.get("title") %></span>
			</td>
			<td id="board_id">
				<span><%= board.get("id") %></span>
			</td>
			<td id="board_name">
				<span><%= board.get("name") %></span>
			</td>
			<td id="board_replies">
				<span onclick="select_reply(<%= board.get("id") %>)"><%= board.get("replies") %></span>
			</td>
			<td id="board_date">
				<span><%= board.get("created") %></span>
			</td>
		</tr>
		<tr>
			<td id="board_content" class='hide' colspan='4'>
				<span><%= board.get("content") %>
					<input type="button" onclick="reply(<%= board.get("pk") %>)" value="답글달기"/>
				</span>
			</td>
		</tr>
		<%} %>
		</table>
	</div>
	<!-- 검색 -->
	<select id="search_select">
		<option value="title">제목</option>
		<option value="id">아이디</option>
		<option value="name">이름</option>
	</select>
	<form id="search_form" onsubmit="return search_content(search_select.value, search_word.value)" >
		<input id="search_word" type="search" placeholder="검색"/>
		<input type="submit" value="검색"/>
	</form>
	<button onclick="write_board()">글쓰기</button>
</div>