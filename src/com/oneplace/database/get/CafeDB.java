package com.oneplace.database.get;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

@SuppressWarnings("unchecked")
public class CafeDB extends DatabaseConnector{
	public CafeDB() {
		super();
	}
//	  pk number primary key,
//	  manager_id varchar2(40) not null,
//	  organization_uri varchar2(60),
//	  detail varchar2(1000),
//	  name varchar2(60) not null unique,
//	  uri varchar2(60) not null unique,
//	  search_words varchar2(60),
//	  is_search varchar2(5) not null,
//	  is_valid varchar2(5) not null,
//	  is_organization varchar2(5) not null,
//	  join_rule number
	/*
	 * set
	 */
	
	public void insertCafe(String managerId, String organizationUri, String detail, String name, String uri, 
			String search_words, String isSearch, String isOrganization, int joinRule){
		setSql("insert into cafe values(seq_cafe.nextval, ?,?,?,?,?, ?,?,?,?,?,sysdate)");
		setString(1, managerId);
		setString(2, organizationUri);
		setString(3, detail);
		setString(4, name);
		setString(5, uri);
		setString(6, search_words);
		setString(7, isSearch);
		setString(8, "true"); // isValid
		setString(9, isOrganization);
		setInt(10, joinRule);
		insertData();
	}
	/*
	 * get
	 */
	public HashMap<String, JSONObject> getAllCafe() {
		String sql = "select * from cafe";
		setSql(sql);
		return getHashMap();
	}
	
	public HashMap<String, JSONObject> getCafeBySearchWord(String word) {
		String sql = "select * from cafe where search_words like('&?&')";
		setSql(sql);
		setString(1, word);
		return getHashMap();
	}
	
	public HashMap<String, JSONObject> getAllOrganization() {
		String sql = "select * from cafe where is_organization='true' ";
		setSql(sql);
		return getHashMap();
	}
	
	public JSONObject getCafeByUri(String cafeUri) {
		String sql = "select * from cafe where uri=?";
		setSql(sql);
		setString(1, cafeUri);
		return getJSONObject();
	}
	
	public JSONObject getMyCafe(String id) {
		setSql("select * from cafe where manager_id=?");
		setString(1, id);
		return getJSONObject();
	}
	
	public JSONObject getCafe(String cafeName) {
		String sql = "select * from cafe where name=?";
		setSql(sql);
		setString(1, cafeName);
		return getJSONObject();
	}

	public JSONArray getCafeArrayBySearchWord(String word) {
		String sql = "select * from cafe where search_words like('&?&')";
		setSql(sql);
		setString(1, word);
		return getJSONArray();
	}
	
	public JSONArray getAllOrganizationArray(){
		setSql("select * from cafe where is_organization='true'");
		return getJSONArray();
	}
	
	public JSONArray getMyJoinCafeArray(String id) {
		String sql = "select * from cafe";
		setSql(sql);
		JSONArray array = getJSONArray();
		return array;
	}
	
	public JSONArray getAllCafeArray() {
		String sql = "select * from cafe";
		setSql(sql);
		JSONArray array = getJSONArray();
		return array;
	}
	
	protected JSONObject getJSONObjectFromResultset(ResultSet rs){
		JSONObject json = new JSONObject();
		try {
			json.put("name", rs.getString("name"));
			json.put("uri", rs.getString("uri"));
			json.put("detail", rs.getString("detail"));
			json.put("search_words", rs.getString("search_words"));
			json.put("manager_id", rs.getString("manager_id"));
			json.put("organization_uri", rs.getString("organization_uri"));
			json.put("is_search", rs.getString("is_search"));
			json.put("is_valid", rs.getString("is_valid"));
			json.put("is_organization", rs.getString("is_organization"));
			json.put("pk", rs.getString("pk"));
			json.put("join_rule", rs.getInt("join_rule"));
			json.put("created", rs.getDate("created").toString());
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
