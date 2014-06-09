package com.oneplace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.action.MemberAction;
import com.util.kht.Action;
import com.util.kht.Forward;
import com.util.kht.RequestURIParser;


@WebServlet("*.do")
public class ActionController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = RequestURIParser.getAction(request); // command = "/action.bo"
		Forward forward = null;
		Action action;
		switch(command){	
		case "join.do":
		case "logout.do":
		case "modify_member.do":
			action = new MemberAction();
			forward = action.execute(command, request, response);
			break;
		}
		if(forward == null)
			return;
		if(forward.isForwarding()){
			request.getRequestDispatcher(forward.getPath()).forward(request, response);
		}else{
			response.sendRedirect(forward.getPath());
		}
	}
}