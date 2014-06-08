package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oneplace.dao.CafeDAO;
import com.oneplace.dao.OrgDAO;
import com.util.kht.Ajax;

public class CafeAjax extends Ajax{
	@Override
	public void execute(String command, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		switch(command){
		case "/cafe_name_check.ajax":
			nameDupCheck(request, response);
			break;
		}
	}

	
	@SuppressWarnings("unchecked")
	private void nameDupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		String cafeName = request.getParameter("cafe_name");
		String orgName = request.getParameter("org_name");
		String cafeAddr = request.getParameter("cafe_uri");
		CafeDAO cafedao = new CafeDAO();
		OrgDAO orgdao = new OrgDAO();
		boolean b1 = cafedao.isDupName(cafeName);
		boolean b2 = orgdao.isDupName(orgName);
		boolean b3 = cafedao.isDupUri(cafeAddr);
		JSONObject json = new JSONObject();
		json.put("cn_check", !b1);
		json.put("on_check", !b2);
		json.put("ca_check", !b3);
		submit(json.toString(), response);
	};
}