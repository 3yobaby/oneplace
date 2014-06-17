package com.oneplace.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oneplace.database.get.BoardDB;
import com.oneplace.database.get.CategoryDB;
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
		case "reply_board.ajax":
			replyBoard(request, response);
			break;
		}
	}

	private void replyBoard(HttpServletRequest request,
			HttpServletResponse response) {
		String content = request.getParameter("content");
		String pk = request.getParameter("pk");
		String title = request.getParameter("title");
		// member
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		if(member == null)
			return;
		String id = (String) member.get("id");
		String name = (String) member.get("name");
		BoardDB db = new BoardDB();
		// 원래 글의 replies, replied 갱신
		db.updateReply(Integer.valueOf(pk), id, name, title, content);
		db.close();
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
		array = JSONArraySerializer.serialize(array);
		request.getSession().setAttribute("boards", array);
		submit(true, response);
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
		//
		JSONArray categories = (JSONArray) request.getSession().getAttribute("categories");
		String categoryPk = request.getParameter("category_pk");
		JSONObject member = (JSONObject) request.getSession().getAttribute("member");
		String name = (String) member.get("name");
		String id = (String) member.get("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 유효성
		for(int i=0; i<categories.size(); i++){
			JSONObject category = (JSONObject)categories.get(i);
			if(Integer.valueOf(categoryPk).equals(category.get("pk"))){
				BoardDB db = new BoardDB();
				db.insertBoard(Integer.valueOf(categoryPk), id, name, title, content);
				submit(true, response);
				db.close();
				return;
			}
		}
		submit(false, response);
	}

	private void getBoard(HttpServletRequest request,
			HttpServletResponse response) {
		int categoryPk = Integer.valueOf(request.getParameter("pk"));
		BoardDB db = new BoardDB();
		HttpSession session = request.getSession();
		JSONArray result = db.getAllBoardArray(categoryPk);
		CategoryDB cdb = new CategoryDB();
		JSONObject category = cdb.getCategoryObject(categoryPk);
		session.setAttribute("category", category);
		session.setAttribute("boards", result);
		if(result != null){
			submit(true, response);
		}else{
			submit(false, response);
		}
		db.close();
	}

}
