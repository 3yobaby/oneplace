package com.oneplace.ajax;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.database.get.BoardDB;
import com.util.kht.Ajax;

public class BoardAjax extends Ajax{
	@Override
	public void execute(String command, HttpServletRequest request,
			HttpServletResponse response) {
		switch(command){
		case "get_all_board.ajax":
			getAllBoard(request,response);
			break;
		case "get_category_board.ajax":
			getCategoryBoard(request, response);
			break;
		case "make_board.ajax":
			makeBoard(request, response);
			break;	
		}
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
			}else{
				// 일치하는 카테고리가 없음
				System.out.println("카테고리 없음");
				return;
			}
		}
		//
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		String name = (String) member.get("name");
		String id = (String) member.get("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("test");
		submit(db.insertBoard(categoryPk, id, name, title, content), response);
		db.close();
	}

	private void getCategoryBoard(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String categoryName = request.getParameter("category_name");
			JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
			for(int i=0; i< categories.size(); i++){
				JSONObject category = (JSONObject) categories.get(i);
				if(category.get("name").equals(categoryName)){
					BoardDB db = new BoardDB();
					JSONArray result = db.getAllBoardArray((Integer)category.get("pk"));
					submit(result, response);
				}else{
					// 세션에 없는 카테고리 요청
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}


	@SuppressWarnings("unchecked")
	private void getAllBoard(HttpServletRequest request,
			HttpServletResponse response) {
		// 접속된 카페의 정보와, 사용자의 카페의 권한을 확인 후 돌려준다
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		JSONArray temp = (JSONArray) categories.clone();
		BoardDB db = new BoardDB();
		for(int i=0; i<temp.size(); i++){
			JSONObject json = (JSONObject) categories.get(i);
			int pk = (int) json.get("pk");
			json.put("boards",db.getAllBoardArray(pk));
		}
		submit(temp, response);
		db.close();
	}

	

}
