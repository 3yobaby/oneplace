package com.oneplace.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.data.Cafe;


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

	public HashMap<Integer, Cafe> getAllCafe() {
		HashMap<Integer, Cafe> map = new HashMap<Integer, Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("cafe" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			map.put(cafe.getKey(), cafe);
		}
		return map;
	}

	// 시간순
	public ArrayList<Cafe> getAllCafeList() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("cafe" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			list.add(cafe);
		}
		return list;
	}
}
