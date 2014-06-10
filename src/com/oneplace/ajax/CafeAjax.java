package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.dao.CafeDAO;
import com.util.kht.Ajax;

@SuppressWarnings("unchecked")
public class CafeAjax extends Ajax{
	private CafeDAO cafedao = new CafeDAO();
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
		case "get_my_join_cafe.ajax":
			getMyJoinCafe(request, response);
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
		}
	}

	private void getAllCafe(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = cafedao.getAllCafe();
		submit(array, response);
	}
	
	private void getMyJoinCafe(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = (JSONArray) request.getAttribute("cafe_list");
		JSONArray result = new JSONArray();
		for(int i=0; i< array.size(); i++){
			result.add(cafedao.getCafeByUri((String)array.get(i)));
		}
		submit(result, response);
	}

	private void getMyCafe(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		try{
			String uri = (String) member.get("cafe");
			JSONObject cafe = cafedao.getCafeByUri(uri);
			submit(cafe, response);
		}catch(NullPointerException e){
			e.printStackTrace();
			submit(new JSONArray(), response);
		}
	}

	private void getAllOrganization(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = cafedao.getAllOrganization();
		submit(array, response);
	}

	private void cafeNameDupCheck(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject cafe = cafedao.getCafe(request.getParameter("name"));
		if(cafe == null)
			submit(false, response);
		else submit(true, response);
	}
	
	private void getAllCafeByWord(HttpServletRequest request,
			HttpServletResponse response) {
		String word = request.getParameter("word");
		CafeDAO dao = new CafeDAO();
		JSONArray array = dao.getCafeBySearchWord(word);
		submit(array, response);
	}
}