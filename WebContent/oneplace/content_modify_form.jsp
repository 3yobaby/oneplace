<%@page import="com.oneplace.data.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>정보수정</h1>
<%
	Member member = (Member)request.getSession().getAttribute("member");
%>
<div>
<form>
아이디 : <input type="text" value="<%= member.getId()%>"/>
비름 : <input type="text" value="<%= member.getName()%>"/>
</form>
</div>