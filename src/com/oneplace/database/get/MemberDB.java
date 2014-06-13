package com.oneplace.database.get;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

@SuppressWarnings("unchecked")
public class MemberDB extends DatabaseConnector{
	public MemberDB() {
		super();
	}
	/*
	 * set
	 */
	
	public boolean addMember(String id, String pass, String email, String name,
			String tel) {
//		insert into member values
//		(seq_member.nextval, 'kht', '1234','minionofdiablo@nate.com','010-6688-2199', '김희택', sysdate);
		setSql("insert into member values(seq_member.nextval, ?,?,?,?,?, sysdate)");
		setString(1, id);
		setString(2, pass);
		setString(3, email);
		setString(4, tel);
		setString(5, name);
		System.out.println("test");
		return insertData();
	}
	
	/*
	 * get
	 */
	public JSONObject getMember(String id) {
		String sql = "select * from member where id = ?";
		setSql(sql);
		setString(1, id);
		JSONObject json = getJSONObject();
		return json;
	}

	public HashMap<String, JSONObject> getAllMember() {
		String sql = "select * from member";
		setSql(sql);
		return getHashMap();
	}

	public JSONArray getAllMemberArray() {
		String sql = "select * from member";
		setSql(sql);
		JSONArray array = getJSONArray();
		return array;
	}
	
	@Override
	protected JSONObject getJSONObjectFromResultset(ResultSet rs){
		try {
			JSONObject json = new JSONObject();
			json.put("id", rs.getString("id"));
			json.put("name", rs.getString("name"));
			json.put("pass", rs.getString("pass"));
			json.put("joined", rs.getDate("joined").toString());
			json.put("email", rs.getString("email"));
			json.put("tel", rs.getString("tel"));
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
