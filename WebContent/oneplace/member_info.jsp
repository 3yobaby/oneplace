<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("member") == null){
		%>
			<jsp:include page="member_login.jsp"></jsp:include>			
		<%
	}else{
		%>
			<jsp:include page="member_login_ok.jsp"></jsp:include>	
		<%
	}
%>