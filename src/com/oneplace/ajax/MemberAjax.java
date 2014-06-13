package com.oneplace.ajax;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.database.get.MemberDB;
import com.util.kht.Ajax;

public class MemberAjax extends Ajax{
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
		case "logout.ajax":
			logout(request, response);
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
		case "join.ajax":
			join(request, response);
			break;
		}
	}
	
	
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("member", null);
		submit(true, response);
	}

	private void join(HttpServletRequest request, HttpServletResponse response) {
		// 가입시 유효성 체크
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		MemberDB db = new MemberDB();
		if(db.getMember("id") != null){
			submit(false, response);
		}else {
			db = new MemberDB();
			boolean b = db.addMember(id, pass, email, name, tel);
			submit(b, response);
		}
		db.close();
	}

	private void forgetId(HttpServletRequest request,
			HttpServletResponse response) {
		MemberDB db = new MemberDB();
		String email = request.getParameter("email");
		Map<String, JSONObject> map = db.getAllMember();
		for (JSONObject member : map.values()) {
			if(member.get("email").equals(email)){
				submit(true, response);
				return;
			}
		}
		submit(false, response);
		db.close();
	}

	private void idDupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		MemberDB db = new MemberDB();
		if(db.getMember(request.getParameter("id")) == null){
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
		MemberDB db = new MemberDB();
		JSONObject member = db.getMember(request.getParameter("id"));
		if(member != null && member.get("pass").equals(request.getParameter("pass"))){
			submit(true, response);
			request.getSession().setAttribute("member", member);
		}else{
			submit(false, response);
		}
		db.close();
	}
	
}
