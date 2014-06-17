package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.oneplace.database.get.CategoryDB;
import com.util.kht.Ajax;

public class CategoryAjax extends Ajax{

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "get_all_category.ajax":
			getAllCategory(request, response);
		case "modify_category.ajax":
			modifyCategory(request, response);
			break;
		}
	}
	
	private void modifyCategory(HttpServletRequest request,
			HttpServletResponse response) {
		int pk = Integer.valueOf(request.getParameter("pk"));
		String name = request.getParameter("name");
		String visibility = request.getParameter("visibility");
		CategoryDB db = new CategoryDB();
		int result = db.updateCategory(pk, name, visibility);
		if(result == 1)
			submit(true, response);
		else submit(false, response);
	}



	private void getAllCategory(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray array = (JSONArray) request.getSession().getAttribute("categories");
		submit(array, response);
	}
	
}