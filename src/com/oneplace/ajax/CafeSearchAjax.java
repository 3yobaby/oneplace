package com.oneplace.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.dao.CafeDAO;
import com.oneplace.data.Cafe;
import com.util.kht.Ajax;
import com.util.kht.DAO;

@SuppressWarnings("unchecked")
public class CafeSearchAjax extends Ajax{
	public CafeSearchAjax() {}

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "cafeSearch.ajax":
			search(request, response);
			break;
		case "search_cafe_by_word.ajax":
			searchCafeByWord(request,response);
			break;
		}
	}
	
	private void search(HttpServletRequest request,
			HttpServletResponse response){
		DAO dao;
		JSONObject member;
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		switch(request.getParameter("select")){
		case "select_group_all":
			dao = new CafeDAO();
			array = ((CafeDAO)dao).getAllCafeList();
			break;
		case "select_group_join":
			member = (JSONObject) request.getSession().getAttribute("member");
			if(member == null){
				break;
			}
			dao = new CafeDAO();
			array = ((CafeDAO) dao).getCafeList(member);
			break;
		case "select_group_my":
			member = (JSONObject) request.getSession().getAttribute("member");
			if(member == null){
				break;
			}
			dao = new CafeDAO();
			json = ((CafeDAO) dao).getMyCafe(member);
			array.add(json);
			break;
		}
		submit(array.toString(), response);
	}
	
	private void searchCafeByWord(HttpServletRequest request,
			HttpServletResponse response) {
		String word = request.getParameter("word");
		CafeDAO dao = new CafeDAO();
		ArrayList<Cafe> list = dao.getCafeBySearchWord(word);
		JSONArray array = new JSONArray();
		for (Cafe cafe : list) {
			array.add(cafe.toJSONObject());
		}
		submit(array.toString(), response);
	}

}
