package com.oneplace.database.get;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

public class CategoryDB extends DatabaseConnector{
//	  pk number primary key,
//	  cafe_uri varchar2(60) not null,
//	  name varchar2(60) not null,
//	  type varchar2(10) not null,
//	  visibility varchar2(10) not null,
//	  created date not null,
//	  replied date not null
	
	public boolean insertCategory(String cafeUri, String name, String type, String visiblity) {
		setSql("insert into category values(seq_category.nextval, ?, ?, ?, ?,sysdate,sysdate)");
		setString(1, cafeUri);
		setString(2, name);
		setString(3, type);
		setString(4, visiblity);
		return insertData();
	}
	
	public HashMap<String, JSONObject> getAllCategoryMap(String cafePk) {
		String sql = "select * from category where cafe=?";
		setSql(sql);
		setString(1, cafePk);
		return getHashMap();
	}

	public JSONArray getAllCategoryArray(String cafeUri) {
		setSql("select * from category where cafe_uri=?");
		setString(1, cafeUri);
		return getJSONArray();
	}
	
	public JSONArray getAllCategoryArray() {
		setSql("select * from category");
		return getJSONArray();
	}
	
	@SuppressWarnings("unchecked")
	protected JSONObject getJSONObjectFromResultset(ResultSet rs){
		try {
			JSONObject json = new JSONObject();
			json.put("pk", rs.getInt("pk"));
			json.put("cafe_uri", rs.getString("cafe_uri"));
			json.put("name", rs.getString("name"));
			json.put("type", rs.getString("type"));
			json.put("created", rs.getDate("created").toString());
			json.put("replied", rs.getDate("replied").toString());
			json.put("visibility", rs.getString("visibility"));
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
