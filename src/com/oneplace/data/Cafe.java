package com.oneplace.data;

import java.sql.Date;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.util.kht.JSONObjectAble;

@SuppressWarnings("unchecked")
public class Cafe implements JSONObjectAble{
	private int key;
	private String name;
	private boolean search = true;
	private boolean isValid;
	private Date date;
	private String detail = "";
	private boolean isOrganization = false;
	private Member manager;
	private Organization organization = null;
	private String searchWords = "";
	private ArrayList<Member> memberList;
	private String uri;
	
	public Cafe() {
		memberList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		memberList.add(member);
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public boolean isOrganization() {
		return isOrganization;
	}
	
	public void setOrganization(boolean isOrganization) {
		this.isOrganization = isOrganization;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public Member getManager() {
		return manager;
	}
	
	public void setManager(Member manager) {
		this.manager = manager;
	}
	
	public boolean hasSearchWord(String word) {
		String temp[] = this.searchWords.split("|");
		for(String t : temp){
			if(t.equals(word)){
				return true;
			}
		}
		return false;
	}
	
	
	public void setSearchWords(String words){
		this.searchWords = words;
	}

	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		json.put("name", new String(this.name));
		json.put("manager", new String(this.manager.getName()));
		json.put("date", this.date.toString());
		json.put("detail", detail);
		return json;
	}

}
