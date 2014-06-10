package com.oneplace.ajax;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.dao.MemberDAO;
import com.oneplace.data.Member;
import com.util.kht.Ajax;

public class MemberAjax extends Ajax{
	private MemberDAO dao = new MemberDAO();
	public MemberAjax() {}
	
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		/*
			설명	Request	get Parameter	Post Parameter
			회원 정보 관련			
			아이디 중복체크	id_dup_check.ajax	id	
			이메일로 아이디 찾기	forget_id.ajax	email	
			비밀번호 확인	pass_check.ajax	pass	
			로그인	login.ajax	id, pass	
		 */
		switch(command){
		case "login.ajax":
			login(request, response);
			break;
		case "id_dup_check.ajax":
			idDupCheck(request, response);
			break;
		case "forget_id.ajax":
			forgetId(request, response);
			break;
		case "pass_check.ajax":
			passCheck(request, response);
			break;
		}
	}
	
	
	private void forgetId(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		Map<String, Member> map = dao.getAllMember();
		for (Member member : map.values()) {
			if(member.getEmail().equals(email)){
				submit(true, response);
				return;
			}
		}
		submit(false, response);
	}

	private void idDupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		if(dao.getMember(request.getParameter("id")) == null){
			submit(false, response);
		}else submit(true, response); // 중복
	}

	private void passCheck(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			JSONObject member = (JSONObject) request.getSession().getAttribute("member");
			if(member.get("pass").equals(request.getParameter("pass"))){
				submit(true, response);
			}
			else submit(false, response);
		}catch(NullPointerException ex){
			ex.printStackTrace();
			submit(false, response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = dao.getMember(request.getParameter("id"), request.getParameter("pass"));
		if(json != null){
			submit("true", response);
			request.getSession().setAttribute("member", json);
			request.getServletContext().setAttribute("member", json);
		}else{
			submit("false", response);
		}
	}
	
}
