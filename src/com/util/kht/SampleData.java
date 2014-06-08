package com.util.kht;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.data.Cafe;
import com.oneplace.data.Member;

public class SampleData {

	public HashMap<Integer, Cafe> getCafeHashMap() {
		HashMap<Integer, Cafe> map = new HashMap<Integer, Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("서버에 등록된 카페 맵" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			map.put(cafe.getKey(), cafe);
		}
		return map;
	}

	public ArrayList<Cafe> getCafeList() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("테스트 소속 카페" + i);
			cafe.setDetail("테스트 소속 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			list.add(cafe);
		}
		return list;
	}

	public ArrayList<Cafe> getMyCafeList() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("내가 만든 카페 목록" + i);
			cafe.setDetail("테스트 내 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			list.add(cafe);
		}
		return list;
	}

	public ArrayList<Cafe> getCafeBySearchWord(String word) {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("검색결과 카페" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			list.add(cafe);
		}
		return list;
	}

	public ArrayList<Cafe> getAllCafeList() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			Cafe cafe = new Cafe();
			cafe.setTitle("서버에 등록된 카페 리스트" + i);
			cafe.setDetail("테스트 카페 " + i);
			cafe.setDate(new Date(System.currentTimeMillis()));
			cafe.setManagerKey(i);
			cafe.setManagerName("김희택" + i);
			list.add(cafe);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getJSONArraySample() {
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

	public boolean isDupName(String orgName) {
		System.out.println(this + " isDUpName is not implemented");
		return false;
	}

	public Member getLoginMember() {
		Member member = new Member();
		member.setId("testid");
		member.setName("테스트 회원");
		return member;
	}
	
}
