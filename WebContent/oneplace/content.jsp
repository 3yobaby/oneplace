<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(request.getSession().getAttribute("content") == null)
		request.getSession().setAttribute("content", "content_cafe_list");
	String content = (String)request.getSession().getAttribute("content");
	if(content.equals("content_cafe_list")){
		%> 
			<jsp:include page="content_cafe_list.jsp"></jsp:include>
		<%
	}
%>