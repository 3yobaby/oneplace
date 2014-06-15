package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.database.get.BoardDB;
import com.util.kht.Ajax;
import com.util.kht.JSONArraySerializer;

public class BoardAjax extends Ajax{

	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "get_all_board.ajax":
			getAllBoard(request,response);
			break;
		case "get_board.ajax":
			getBoard(request, response);
			break;
		case "make_board.ajax":
			makeBoard(request, response);
			break;	
		case "get_all_my_board.ajax":
			getAllMyBoard(request, response);
			break;
		}
	}

	
	@SuppressWarnings("unchecked")
	private void getAllBoard(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		JSONArray array = new JSONArray();
		BoardDB db = new BoardDB();
		for(int i=0; i<categories.size(); i++){
			JSONObject category = (JSONObject)categories.get(i);
			int key = (int) category.get("pk");
			array.add(db.getAllBoardArray(key));
		}
		db.close();
		submit(JSONArraySerializer.serialize(array), response);
	}

	// 카페 내에서 내가 쓴 글 확인
	@SuppressWarnings("unchecked")
	private void getAllMyBoard(HttpServletRequest request,
			HttpServletResponse response) {
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		JSONArray array = new JSONArray();
		for(int i=0; i< categories.size(); i++){
			JSONObject category = (JSONObject) categories.get(i);
			int pk = (int) category.get("pk");
			BoardDB db = new BoardDB();
			array.add(db.getAllBoardArray(pk, (String)member.get("id")));
		}
		submit(JSONArraySerializer.serialize(array), response);
	}

	private void makeBoard(HttpServletRequest request,
			HttpServletResponse response) {
		BoardDB db = new BoardDB();
		//
		String categoryTitle = request.getParameter("category");
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		int categoryPk = 0;
		for(int i=0 ;i<categories.size(); i++){
			JSONObject json = (JSONObject) categories.get(i);
			if(json.get("name").equals(categoryTitle)){
				categoryPk = (int) json.get("pk");
			}
		}
		//
		if(categoryPk == 0){ // 카테고리 없음 
			submit(false, response);
			System.out.println("카테고리 없음");
			return;
		}
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		String name = (String) member.get("name");
		String id = (String) member.get("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		submit(db.insertBoard(categoryPk, id, name, title, content), response);
		db.close();
	}

	private void getBoard(HttpServletRequest request,
			HttpServletResponse response) {
		// 접속된 카페의 정보와, 사용자의 카페의 권한을 확인 후 돌려준다
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		JSONArray result = null;
		String name = request.getParameter("category");
		for(int i=0; i<categories.size(); i++){
			JSONObject category = (JSONObject)categories.get(i);
			if(category.get("name").equals(name)){
				BoardDB db = new BoardDB();
				result = db.getAllBoardArray((int) category.get("pk"));
				db.close();
			}
		}
		submit(result, response);
	}

}
