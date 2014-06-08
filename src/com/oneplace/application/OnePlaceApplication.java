package com.oneplace.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oneplace.dao.CafeDAO;
import com.oneplace.data.Cafe;
import com.util.kht.Application;


public class OnePlaceApplication extends Application{
	private Map<Integer, Cafe> cafeMap;
	private List<Cafe> cafeList;
	public OnePlaceApplication() {
		cafeMap = new HashMap<Integer, Cafe>();
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
		cafeMap = dao.getAllCafeMap();
	}
	
	// 최근 카페 순으로 찾아준다
	public ArrayList<Cafe> getNewCafeList(int size){
		ArrayList<Cafe> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(this.cafeList.get(i));
		}
		return list;
	}
	
	public Cafe getCafe(int cafeKey){
		return cafeMap.get(cafeKey);
	}
	
	// 전체 카페 선택시 반환하는 카페 목록
	public ArrayList<Cafe> getCafeAll() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		for (int i = 0; i < 10; i++) {
			list.add(cafeList.get(i));
		}
		return list;
	}
}
