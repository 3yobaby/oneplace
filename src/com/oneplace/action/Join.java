package com.oneplace.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oneplace.data.Member;
import com.oneplace.util.Action;
import com.oneplace.util.Forward;

public class Join extends Action{

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * 중복확인
		 */
		
		Member member = new Member();
		member.setId(request.getParameter("join_id"));
		member.setPass(request.getParameter("join_pass"));
		member.setEmail(request.getParameter("join_email"));
		member.setName(request.getParameter("join_name"));
		member.setTel(request.getParameter("join_tel"));
		
		return forward;
	}
	
}
