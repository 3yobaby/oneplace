package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.util.kht.Ajax;

public class CategoryAjax extends Ajax{

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "get_all_category.ajax":
			getAllCategory(request, response);
			break;
		}
	}

	private void getAllCategory(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = (JSONArray) request.getSession().getAttribute("categories");
		submit(array, response);
	}
	
}