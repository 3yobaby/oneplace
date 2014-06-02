package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.action.MemberAction;
import com.oneplace.ajax.CafeSearchAjax;
import com.oneplace.ajax.MemberAjax;
import com.oneplace.application.OnePlace;
import com.oneplace.util.Forward;

public class OnePlaceController {
	private OnePlace app;
	private CafeSearchAjax cafeSearchAjax;
	private MemberAjax memberAjax;
	private MemberAction memberAction;
	public OnePlaceController() {
		app = new OnePlace();
		cafeSearchAjax = new CafeSearchAjax(app);
		memberAjax = new MemberAjax(app);
		memberAction = new MemberAction(app);
	}

	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		Forward forward = null;
		switch(command){	
		case "/login.do":
			forward = memberAction.execute(command, request, response);
			break;
		case "/logout.do":
			forward = memberAction.execute(command, request, response);
			break;
		}
		return forward;
	}

	public void executeAjax(String command, HttpServletRequest request,
			HttpServletResponse response) {
		String path = null;
		switch(command){
		case "/cafeSearch.ajax":
			cafeSearchAjax.execute(command, request, response);
			path = "WEB-INF/session/search_result.jsp";
			break;
		case "/join.ajax":
			memberAjax.execute(command, request, response);
			path = "content_join_form.jsp";
			break;
		}
		try {
			request.getRequestDispatcher(path).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
