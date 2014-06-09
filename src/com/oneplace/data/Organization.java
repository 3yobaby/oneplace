package com.oneplace.data;

import java.sql.Date;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.util.kht.JSONObjectAble;
@SuppressWarnings("unchecked")
public class Organization extends Cafe implements JSONObjectAble{
	private String name;
	private Member manager;
	private Cafe cafe;
	private ArrayList<Cafe> cafeList;
	private Date date;
	private String detail;
	private String uri;
	
	public Organization(String name) {
		this.name = name;
		setCafe(name);
		cafeList = new ArrayList<Cafe>();
		this.detail = name;
	}
	public void setName(String orgName) {
		this.name = orgName;
	}
	public String getName() {
		return name;
	}
	public void setManager(Member manager) {
		this.manager = manager;
	}
	public Member getManager() {
		return manager;
	}
	public Cafe getCafe() {
		return cafe;
	}
	
	public void addCafe(Cafe cafe){
		this.cafeList.add(cafe);
	}
	
	private void setCafe(String name){
		cafe = new Cafe();
		cafe.setName(name);
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("manager", manager.getName());
		json.put("date", date.toString());
		json.put("detail", detail);
		json.put("uri", uri);
		return json;
	}
}
