<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="content_manage_member">
<script>
	var $members;
	$.get('get_all_cafe_member.ajax', function(result){
		$members = $.parseJSON(result);
		var $content = $('#content_manage_member_list');
		$.each($members, function(index, member){
			$content.append('<p>아이디 : '+member.member_id+'</p>');
			$content.append('<p>회원상태 : '+member.member_type+'</p>');
			$content.append('<button onclick="content_manage_member_get_out('+index+')">회원 탈퇴</button>');
			$content.append('<br>');
		});
	});
	function content_manage_member_get_out(index){
		$.get('remove_member.ajax?id='+$members[index].member_id ,function(){
			var cof = confirm("정말?");
			if(cof == true){
				$.get('cafe/content_manage_member.jsp',function(page){
					$('#contents').html(page);
				});
			}
		});
	}
</script>
	<fieldset>
		<legend>회원 목록</legend>
		<div id="content_manage_member_list">
		
		</div>
	</fieldset>
	<fieldset>
		<legend>카페 가입 신청</legend>
	</fieldset>
</div>