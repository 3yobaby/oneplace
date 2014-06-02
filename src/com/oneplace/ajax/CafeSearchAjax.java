package com.oneplace.ajax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.oneplace.application.OnePlace;
import com.oneplace.data.Cafe;
import com.oneplace.util.Ajax;
import com.oneplace.util.Forward;

public class CafeSearchAjax extends Ajax{
	private OnePlace app;
	public CafeSearchAjax(OnePlace app) {
		this.app = app;
	}

	@Override
	public Forward execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "/cafeSearch.ajax":
			search(request, response);
			break;
		}
		return forward;
	}
	
	@SuppressWarnings("unchecked")
	private void search(HttpServletRequest request,
			HttpServletResponse response){
		ArrayList<Cafe> list;
		JSONArray array = new JSONArray();
		switch(request.getParameter("select")){
		case "select_group_all":
			break;
		case "select_group_new":
			list = app.getCafeList(10);
			for (Cafe cafe : list) {
				array.add(cafe.getJson());
			}
			break;
		case "select_group_join":
			break;
		case "select_group_my":
			break;
		}
		request.getSession().setAttribute("search_result", array.toString());
	}
}