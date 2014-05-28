package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.oneplace.util.Action;
import com.oneplace.util.Forward;

public class Login extends Action{
	
	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * 로그인 정보 확인
		 */
		HttpSession session = request.getSession();
		String id = request.getParameter("login_id");
		String pass = request.getParameter("login_pass");
		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, pass);
		if(member != null){ // 로그인 성공
			setForwarding(true);
			setPath("/WEB-INF/main.jsp");
			session.setAttribute("login_member", member);
		}else{
			setPath("./");
		}
		return forward;
	}
}
