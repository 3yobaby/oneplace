package com.oneplace.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oneplace.dao.CafeDAO;
import com.oneplace.data.Cafe;
import com.oneplace.data.Member;
import com.util.kht.Application;


public class OnePlaceApplication extends Application{
	private Map<Integer, Cafe> cafeMap;
	private List<Cafe> cafeList;
	private Map<String, Member> memberMap;
	public OnePlaceApplication() {
		cafeMap = new HashMap<Integer, Cafe>();
		memberMap = new HashMap<String, Member>();
		loadCafeMap();
		
		cafeList = new ArrayList<Cafe>();
		loadCafeList();
	}
	
	private void loadCafeList() {
		CafeDAO dao = new CafeDAO();
		cafeList = dao.getAllCafeList();
	}

	private void loadCafeMap() {
		CafeDAO dao = new CafeDAO();
		cafeMap = dao.getAllCafe();
	}
	
	// 최근 카페 순으로 찾아준다
	public ArrayList<Cafe> getCafeList(int size){
		ArrayList<Cafe> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(this.cafeList.get(i));
		}
		return list;
	}
	
	public Cafe getCafe(int cafeKey){
		return cafeMap.get(cafeKey);
	}
	
	public void login(String sessionId, Member member) {
		memberMap.put(sessionId, member);
	}
	
	public void logout(String sessionId){
		memberMap.remove(sessionId);
	}
}
