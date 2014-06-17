package com.oneplace.database.get;

import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.util.kht.DatabaseConnector;

@SuppressWarnings("unchecked")
public class CafeOrganizationDB extends DatabaseConnector{
//	  pk number primary key,
//	  cafe_uri varchar2(20),
//	  organization_uri varchar2(20),
//	  joined varchar2(5)
	/*
	 * set
	 */
	
	public int updateData(int pk, String joined) {
		setSql("update cafe_organization set joined=? where pk=?");
		setString(1, joined);
		setInt(2, pk);
		return super.updateData();
	}
	
	/*
	 * get
	 */
	public JSONArray getCafeArray(String orgUri) {
		setSql("select * from cafe_organization where organization_uri=?");
		setString(1, orgUri);
		JSONArray array = getJSONArray();
		return array;
	}
	
	public JSONArray getAllArray(){
		setSql("select * from cafe_organization");
		return getJSONArray();
	}
	
	@Override
	protected JSONObject getJSONObjectFromResultset(ResultSet rs) {
		try{
			JSONObject json = new JSONObject();
			json.put("pk", rs.getInt("pk"));
			json.put("cafe_uri", rs.getString("cafe_uri"));
			json.put("organization_uri", rs.getString("organization_uri"));
			json.put("joined", rs.getString("joined"));
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
