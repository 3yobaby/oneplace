package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.application.Application;
import com.oneplace.database.get.CafeDB;
import com.oneplace.database.get.CafeMemberDB;
import com.util.kht.Ajax;

public class CafeAjax extends Ajax{
	@Override
	public void execute(String command, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
		/*
		전체 카페	get_all_cafe.ajax
		내가 가입한 카페	get_my_join_cafe.ajax
		내가 만든 카페	get_my_cafe.ajax
		전체 기관 카페	get_all_organization.ajax
		카페이름 중복 체크	cafe_name_dup_check.ajax
		검색어로 카페 찾기	get_all_cafe_by_word.ajax
		*/
		switch (command) {
		case "get_all_cafe.ajax":
			getAllCafe(request, response);
			break;
		case "get_joined_cafe.ajax":
			getJoinedCafe(request, response);
			break;
		case "get_my_cafe.ajax":
			getMyCafe(request, response);
			break;
		case "get_all_organization.ajax":
			getAllOrganization(request, response);
			break;
		case "get_all_cafe_by_word.ajax":
			getAllCafeByWord(request, response);
			break;
		case "cafe_name_dup_check.ajax":
			cafeNameDupCheck(request, response);
			break;
		case "get_organization.ajax":
			getOrganization(request, response);
			break;
		case "make_cafe.ajax":
			makeCafe(request, response);
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void makeCafe(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		json.put("manager_id", member.get("id"));
		json.put("organization_uri", request.getParameter("organization_uri"));
		json.put("detail", request.getParameter("detail"));
		json.put("name", request.getParameter("name"));
		json.put("search_words", request.getParameter("search_words"));
		json.put("is_search", request.getParameter("is_search"));
		json.put("join_rule", request.getParameter("join_rule"));
		json.put("uri", request.getParameter("uri")+".cafe");
		json.put("created", request.getParameter("created"));
		Application app = new Application();
		boolean b = app.makeCafe(json);
		submit(b, response);
	}

	@SuppressWarnings("unchecked")
	private void getOrganization(HttpServletRequest request,
			HttpServletResponse response) {
		CafeDB db = new CafeDB();
		JSONObject cafe = db.getCafe(request.getParameter("name"));
		try{
			if(cafe.get("is_organization").equals("true")){
				JSONArray array = new JSONArray();
				array.add(cafe);
				submit(array, response);
			}else{
				submit("", response);
			}
		}catch(Exception e){}
		finally{
			db.close();
		}
	}

	// to search
	private void getAllCafe(HttpServletRequest request,
			HttpServletResponse response) {
		CafeDB db = new CafeDB();
		JSONArray array = db.getAllCafeArray();
		submit(array, response);
		db.close();
	}

	@SuppressWarnings("unchecked")
	private void getJoinedCafe(HttpServletRequest request,
			HttpServletResponse response) {
		CafeMemberDB db = new CafeMemberDB();
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		if(member == null){
			submit(false, response);
			return;
		}
		JSONArray temp = db.getJoinedCafeArray((String) member.get("id"));
		JSONArray result = new JSONArray();
		CafeDB cafedb = new CafeDB();
		for(int i=0; i<temp.size(); i++){
			JSONObject obj = (JSONObject) temp.get(i);
			result.add(cafedb.getCafeByUri((String)obj.get("cafe_uri")));
		}
		submit(result, response);
		db.close();
		cafedb.close();
	}

	@SuppressWarnings("unchecked")
	private void getMyCafe(HttpServletRequest request,
			HttpServletResponse response) {
		CafeMemberDB db = new CafeMemberDB();
		CafeDB cafedb = new CafeDB();
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		if(member == null){
			submit(false, response);
			return;
		}
		String id = (String) member.get("id");
		JSONObject cafe = cafedb.getMyCafe(id);
		JSONArray result = new JSONArray();
		result.add(cafe);
		submit(result, response);
		db.close();
		cafedb.close();
	}

	private void getAllOrganization(HttpServletRequest request,
			HttpServletResponse response) {
		CafeDB db = new CafeDB();
		JSONArray array = db.getAllOrganizationArray();
		submit(array, response);
		db.close();
	}

	private void cafeNameDupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		CafeDB db = new CafeDB();
		JSONObject cafe = db.getCafe(request.getParameter("name"));
		if(cafe == null)
			submit(false, response);
		else submit(true, response);
		db.close();
	}
	
	private void getAllCafeByWord(HttpServletRequest request,
			HttpServletResponse response) {
		CafeDB db = new CafeDB();
		String word = request.getParameter("word");
		JSONArray array = db.getCafeArrayBySearchWord(word);
		submit(array, response);
		db.close();
	}
}