<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="content_manage_category">
	<script>
		$.get('get_all_category.ajax', function(result){
			$.parseJSON(result);
			$('#content_manage_category').html(result);
		});
	</script>	
</div>