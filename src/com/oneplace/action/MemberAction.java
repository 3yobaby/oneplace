package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.application.OnePlace;
import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.oneplace.util.Action;
import com.oneplace.util.Forward;

public class MemberAction extends Action{
	private OnePlace app;
	public MemberAction(OnePlace app) {
		this.app = app;
	}

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/login.do":
			login(request, response);
			break;
		}
		return forward;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		Member member = dao.login(request.getParameter("login_id"), 
				request.getParameter("login_pass"));
		if(member != null){
			request.getSession().setAttribute("member", member);
			app.login(request.getSession().getId(), member);
			forward.setPath("./");
		}else{
			// 로그인 실패 페이지
		}
		forward.setPath("./");
	}
}
