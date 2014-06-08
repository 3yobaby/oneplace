package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.dao.MemberDAO;
import com.util.kht.Ajax;

public class MemberAjax extends Ajax{
	public MemberAjax() {}
	@SuppressWarnings("unchecked")
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/join_id_check.ajax":
			MemberDAO dao = new MemberDAO();
			boolean result = dao.isDuplicatedId(request.getParameter("join_id"));
			JSONObject json = new JSONObject();
			json.put("join_id_check", result);
			submit(json.toString(), response);
			break;
		case "/id_pass_find.ajax":
			idFind(request, response);
			break;
		case "/login.ajax":
			login(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		JSONObject json = dao.login(request.getParameter("id"), request.getParameter("pass"));
		if(json != null){
			submit("true", response);
			request.getSession().setAttribute("member", json);
		}else{
			submit("false", response);
		}
	}
	@SuppressWarnings("unchecked")
	private void idFind(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		JSONObject json = new JSONObject();
		boolean b = dao.hasMemberByEmail(request.getParameter("email"));
		if(b){
			json.put("result", true);
			submit(json.toString(), response);
		}else{
			json.put("result", false);
			submit(json.toString(), response);
		}
	}
}
