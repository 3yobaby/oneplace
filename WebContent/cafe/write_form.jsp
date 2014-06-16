<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var oEditors = [];
	/* nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "content",
	    sSkinURI: "cafe/se/SmartEditor2Skin.html",
	    fCreator: "createSEditor2"
	}); */
	function content_write_submit(){
		var temp = $('#write_form form').serialize();
		temp += "&pk=" + $board[0].pk;
		$.post('reply_board.ajax', temp, function(result){
			alert(result);
		})
		return false;
	}
	
	function write_form_cancel(){
		$('#write_form').html('');
	}
	$('#write_form #title').val('re : ' + $board[0].title);
</script>
<h2 id="write_form_header"></h2>
<form>
	<input type="text" id="title" name="title" placeholder="제목" size="40" readonly="readonly"/><br>
	<textarea name="content" rows="10" cols="100"></textarea>
	<input type="button" onclick="content_write_submit()" value="확인"/>
	<input type="button" value="취소" onclick="return write_form_cancel()"/>
</form>