package com.oneplace.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class CafeDAO {
	@SuppressWarnings("unchecked")
	public JSONArray getSample(){
		JSONArray arr = new JSONArray();
		// json1
		JSONObject json1 = new JSONObject();
		json1.put("title", "제목 1");
		json1.put("name", "김희택");
		json1.put("date", "2014-01-27");
		arr.add(0, json1);
		// json2
		JSONObject json2 = new JSONObject();
		json2.put("title", "제목 2");
		json2.put("name", "이한일");
		json2.put("date", "2014-03-22");
		arr.add(1, json2);
		return arr;
	}
}
