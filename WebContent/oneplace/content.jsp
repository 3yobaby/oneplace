<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    #contents {
    	width : 70%;
    }
   	#contents > button {
   		clear : right;
   		float : right;
   	}
    </style>
    <script>
    	function content_cafe_make_form(){
    		$.get('oneplace/content_cafe_make_form.jsp', function(result){
    			$('#contents').html(result);
    		});
    	}
    </script>
<% 
	if(request.getSession().getAttribute("content") == null)
		request.getSession().setAttribute("content", "content_cafe_list");
	String content = (String)request.getSession().getAttribute("content");
	if(content.equals("content_cafe_list")){
		%> 
			<jsp:include page="content_cafe_list.jsp"></jsp:include>
			<button onclick="content_cafe_make_form()">카페 만들기</button>
		<%
		
	}
%>
