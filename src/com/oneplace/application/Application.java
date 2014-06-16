package com.oneplace.application;

import org.json.simple.JSONObject;

import com.oneplace.database.get.CafeDB;
import com.oneplace.database.get.CategoryDB;

public class Application {
	public Application() {}
	private String[] defaultCategoryName = {"기본 카테고리","기본 카테고리2"};
	@SuppressWarnings("unchecked")
	public boolean makeCafe(JSONObject json) {
		// 유효성 검사
		//
		CafeDB db = new CafeDB();
		json.put("is_organization", "false");
		db.insertCafe((String)json.get("manager_id"), (String)json.get("organization_uri"), (String)json.get("detail"),
				(String)json.get("name"), (String)json.get("uri"), (String)json.get("search_words"), (String)json.get("is_search"), 
				(String)json.get("is_organization"), Integer.valueOf((String)json.get("join_rule")));
		db.close();
		// Generate Default Category
		CategoryDB cdb = new CategoryDB();
		for(String categoryName : defaultCategoryName){
			cdb.insertCategory((String)json.get("uri"), categoryName, "default", "all");	
		}
		return false;
	}
	public JSONObject getDefaultMember(){
		JSONObject member = new JSONObject();
		return member;
	}
}
