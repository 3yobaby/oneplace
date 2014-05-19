<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align : center;
}
</style>
</head>
<body>
<h1>Welcome!</h1>
	<form method="get" action="Login.do">
		아이디 : <input type="text" name="login_id"/><br>
		비밀번호 : <input type="password" name="login_pass"/>
		<input type="submit" value="로그인"/><br>
		저장하기
		아이디<input type="checkbox" checked="checked" name="save_id"/> 
		비밀번호<input type="checkbox" name="save_id"/><br>
		<a href="join.html">가입하기</a><br>
		<a href="Login.do">둘러보기</a>
	</form>
</body>
</html>