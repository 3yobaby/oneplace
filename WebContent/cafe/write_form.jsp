<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "content",
	    sSkinURI: "cafe/se/SmartEditor2Skin.html",
	    fCreator: "createSEditor2"
	});
	function content_write_submit(){
		var data = {};
		data.title = $('form')[0].title.value;
		data.content = oEditors.getById['content'].getContents();
		data.category = category;
		data.reference = 0;
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		$.post('make_board.ajax', data, function(result){
			if(result == "true"){
				$.post('cafe/content_board.jsp?category_name=',function(page){
					$('#contents').html(page);
				});
			}
		});
		return false;
	}
</script>
<h2>글쓰기</h2>
<form>
	<input type="text" id="title" name="title" placeholder="제목" size="40"/><br>
	<textarea name="content" id="content" rows="10" cols="100"></textarea>
	<input type="button" onclick="content_write_submit()" value="확인"/>
	<input type="button" value="취소"/>
</form>