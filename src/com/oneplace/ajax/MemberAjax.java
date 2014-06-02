package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.application.OnePlace;
import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.oneplace.util.Ajax;

public class MemberAjax extends Ajax{
	private MemberDAO dao;
	private OnePlace app;
	public MemberAjax(OnePlace app) {
		this.app = app;
	}
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/join.ajax":
			join(request, response);
			break;
		}
	}
	
	private void join(HttpServletRequest request,
			HttpServletResponse response) {
		Member member = new Member();
		member.setId(request.getParameter("login_id"));
		member.setPass(request.getParameter("join_pass"));
		member.setEmail(request.getParameter("join_email"));
		member.setName(request.getParameter("join_name"));
		member.setTel(request.getParameter("join_tel"));
		boolean bool = dao.join(member);
		if(bool){ // 가입 성공
			request.getSession().setAttribute("join_result", true);
		}else{ // 가입 실패
			request.getSession().setAttribute("join_result", false);
		}
	}

}
