package com.oneplace.database.get;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

public class CafeMemberDB extends DatabaseConnector{
	// member_type
	// 0 default 1 가입신정충 2 가입완료, 회원 3 관리자 4 기관 관리자
//	pk number primary key,
//	  member_id varchar2(20),
//	  cafe_uri varchar2(60)
	
	public int deleteMember(String id, String cafeUri) {
		setSql("delete from member_joined_cafe where member_id=? and manager_id != ? and cafe_uri=?");
		setString(1, id);
		setString(2, id);
		setString(3, cafeUri);
		return deleteData();
	}
	
	public JSONArray getAll() {
		setSql("select * from member_joined_cafe");
		return getJSONArray();
	}

	public JSONObject getObject(String cafeUri, String memberId) {
		setSql("select * from member_joined_cafe where cafe_uri=? and member_id=?");
		setString(1, cafeUri);
		setString(2, memberId);
		return getJSONObject();
	}
	
	public JSONArray getMemberArray(String uri) {
		setSql("select * from member_joined_cafe where cafe_uri=?");
		setString(1, uri);
		return getJSONArray();
	}
	
	public JSONArray getJoinedCafeArray(String memberId) {
		setSql("select * from member_joined_cafe where member_id = ?");
		setString(1, memberId);
		JSONArray array = getJSONArray();
		return array;
	}

	public JSONObject getMyCafe(String memberId) {
		setSql("select * from member_joined_cafe where manager_id = ?");
		setString(1, memberId);
		return getJSONObject();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected JSONObject getJSONObjectFromResultset(ResultSet rs) {
		try {
			JSONObject json = new JSONObject();
			json.put("member_id", rs.getString("member_id"));
			json.put("manager_id", rs.getString("manager_id"));
			json.put("cafe_uri", rs.getString("cafe_uri"));
			json.put("member_type", rs.getInt("member_type"));
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
