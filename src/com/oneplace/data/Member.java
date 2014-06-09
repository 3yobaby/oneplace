package com.oneplace.data;

import java.sql.Date;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.util.kht.JSONObjectAble;

/*
 * 개인정보, 가입시간 등등
 */
public class Member implements JSONObjectAble{
	private String id;
	private String name = "";
	private String pass;
	private Date birthday;
	private String email = "";
	private String tel = "";
	private Date join;
	private boolean isValid = true;
	private boolean isOrgMember = false;
	private ArrayList<Cafe> cafeArray = new ArrayList<Cafe>();
	private Cafe cafe;
	
	public Cafe getCafe() {
		return cafe;
	}
	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getJoin() {
		return join;
	}
	public void setJoin(Date join) {
		this.join = join;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public boolean isOrgMember() {
		return isOrgMember;
	}
	
	public void setOrgMember(boolean isOrgMember) {
		this.isOrgMember = isOrgMember;
	}
	
	public void addCafe(Cafe cafe) {
		cafeArray.add(cafe);
	}
	
	public ArrayList<Cafe> getCafeList() {
		return cafeArray;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pass=" + pass
				+ ", birthday=" + birthday + ", email="
				+ email + ", tel=" + tel + ", join=" + join + ", isValid="
				+ isValid + "]";
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject(){
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("name", name);
		json.put("email", email);
		json.put("tel", tel);
		json.put("birthday", birthday);
		json.put("pass", pass);
		json.put("isOrgMember", isOrgMember);
		if(cafe != null){
			json.put("cafe", cafe.getName());
			json.put("cafe_uri", cafe.getUri());
		}
		return json;
	}
}
