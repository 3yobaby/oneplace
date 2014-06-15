package com.oneplace.database.get;

import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

public class BoardDB extends DatabaseConnector{
//	  pk number primary key,
//	  fk_category number,
//	  id varchar2(40) not null,
//	  name varchar2(20) not null,
//	  title varchar2(60) not null,
//	  content varchar2(4000) not null,
//	  created date not null,
//	  replied date,
//	  replies number,
//	  is_valid varchar2(5)
	/*
	 * set
	 */
	
	public boolean insertBoard(int categoryPk, String id, String name, String title, String content) {
//		insert into board values(        seq_board.nextval, 1,'이한일','lhi','와','잘만들었네요', sysdate, sysdate, 0, 'true');
		setSql("insert into board values(seq_board.nextval, ?,     ?,    ?,   ?,         ?, sysdate, sysdate, 0, 'true')");
		setInt(1, categoryPk);
		setString(2, name);
		setString(3, id);
		setString(4, title);
		setString(5, content);
		return insertData();
	}
	
	/*
	 * get 
	 */
	
	public JSONArray getAllBoardArray(int categoryPk) {
		setSql("select * from board where fk_category=? order by pk desc");
		setInt(1, categoryPk);
		return getJSONArray();
	}
	
	// 내 글 보기
	public JSONArray getAllBoardArray(int pk, String id) {
		setSql("select * from board where fk_category=? and id=?");
		setInt(1, pk);
		setString(2, id);
		return getJSONArray();
	}
	
	// 조건 검색
	// type = "title", "name", "id"
	public JSONArray getAllBoardArray(int categoryPk, String type, String string) {
		switch(type){
		case "title":
			setSql("select * from board where fk_category=? and title like ?");
			break;
		case "name":
			setSql("select * from board where fk_category=? and name=?");
			break;
		case "id":
			setSql("select * from board where fk_category=? and id=?");
			break;
		}
		setInt(1, categoryPk);
		setString(2, "%"+string+"%");
		return getJSONArray();
	}
	
	public JSONArray getAllBoardArray() {
		setSql("select * from board where is_valid='true'");
		return getJSONArray();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected JSONObject getJSONObjectFromResultset(ResultSet rs) {
		try{
			JSONObject json = new JSONObject();
			json.put("pk", rs.getInt("pk"));
			json.put("fk_category", rs.getInt("fk_category"));
			json.put("name", rs.getString("name"));
			json.put("id", rs.getString("id"));
			json.put("title", rs.getString("title"));
			json.put("content", rs.getString("content"));
			json.put("created", rs.getDate("created").toString());
			json.put("replied", rs.getDate("replied").toString());
			json.put("replies", rs.getInt("replies"));
			json.put("is_valid", rs.getString("is_valid"));
			return json;
		}catch(Exception e){e.printStackTrace();}
		return null;
	}


}
