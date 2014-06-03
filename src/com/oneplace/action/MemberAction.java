package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.application.OnePlace;
import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.util.kht.Action;
import com.util.kht.Forward;

public class MemberAction extends Action{
	private OnePlace app;
	private MemberDAO dao;
	public MemberAction(OnePlace app) {
		this.app = app;
		dao = MemberDAO.getInstance();
	}

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/login.do":
			login(request, response);
			break;
		case "/logout.do":
			logout(request, response);
			break;
		case "/join.do":
			join(request, response);
			break;
		}
		return forward;
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		app.logout(request.getSession().getId());
		request.getSession().setAttribute("member", null);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
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
	
	private void join(HttpServletRequest request,
			HttpServletResponse response) {
		Member member = new Member();
		member.setId(request.getParameter("join_id"));
		member.setPass(request.getParameter("join_pass"));
		member.setEmail(request.getParameter("join_email"));
		member.setName(request.getParameter("join_name"));
		member.setTel(request.getParameter("join_tel"));
		System.out.println(member);
		boolean bool = dao.join(member);
		if(bool){ // 가입 성공
			request.getSession().setAttribute("join_result", true);
		}else{ // 가입 실패
			request.getSession().setAttribute("join_result", false);
		}
		forward.setPath("./");
	}
}
