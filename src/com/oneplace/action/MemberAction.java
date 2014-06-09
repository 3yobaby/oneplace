package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.dao.MemberDAO;
import com.util.kht.Action;
import com.util.kht.Forward;

public class MemberAction extends Action{
	public MemberAction() {}

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "logout.do":
			logout(request, response);
			break;
		case "modify_member.do":
			modify(request, response);
			break;
		case "join.do":
			join(request, response);
			break;
		}
		return forward;
	}

	private void join(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		if(member.get("pass").equals(request.getParameter("pass"))){
			MemberDAO dao = new MemberDAO();
			dao.modify(member);
		}
		forward.setPath("./");
		forward.setForwarding(false);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("member", null);
		forward.setPath("./");
	}	
}
