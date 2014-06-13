package com.oneplace.database.get;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

public class MemberJoinedCafeDB extends DatabaseConnector{
	// member_type
	// 0 가입신청중 1 가입완료-회원 2 관리회원 3 관리자
//	pk number primary key,
//	  member_id varchar2(20),
//	  cafe_uri varchar2(60)
	
	public JSONArray getAll() {
		setSql("select * from member_joined_cafe");
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
