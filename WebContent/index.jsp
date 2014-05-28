<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	padding : 100px;
	text-align : center;
}
#join {
	float : left;
}

#find{
	color : #bbb;
	float : right;
}
fieldset{
	border-color : #aaa;
	display : inline-block;
}
#login_id, #login_pass{
	float : left;
	width : 100%;
}
#login_btn{
	width : 100%;
}
</style>
<script>

</script>
</head>
<body>
<h1>Welcome!</h1>
<fieldset>
		<a id="join" href="join_form.html">회원가입</a>
		<a id="find" href="inquiry.html">아이디/비밀번호 찾기</a><br>
	<form method="get" action="login.do">
		<input type="text" id="login_id" name="login_id" placeholder="아이디"/><br>
		<input type="password" id="login_pass" name="login_pass" placeholder="비밀번호"/><br>
		<input type="submit" id="login_btn" value="로그인"/><br>
	</form>
</fieldset>
</body>
</html>