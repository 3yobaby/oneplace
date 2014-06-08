package com.oneplace.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;

import com.oneplace.data.Cafe;
import com.oneplace.data.Member;
import com.util.kht.DAO;
import com.util.kht.SampleData;

public class CafeDAO extends DAO{
	private SampleData data = new SampleData();
	public CafeDAO() {}
	
	public JSONArray getSample(){
		JSONArray arr = data.getJSONArraySample();
		return arr;
	}

	public HashMap<Integer, Cafe> getAllCafeMap() {
		HashMap<Integer, Cafe> map = data.getCafeHashMap();
		return map;
	}

	// 시간순
	public ArrayList<Cafe> getAllCafeList() {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		list = data.getAllCafeList();
		return list;
	}

	// 소속된
	public ArrayList<Cafe> getCafeList(Member member) {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		list = data.getCafeList();
		return list;
	}
	
	// 직접 만든
	public ArrayList<Cafe> getMyCafeList(Member member) {
		ArrayList<Cafe> list = new ArrayList<Cafe>();
		list = data.getMyCafeList();
		return list;
	}

	// search
	public ArrayList<Cafe> getNewCafeList(int size) {
		return getAllCafeList();
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
