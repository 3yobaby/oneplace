package com.oneplace.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.data.Cafe;
import com.oneplace.data.Member;
import com.util.kht.DAO;
import com.util.kht.SampleData;

@SuppressWarnings("unchecked")
public class CafeDAO extends DAO{
	private SampleData data = SampleData.getInstance();
	public CafeDAO() {}
	
	public JSONArray getSample(){
		JSONArray arr = data.getJSONArraySample();
		return arr;
	}

	public JSONArray getAllCafeList() {
		ArrayList<Cafe> list = data.getAllCafeList();
		JSONArray array = new JSONArray();
		for (Cafe cafe : list) {
			array.add(cafe.toJSONObject());
		}
		return array;
	}

	public JSONArray getCafeList(JSONObject member) {
		Member temp = data.getMember((String)member.get("id"));
		ArrayList<Cafe> list = temp.getCafeList();
		JSONArray array = new JSONArray();
		for (Cafe cafe : list) {
			array.add(cafe.toJSONObject());
		}
		return array;
	}
	
	public JSONObject getMyCafe(JSONObject member) {
		Member temp = data.getMember((String)member.get("id"));
		Cafe cafe = temp.getCafe();
		if(cafe != null)
			return cafe.toJSONObject();
		else return null;
	}
	
	public boolean isDupName(String cafeName) {
		return false;
	}

	public boolean isDupUri(String cafeUri) {
		return false;
	}

	public ArrayList<Cafe> getCafeBySearchWord(String word) {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		list = data.getCafeBySearchWord(word);
		return list;
	}
}
