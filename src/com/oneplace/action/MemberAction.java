package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.application.OnePlaceApplication;
import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.util.kht.Action;
import com.util.kht.Application;
import com.util.kht.Forward;

public class MemberAction extends Action{
	public MemberAction() {}

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
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
		request.getSession().setAttribute("member", null);
		forward.setPath("./");
	}
	
	private void join(HttpServletRequest request,
			HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		Member member = new Member();
		member.setId(request.getParameter("join_id"));
		member.setPass(request.getParameter("join_pass"));
		member.setEmail(request.getParameter("join_email"));
		member.setName(request.getParameter("join_name"));
		member.setTel(request.getParameter("join_tel"));
		boolean bool = dao.addMember(member);
		if(bool){ // 가입 성공
			request.getSession().setAttribute("join_result", true);
		}else{ // 가입 실패
			request.getSession().setAttribute("join_result", false);
		}
		forward.setPath("./");
	}
}
