<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    	function content_cafe_make_form(){
    		$.get('oneplace/content_cafe_make_form.jsp', function(result){
    			$('#contents').html(result);
    		});
    	}
    </script>
<jsp:include page="content_cafe_list.jsp"></jsp:include>